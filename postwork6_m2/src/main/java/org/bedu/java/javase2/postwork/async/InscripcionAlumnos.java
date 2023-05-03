package org.bedu.java.javase2.postwork.async;

import org.bedu.java.javase2.postwork.model.Curso;
import org.bedu.java.javase2.postwork.model.Estudiante;
import org.bedu.java.javase2.postwork.model.Materia;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class InscripcionAlumnos {
    public static void main(String[] args) {
        Random rnd = new Random();

        ReceptorSolicitudes evenLoop = new ReceptorSolicitudes(solicitud -> {
           if (solicitud.getEstudiante() == null || solicitud.getCurso() == null){
               System.out.println("Solicitud rechazada por datos incompletos");
           }
            System.out.println("El estuduante: [" + solicitud.getEstudiante().getNombreCompleto()
            + "] se ha inscrito en la materia: " + solicitud.getCurso().getMateria().getNombre());
        });


        evenLoop.iniciar();
        SolicitudEstudiante[] solicitudes = crearSolicitudes();
        for (SolicitudEstudiante s : solicitudes){
            evenLoop.registrarEvento(s);
            try {
                TimeUnit.MILLISECONDS.sleep(rnd.nextInt(200));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        evenLoop.detener();
    }

    private static SolicitudEstudiante[] crearSolicitudes() {
        Random rnd = new Random();
        Curso[] cursos = new Curso[]{
                crearCurso(rnd, "Programación estructurada", 1),
                crearCurso(rnd, "Programación orientada a objetos", 2),
                crearCurso(rnd, "Estructura de datos", 3),
                crearCurso(rnd, "Bases de datos", 4)
        };

        SolicitudEstudiante[] solicitudes = new SolicitudEstudiante[20];
        for (int i = 0; i < 20; i++) {
            Estudiante e = new Estudiante();
            e.setNombreCompleto("Estudiante " + i);
            e.setId((long)i);

            solicitudes[i] = new SolicitudEstudiante(e, cursos[rnd.nextInt(cursos.length)]);
        }
        return solicitudes;
    }
    private static Curso crearCurso(Random rnd, String nombreMateria, long idCurso) {
        Curso curso1 = new Curso();
        curso1.setId(idCurso);
        Materia materia1 = new Materia();
        materia1.setNombre(nombreMateria);
        curso1.setMateria(materia1);
        return curso1;
    }
}
