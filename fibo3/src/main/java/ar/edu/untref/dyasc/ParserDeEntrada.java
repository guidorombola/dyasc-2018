package ar.edu.untref.dyasc;

import java.util.Map;
import java.util.Set;

public class ParserDeEntrada {
    
    private Map<String, String> parametrosConfiguracion;
    private Map<String, Set<String>> parametrosAdmitidos;
    
    public ParserDeEntrada(Map<String, String> parametrosConfiguracion, Map<String, Set<String>> parametrosAdmitidos) {
        this.parametrosConfiguracion = parametrosConfiguracion;
        this.parametrosAdmitidos = parametrosAdmitidos;
    }
    
    public Configuracion parsear(String[] args) throws EntradaErroneaException {
        int parametros = args.length;
        String opcion = "";
        String parametrosOpcion = "";
        
        for(int i=0; i<parametros-1; i++) {
            opcion = args[i].substring(0, 3);
            parametrosOpcion = args[i].substring(3, args[i].length());
            if(!this.parametrosConfiguracion.containsKey(opcion)) {
                throw new EntradaErroneaException("Opciones no validas");
            } else if(this.parametrosConfiguracion.containsKey(opcion) && !opcion.equals("-f=") 
                    && !this.parametrosAdmitidos.get(opcion).contains(parametrosOpcion)) {
                throw new EntradaErroneaException("Opciones no validas");
            }
            this.parametrosConfiguracion.put(opcion, parametrosOpcion);                
        }
        int cantidadTerminos = Integer.parseInt(args[parametros-1]);
        
        return new Configuracion(this.parametrosConfiguracion, cantidadTerminos);
    }
    
}
