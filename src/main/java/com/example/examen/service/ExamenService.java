package com.example.examen.service;

import com.example.examen.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.examen.entity.Examen;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Service
public class ExamenService {

    @Autowired
    ExamenRepository examenRepository;

    public Examen save(Examen examen) {
        return this.examenRepository.save(examen);
    }
}
