package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

public class Libreria {

    private Map<Integer, ClienteRegistrado> clientesRegistrados;
    private Map<Integer, GeneradorProducto> catalogoProductosNoSuscribibles;
    private Map<Integer, GeneradorProducto> catalogoProductosSuscribibles;
    private static float descuentoPorRegistro = 0.95f;
    private static float descuentoPorSuscripcionAnual = 0.8f;

    public Libreria(Map<Integer, ClienteRegistrado> clientesRegistrados, 
            Map<Integer, GeneradorProducto> catalogoProductosNoSuscribibles, 
            Map<Integer, GeneradorProducto> catalogoProductosSuscribibles) {
        this.clientesRegistrados = clientesRegistrados;
        this.catalogoProductosNoSuscribibles = catalogoProductosNoSuscribibles;
        this.catalogoProductosSuscribibles = catalogoProductosSuscribibles;
    }

    public Map<Integer, Float> obtenerImportesACobrarPorClienteMensual(String mes){
        Map<Integer, Float> importes = new HashMap<>();
        float importeMensual = 0;
        for(Integer cliente : clientesRegistrados.keySet()) {
            importeMensual = this.obtenerTotalACobrarMensual(cliente, mes);
            importes.put(cliente, importeMensual);
        }
        return importes;
    }

    public Map<Integer,Float> obtenerImportesACobrarPorClienteAnual(){
        Map<Integer, Float> importes = new HashMap<>();
        float importeAnual = 0;
        for(Integer cliente : clientesRegistrados.keySet()) {
            importeAnual = this.obtenerTotalACobrarAnual(cliente);
            importes.put(cliente, importeAnual);
        }
        return importes;
    }

    public float obtenerTotalACobrarMensual(int idCliente, String mes) {
        return this.clientesRegistrados.get(idCliente).obtenerCuenta().obtenerTotalMensual(mes);
    }

    public float obtenerTotalACobrarAnual(int idCliente) {
        return this.clientesRegistrados.get(idCliente).obtenerCuenta().obtenerTotalAnual();
    }

    public void aniadirCompraProducto(int idCliente, int idProducto, String mes) {
        ClienteRegistrado cliente = this.clientesRegistrados.get(idCliente);
        Producto producto = this.catalogoProductosNoSuscribibles.get(idProducto).generar();
        cliente.aniadirProducto(producto, mes);
    }

    public void aniadirSuscripcion(int idCliente, int idProducto, String mes) {
        ClienteRegistrado cliente = this.clientesRegistrados.get(idCliente);
        ArticuloSuscribible suscripcion = (ArticuloSuscribible) this.catalogoProductosSuscribibles.get(idProducto).generar();
        suscripcion.establecerPeriodo(PeriodoSuscripcion.MENSUAL);
        cliente.aniadirSuscripcion(suscripcion, mes);
    }

    public void aniadirSuscripcion(int idCliente, int idProducto) {
        ClienteRegistrado cliente = this.clientesRegistrados.get(idCliente);
        ArticuloSuscribible suscripcion = (ArticuloSuscribible) this.catalogoProductosSuscribibles.get(idProducto).generar();
        suscripcion.establecerPeriodo(PeriodoSuscripcion.ANUAL);
        cliente.aniadirSuscripcion(suscripcion);
    }

    public static float obtenerDescuentoPorRegistro() {
        return descuentoPorRegistro;
    }

    public static float obtenerDescuentoPorSuscripcionAnual() {
        return descuentoPorSuscripcionAnual;
    }
}
