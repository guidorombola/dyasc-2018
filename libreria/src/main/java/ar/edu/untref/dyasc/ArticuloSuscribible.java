package ar.edu.untref.dyasc;

public class ArticuloSuscribible extends Producto {

    private TipoArticuloSuscribible tipo;
    private int periodicidadMensual;
    private PeriodoSuscripcion periodo;

    public ArticuloSuscribible(int id, float precio, String nombre, TipoArticuloSuscribible tipo,
            int periodicidadMensual, PeriodoSuscripcion periodo) {
        super(id, precio, nombre);
        this.tipo = tipo;
        this.periodicidadMensual = periodicidadMensual;
        this.periodo = periodo;
    }

    public PeriodoSuscripcion obtenerPeriodo() {
        return periodo;
    }

    public TipoArticuloSuscribible obtenerTipo() {
        return tipo;
    }

    public int obtenerPeriodicidadMensual() {
        return periodicidadMensual;
    }

    public void establecerPeriodo(PeriodoSuscripcion periodo) {
        this.periodo = periodo;
    }

}
