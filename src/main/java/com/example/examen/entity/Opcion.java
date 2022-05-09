package com.example.examen.entity;

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
public class Opcion {

    @NotNull
    @NotEmpty(message = "La respuesta no puede ser vacía.")
    private String respuesta;
    @NotNull(message = "Se requiere indicar si la respuesta correcta.")
    private Boolean isCorrecta;

    public Opcion() {
    }

    public Opcion(String respuesta, Boolean isCorrecta) {
        this.respuesta = respuesta;
        this.isCorrecta = isCorrecta;
    }

}
