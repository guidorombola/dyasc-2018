package ar.edu.untref.dyasc;

public class LibroDeCatalogo implements GeneradorProducto {

    private int id;
    private float precio;
    private String nombre;

    public LibroDeCatalogo(int id, float precio, String nombre) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
    }

    public Libro generar() {
        return new Libro(this.id, this.precio, this.nombre);
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
