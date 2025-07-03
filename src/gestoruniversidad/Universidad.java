package gestoruniversidad;

import java.util.ArrayList;
import java.util.List;

public class Universidad {
    private String nombre;
    private List<Departamento> departamentos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void agregarDepartamento(String nombreDepartamento) {
        departamentos.add(new Departamento(nombreDepartamento));
    }

    public void eliminarDepartamento(String nombreDepartamento) {
        departamentos.removeIf(d -> d.getNombre().equalsIgnoreCase(nombreDepartamento));
    }

    public Profesor buscarProfesorPorNombre(String nombreProfesor) {
        for (Departamento d : departamentos) {
            for (Profesor p : d.getProfesores()) {
                if (p.getNombre().equalsIgnoreCase(nombreProfesor)) {
                    return p;
                }
            }
        }
        return null;
    }

    public List<Profesor> obtenerTodosProfesores() {
        List<Profesor> lista = new ArrayList<>();
        for (Departamento d : departamentos) {
            lista.addAll(d.getProfesores());
        }
        return lista;
    }
}
