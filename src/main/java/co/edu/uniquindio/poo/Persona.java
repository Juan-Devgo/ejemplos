package co.edu.uniquindio.poo;

import java.time.LocalTime;

public abstract class Persona {
    private final String nombre;
    private final String documento;
    private final String telefono;
    private final String email;

    public Persona(String nombre, String documento, String telefono, String email){
        assert nombre != null && !nombre.isBlank();
        assert documento != null && !documento.isBlank();
        assert telefono != null && !telefono.isBlank();
        assert email != null && !email.isBlank();

        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }public String getEmail() {
        return email;
    }public String getNombre() {
        return nombre;
    }public String getTelefono() {
        return telefono;
    }

    public abstract boolean esHorarioLaboral(LocalTime hora);
}
