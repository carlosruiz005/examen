/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.service;

import com.example.examen.dto.CreacionAsignacionDto;
import com.example.examen.dto.ExamenAsignadoDto;
import com.example.examen.dto.ExamenAlumnoDto;
import com.example.examen.repository.AsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.examen.entity.AsignacionEntity;
import com.example.examen.entity.EstudianteEntity;
import com.example.examen.util.EntityMapper;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Service
public class AsignacionService {

    private static final Logger LOG = Logger.getLogger(AsignacionService.class.getName());

    @Autowired
    private AsignacionRepository asignacionRepository;
    @Autowired
    private ExamenService examenService;
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private MongoTemplate mongoTemplate;

    public AsignacionEntity save(AsignacionEntity asignacion) {
        if (asignacion.getCreated() == null) {
            asignacion.setCreated(new Date());
        }
        asignacion.setUpdated(new Date());
        return asignacionRepository.save(asignacion);
    }

    public AsignacionEntity create(CreacionAsignacionDto asignacion) {
        AsignacionEntity asignacionEntity = EntityMapper.creacionAsignacionToAsignacionEntityMapper(
                asignacion,
                this.examenService.findById(asignacion.getExamen()),
                this.estudianteService.findById(asignacion.getEstudiante()));
        asignacionEntity.setCreated(new Date());
        asignacionEntity.setUpdated(new Date());
        return asignacionRepository.save(asignacionEntity);
    }

    public List<ExamenAsignadoDto> findByEstudianteId(String estudianteId) {
        EstudianteEntity estudiante = this.estudianteService.findById(estudianteId);
        List<ExamenAsignadoDto> asignaciones = this.asignacionRepository.findAsignacionesForEstudiante(estudianteId);
        ZoneId zone = ZoneId.of(estudiante.getCiudad().getHuso());
        ZoneId localzone = ZoneId.systemDefault();
        asignaciones.forEach(a -> {
            a.setFechaAplicacion(a.getFechaAplicacion().atZone(localzone).withZoneSameInstant(zone).toLocalDateTime());
        });

        return asignaciones;
    }

    public boolean saveRespuestas(String asignacionId, ExamenAlumnoDto examen) {
        AsignacionEntity asignacionEntity = this.asignacionRepository.findByIdAndExamenAndDeletedIsNull(asignacionId, examen.getId());
        if (asignacionEntity == null) {
            return false;
        }
        asignacionEntity.getExamen().getPreguntas().forEach(p -> {
            examen.getPreguntas().stream().anyMatch(e -> {
                if (e.getId().equals(p.getId())) {
                    p.getOpciones().stream().anyMatch(o -> {
                        if (o.getTexto().equals(e.getRespuesta().getTexto())) {
                            p.setRespuesta(o);
                            return true;
                        }
                        return false;
                    });
                    return true;
                }
                return false;
            });
        });
        this.save(asignacionEntity);
        return true;
    }

    public Map<String, Integer> obtenerCalificacion(String asignacionId) {
        Map<String, Integer> resultados = new HashMap<>();
        AsignacionEntity asignacionEntity = this.asignacionRepository.findByIdAndDeletedIsNull(asignacionId);
        if (asignacionEntity == null) {
            return null;
        }
        Integer total = asignacionEntity.getExamen().getPreguntas().stream().map(p -> {
            return p.getRespuesta() == null ? 0 : p.getRespuesta().getIsCorrecta() ? p.getPuntaje() : 0;
        }).reduce(0, Integer::sum);
        resultados.put("total", total);
        return resultados;
    }
}
