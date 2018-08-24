package ar.edu.untref.dyasc;

public class MainFibonacci2 {
    public static void main(String[] args) {
        char orientacion = ' '; 
        char direccion = ' ';
        int cantidadTerminos = 0;
        if(args.length == 2) {
            String opcion = args[0].substring(0, 3);
            orientacion = args[0].charAt(3);
            direccion = args[0].charAt(4);
            if(!(opcion.equals("-o=") && (orientacion == 'v' || orientacion == 'h') && (direccion == 'd' || direccion == 'i'))) {
                System.out.println("Opcion no valida");
                System.exit(1);
            }
            cantidadTerminos = Integer.parseInt(args[1]);
        } else {
            cantidadTerminos = Integer.parseInt(args[0]);
            orientacion = 'h';
            direccion = 'd';
        }
        Fibonacci2 f = new Fibonacci2();
        int[] serie = f.desarrollarSerie(cantidadTerminos);
        System.out.println(f.mostrarSerie(serie, cantidadTerminos, orientacion, direccion));
        
    }
    
}
