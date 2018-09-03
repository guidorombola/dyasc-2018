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
        this.cuenta.aniadirCompraProducto(prod, mes);
    }
    
    public void aniadirSuscripcion(ArticuloSuscribible suscripcion) {
        
    }
    
    public CuentaCorriente getCuenta() {
        return cuenta;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public int getId() {
        return id;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
