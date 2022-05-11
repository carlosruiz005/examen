package com.example.examen.entity;

import com.example.examen.validators.ConstraintAnnotations.MaxSizeConstraint;
import com.example.examen.validators.ConstraintAnnotations.OneCorrectAnswerConstraint;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class PreguntaEntity {

    @Id
    private String id;
    @NotNull
    @NotEmpty(message = "La pregunta no puede ser vacía.")
    private String pregunta;
    @NotNull
    @MaxSizeConstraint
    @OneCorrectAnswerConstraint
    @Valid
    private List<OpcionEntity> opciones;
    @NotNull
    @Min(1)
    @Max(100)
    private Integer puntaje;
    private OpcionEntity respuesta;

    public PreguntaEntity() {
        this.id = new ObjectId().toString();
    }

    public PreguntaEntity(String pregunta, List<OpcionEntity> opciones, Integer puntaje, OpcionEntity respuesta) {
        this.id = new ObjectId().toString();
        this.pregunta = pregunta;
        this.opciones = opciones;
        this.puntaje = puntaje;
        this.respuesta = respuesta;
    }

}
