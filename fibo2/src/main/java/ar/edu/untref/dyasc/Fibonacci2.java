package ar.edu.untref.dyasc;

public class Fibonacci2 {

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
    
    public String mostrarSerie(int[] serie, char orientacion, char direccion) {
        String salida = "fibo<" + serie.length + ">:";
        if(direccion == 'd') {
            for(int i = 0; i < serie.length; i++) {
                salida = mostrarSegunOrientacion(serie, i, orientacion, salida);
            }
        } else {
            for(int i = serie.length-1; i >= 0; i--) {
                salida = mostrarSegunOrientacion(serie, i, orientacion, salida);
            }
        }
        
        return salida;
    }
    
    public String mostrarSegunOrientacion(int[] serie, int indice, char orientacion, String salida) {
        if(orientacion == 'h') {
            salida += " " + serie[indice];
        } else {
            salida += "\n" + serie[indice];
        }
        
        return salida;
    }
}
