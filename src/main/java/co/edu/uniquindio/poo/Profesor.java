package co.edu.uniquindio.poo;

import java.time.LocalTime;

public class Profesor extends Persona{
    private final LocalTime horarioInicio;
    private final LocalTime horarioFinal;

    public Profesor(String nombre, String documento, String telefono, String email, LocalTime horarioInicio, LocalTime horarioFinal){
        super(nombre, documento, telefono, email);
        assert horarioInicio != null;
        assert horarioFinal != null;
        assert !horarioFinal.isBefore(horarioInicio);

        this.horarioInicio = horarioInicio;
        this.horarioFinal = horarioFinal;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }public LocalTime getHorarioFinal() {
        return horarioFinal;
    }

    @Override
    public boolean esHorarioLaboral(LocalTime hora){
        boolean eshorario = false;
        if (hora.isAfter(horarioInicio) && hora.isBefore(horarioFinal)) {
            eshorario = true;
        }
        return eshorario;
    }
}
