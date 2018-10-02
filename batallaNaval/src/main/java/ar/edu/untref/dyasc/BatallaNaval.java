package ar.edu.untref.dyasc;

import java.util.Iterator;
import java.util.List;

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

}
