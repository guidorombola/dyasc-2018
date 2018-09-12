package ar.edu.untref.dyasc;

public class Producto {

    private int id;
    private float precio;
    private String nombre;

    public Producto(int id, float precio, String nombre) {
        this.id = id;
        this.precio = precio;
        this.nombre = nombre;
    }

    public float obtenerPrecio() {
        return precio;
    }

    public String obtenerNombre() {
        return nombre;
    }

}
