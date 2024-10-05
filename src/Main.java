import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Que desea hacer? \n1. Ordenar estudiantes por indice academico \n2. Desplazar elementos en el arreglo de caracteres");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.println("¿Desea ordenar de forma ascendente? (true/false)");
            String entrada = scanner.next();
            boolean ascendente = entrada.equalsIgnoreCase("true");

            Estudiante[] estudiantes = llenarArregloAleatoriamente(30);
            Estudiante[] estudiantesOrdenados = bubbleSort(estudiantes, ascendente);

            System.out.println("Estudiantes ordenados por indice academico:");
            for (Estudiante estudiante : estudiantesOrdenados) {
                System.out.println("Nombre: " + estudiante.nombre + ", indice Academico: " + estudiante.indiceAcademico);
            }

        } else if (opcion == 2) {
            System.out.print("Cantidad de elementos para el arreglo de caracteres: ");
            int cantidad = scanner.nextInt();

            if (cantidad % 2 != 0) {
                System.out.println("La cantidad debe ser par");
                return;
            }

            char[] arreglo = new char[cantidad];

            System.out.print("Por favor, ingrese los " + cantidad + " caracteres: ");
            for (int i = 0; i < cantidad; i++) {
                arreglo[i] = scanner.next().charAt(0);
            }

            System.out.print("Ingrese el número de posiciones a desplazar: ");
            int T = scanner.nextInt();

            desplazarElementos(arreglo, T);

            int mitadDelArreglo = arreglo.length / 2;
            System.out.println("1ra mitad:");
            for (int i = 0; i < mitadDelArreglo; i++) {
                System.out.println(arreglo[i]);
            }

            System.out.println("2da mitad:");
            for (int i = mitadDelArreglo; i < arreglo.length; i++) {
                System.out.println(arreglo[i]);
            }
        } else {
            System.out.println("Opcion no valida.");
        }

        scanner.close();
    }

    public static void desplazarElementos(char[] arreglo, int T) {
        int n = arreglo.length;
        if (n % 2 != 0) {
            System.out.println("El tamaño del arreglo debe ser un número par.");
            return;
        }

        int mitadDelArreglo = n / 2;

        for (int i = 1; i <= T; i++) {
            if (i % 2 != 0) {
                char valorGuardado = arreglo[0];
                for (int j = 1; j < mitadDelArreglo; j++) {
                    char valorActual = arreglo[j];
                    arreglo[j] = valorGuardado;
                    valorGuardado = valorActual;
                }
                arreglo[0] = valorGuardado;
            } else {
                char valorGuardado = arreglo[mitadDelArreglo];
                for (int j = mitadDelArreglo + 1; j < n; j++) {
                    char valorActual = arreglo[j];
                    arreglo[j] = valorGuardado;
                    valorGuardado = valorActual;
                }
                arreglo[mitadDelArreglo] = valorGuardado;
            }
        }
    }

    public static Estudiante[] llenarArregloAleatoriamente(int cantidad) {
        Estudiante[] estudiantes = new Estudiante[cantidad];

        for (int i = 0; i < cantidad; i++) {
            Random random = new Random();
            int numeroAleatorio = random.nextInt(101);
            Estudiante estudiante = new Estudiante();
            estudiante.nombre = "Estudiante " + i;
            estudiante.matricula = i;
            estudiante.indiceAcademico = numeroAleatorio;
            estudiantes[i] = estudiante;
        }

        return estudiantes;
    }

    public static Estudiante[] bubbleSort(Estudiante[] estudiantesSinOrdenar, boolean ascendente) {
        Estudiante[] estudiantesOrdenados = Arrays.copyOf(estudiantesSinOrdenar, estudiantesSinOrdenar.length);

        for (int i = 0; i < estudiantesOrdenados.length - 1; i++) {
            for (int j = 0; j < estudiantesOrdenados.length - i - 1; j++) {
                if (ascendente) {
                    if (estudiantesOrdenados[j].indiceAcademico > estudiantesOrdenados[j + 1].indiceAcademico) {
                        swap(estudiantesOrdenados, j);
                    }
                } else {
                    if (estudiantesOrdenados[j].indiceAcademico < estudiantesOrdenados[j + 1].indiceAcademico) {
                        swap(estudiantesOrdenados, j);
                    }
                }
            }
        }
        return estudiantesOrdenados;
    }

    private static void swap(Estudiante[] estudiantes, int j) {
        Estudiante estudianteTemporal = estudiantes[j];
        estudiantes[j] = estudiantes[j + 1];
        estudiantes[j + 1] = estudianteTemporal;
    }
}
