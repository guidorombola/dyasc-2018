package ar.edu.untref.dyasc;

import java.util.Map;

public class Barco {
    
    private Map<Casillero, Boolean> ubicacionEnTablero;
    
    public Barco(Map<Casillero, Boolean> ubicacionEnTablero) {
       this.ubicacionEnTablero = ubicacionEnTablero;
    }

    public InformeDeAtaque recibirAtaque(int coordenadaX, int coordenadaY) {
        Casillero coordenada = new Casillero(coordenadaX,coordenadaY);
        this.ubicacionEnTablero.put(coordenada, true);
        if(ubicacionEnTablero.containsValue(false)) {
            return InformeDeAtaque.TOCADO;            
        } else {
            return InformeDeAtaque.HUNDIDO;
        }
    }

}
