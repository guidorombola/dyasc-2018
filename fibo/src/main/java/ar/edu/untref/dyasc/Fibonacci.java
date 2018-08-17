package ar.edu.untref.dyasc;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int num = Integer.parseInt(args[0]);
        int serie[] = f.desarrollarSerie(num);
        String salida = "fibo<" + num + ">:";
        for (int i = 0; i < serie.length; i++) {
            salida += " " + serie[i];
        }
        System.out.println(salida);
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
}
