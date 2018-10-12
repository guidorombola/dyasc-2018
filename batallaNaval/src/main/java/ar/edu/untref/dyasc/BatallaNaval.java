package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BatallaNaval {

    private List<Barco> barcosAnclados;

    public BatallaNaval(List<Barco> barcosDelJuego) {
        this.barcosAnclados = barcosDelJuego;
    }

    public InformeDeAtaque atacar(int coordenadaX, int coordenadaY) {
        Casillero casillero = new Casillero(coordenadaX, coordenadaY);
        Barco barcoObjetivo = buscarObjetivo(coordenadaX, coordenadaY);
        if (barcoObjetivo == null) {
            return InformeDeAtaque.AGUA;
        } else {
            barcoObjetivo.ubicacionEnTablero().put(casillero, true);
            if (barcoObjetivo.ubicacionEnTablero().containsValue(false)) {
                return InformeDeAtaque.TOCADO;
            } else {
                this.barcosAnclados.remove(barcoObjetivo);
                return InformeDeAtaque.HUNDIDO;
            }
        }

    }

    private Barco buscarObjetivo(int coordenadaX, int coordenadaY) {
        Iterator<Barco> iterador = barcosAnclados.iterator();
        boolean encontroBarco = false;
        Casillero casillero = new Casillero(coordenadaX, coordenadaY);
        Barco barcoObjetivo = null;
        while (iterador.hasNext() && !encontroBarco) {
            barcoObjetivo = iterador.next();
            if (barcoObjetivo.ubicacionEnTablero().keySet().contains(casillero)) {
                encontroBarco = true;
                return barcoObjetivo;
            }
        }
        return null;
    }

    public List<Barco> barcosAnclados() {
        return this.barcosAnclados;
    }

    public void aniadirBote(int coordenadaX, int coordenadaY) {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<Casillero, Boolean>();
        ubicacionEnTablero.put(new Casillero(coordenadaX,coordenadaY), false);
        Barco bote = new Barco(ubicacionEnTablero);
        this.barcosAnclados.add(bote);
    }

    public void aniadirCrucero(int coordenadaXInicio, int coordenadaYInicio, DireccionDeDespliegue direccion) {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<Casillero, Boolean>();
        Casillero casillero1 = new Casillero(coordenadaXInicio, coordenadaYInicio);
        Casillero casillero2 = null;
        Casillero casillero3 = null;
        switch(direccion) {
            case HACIA_ABAJO:
                casillero2 = new Casillero(coordenadaXInicio, coordenadaYInicio+1);
                casillero3 = new Casillero(coordenadaXInicio, coordenadaYInicio+2);
            case HACIA_ARRIBA:
                casillero2 = new Casillero(coordenadaXInicio, coordenadaYInicio-1);
                casillero3 = new Casillero(coordenadaXInicio, coordenadaYInicio-2);
            case HACIA_IZQUIERDA:
                casillero2 = new Casillero(coordenadaXInicio-1, coordenadaYInicio);
                casillero3 = new Casillero(coordenadaXInicio-2, coordenadaYInicio);
            case HACIA_DERECHA:
                casillero2 = new Casillero(coordenadaXInicio+1, coordenadaYInicio);
                casillero3 = new Casillero(coordenadaXInicio+2, coordenadaYInicio);
        }
        ubicacionEnTablero.put(casillero1, false);
        ubicacionEnTablero.put(casillero2, false);
        ubicacionEnTablero.put(casillero3, false);
        Barco crucero = new Barco(ubicacionEnTablero);
        this.barcosAnclados.add(crucero);
    }

}
