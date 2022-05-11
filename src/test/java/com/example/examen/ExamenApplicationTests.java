package com.example.examen;

import com.example.examen.dto.CreacionExamenDto;
import com.example.examen.dto.CreacionOpcionDto;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import org.springframework.http.MediaType;
import com.example.examen.dto.CreacionPreguntaDto;
import java.util.Arrays;

@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-test.properties")
class ExamenApplicationTests {

    private static final Logger LOG = Logger.getLogger(ExamenApplicationTests.class.getName());

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void isAlive() {
        try {
            mvc
                    .perform(get("/alive"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.valor").value("alive"));
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "isAlive: " + e.getMessage());
        }
    }

    @Test
    public void isExamenSaveThenOk() {
        try {
            CreacionOpcionDto opcion1 = new CreacionOpcionDto("Esta es una opción", Boolean.TRUE);
            CreacionOpcionDto opcion2 = new CreacionOpcionDto("Esta es una opción", Boolean.FALSE);
            CreacionOpcionDto opcion3 = new CreacionOpcionDto("Esta es una opción", Boolean.FALSE);
            CreacionOpcionDto opcion4 = new CreacionOpcionDto("Esta es una opción", Boolean.FALSE);
            CreacionPreguntaDto preguntas = new CreacionPreguntaDto("¿Esta es una pregunta?", 100, Arrays.asList(opcion1, opcion2, opcion3, opcion4));
            CreacionExamenDto examen = new CreacionExamenDto("esto_es_un_examen", "Prueba de JUNIT", Arrays.asList(preguntas));
            String examenString = mapper.writeValueAsString(examen);
            mvc
                    .perform(post("/crear-examen")
                            .content(examenString)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "isRespuestaCorrectaNullThenBadRequest: " + e.getMessage());
        }
    }

    public void isValidationUpThenFail() {
        try {
            CreacionOpcionDto opcion = new CreacionOpcionDto("Esta es una opción", Boolean.TRUE);
            CreacionPreguntaDto preguntas = new CreacionPreguntaDto("¿Esta es una pregunta?", 1, Arrays.asList(opcion));
            CreacionExamenDto examen = new CreacionExamenDto("esto_es_un_examen", "Prueba de JUNIT", Arrays.asList(preguntas));
            String examenString = mapper.writeValueAsString(examen);
            mvc
                    .perform(post("/crear-examen")
                            .content(examenString)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "isRespuestaCorrectaNullThenBadRequest: " + e.getMessage());
        }
    }
//
//    @Test
//    public void isRespuestaCorrectaNullThenBadRequest() {
//        try {
//            String json = mapper.writeValueAsString(new Examen(null, null, new ArrayList<>(), 1, null, null, null));
//            mvc
//                    .perform(post("/crear-examen")
//                            .content(json)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isBadRequest());
//        } catch (Exception e) {
//            LOG.log(Level.SEVERE, "isRespuestaCorrectaNullThenBadRequest: " + e.getMessage());
//        }
//    }

}
