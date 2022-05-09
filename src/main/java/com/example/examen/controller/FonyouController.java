package com.example.examen.controller;

import com.example.examen.service.ExamenService;
import com.example.examen.util.ApiConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.ArrayList;
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
import com.example.examen.entity.Examen;
import java.util.Set;
import java.util.logging.Level;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;

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
    public ResponseEntity<Examen> crearExamen(@RequestBody Examen examen) {
        Examen s = this.examenService.save(examen);
        return ResponseEntity.ok(s);
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
