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
        Jugador ganador = jugadores.get(numeroDeJugador);
        Jugador perdedor = jugadores.get(NumeroDeJugador.UNO);

        if (numeroDeJugador == NumeroDeJugador.UNO) {
            perdedor = jugadores.get(NumeroDeJugador.DOS);
        }

        if (ganador.puntaje() == perdedor.puntaje() && ganador.puntaje() == 40) {
            anotarEnDeuce(ganador, perdedor);

        } else {
            anotarNormalmente(ganador, perdedor);
        }
    }

    public int obtenerGames(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);

        return jugador.games();
    }

    public boolean estaEnVentaja(NumeroDeJugador numeroDeJugador) {
        Jugador jugador = jugadores.get(numeroDeJugador);

        return jugador.estaEnVentaja();
    }

    private void anotarNormalmente(Jugador ganador, Jugador perdedor) {
        ganador.incrementarPuntaje();
    }

    private void anotarEnDeuce(Jugador ganador, Jugador perdedor) {

        if (ganador.estaEnVentaja()) {
            ganador.establecerVentaja(false);
            ganador.incrementarPuntaje();
            perdedor.resetearPuntaje();

        } else {
            ganador.establecerVentaja(true);
            perdedor.establecerVentaja(false);
        }
    }
}