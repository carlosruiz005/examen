/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.validators;

import com.example.examen.entity.Pregunta;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public class TotalScoreConstraintValidator implements ConstraintValidator<ConstraintAnnotations.TotalScoreConstraint, List<Pregunta>> {

    @Override
    public boolean isValid(List<Pregunta> values, ConstraintValidatorContext context) {
        return values.stream().map(v -> v.getPeso()).reduce(0, Integer::sum) == 100;
    }
}
