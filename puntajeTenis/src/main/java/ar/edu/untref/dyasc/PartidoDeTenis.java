package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

import ar.edu.untref.dyasc.Jugador;

public class PartidoDeTenis {
    
    private Map<NumeroDeJugador, Jugador> jugadores;
    
    public PartidoDeTenis() {
        jugadores = new HashMap<>();
        jugadores.put(NumeroDeJugador.UNO, new Jugador());
        jugadores.put(NumeroDeJugador.DOS, new Jugador());
    }

    public int obtenerPuntaje(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);
        
        return jugador.puntaje();
    }

    public void anotar(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);
        jugador.incrementarPuntaje();
    }

    public int obtenerGames(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);
                
        return jugador.games();
    }

}