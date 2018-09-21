package ar.edu.untref.dyasc;

public class FabricaDeSalidas {

    public Salida generar(String parametro) {
        if (parametro.equals("CONSOLA")) {
            return new SalidaPorPantalla();
        } else {
            return new SalidaPorArchivo(parametro);
        }
    }
}
