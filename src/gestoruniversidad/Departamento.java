package gestoruniversidad;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void contratarProfesor(Profesor profesor) {
        for (Profesor p : profesores) {
            if (p.getNombre().equalsIgnoreCase(profesor.getNombre())) {
                System.out.println("El profesor ya existe o ya está contratado.");
                return;
            }
        }
        profesores.add(profesor);
        System.out.println("Profesor contratado.");
    }

    public void despedirProfesor(String nombre) {
        profesores.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    public void ofrecerCurso(Curso curso) {
        for (Curso c : cursos) {
            if (c.getCodigo().equalsIgnoreCase(curso.getCodigo())) {
                System.out.println("El curso ya existe.");
                return;
            }
        }
        cursos.add(curso);
        System.out.println("Curso agregado.");
    }

    public String getNombre() {
        return nombre;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Curso> getCursos() {
        return cursos;
    }
}