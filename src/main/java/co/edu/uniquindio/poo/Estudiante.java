package co.edu.uniquindio.poo;

import java.time.LocalTime;

public class Estudiante extends Persona{
    public String tema;

    public Estudiante(String nombre, String documento, String telefono, String email, String tema){
        super(nombre, documento, telefono, email);
        assert tema != null && !tema.isBlank();

        this.tema = tema;
    }

    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
        assert tema != null && !tema.isBlank();
    }

    @Override
    public boolean esHorarioLaboral(LocalTime hora){
        return false;
    }
}
