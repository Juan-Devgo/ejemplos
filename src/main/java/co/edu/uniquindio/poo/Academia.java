package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.LinkedList;

public class Academia {
    private Collection<Persona> miembros;
    private Administracion administracion;

    public Academia(){
        this.miembros = new LinkedList<>();
        this.administracion = new Administracion(miembros, miembros);
    }
    public Collection<Persona> getMiembros() {
        return miembros;
    }public Administracion getAdministracion() {
        return administracion;
    }

    public void registrarMiembro(Persona miembro){
        assert miembro != null;
        miembros.add(miembro);
        administracion.registrarMiembro(miembro);
    }
}
