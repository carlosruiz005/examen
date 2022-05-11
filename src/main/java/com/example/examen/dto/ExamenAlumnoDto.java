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
public class ExamenAlumnoDto {

    private String id;
    private String nombre;
    private String descripcion;
    private List<PreguntaAlumnoDto> preguntas;

    public ExamenAlumnoDto() {
    }

    public ExamenAlumnoDto(String id, String nombre, String descripcion, List<PreguntaAlumnoDto> preguntas) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
    }

}
