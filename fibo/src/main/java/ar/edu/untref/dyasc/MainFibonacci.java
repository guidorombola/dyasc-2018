package ar.edu.untref.dyasc;

public class MainFibonacci {
    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        int cantidadTerminos = Integer.parseInt(args[0]);
        int serie[] = f.desarrollarSerie(cantidadTerminos);
        System.out.println(f.mostrarSerie(serie, cantidadTerminos));
    }
}
