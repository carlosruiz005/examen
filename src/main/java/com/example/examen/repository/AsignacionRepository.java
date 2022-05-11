/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.examen.repository;

import com.example.examen.dto.ExamenAsignadoDto;
import com.example.examen.entity.AsignacionEntity;
import java.util.List;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public interface AsignacionRepository extends MongoRepository<AsignacionEntity, String> {

    AsignacionEntity findByIdAndDeletedIsNull(String id);

    @Query(value = "{'_id':?0, 'examen._id':?1 }")
    AsignacionEntity findByIdAndExamenAndDeletedIsNull(String asignacionId, String examenId);

    @Aggregation(pipeline = {
        "{$match: {'estudiante._id': ObjectId(?0)}}"
    /*,
        "{$unset: ['estudiante','created','updated','examen.preguntas.opciones.isCorrecta']}"*/
    })
    List<ExamenAsignadoDto> findAsignacionesForEstudiante(String estudianteId);

}
