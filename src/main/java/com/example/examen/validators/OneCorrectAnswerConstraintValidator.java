package com.example.examen.validators;

import com.example.examen.entity.Opcion;
import com.example.examen.entity.Pregunta;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public class OneCorrectAnswerConstraintValidator implements ConstraintValidator<ConstraintAnnotations.OneCorrectAnswerConstraint, List<Opcion>> {

    @Override
    public boolean isValid(List<Opcion> values, ConstraintValidatorContext context) {
        List<Opcion> c = values.stream().filter(op -> op.getIsCorrecta()).collect(Collectors.toList());
        return c.size() == 1;
    }
}
