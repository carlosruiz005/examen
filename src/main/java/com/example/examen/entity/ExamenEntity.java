package com.example.examen.entity;

import com.example.examen.validators.ConstraintAnnotations.TotalScoreConstraint;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
@Document(collection = "examenes")
public class ExamenEntity {

    @Id
    private String id;
    @Pattern(regexp = "^(?!.*\\.\\.)(?!.*\\.$)[^\\W][\\w.]{0,29}$", message = "El nombre no puede contener puntos o espacios y debe tener como límite 30 caracteres.")
    @NotNull
    @NotEmpty(message = "El nombre del examen no puede ser vacío.")
    private String nombre;
    private String descripcion;
    @NotNull
    @Valid
    @TotalScoreConstraint
    private List<PreguntaEntity> preguntas;
    private Date created;
    private Date updated;
    private Date deleted;

    public ExamenEntity() {
    }

    public ExamenEntity(String id, String nombre, String descripcion, List<PreguntaEntity> preguntas, Date created, Date updated, Date deleted) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.preguntas = preguntas;
        this.created = created;
        this.updated = updated;
        this.deleted = deleted;
    }
}
