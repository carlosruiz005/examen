package com.example.examen.util;

/**
 *
 * @author Carlos Ruiz at getweb.mx
 */
public class ApiConstants {

    public static final String CONTENT_TYPE_JSON_APPLICATION = "application/json";
    public static final String RESPONSE_CODE_200 = "200";
    public static final String RESPONSE_CODE_200_DESCRIPTION = "Solicitud resuelta.";
    public static final String RESPONSE_CODE_400 = "400";
    public static final String RESPONSE_CODE_400_DESCRIPTION = "Solicitud mal formada.";
    public static final String RESPONSE_CODE_404 = "404";
    public static final String RESPONSE_CODE_404_DESCRIPTION = "Recurso no encontrado.";

    public static class ExamenControllerConstants {

        public static final String URL = "/";

        public static class CrearExamen {

            public static final String URL = "/crear-examen";
            public static final String URL_SUMMARY = "Crear examen";
            public static final String URL_DESCRIPTION = "Este se compone de un conjunto de preguntas con 4 opciones, 1 opción correcta y un puntaje por cada pregunta que en total deben sumar 100 puntos (la nota total del examen).";
        }

        public static class CrearEstudiante {

            public static final String URL = "/crear-estudiante";
            public static final String URL_SUMMARY = "Crear estudiante";
            public static final String URL_DESCRIPTION = "Este se compone de la siguiente información: nombre, edad, ciudad y zona horaria de la ciudad. ";
        ;

        }

        public static class AsignarExamen {

            public static final String URL = "/asigar-examen";
            public static final String URL_SUMMARY = "Asignar examen";
            public static final String URL_DESCRIPTION = "Dada una fechade presentación del examen en zona horaria de Bogotá se debe recibir la fecha de  presentación para cada estudiante en su zona horaria correspondiente. ";
        }

        public static class RecopilarRespuestas {

            public static final String URL = "/recopilar-respuestas";
            public static final String URL_SUMMARY = "Recopilar respuestas";
            public static final String URL_DESCRIPTION = "Se debe poder recopilar todas las respuestas de un estudiante en un examen que se le ha asignado.";
        }

        public static class CalificarExamen {

            public static final String URL = "/calificar-examen";
            public static final String URL_SUMMARY = "Calificar examen";
            public static final String URL_DESCRIPTION = "Una vez recibida las respuestas de un estudiante se deberá entregarla calificación de este.";
        }

    }
}
