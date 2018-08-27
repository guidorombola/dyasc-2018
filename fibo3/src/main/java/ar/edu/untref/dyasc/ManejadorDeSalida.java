package ar.edu.untref.dyasc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ManejadorDeSalida {
    
    private int[] serie;
    private Configuracion configuracion;

    public ManejadorDeSalida(int[] serie, Configuracion configuracion) {
        this.serie = serie;
        this.configuracion = configuracion;
    }
    
    public void devolver() {
        Map<String, String> parametrosConfiguracion = this.configuracion.getParametros();
        String salida = "fibo<"+this.configuracion.getCantidadDeTerminos()+">";
        char orientacion = parametrosConfiguracion.get("-o=").charAt(0);
        if(parametrosConfiguracion.get("-m=").equals("s")){
            salida += "s:" + mostrarSegunOrientacion(orientacion) + String.valueOf(sumarSerie(this.serie));
        } else {
            char direccion = parametrosConfiguracion.get("-o=").charAt(1);
            salida += ":" + mostrarSerie(this.serie, orientacion, direccion);
        }
        String nombreArchivo = parametrosConfiguracion.get("-f=");
        if(!(nombreArchivo.equals(""))) {
            escribirEnArchivo(nombreArchivo, salida);
            imprimirEnPantalla("guardado en "+ nombreArchivo);
        } else {
            imprimirEnPantalla(salida);
        }
        
    }

    public void escribirEnArchivo(String nombre, String serie) {
        try {
            FileWriter escritor = new FileWriter(nombre);
            escritor.write(serie);
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void imprimirEnPantalla(String serie) {
        System.out.println(serie);
    }

    public String mostrarSerie(int[] serie, char orientacion, char direccion) {
        String salida = "";
        String separador = "";
        separador = mostrarSegunOrientacion(orientacion);
        if (direccion == 'd') {
            for (int i = 0; i < serie.length; i++) {
                salida += separador + serie[i];            
            }
        } else {
            for (int i = serie.length - 1; i >= 0; i--) {
                salida += separador + serie[i]; 
            }
        }

        return salida;
    }

    private String mostrarSegunOrientacion(char orientacion) {
        if(orientacion == 'h') {
            return " ";
        } else {
            return "\n";
        }
    }
    
    private int sumarSerie(int[] serie) {
        int suma = 0;
        for (int i = 0; i < serie.length; i++) {
            suma += serie[i];
        }
        return suma;
    }
}
