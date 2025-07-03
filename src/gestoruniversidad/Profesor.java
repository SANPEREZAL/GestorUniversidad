package gestoruniversidad;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private String especialidad;
    private List<Curso> cursosImpartidos;

    public Profesor(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursosImpartidos = new ArrayList<>();
    }

    public void asignarCurso(Curso curso) {
        for (Curso c : cursosImpartidos) {
            if (c.getCodigo().equalsIgnoreCase(curso.getCodigo())) {
                System.out.println("Ya da este curso.");
                return;
            }
        }
        cursosImpartidos.add(curso);
        System.out.println("Curso asignado al profesor correctamente.");
    }

    public void desasignarCurso(Curso curso) {
        cursosImpartidos.remove(curso);
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Curso> getCursosImpartidos() {
        return cursosImpartidos;
    }
}