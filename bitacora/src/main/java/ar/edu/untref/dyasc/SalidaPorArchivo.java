package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;

public class SalidaPorArchivo implements Salida {

    private String archivoSalida;

    public SalidaPorArchivo(String archivoSalida) {
        this.archivoSalida = archivoSalida;
    }

    public void imprimir(String mensaje) {
        try {
            FileWriter escritorArchivoSalida = new FileWriter(this.archivoSalida, true);
            escritorArchivoSalida.write(mensaje + "\n");
            escritorArchivoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
