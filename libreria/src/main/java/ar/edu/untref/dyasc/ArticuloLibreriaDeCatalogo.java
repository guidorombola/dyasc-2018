package ar.edu.untref.dyasc;

public class ArticuloLibreriaDeCatalogo implements GeneradorProducto {

    private int id;
    private float precio;
    private String nombre;
    
    public ArticuloLibreriaDeCatalogo(int id, float precio, String nombre) {
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
