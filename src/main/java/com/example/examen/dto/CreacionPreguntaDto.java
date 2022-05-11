package com.example.examen.dto;

import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class CreacionPreguntaDto implements Serializable {

    private String pregunta;
    private Integer puntaje;
    private List<CreacionOpcionDto> opciones;

    public CreacionPreguntaDto() {
    }

    public CreacionPreguntaDto(String pregunta, Integer puntaje, List<CreacionOpcionDto> opciones) {
        this.pregunta = pregunta;
        this.puntaje = puntaje;
        this.opciones = opciones;
    }
}
