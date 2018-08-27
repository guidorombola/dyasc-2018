package ar.edu.untref.dyasc;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Map<String, String> parametrosConfiguracion = new HashMap<>();
        parametrosConfiguracion.put("-o=", "hd");
        parametrosConfiguracion.put("-f=", "");
        parametrosConfiguracion.put("-m=", "l");
        Map<String, Set<String>> parametrosAdmitidos = new HashMap<>();
        parametrosAdmitidos.put("-o=", new HashSet<>(Arrays.asList(new String[]{"hd","hi","vd","vi"})));
        parametrosAdmitidos.put("-m=", new HashSet<>(Arrays.asList(new String[]{"l","s"})));
        ParserDeEntrada parser = new ParserDeEntrada(parametrosConfiguracion, parametrosAdmitidos);
        Configuracion config;
        try {
            config = parser.parsear(args);
            CalculadorFibonacci fibo = new CalculadorFibonacci();
            int[] serie = fibo.desarrollarSerie(config.getCantidadDeTerminos());
            ManejadorDeSalida salida = new ManejadorDeSalida(serie, config);
            salida.devolver();
        } catch (EntradaErroneaException e) {
           System.out.println(e.getMessage());
        }
    }
}
