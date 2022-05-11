/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class CreacionAsignacionDto implements Serializable {

    private String examen;
    private String estudiante;
    private LocalDateTime fechaAplicacion;

    public CreacionAsignacionDto() {
    }

    public CreacionAsignacionDto(String examen, String estudiante, LocalDateTime fechaAplicacion) {
        this.examen = examen;
        this.estudiante = estudiante;
        this.fechaAplicacion = fechaAplicacion;
    }
}
