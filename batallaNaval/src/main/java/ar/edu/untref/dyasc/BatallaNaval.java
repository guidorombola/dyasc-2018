package ar.edu.untref.dyasc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BatallaNaval {

    private static final int TAMANIO_TABLERO = 10;
    private List<Barco> barcosAnclados;

    public BatallaNaval() {
        this.barcosAnclados = new ArrayList<>();
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

    public void aniadirBote(int coordenadaX, int coordenadaY) throws ExcepcionLimitesInvalidos {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<Casillero, Boolean>();
        ubicacionEnTablero.put(new Casillero(coordenadaX,coordenadaY), false);
        if(!ubicacionEnTableroValida(ubicacionEnTablero.keySet())) {
            throw new ExcepcionLimitesInvalidos();
        }
        Barco bote = new Barco(ubicacionEnTablero);
        this.barcosAnclados.add(bote);
    }

    public void aniadirCrucero(int coordenadaXInicio, int coordenadaYInicio, DireccionDeDespliegue direccion) throws ExcepcionLimitesInvalidos {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<Casillero, Boolean>();
        Casillero casillero1 = new Casillero(coordenadaXInicio, coordenadaYInicio);
        Casillero casillero2 = null;
        Casillero casillero3 = null;
        switch(direccion) {
            case HACIA_ABAJO:
                casillero2 = new Casillero(coordenadaXInicio, coordenadaYInicio+1);
                casillero3 = new Casillero(coordenadaXInicio, coordenadaYInicio+2);
                break;
            case HACIA_ARRIBA:
                casillero2 = new Casillero(coordenadaXInicio, coordenadaYInicio-1);
                casillero3 = new Casillero(coordenadaXInicio, coordenadaYInicio-2);
                break;
            case HACIA_IZQUIERDA:
                casillero2 = new Casillero(coordenadaXInicio-1, coordenadaYInicio);
                casillero3 = new Casillero(coordenadaXInicio-2, coordenadaYInicio);
                break;
            case HACIA_DERECHA:
                casillero2 = new Casillero(coordenadaXInicio+1, coordenadaYInicio);
                casillero3 = new Casillero(coordenadaXInicio+2, coordenadaYInicio);
                break;
        }
        ubicacionEnTablero.put(casillero1, false);
        ubicacionEnTablero.put(casillero2, false);
        ubicacionEnTablero.put(casillero3, false);
        if(!ubicacionEnTableroValida(ubicacionEnTablero.keySet())) {
            throw new ExcepcionLimitesInvalidos();
        }
        Barco crucero = new Barco(ubicacionEnTablero);
        this.barcosAnclados.add(crucero);
    }
    
    private boolean ubicacionEnTableroValida(Set<Casillero> casilerosQueConformaranElBarco) {
        Iterator<Casillero> iterador = casilerosQueConformaranElBarco.iterator();
        boolean casillerosValidos = true;
        Casillero actual = null;
        while(iterador.hasNext() && casillerosValidos) {
            actual = iterador.next();
            casillerosValidos = (actual.coordenadaX() >= 0 && actual.coordenadaX() < TAMANIO_TABLERO) && 
                    (actual.coordenadaY()>= 0 && actual.coordenadaY() < TAMANIO_TABLERO);
        }
        return casillerosValidos;
    }

}
