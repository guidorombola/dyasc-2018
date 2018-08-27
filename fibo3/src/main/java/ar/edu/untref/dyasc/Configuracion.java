package ar.edu.untref.dyasc;

import java.util.Map;

public class Configuracion {
    
    private Map<String, String> parametros;
    private int cantidadDeTerminos;
    
    public Configuracion(Map<String, String> parametros, int cantidadDeTerminos) {
        this.parametros = parametros;
        this.cantidadDeTerminos = cantidadDeTerminos;
    }
    
    public int getCantidadDeTerminos() {
        return cantidadDeTerminos;
    }
    
    public Map<String, String> getParametros() {
        return parametros;
    }

}
