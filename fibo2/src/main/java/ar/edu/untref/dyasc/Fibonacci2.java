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
    
    public String mostrarSerie(int[] serie, char orientacion, char direccion) {
        String salida = "fibo<" + serie.length + ">:";
        if(direccion == 'd') {
            for(int i = 0; i < serie.length; i++) {
                if(orientacion == 'v') {
                    salida += "\n" + serie[i];
                } else {
                    salida += " " + serie[i];                    
                }
            }
        } else {
            for(int i = serie.length-1; i >= 0; i--) {
                if(orientacion == 'v') {
                    salida += "\n" + serie[i];
                } else {
                    salida += " " + serie[i];                    
                }
            }
        }
        
        return salida;
    }
}
