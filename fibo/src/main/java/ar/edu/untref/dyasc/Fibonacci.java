package ar.edu.untref.dyasc;

public class Fibonacci {
    
    public int[] desarrollarSerie(int cantidadTerminos) {
        int[] serie = new int[cantidadTerminos];
        if (cantidadTerminos == 1) {
            serie[0] = 0;
        } else if (cantidadTerminos > 1) {
            serie[0] = 0;
            serie[1] = 1;
        }
        for (int i = 2; i < serie.length; i++) {
            serie[i] = serie[i - 1] + serie[i - 2];
        }
        return serie;
    }
    
    public String mostrarSerie(int[] serie) {
        String salida = "fibo<" + serie.length + ">:";
        for (int i = 0; i < serie.length; i++) {
            salida += " " + serie[i];
        }
        return salida;
    }
}
