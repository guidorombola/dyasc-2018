package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bitacora {

    public void registrarEvento(String mensaje) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        String fechaFormateada = fecha.format(formateador);
        String salida = fechaFormateada + " " + mensaje;
        String archivoDestino = System.getProperty("DESTINO_BITACORA");
        if (archivoDestino == null) {
            System.out.println(salida);
        } else {
            escribirEnArchivo(salida, archivoDestino);
        }
    }

    public void escribirEnArchivo(String mensaje, String archivo) {
        try {
            FileWriter escritorArchivoSalida = new FileWriter(archivo, true);
            escritorArchivoSalida.write(mensaje + "\n");
            escritorArchivoSalida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
