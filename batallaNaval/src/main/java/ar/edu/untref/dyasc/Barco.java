package ar.edu.untref.dyasc;

import java.util.Map;

public class Barco {

    private Map<Casillero, Boolean> ubicacionEnTablero;

    public Barco(Map<Casillero, Boolean> ubicacionEnTablero) {
        this.ubicacionEnTablero = ubicacionEnTablero;
    }

    public Map<Casillero, Boolean> ubicacionEnTablero() {
        return this.ubicacionEnTablero;
    }

}
