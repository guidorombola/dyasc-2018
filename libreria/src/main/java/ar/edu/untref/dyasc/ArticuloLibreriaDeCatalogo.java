package ar.edu.untref.dyasc;

public class GeneradorArticuloLibreria implements GeneradorProducto {

    private int id;
    private float precio;
    private String nombre;
    
    public GeneradorArticuloLibreria(int id, float precio, String nombre) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
    }
    
    public ArticuloLibreria generar() {
        return new ArticuloLibreria(this.id, this.precio, this.nombre);
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
}
