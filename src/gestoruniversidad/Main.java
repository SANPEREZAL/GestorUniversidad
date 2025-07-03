//* @authors Santiago y Luis
package gestoruniversidad;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Universidad> universidades = new ArrayList<>();
        List<Profesor> profesoresGlobales = new ArrayList<>();
        List<Estudiante> estudiantesGlobales = new ArrayList<>();
        int opcion;

        do {
            System.out.println("\nGestor");
            System.out.println("1. Crear universidad");
            System.out.println("2. Ver universidades y departamentos");
            System.out.println("3. Eliminar universidad");
            System.out.println("4. Ver todos los profesores de una universidad");
            System.out.println("5. Ver profesores independientes");
            System.out.println("6. Contratar profesor en un departamento");
            System.out.println("7. Inscribir estudiante en curso");
            System.out.println("8. Generar reporte de curso");
            System.out.println("9. Crear curso en un departamento");
            System.out.println("10. Ver cursos de un departamento");
            System.out.println("11. Asignar profesor a un curso");
            System.out.println("0. Salir");
            System.out.print("Que desea hacer?: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la universidad: ");
                    String nombreUni = scanner.nextLine();
                    Universidad nueva = new Universidad(nombreUni);
                    universidades.add(nueva);
                    System.out.print("Ingrese un departamento: ");
                    String dep = scanner.nextLine();
                    nueva.agregarDepartamento(dep);
                    System.out.println("Universidad creada correctamente .");
                    break;

                case 2:
                    for (Universidad u : universidades) {
                        System.out.println("Universidad: " + u.getNombre());
                        for (Departamento d : u.getDepartamentos()) {
                            System.out.println("  - Departamento: " + d.getNombre());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre de la universidad: ");
                    String nombreEliminar = scanner.nextLine();
                    boolean eliminada = universidades.removeIf(u -> u.getNombre().equalsIgnoreCase(nombreEliminar));
                    if (eliminada) {
                        System.out.println("Universidad eliminada correctamente.");
                    } else {
                        System.out.println("Universidad no encontrada.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el nombre de la universidad: ");
                    String nombreBuscar = scanner.nextLine();
                    for (Universidad u : universidades) {
                        if (u.getNombre().equalsIgnoreCase(nombreBuscar)) {
                            List<Profesor> profesores = u.obtenerTodosProfesores();
                            if (profesores.isEmpty()) {
                                System.out.println("No hay profesores en esta universidad.");
                            } else {
                                for (Profesor p : profesores) {
                                    System.out.println("Profesor: " + p.getNombre());
                                }
                            }
                        }
                    }
                    break;

                case 5:
                    System.out.println("Profesores independientes:");
                    for (Profesor p : profesoresGlobales) {
                        System.out.println("- " + p.getNombre() + " (" + p.getEspecialidad() + ")");
                    }
                    break;

                case 6:
                    System.out.print("Nombre del profesor: ");
                    String nombreProf = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String esp = scanner.nextLine();
                    Profesor nuevoProf = new Profesor(nombreProf, esp);
                    profesoresGlobales.add(nuevoProf);
                    System.out.println("Profesor creado correctamente.");

                    System.out.print("Desea asignarlo a un departamento? (si/no): ");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equalsIgnoreCase("si")) {
                        System.out.print("Ingrese nombre de la universidad: ");
                        String uni = scanner.nextLine();
                        Universidad seleccionada = null;
                        for (Universidad u : universidades) {
                            if (u.getNombre().equalsIgnoreCase(uni)) {
                                seleccionada = u;
                                break;
                            }
                        }
                        if (seleccionada == null) {
                            System.out.println("Universidad no encontrada.");
                            break;
                        }

                        System.out.print("Ingrese nombre del departamento: ");
                        String depa = scanner.nextLine();
                        Departamento depto = null;
                        for (Departamento d : seleccionada.getDepartamentos()) {
                            if (d.getNombre().equalsIgnoreCase(depa)) {
                                depto = d;
                                break;
                            }
                        }
                        if (depto == null) {
                            System.out.println("Departamento no encontrado.");
                            break;
                        }
                        depto.contratarProfesor(nuevoProf);
                        System.out.println("Profesor asignado al departamento.");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese código del estudiante: ");
                    String codEst = scanner.nextLine();
                    Estudiante estudiante = null;
                    for (Estudiante e : estudiantesGlobales) {
                        if (e.getCodigo().equalsIgnoreCase(codEst)) {
                            estudiante = e;
                            break;
                        }
                    }
                    if (estudiante == null) {
                        System.out.print("Nombre del estudiante: ");
                        String nomEst = scanner.nextLine();
                        estudiante = new Estudiante(codEst, nomEst);
                        estudiantesGlobales.add(estudiante);
                        System.out.println("Estudiante creado.");
                    }

                    System.out.print("Nombre de la universidad: ");
                    String univ = scanner.nextLine();
                    Universidad uniObj = null;
                    for (Universidad u : universidades) {
                        if (u.getNombre().equalsIgnoreCase(univ)) {
                            uniObj = u;
                            break;
                        }
                    }
                    if (uniObj == null) {
                        System.out.println("Universidad no encontrada.");
                        break;
                    }

                    System.out.print("Nombre del departamento: ");
                    String depCurso = scanner.nextLine();
                    Departamento depObj = null;
                    for (Departamento d : uniObj.getDepartamentos()) {
                        if (d.getNombre().equalsIgnoreCase(depCurso)) {
                            depObj = d;
                            break;
                        }
                    }
                    if (depObj == null) {
                        System.out.println("Departamento no encontrado.");
                        break;
                    }

                    System.out.print("Codigo del curso: ");
                    String codCurso = scanner.nextLine();
                    Curso cursoEncontrado = null;
                    for (Curso c : depObj.getCursos()) {
                        if (c.getCodigo().equalsIgnoreCase(codCurso)) {
                            cursoEncontrado = c;
                            break;
                        }
                    }
                    if (cursoEncontrado == null) {
                        System.out.println("Curso no encontrado.");
                        break;
                    }

                    cursoEncontrado.inscribirEstudiante(estudiante);
                    System.out.println("Estudiante inscrito en el curso.");
                    break;

                case 8:
                    System.out.print("Nombre de la universidad: ");
                    String uniReporte = scanner.nextLine();
                    Universidad uReporte = null;
                    for (Universidad u : universidades) {
                        if (u.getNombre().equalsIgnoreCase(uniReporte)) {
                            uReporte = u;
                            break;
                        }
                    }
                    if (uReporte == null) {
                        System.out.println("Universidad no encontrada.");
                        break;
                    }

                    System.out.print("Nombre del departamento: ");
                    String depReporte = scanner.nextLine();
                    Departamento dReporte = null;
                    for (Departamento d : uReporte.getDepartamentos()) {
                        if (d.getNombre().equalsIgnoreCase(depReporte)) {
                            dReporte = d;
                            break;
                        }
                    }
                    if (dReporte == null) {
                        System.out.println("Departamento no encontrado.");
                        break;
                    }

                    System.out.print("Codigo del curso: ");
                    String codReporte = scanner.nextLine();
                    Curso cursoReporte = null;
                    for (Curso c : dReporte.getCursos()) {
                        if (c.getCodigo().equalsIgnoreCase(codReporte)) {
                            cursoReporte = c;
                            break;
                        }
                    }
                    if (cursoReporte == null) {
                        System.out.println("Curso no encontrado.");
                        break;
                    }

                    GeneradorReporte generador = new GeneradorReporte();
                    cursoReporte.generarReporte(generador);
                    break;

                case 9:
                    System.out.print("Nombre de la universidad: ");
                    String uniC = scanner.nextLine();
                    Universidad uC = null;
                    for (Universidad u : universidades) {
                        if (u.getNombre().equalsIgnoreCase(uniC)) {
                            uC = u;
                            break;
                        }
                    }
                    if (uC == null) {
                        System.out.println("Universidad no encontrada.");
                        break;
                    }
                    System.out.print("Nombre del departamento: ");
                    String depC = scanner.nextLine();
                    Departamento dC = null;
                    for (Departamento d : uC.getDepartamentos()) {
                        if (d.getNombre().equalsIgnoreCase(depC)) {
                            dC = d;
                            break;
                        }
                    }
                    if (dC == null) {
                        System.out.println("Departamento no encontrado.");
                        break;
                    }
                    System.out.print("Codigo del curso: ");
                    String codNew = scanner.nextLine();
                    System.out.print("Nombre del curso: ");
                    String nomNew = scanner.nextLine();
                    Curso nuevoCurso = new Curso(codNew, nomNew);
                    dC.ofrecerCurso(nuevoCurso);
                    System.out.println("Curso agregado correctamente.");
                    break;

                case 10:
                    System.out.print("Nombre de la universidad: ");
                    String uniVer = scanner.nextLine();
                    Universidad uVer = null;
                    for (Universidad u : universidades) {
                        if (u.getNombre().equalsIgnoreCase(uniVer)) {
                            uVer = u;
                            break;
                        }
                    }
                    if (uVer == null) {
                        System.out.println("Universidad no encontrada.");
                        break;
                    }
                    System.out.print("Nombre del departamento: ");
                    String depVer = scanner.nextLine();
                    Departamento dVer = null;
                    for (Departamento d : uVer.getDepartamentos()) {
                        if (d.getNombre().equalsIgnoreCase(depVer)) {
                            dVer = d;
                            break;
                        }
                    }
                    if (dVer == null) {
                        System.out.println("Departamento no encontrado.");
                        break;
                    }
                    if (dVer.getCursos().isEmpty()) {
                        System.out.println("Este departamento no tiene cursos.");
                    } else {
                        System.out.println("Cursos del departamento:");
                        for (Curso c : dVer.getCursos()) {
                            System.out.println("- " + c.getNombre() + " (" + c.getCodigo() + ")");
                        }
                    }
                    break;

                case 11:
                    System.out.print("Nombre del profesor: ");
                    String nomProf = scanner.nextLine();
                    Profesor profAsignar = null;
                    for (Profesor p : profesoresGlobales) {
                        if (p.getNombre().equalsIgnoreCase(nomProf)) {
                            profAsignar = p;
                            break;
                        }
                    }
                    if (profAsignar == null) {
                        System.out.println("Profesor no encontrado.");
                        break;
                    }

                    System.out.print("Nombre de la universidad: ");
                    String uniPA = scanner.nextLine();
                    Universidad uPA = null;
                    for (Universidad u : universidades) {
                        if (u.getNombre().equalsIgnoreCase(uniPA)) {
                            uPA = u;
                            break;
                        }
                    }
                    if (uPA == null) {
                        System.out.println("Universidad no encontrada.");
                        break;
                    }
                    System.out.print("Nombre del departamento: ");
                    String depPA = scanner.nextLine();
                    Departamento dPA = null;
                    for (Departamento d : uPA.getDepartamentos()) {
                        if (d.getNombre().equalsIgnoreCase(depPA)) {
                            dPA = d;
                            break;
                        }
                    }
                    if (dPA == null) {
                        System.out.println("Departamento no encontrado.");
                        break;
                    }
                    System.out.print("Codigo del curso: ");
                    String codPA = scanner.nextLine();
                    Curso cursoPA = null;
                    for (Curso c : dPA.getCursos()) {
                        if (c.getCodigo().equalsIgnoreCase(codPA)) {
                            cursoPA = c;
                            break;
                        }
                    }
                    if (cursoPA == null) {
                        System.out.println("Curso no encontrado.");
                        break;
                    }
                    cursoPA.asignarProfesor(profAsignar);
                    profAsignar.getCursosImpartidos().add(cursoPA);
                    System.out.println("Profesor asignado al curso.");
                    break;
            }
        } while (opcion != 0);

        System.out.println("Programa finalizado.");
    }
}
