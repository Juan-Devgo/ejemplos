package co.edu.uniquindio.poo;

import java.time.LocalTime;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

public class Administracion implements RegistroClase{
    private Collection<Persona> estudiantes;
    private Collection<Persona> profesores;
    private Collection<Clase> clases;

    public Administracion(Collection<Persona> estudiantes, Collection<Persona> profesores){
        assert estudiantes.size() == 0;
        assert profesores.size() == 0;

        this.estudiantes = estudiantes;
        this.profesores = profesores;
        this.clases = new LinkedList<>();
    }

    public Collection<Persona> getEstudiantes() {
        return estudiantes;
    }public Collection<Persona> getProfesores() {
        return profesores;
    }public Collection<Clase> getClases() {
        return clases;
    }

    public void registrarMiembro(Persona persona){
        assert persona != null;
        if (persona instanceof Estudiante) {
            estudiantes.add(persona);
        }
        else {
            profesores.add(persona);
        }
    }

    @Override
    public void registrarClase(LocalTime hora){
        validarProfesorDisponible(hora);
        Persona profesor = encontrarProfesorDisponible(hora).get();
        Collection<Persona> estudiantes = escogerMax6Estuidiantes();
        assert estudiantes.size() >= 1;
        Clase clase = new Clase(profesor, estudiantes, hora);
        clases.add(clase);
    }

    private void validarProfesorDisponible(LocalTime hora){
        assert profesores.size() >= 1;
        assert encontrarProfesorDisponible(hora).isPresent():"No hay profesores disponibles ahora mismo.";
    }

    private Collection<Persona> escogerMax6Estuidiantes(){
        Collection<Persona> companerosClase = new LinkedList<>();
        for (Persona persona : estudiantes) {
            companerosClase.add(persona);
            if(companerosClase.size() >= 6){
                break;
            }
        }
        return companerosClase;
    }

    private Optional<Persona> encontrarProfesorDisponible(LocalTime hora){
        Predicate<Persona> condicion = p->p.esHorarioLaboral(hora);
        return profesores.stream().filter(condicion).findFirst();
    }
}
