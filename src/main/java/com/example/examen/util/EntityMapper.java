/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.util;

import com.example.examen.dto.CreacionAsignacionDto;
import com.example.examen.dto.CreacionExamenDto;
import com.example.examen.entity.AsignacionEntity;
import com.example.examen.entity.EstudianteEntity;
import com.example.examen.entity.ExamenEntity;
import com.example.examen.entity.OpcionEntity;
import com.example.examen.entity.PreguntaEntity;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public class EntityMapper {

    public static ExamenEntity creacionExamenToExamenEntityToMapper(CreacionExamenDto examen) {
        ExamenEntity e = new ExamenEntity();
        e.setNombre(examen.getNombre());
        e.setDescripcion(examen.getDescripcion());
        List<PreguntaEntity> preguntas = new LinkedList();
        examen.getPreguntas().forEach(p -> {
            List<OpcionEntity> opciones = new LinkedList();
            p.getOpciones().forEach(o -> {
                OpcionEntity opcion = new OpcionEntity(o.getTexto(), o.getIsCorrecta());
                opciones.add(opcion);
            });
            PreguntaEntity pregunta = new PreguntaEntity(p.getPregunta(), opciones, p.getPuntaje(), null);
            preguntas.add(pregunta);
        });
        e.setPreguntas(preguntas);
        return e;
    }

    public static AsignacionEntity creacionAsignacionToAsignacionEntityMapper(
            CreacionAsignacionDto asignacion,
            ExamenEntity examen,
            EstudianteEntity estudiante) {
        AsignacionEntity asignacionEntity = new AsignacionEntity();
        asignacionEntity.setExamen(examen);
        asignacionEntity.setEstudiante(estudiante);
        asignacionEntity.setFechaAplicacion(asignacion.getFechaAplicacion());
        return asignacionEntity;
    }
}
