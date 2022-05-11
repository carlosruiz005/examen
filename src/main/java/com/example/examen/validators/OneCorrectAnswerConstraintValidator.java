package com.example.examen.validators;

import com.example.examen.entity.OpcionEntity;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public class OneCorrectAnswerConstraintValidator implements ConstraintValidator<ConstraintAnnotations.OneCorrectAnswerConstraint, List<OpcionEntity>> {

    @Override
    public boolean isValid(List<OpcionEntity> values, ConstraintValidatorContext context) {
        List<OpcionEntity> c = values.stream().filter(op -> op.getIsCorrecta()).collect(Collectors.toList());
        return c.size() == 1;
    }
}
