package ar.edu.untref.dyasc;

public class ArticuloLibreria extends Producto {

    public ArticuloLibreria(int id, float precio, String nombre) {
        super(id, precio, nombre);
    }
    
    public float obtenerPrecio() {
        float recargoIva = (float) 1.21;
        return super.obtenerPrecio() * recargoIva;
    }

}
