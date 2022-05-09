package com.example.examen.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.examen.entity.Examen;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public interface ExamenRepository extends MongoRepository<Examen, String> {

}
