package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CuentaCorriente {
    
    private Map<String, List<Producto>> productosSinSuscripcion;
    private Map<String, List<ArticuloSuscribible>> suscripciones;
    
    public CuentaCorriente() {
        this.productosSinSuscripcion = new HashMap<String, List<Producto>>();
        this.suscripciones = new HashMap<String, List<ArticuloSuscribible>>();
        this.inicializarListasProductos();
        this.inicializarListasSuscripciones();
    }
    
    public float obtenerTotalAnual() {
        return this.calcularTotalSuscripcionesAnual() + this.calcularTotalProductosAnual();
    }
    
    public float obtenerTotalMensual(String mes) {
        return this.calcularTotalProductosMensual(mes) + this.calcularTotalSuscripcionesMensual(mes);
    }
    
    public void aniadirProducto(Producto producto, String mes) {
        this.productosSinSuscripcion.get(mes).add(producto);
    }
    
    public void aniadirSuscripcion(ArticuloSuscribible suscripcion) {
        for(List<ArticuloSuscribible> compras : this.suscripciones.values()) {
            compras.add(suscripcion);
        }
    }
    
    public void aniadirSuscripcion(ArticuloSuscribible suscripcion, String mes) {
        this.suscripciones.get(mes).add(suscripcion);
    }
    
    private float calcularTotalProductosMensual(String mes) {
        float totalMensual = 0;
        Iterator<Producto> itr = this.productosSinSuscripcion.get(mes).iterator();
        while(itr.hasNext()) {
            Producto compra = itr.next();
            totalMensual += compra.obtenerPrecio();
        }
        return totalMensual * Libreria.obtenerDescuentoPorRegistro();
    }
    
    private float calcularTotalSuscripcionesMensual(String mes) {
        float totalSuscripcionesAnuales = 0;
        float totalSuscripcionesMensuales = 0;
        Iterator<ArticuloSuscribible> itr = this.suscripciones.get(mes).iterator();
        while(itr.hasNext()) {
            ArticuloSuscribible compra = itr.next();
            if(compra.obtenerPeriodo() == PeriodoSuscripcion.ANUAL) {
                totalSuscripcionesAnuales += compra.obtenerPrecio();
            } else {
                totalSuscripcionesMensuales += compra.obtenerPrecio();
            }
        }
        return totalSuscripcionesAnuales * Libreria.obtenerDescuentoPorSuscripcionAnual() + 
                totalSuscripcionesMensuales * Libreria.obtenerDescuentoPorRegistro();
    }
    
    private float calcularTotalProductosAnual() {
        float totalComprasProductos = 0;
        for(String mes: this.productosSinSuscripcion.keySet()) {
            totalComprasProductos += this.calcularTotalProductosMensual(mes);
        }
        return totalComprasProductos;
    }
    
    private float calcularTotalSuscripcionesAnual() {
        float totalSuscripciones = 0;       
        for(String mes : this.suscripciones.keySet()) {
            totalSuscripciones += this.calcularTotalSuscripcionesMensual(mes);
        }
        return totalSuscripciones;
    }
    
    private void inicializarListasSuscripciones() {
        for(List<ArticuloSuscribible> compras : this.suscripciones.values()) {
            compras = new ArrayList<ArticuloSuscribible>();
        }
    }
    
    private void inicializarListasProductos() {
        for(List<Producto> compras : this.productosSinSuscripcion.values()) {
            compras = new ArrayList<Producto>();
        }
    }

}
