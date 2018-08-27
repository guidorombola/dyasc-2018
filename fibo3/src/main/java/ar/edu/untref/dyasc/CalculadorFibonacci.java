package ar.edu.untref.dyasc;

public class CalculadorFibonacci {

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
    
}
