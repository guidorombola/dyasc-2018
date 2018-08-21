package ar.edu.untref.dyasc;

public class Fibonacci2 {

    public int[] desarrollarSerie(int n) {
        int[] serie = new int[n];
        if (n == 1) {
            serie[0] = 0;
        }
        if (n > 1) {
            serie[1] = 1;
        }
        for (int i = 2; i < serie.length; i++) {
            serie[i] = serie[i - 1] + serie[i - 2];
        }
        return serie;
    }
    
    public String mostrarSerie(int[] serie, int cantidadTerminos, char orientacion, char direccion) {
        String salida = "fibo<" + cantidadTerminos + ">:";
        for (int i = 0; i < serie.length; i++) {
            salida += " " + serie[i];
        }
        return salida;
    }
}
