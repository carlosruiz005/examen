/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
public class CreacionExamenDto implements Serializable {

    private String nombre;
    private String descripcion;
    private List<CreacionPreguntaDto> preguntas;

    public CreacionExamenDto() {
    }

    public CreacionExamenDto(String nombre, String descripcion, List<CreacionPreguntaDto> preguntas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
    }

}
