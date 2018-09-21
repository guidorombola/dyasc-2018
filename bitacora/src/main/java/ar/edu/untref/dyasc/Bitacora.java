package ar.edu.untref.dyasc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Bitacora {

    private FabricaDeSalidas creadorDeSalidas;

    public Bitacora() {
        this.creadorDeSalidas = new FabricaDeSalidas();
    }

    public void registrarEvento(String mensaje) {
        String mensajeDeSalida = this.formatearMensaje(mensaje);
        String configuracionDeSalida = System.getProperty("bitacora.destino");
        List<Salida> salidasEvento = this.parsearEntrada(configuracionDeSalida);
        Iterator<Salida> iterador = salidasEvento.iterator();
        while (iterador.hasNext()) {
            Salida salida = iterador.next();
            salida.mostrar(mensajeDeSalida);
        }
    }

    private List<Salida> parsearEntrada(String parametros) {
        StringTokenizer tokenizer = new StringTokenizer(parametros, ",");
        List<Salida> salidasEvento = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String parametroDeSalida = tokenizer.nextToken();
            salidasEvento.add(creadorDeSalidas.generar(parametroDeSalida));
        }
        return salidasEvento;
    }

    private String formatearMensaje(String mensaje) {
        LocalDateTime fecha = LocalDateTime.now();
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String fechaFormateada = fecha.format(formateador);
        String mensajeDeSalida = fechaFormateada + " " + mensaje;
        return mensajeDeSalida;
    }
}
