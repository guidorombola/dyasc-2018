package ar.edu.untref.dyasc;

public class ArticuloSuscribibleDeCatalogo implements GeneradorProducto{

    private int id;
    private float precio;
    private String nombre;
    private TipoArticuloSuscribible tipo;
    private int periodicidadMensual;
    
    public ArticuloSuscribibleDeCatalogo(int id, float precio, String nombre, TipoArticuloSuscribible tipo,
            int periodicidadMensual) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
        this.tipo = tipo;
        this.periodicidadMensual = periodicidadMensual;
    }
    
    public ArticuloSuscribible generar() {
        return new ArticuloSuscribible(id, precio, nombre, tipo, periodicidadMensual, null);
    }
    
    public int obtenerId() {
        return this.id;
    }
    
    public float obtenerPrecio() {
        return this.precio;
    }
    
    public String obtenerNombre() {
        return this.nombre;
    }
    
    public TipoArticuloSuscribible obtenerTipo() {
        return this.tipo;
    }
    
    public int obtenerPeriodicidadMensual() {
        return this.periodicidadMensual;
    }
    
   
}
