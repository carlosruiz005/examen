/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.service;

import com.example.examen.dto.CreacionEstudianteDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.examen.entity.EstudianteEntity;
import com.example.examen.repository.EstudianteRepository;
import java.util.Date;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;

    public EstudianteEntity findById(String estudianteId) {
        return estudianteRepository.findByIdAndDeletedIsNull(estudianteId);
    }

    public EstudianteEntity save(EstudianteEntity estudiante) {
        if (estudiante.getCreated() == null) {
            estudiante.setCreated(new Date());
        }
        estudiante.setUpdated(new Date());
        return estudianteRepository.save(estudiante);
    }

    public EstudianteEntity create(CreacionEstudianteDto estudiante) {
        EstudianteEntity e = new EstudianteEntity();
        e.setNombre(estudiante.getNombre());
        e.setEdad(estudiante.getEdad());
        e.setCiudad(estudiante.getCiudad());
        e.setCreated(new Date());
        e.setUpdated(new Date());
        return estudianteRepository.save(e);
    }
}
