package co.edu.uniquindio.poo;

import java.time.LocalTime;
import java.util.Collection;

public class Clase {
    private final Persona profesor;
    private final Collection<Persona> estudiantes;
    private final LocalTime hora;

    public Clase(Persona profesor, Collection<Persona> estudiantes, LocalTime hora){
        assert profesor != null;
        assert estudiantes != null;
        assert hora != null;

        this.profesor = profesor;
        this.estudiantes = estudiantes;
        this.hora = hora;
    }

    public Collection<Persona> getEstudiantes() {
        return estudiantes;
    }public LocalTime getHora() {
        return hora;
    }public Persona getProfesor() {
        return profesor;
    }

}
