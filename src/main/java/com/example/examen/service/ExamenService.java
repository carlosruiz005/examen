package com.example.examen.service;

import com.example.examen.dto.CreacionExamenDto;
import com.example.examen.repository.ExamenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.examen.entity.ExamenEntity;
import com.example.examen.util.EntityMapper;
import java.util.Date;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Service
public class ExamenService {

    @Autowired
    ExamenRepository examenRepository;

    public ExamenEntity findById(String examenId) {
        return this.examenRepository.findByIdAndDeletedIsNull(examenId);
    }

    public ExamenEntity create(CreacionExamenDto examen) {
        ExamenEntity examenEntity = EntityMapper.creacionExamenToExamenEntityToMapper(examen);
        examenEntity.setCreated(new Date());
        examenEntity.setUpdated(new Date());
        examenEntity = this.examenRepository.save(examenEntity);
        return examenEntity;
    }

    public void delete(ExamenEntity examen) {
        examen.setDeleted(new Date());
        this.examenRepository.save(examen);
    }

}
