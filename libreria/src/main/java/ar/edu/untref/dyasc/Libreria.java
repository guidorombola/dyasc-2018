package ar.edu.untref.dyasc;

import java.util.Map;

public class Libreria {

    private Map<Integer, ClienteRegistrado> clientesRegistrados;
    private Map<Integer, Producto> productos;
    
    public Libreria(Map<Integer, ClienteRegistrado> clientesRegistrados, Map<Integer, Producto> productos) {
        this.clientesRegistrados = clientesRegistrados;
        this.productos = productos;
    }
    
    public float obtenerTotalACobrarMensual(int idCliente, String mes) {
        return this.clientesRegistrados.get(idCliente).getCuenta().obtenerTotalMensual(mes);
    }
    
    public float obtenerTotalACobrarAnual(int idCliente) {
        return this.clientesRegistrados.get(idCliente).getCuenta().obtenerTotalAnual();
    }
    
    public void aniadirCompra(int idCliente, int idProducto, String mes) {
        
        return;
    }
    
    public void aniadirSuscripcionMensual(int idCliente, int idProducto, TipoArticuloSuscribible tipoSuscripcion, String mes) {
        return;
    }
    
    public void aniadirSuscripcionAnual(int idCliente, int idProducto, TipoArticuloSuscribible tipoSuscripcion) {
        return ;
    }
}
