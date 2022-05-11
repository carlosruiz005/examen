/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.examen.repository;

import com.example.examen.entity.EstudianteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public interface EstudianteRepository extends MongoRepository<EstudianteEntity, String> {

    public EstudianteEntity findByIdAndDeletedIsNull(String id);
}
