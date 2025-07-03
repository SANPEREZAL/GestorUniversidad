package gestoruniversidad;

public class GeneradorReporte {
    public void generar(Curso curso) {
        System.out.println("\nReporte del curso");
        System.out.println("Curso: " + curso.getNombre() + " (" + curso.getCodigo() + ")");
        System.out.println("Profesor: " + (curso.getProfesor() != null ? curso.getProfesor().getNombre() : "Sin asignar"));
        System.out.println("Estudiantes inscritos:");
        for (Estudiante e : curso.getEstudiantes()) {
            System.out.println("- " + e.getNombre() + " [" + e.getCodigo() + "]");
        }
        System.out.println("--------------------------");
    }
}