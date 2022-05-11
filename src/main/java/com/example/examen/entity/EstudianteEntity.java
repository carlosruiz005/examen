/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.entity;

import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@Getter
@Setter
@Document(collection = "estudiantes")
public class EstudianteEntity {

    @Id
    private String id;
    @NotNull
    @NotEmpty(message = "El nombre del estudiante no puede ser vacío.")
    private String nombre;
    @NotNull
    @NotEmpty(message = "La edad del estudiante no puede ser vacío.")
    private String edad;
    @NotNull
    private Ciudad ciudad;
    private Date created;
    private Date updated;
    private Date deleted;

    public EstudianteEntity() {
    }

    public EstudianteEntity(String id, String nombre, String edad, Ciudad ciudad, Date created, Date updated, Date deleted) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.created = created;
        this.updated = updated;
        this.deleted = deleted;
    }

}
