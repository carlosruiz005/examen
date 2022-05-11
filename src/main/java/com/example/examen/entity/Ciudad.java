/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.entity;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class Ciudad {

    private String nombre;
    private String huso;

    public Ciudad() {
    }

    public Ciudad(String nombre, String huso) {
        this.nombre = nombre;
        this.huso = huso;
    }

}
