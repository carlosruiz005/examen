package com.example.examen.controller;

import com.example.examen.dto.CreacionAsignacionDto;
import com.example.examen.dto.CreacionEstudianteDto;
import com.example.examen.dto.CreacionExamenDto;
import com.example.examen.dto.ExamenAlumnoDto;
import com.example.examen.dto.ExamenAsignadoDto;
import com.example.examen.entity.AsignacionEntity;
import com.example.examen.service.ExamenService;
import com.example.examen.util.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.examen.entity.ExamenEntity;
import com.example.examen.service.EstudianteService;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.examen.entity.EstudianteEntity;
import com.example.examen.service.AsignacionService;
import java.util.TimeZone;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Carlos Ruiz <Carlos Ruiz>
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(ApiConstants.ExamenControllerConstants.URL)
@ApiResponses(
        value = {
            @ApiResponse(
                    responseCode = ApiConstants.RESPONSE_CODE_200,
                    description = ApiConstants.RESPONSE_CODE_200_DESCRIPTION,
                    content = {
                        @Content(mediaType = ApiConstants.CONTENT_TYPE_JSON_APPLICATION),}
            ),
            @ApiResponse(
                    responseCode = ApiConstants.RESPONSE_CODE_404,
                    description = ApiConstants.RESPONSE_CODE_404_DESCRIPTION,
                    content = @Content
            ),}
)
public class FonyouController {

    private static final Logger LOG = Logger.getLogger(FonyouController.class.getName());

    @Autowired
    private ExamenService examenService;
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private AsignacionService asignacionService;

    @GetMapping("/alive")
    public ResponseEntity<Map> alive() {
        Map<String, String> m = new HashMap();
        m.put("valor", "alive");
        return ResponseEntity.ok(m);
    }

    @PostMapping(ApiConstants.ExamenControllerConstants.CrearExamen.URL)
    @Operation(
            summary = ApiConstants.ExamenControllerConstants.CrearExamen.URL_SUMMARY,
            description = ApiConstants.ExamenControllerConstants.CrearExamen.URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = String.class))}
    )
    public ResponseEntity<ExamenEntity> crearExamen(@RequestBody CreacionExamenDto examen) {
        return ResponseEntity.ok(this.examenService.create(examen));
    }

    @PostMapping(ApiConstants.ExamenControllerConstants.CrearEstudiante.URL)
    @Operation(
            summary = ApiConstants.ExamenControllerConstants.CrearEstudiante.URL_SUMMARY,
            description = ApiConstants.ExamenControllerConstants.CrearEstudiante.URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = String.class))}
    )
    public ResponseEntity<EstudianteEntity> crearEstudiante(@RequestBody CreacionEstudianteDto estudiante) {
        return ResponseEntity.ok(this.estudianteService.create(estudiante));
    }

    @PostMapping(ApiConstants.ExamenControllerConstants.AsignarExamen.URL)
    @Operation(
            summary = ApiConstants.ExamenControllerConstants.AsignarExamen.URL_SUMMARY,
            description = ApiConstants.ExamenControllerConstants.AsignarExamen.URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = String.class))}
    )
    public ResponseEntity<AsignacionEntity> asignarExamen(@RequestBody CreacionAsignacionDto asignacion) {
        return ResponseEntity.ok(this.asignacionService.create(asignacion));
    }

    @GetMapping(ApiConstants.ExamenControllerConstants.ObtenerExamenesAsignados.URL)
    @Operation(
            summary = ApiConstants.ExamenControllerConstants.ObtenerExamenesAsignados.URL_SUMMARY,
            description = ApiConstants.ExamenControllerConstants.ObtenerExamenesAsignados.URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = String.class))}
    )
    public ResponseEntity<List<ExamenAsignadoDto>> obtenerExamenesAsignados(@RequestParam(name = "estudiante") String estudianteId) {
        List<ExamenAsignadoDto> asignaciones = this.asignacionService.findByEstudianteId(estudianteId);
        if (asignaciones == null || asignaciones.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(asignaciones);
    }

    @PutMapping(ApiConstants.ExamenControllerConstants.RecopilarRespuestas.URL)
    @Operation(
            summary = ApiConstants.ExamenControllerConstants.RecopilarRespuestas.URL_SUMMARY,
            description = ApiConstants.ExamenControllerConstants.RecopilarRespuestas.URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = String.class))}
    )
    public ResponseEntity<Map<String, String>> recopilarRespuestas(@PathVariable String asignacionId, @RequestBody ExamenAlumnoDto examen) {
        Map<String, String> m = new HashMap();
        m.put("status", "A calificar");
        boolean ok = this.asignacionService.saveRespuestas(asignacionId, examen);
        m.put("status", ok ? "A calificar" : "No se guardaron las respuestas. Favor de intentar nuevamente");
        return new ResponseEntity(m, ok ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @GetMapping(ApiConstants.ExamenControllerConstants.CalificarExamen.URL)
    @Operation(
            summary = ApiConstants.ExamenControllerConstants.CalificarExamen.URL_SUMMARY,
            description = ApiConstants.ExamenControllerConstants.CalificarExamen.URL_DESCRIPTION
    )
    @ApiResponse(
            content = {
                @Content(schema = @Schema(implementation = String.class))}
    )
    public ResponseEntity<Map<String, Integer>> calificarExamen(@RequestParam(name = "asignacion") String asignacionId) {
        Map<String, Integer> resultados = this.asignacionService.obtenerCalificacion(asignacionId);
        return new ResponseEntity(resultados, resultados != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handle(ConstraintViolationException constraintViolationException) {
        Map<String, Object> err = new HashMap();
        Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
        violations.forEach(v -> {
            err.put(v.getPropertyPath().toString(), v.getMessage() + (v.getInvalidValue() instanceof String ? ": " + v.getInvalidValue() : ""));
        });
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
