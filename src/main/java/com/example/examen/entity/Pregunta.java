package com.example.examen.entity;

import com.example.examen.validators.ConstraintAnnotations.MaxSizeConstraint;
import com.example.examen.validators.ConstraintAnnotations.OneCorrectAnswerConstraint;
import com.example.examen.validators.MaxSizeConstraintValidator;
import com.example.examen.validators.OneCorrectAnswerConstraintValidator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class Pregunta {

    @NotNull
    @NotEmpty(message = "La pregunta no puede ser vacía.")
    private String pregunta;
    @NotNull
    @MaxSizeConstraint
    @OneCorrectAnswerConstraint
    @Valid
    private List<Opcion> opciones;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer peso;

    public Pregunta() {
    }

    public Pregunta(String pregunta, List<Opcion> opciones, Integer peso) {
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.peso = peso;
    }

}
