package gestoruniversidad;

public class GeneradorReporte {
    public void generar(Curso curso) {
        System.out.println("\n Reporte del curso " + curso.getNombre() + " (" + curso.getCodigo() + ")");
        System.out.println("Profesor: " + curso.getProfesor().getNombre());
        System.out.println("Estudiantes inscritos:");
        if (curso.getEstudiantes().isEmpty()) {
            System.out.println("- (ninguno)");
        } else {
            for (Estudiante e : curso.getEstudiantes()) {
                System.out.println("- " + e.getNombre() + " (Código: " + e.getCodigo() + ")");
            }
        }
    }
}