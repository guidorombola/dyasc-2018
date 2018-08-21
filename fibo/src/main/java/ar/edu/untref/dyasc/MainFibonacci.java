package ar.edu.untref.dyasc;

public class MainFibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int num = Integer.parseInt(args[0]);
        int serie[] = f.desarrollarSerie(num);
        System.out.println(f.mostrarSerie(serie, num));
    }
}
