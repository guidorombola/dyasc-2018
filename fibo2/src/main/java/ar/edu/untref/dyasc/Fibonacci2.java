package ar.edu.untref.dyasc;

public class Fibonacci2 {
    public static void main(String[] args) {
        Fibonacci2 f = new Fibonacci2();
        int num = Integer.parseInt(args[0]);
        int serie[] = f.desarrollarSerie(num);
        System.out.println(f.mostrarSerie(serie, num));
    }

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
    
    public String mostrarSerie(int[] serie, int cantidadTerminos) {
        String salida = "fibo<" + cantidadTerminos + ">:";
        for (int i = 0; i < serie.length; i++) {
            salida += " " + serie[i];
        }
        return salida;
    }
}
