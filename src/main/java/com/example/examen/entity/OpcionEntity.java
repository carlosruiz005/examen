package com.example.examen.entity;

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
public class OpcionEntity {

    @NotNull
    @NotEmpty(message = "La respuesta no puede ser vacía.")
    private String texto;
    @NotNull(message = "Se requiere indicar si la respuesta correcta.")
    private Boolean isCorrecta;

    public OpcionEntity() {
    }

    public OpcionEntity(String texto, Boolean isCorrecta) {
        this.texto = texto;
        this.isCorrecta = isCorrecta;
    }

}
