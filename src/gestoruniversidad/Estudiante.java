package gestoruniversidad;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String codigo;
    private String nombre;
    private List<Curso> cursosInscritos;

    public Estudiante(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cursosInscritos = new ArrayList<>();
    }

    public void inscribirseEnCurso(Curso curso) {
        for (Curso c : cursosInscritos) {
            if (c.getCodigo().equalsIgnoreCase(curso.getCodigo())) {
                System.out.println("Ya estás inscrito en este curso.");
                return;
            }
        }
        cursosInscritos.add(curso);
        curso.inscribirEstudiante(this);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }
}