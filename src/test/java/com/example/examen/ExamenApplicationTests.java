package com.example.examen;

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
import com.example.examen.entity.Examen;
import com.example.examen.entity.Opcion;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.logging.Level;
import org.springframework.http.MediaType;

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
    
//    @Test
//    public void isExamenSaveThenOk() {
//        try {
//            Opcion oc = new Opcion(1,"Es la correcta");
//            
//            String OpcionCorre = mapper.writeValueAsString(new Examen(null, null, new ArrayList<>(), 1, null, null, null));
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
