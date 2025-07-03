package gestoruniversidad;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String codigo;
    private String nombre;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Curso(String codigo, String nombre, Profesor profesor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equalsIgnoreCase(estudiante.getCodigo())) {
                System.out.println("El estudiante ya está inscrito en el curso.");
                return;
            }
        }
        estudiantes.add(estudiante);
        System.out.println("Estudiante inscrito en el curso.");
    }

    public void desinscribirEstudiante(String codigoEstudiante) {
        estudiantes.removeIf(e -> e.getCodigo().equalsIgnoreCase(codigoEstudiante));
    }

    public void asignarProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void generarReporte(GeneradorReporte generador) {
        generador.generar(this);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}