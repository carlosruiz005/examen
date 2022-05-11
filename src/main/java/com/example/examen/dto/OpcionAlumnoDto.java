/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class OpcionAlumnoDto {

    private String texto;

    public OpcionAlumnoDto() {
    }

    public OpcionAlumnoDto(String texto) {
        this.texto = texto;
    }

}
