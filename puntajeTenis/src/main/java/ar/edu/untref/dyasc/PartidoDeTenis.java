package ar.edu.untref.dyasc;

public class PartidoDeTenis {
    
    int puntajeJugador1 = 0;
    int puntajeJugador2 = 0;

    public int obtenerPuntaje(Jugador jugador) {
        int puntaje = puntajeJugador1;
        
        if (jugador == Jugador.DOS) {
            puntaje = puntajeJugador2;
        }
        
        return puntaje;
    }

    public void anotar(Jugador uno) {
        if(uno == Jugador.UNO) {
            puntajeJugador1 = 15;
        } else {
            puntajeJugador2 = 15;
        }
    }

}