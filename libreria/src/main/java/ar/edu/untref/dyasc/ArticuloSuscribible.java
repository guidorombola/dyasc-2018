package ar.edu.untref.dyasc;

public class ArticuloSuscribible extends Producto {
    
    private TipoArticuloSuscribible tipo;
    private int periodicidadMensual;
    private PeriodoSuscripcion periodo;

    public ArticuloSuscribible(int id, float precio, String nombre, TipoArticuloSuscribible tipo, int periodicidadMensual, PeriodoSuscripcion periodo) {
        super(id, precio, nombre);
        this.tipo = tipo;
        this.periodicidadMensual = periodicidadMensual;
        this.periodo = periodo;
    }
    
    public PeriodoSuscripcion getPeriodo() {
        return periodo;
    }
    
    public TipoArticuloSuscribible getTipo() {
        return tipo;
    }
    
    public int getPeriodicidadMensual() {
        return periodicidadMensual;
    }

}
