package ar.edu.untref.dyasc;

public class ClienteRegistrado {
    
    private int id;
    private String direccion;
    private CuentaCorriente cuenta;
    
    public ClienteRegistrado(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
        this.cuenta = new CuentaCorriente();
    }
    
    public void aniadirProducto(Producto prod, String mes) {
        this.cuenta.aniadirProducto(prod, mes);
    }
    
    public void aniadirSuscripcion(ArticuloSuscribible suscripcion, String mes) {
        this.cuenta.aniadirSuscripcion(suscripcion, mes);
    }
    
    public void aniadirSuscripcion(ArticuloSuscribible suscripcion) {
        this.cuenta.aniadirSuscripcion(suscripcion);
    }
    
    public CuentaCorriente obtenerCuenta() {
        return cuenta;
    }
    
    public String obtenerDireccion() {
        return direccion;
    }
    
    public int obtenerId() {
        return id;
    }
    
    public void establecerDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
