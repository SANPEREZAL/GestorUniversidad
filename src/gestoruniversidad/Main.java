//* @authors Santiago y Luis
package gestoruniversidad;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Universidad universidad = new Universidad("Gestor de universidad");
        GeneradorReporte generador = new GeneradorReporte();

        while (true) {
            System.out.println("\n GESTOR");
            System.out.println("1. Agregar departamento");
            System.out.println("2. Contratar profesor");
            System.out.println("3. Crear curso");
            System.out.println("4. Inscribir estudiante en curso");
            System.out.println("5. Generar reporte de curso");
            System.out.println("6. Mostrar todos los profesores");
            System.out.println("7. Salir");
            System.out.print("Que quieres hacer?: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: {
                    System.out.print("Nombre del departamento: ");
                    String nombreDep = scanner.nextLine();
                    universidad.agregarDepartamento(nombreDep);
                    System.out.println("Departamento agregado.");
                    break;
                }
                case 2: {
                    System.out.print("Nombre del departamento: ");
                    String nombreDep = scanner.nextLine();
                    Departamento dep = buscarDepartamento(universidad, nombreDep);
                    if (dep != null) {
                        System.out.print("Nombre del profesor: ");
                        String nombreProf = scanner.nextLine();
                        System.out.print("Especialidad: ");
                        String esp = scanner.nextLine();
                        Profesor p = new Profesor(nombreProf, esp);
                        dep.contratarProfesor(p);
                        System.out.println("Profesor contratado.");
                    } else {
                        System.out.println("Departamento no encontrado.");
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nombre del departamento: ");
                    String nombreDep = scanner.nextLine();
                    Departamento dep = buscarDepartamento(universidad, nombreDep);
                    if (dep != null) {
                        System.out.print("Código del curso: ");
                        String cod = scanner.nextLine();
                        System.out.print("Nombre del curso: ");
                        String nom = scanner.nextLine();
                        System.out.print("Nombre del profesor (ya contratado): ");
                        String nomProf = scanner.nextLine();
                        Profesor prof = buscarProfesor(dep, nomProf);
                        if (prof != null) {
                            Curso curso = new Curso(cod, nom, prof);
                            prof.asignarCurso(curso);
                            dep.ofrecerCurso(curso);
                            System.out.println("Curso creado y asignado.");
                        } else {
                            System.out.println("Profesor no encontrado.");
                        }
                    } else {
                        System.out.println("Departamento no encontrado.");
                    }
                    break;
                }
                case 4: {
                    System.out.print("Nombre del departamento: ");
                    String nombreDep = scanner.nextLine();
                    Departamento dep = buscarDepartamento(universidad, nombreDep);
                    if (dep != null) {
                        System.out.print("Codigo del curso: ");
                        String cod = scanner.nextLine();
                        Curso curso = buscarCurso(dep, cod);
                        if (curso != null) {
                            System.out.print("Nombre del estudiante: ");
                            String nombreEst = scanner.nextLine();
                            System.out.print("Codigo del estudiante: ");
                            String codigoEst = scanner.nextLine();
                            Estudiante est = new Estudiante(codigoEst, nombreEst);
                            est.inscribirseEnCurso(curso);
                            System.out.println("Estudiante inscrito.");
                        } else {
                            System.out.println("Curso no encontrado.");
                        }
                    } else {
                        System.out.println("Departamento no encontrado.");
                    }
                    break;
                }
                case 5: {
                    System.out.print("Nombre del departamento: ");
                    String nombreDep = scanner.nextLine();
                    Departamento dep = buscarDepartamento(universidad, nombreDep);
                    if (dep != null) {
                        System.out.print("Codigo del curso: ");
                        String cod = scanner.nextLine();
                        Curso curso = buscarCurso(dep, cod);
                        if (curso != null) {
                            curso.generarReporte(generador);
                        } else {
                            System.out.println("Curso no encontrado.");
                        }
                    } else {
                        System.out.println("Departamento no encontrado.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Profesores:");
                    for (Profesor p : universidad.obtenerTodosProfesores()) {
                        System.out.println("- " + p.getNombre() + " (" + p.getEspecialidad() + ")");
                    }
                    break;
                }
                case 7: {
                    System.out.println("Saliendoo");
                    return;
                }
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    public static Departamento buscarDepartamento(Universidad uni, String nombre) {
        for (Departamento d : uni.getDepartamentos()) {
            if (d.getNombre().equalsIgnoreCase(nombre)) return d;
        }
        return null;
    }

    public static Profesor buscarProfesor(Departamento d, String nombre) {
        for (Profesor p : d.getProfesores()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) return p;
        }
        return null;
    }

    public static Curso buscarCurso(Departamento d, String codigo) {
        for (Curso c : d.getCursos()) {
            if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        }
        return null;
    }
}
