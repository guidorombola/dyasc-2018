package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;
import ar.edu.untref.dyasc.Jugador;

public class PartidoDeTenis {

    private Map<NumeroDeJugador, Jugador> jugadores;
    private AnotadorDeSet anotadorDeSet;
    private AnotadorDeGame anotadorDeGame;

    public PartidoDeTenis() {
        jugadores = new HashMap<>();
        jugadores.put(NumeroDeJugador.UNO, new Jugador());
        jugadores.put(NumeroDeJugador.DOS, new Jugador());
        anotadorDeSet = new AnotadorDeSet();
        anotadorDeGame = new AnotadorDeGame();
    }

    public int obtenerPuntaje(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);

        return jugador.puntaje();
    }

    public int obtenerGames(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);
        
        return jugador.games();
    }
    
    public int obtenerSets(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = this.jugadores.get(numeroDeJugador);
        
        return jugador.sets();
    }
    
    public void anotar(NumeroDeJugador numeroDeJugador) {
        Jugador ganador = jugadores.get(numeroDeJugador);
        Jugador perdedor = jugadores.get(NumeroDeJugador.UNO);

        if (numeroDeJugador == NumeroDeJugador.UNO) {
            perdedor = jugadores.get(NumeroDeJugador.DOS);
        }
        boolean defineTieBreak = anotadorDeSet.defineTieBreak();
        if(!defineTieBreak) {
            anotadorDeGame.anotar(ganador, perdedor);            
        }
        anotadorDeSet.anotar(ganador, perdedor);
        
    }

    public boolean estaEnVentaja(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);

        return jugador.estaEnVentaja();
    }

    public int obtenerPuntosTieBreak(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = this.jugadores.get(numeroDeJugador);
        
        return jugador.puntosDeTieBreak();
    }

    public NumeroDeJugador obtenerGanador() {
                
        return NumeroDeJugador.UNO;
    }

}