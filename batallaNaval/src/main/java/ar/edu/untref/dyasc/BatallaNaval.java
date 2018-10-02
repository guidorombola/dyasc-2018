package ar.edu.untref.dyasc;

import java.util.Iterator;
import java.util.List;

public class BatallaNaval {
    
    private List<Barco> barcosAnclados;
    
    public BatallaNaval(List<Barco> barcosDelJuego) {
        this.barcosAnclados = barcosDelJuego;
    }

    public InformeDeAtaque atacar(int i, int j) {
        Casillero casillero = new Casillero(i,j);
        Barco barcoObjetivo = buscarObjetivo(i, j);
        if(barcoObjetivo == null) {
            return InformeDeAtaque.AGUA;
        } else {
            barcoObjetivo.ubicacionEnTablero().put(casillero, true);
            if (barcoObjetivo.ubicacionEnTablero().containsValue(false)) {
                return InformeDeAtaque.TOCADO;
            } else {
                return InformeDeAtaque.HUNDIDO;
            }
        }    
        
    }
    
    public Barco buscarObjetivo(int i, int j) {
        Iterator<Barco> iterador = barcosAnclados.iterator();
        boolean encontroBarco = false;
        Casillero casillero = new Casillero(i,j);
        Barco barcoObjetivo = null;
        while(iterador.hasNext() && !encontroBarco) {
            barcoObjetivo = iterador.next();
            if(barcoObjetivo.ubicacionEnTablero().keySet().contains(casillero)) {
                encontroBarco = true;
                return barcoObjetivo;
            }
        }
        return null;
    }

}
