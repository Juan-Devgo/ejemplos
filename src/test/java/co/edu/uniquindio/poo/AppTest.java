/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import java.time.LocalTime;
import org.junit.jupiter.api.Test;


public class AppTest {

    @Test
    public void registrar() {
        Academia academia = new Academia();
        Persona estudiante1 = new Estudiante("H", "1", "3", "@", "-");
        Persona profesor1 = new Profesor("J", "4", "3", "@", LocalTime.of(0,0,0), LocalTime.of(7,0,0));
        academia.registrarMiembro(profesor1);
        academia.registrarMiembro(estudiante1);
        assertTrue(academia.getMiembros().contains(profesor1));
        assertTrue(academia.getMiembros().contains(estudiante1));
        assertTrue(academia.getAdministracion().getEstudiantes().contains(estudiante1));
        assertTrue(academia.getAdministracion().getProfesores().contains(profesor1));
    }

    @Test
    public void calcularHorario() {
        Academia academia = new Academia();
        Persona estudiante1 = new Estudiante("H", "1", "3", "@", "-");
        Persona profesor1 = new Profesor("J", "4", "3", "@", LocalTime.of(0,0,0), LocalTime.of(7,0,0));
        Persona profesor2 = new Profesor("J", "4", "3", "@", LocalTime.of(7,0,0), LocalTime.of(14,0,0));
        assertTrue(profesor1.esHorarioLaboral(LocalTime.of(1,0,0)));
        assertFalse(profesor2.esHorarioLaboral(LocalTime.of(15, 0, 0)));
        academia.registrarMiembro(profesor1);
        academia.registrarMiembro(estudiante1);
    }

    @Test
    public void registrarClase() {
        Academia academia = new Academia();
        Persona estudiante1 = new Estudiante("H", "1", "3", "@", "-");
        Persona profesor1 = new Profesor("J", "4", "3", "@", LocalTime.of(7,0,0), LocalTime.of(12,0,0));
        Persona estudiante2 = new Estudiante("J", "4", "3", "@", "--");
        academia.registrarMiembro(profesor1);
        academia.registrarMiembro(estudiante1);
        academia.registrarMiembro(estudiante2);
        academia.getAdministracion().registrarClase(LocalTime.of(8,0,0));
        assertTrue(academia.getAdministracion().getClases().stream().findFirst().get().getProfesor().equals(profesor1));
        assertTrue(academia.getAdministracion().getClases().stream().findFirst().get().getEstudiantes().contains(estudiante1));
        assertTrue(academia.getAdministracion().getClases().stream().findFirst().get().getEstudiantes().contains(estudiante2));
    }
}
