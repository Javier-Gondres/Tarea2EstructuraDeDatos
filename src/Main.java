public class Main {
    public static void main(String[] args) {
        char arreglo[] = new char[8];
        arreglo[0] = 'A';
        arreglo[1] = 'B';
        arreglo[2] = 'C';
        arreglo[3] = 'D';
        arreglo[4] = 'E';
        arreglo[5] = 'F';
        arreglo[6] = 'G';
        arreglo[7] = 'H';


        desplazarElementos(arreglo, 3);

        int mitadDelArreglo = Math.abs(arreglo.length / 2);
        System.out.println("1ra mitad");
        for (int i = 0; i < mitadDelArreglo; i++) {
            System.out.println(arreglo[i]);
        }

        System.out.println("2da mitad");
        for (int i = mitadDelArreglo; i < arreglo.length; i++) {
            System.out.println(arreglo[i]);
        }
    }

    public static void desplazarElementos(char[] arreglo, int T) {
        int n = arreglo.length;
        if (n % 2 != 0) {
            System.out.println("El tamño del arreglo debe ser un numero par");
            return;
        }

        int mitadDelArreglo = Math.abs(n / 2);

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
}
