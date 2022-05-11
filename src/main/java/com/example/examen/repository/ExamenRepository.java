package com.example.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.examen.entity.ExamenEntity;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public interface ExamenRepository extends MongoRepository<ExamenEntity, String> {

    public ExamenEntity findByIdAndDeletedIsNull(String id);
}
