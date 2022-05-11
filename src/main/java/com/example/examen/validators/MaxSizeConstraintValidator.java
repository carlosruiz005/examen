/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.validators;

import com.example.examen.entity.OpcionEntity;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public class MaxSizeConstraintValidator implements ConstraintValidator<ConstraintAnnotations.MaxSizeConstraint, List<OpcionEntity>> {

    @Override
    public boolean isValid(List<OpcionEntity> values, ConstraintValidatorContext context) {
        return values.size() == 4;
    }
}
