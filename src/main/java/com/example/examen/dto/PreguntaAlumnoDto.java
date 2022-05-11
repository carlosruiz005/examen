/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class PreguntaAlumnoDto {

    private String id;
    private String pregunta;
    private OpcionAlumnoDto respuesta;
    private List<OpcionAlumnoDto> opciones;

    public PreguntaAlumnoDto() {
    }

    public PreguntaAlumnoDto(String id, String pregunta, OpcionAlumnoDto respuesta, List<OpcionAlumnoDto> opciones) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.opciones = opciones;
    }

}
