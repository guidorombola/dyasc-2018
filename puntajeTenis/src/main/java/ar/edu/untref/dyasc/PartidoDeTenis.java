package ar.edu.untref.dyasc;

public class PartidoDeTenis {
    
    int puntajeJugador1 = 0;
    int puntajeJugador2 = 0;
    private int[] puntajesPosibles = {0, 15, 30, 40};

    public int obtenerPuntaje(Jugador jugador) {
        int puntaje = puntajeJugador1;
        
        if (jugador == Jugador.DOS) {
            puntaje = puntajeJugador2;
        }
        
        return puntajesPosibles[puntaje];
    }

    public void anotar(Jugador jugador) {
        if(jugador == Jugador.UNO) {
            puntajeJugador1++;
        } else {
            puntajeJugador2++;
        }
    }

}