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

    @Override
    public int hashCode() {
        return ubicacionEnTablero.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this.getClass() != obj.getClass() || obj == null) {
            return false;
        } else {
            Barco barco = (Barco)obj;
            return (this.ubicacionEnTablero.equals(barco.ubicacionEnTablero()));
        }
    }
    
    

}
