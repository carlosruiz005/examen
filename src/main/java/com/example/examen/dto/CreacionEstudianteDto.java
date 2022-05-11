/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.dto;

import com.example.examen.entity.Ciudad;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
public class CreacionEstudianteDto implements Serializable {

    private String nombre;
    private String edad;
    private Ciudad ciudad;

    public CreacionEstudianteDto() {
    }

    public CreacionEstudianteDto(String nombre, String edad, Ciudad ciudad) {
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }

}
