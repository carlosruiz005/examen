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
public class CreacionOpcionDto {

    private String texto;
    private Boolean isCorrecta;

    public CreacionOpcionDto() {
    }

    public CreacionOpcionDto(String texto, Boolean isCorrecta) {
        this.texto = texto;
        this.isCorrecta = isCorrecta;
    }

}
