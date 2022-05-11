/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class ExamenAsignadoDto implements Serializable {

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private String id;
    private ExamenAlumnoDto examen;
    private LocalDateTime fechaAplicacion;

    public ExamenAsignadoDto() {
    }

    public ExamenAsignadoDto(String id, ExamenAlumnoDto examen, LocalDateTime fechaAplicacion) {
        this.id = id;
        this.examen = examen;
        this.fechaAplicacion = fechaAplicacion;
    }
}
