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

    public void agregarDepartamento(String nombre) {
        for (Departamento d : departamentos) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Departamento ya existe.");
                return;
            }
        }
        departamentos.add(new Departamento(nombre));
        System.out.println("Departamento agregado correctamente.");
    }

    public void eliminarDepartamento(String nombre) {
        departamentos.removeIf(d -> d.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Profesor> obtenerTodosProfesores() {
        List<Profesor> todos = new ArrayList<>();
        for (Departamento d : departamentos) {
            todos.addAll(d.getProfesores());
        }
        return todos;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
