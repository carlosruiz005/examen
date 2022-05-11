/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.validators;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
public class ConstraintAnnotations {

    @Constraint(validatedBy = MaxSizeConstraintValidator.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MaxSizeConstraint {

        String message() default "La pregunta debe contener 4 respuestas.";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }

    @Constraint(validatedBy = OneCorrectAnswerConstraintValidator.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface OneCorrectAnswerConstraint {

        String message() default "Solo puede seleccionar una pregunta como correcta.";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
    
    @Constraint(validatedBy = TotalScoreConstraintValidator.class)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TotalScoreConstraint {

        String message() default "El total de puntaje debe ser igual a 100.";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};
    }
}
