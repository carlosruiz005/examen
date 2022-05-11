/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examen.entity;

import java.time.LocalDateTime;
import java.util.Date;
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
@Document(collection = "asignaciones")
public class AsignacionEntity {

    @Id
    private String id;
    @NotNull(message = "Debe agregar un examen.")
    private ExamenEntity examen;
    @NotNull(message = "Debe agregar a un estudiante.")
    private EstudianteEntity estudiante;
    @NotNull(message = "Debe agregar la fecha de aplicación.")
    private LocalDateTime fechaAplicacion;
    private Date created;
    private Date updated;
    private Date deleted;

    public AsignacionEntity() {
    }

    public AsignacionEntity(String id, ExamenEntity examen, EstudianteEntity estudiante, LocalDateTime fechaAplicacion, Date created, Date updated, Date deleted) {
        this.id = id;
        this.examen = examen;
        this.estudiante = estudiante;
        this.fechaAplicacion = fechaAplicacion;
        this.created = created;
        this.updated = updated;
        this.deleted = deleted;
    }

}
