package ar.edu.untref.dyasc;

public class AnotadorDeGame {

    private int[] puntajesPosibles;

    public AnotadorDeGame() {
        puntajesPosibles = new int[] { 0, 15, 30, 40 };
    }

    public void anotar(Jugador jugadorQueAnota, Jugador jugadorAdversario) {
        if (jugadorQueAnota.puntaje() == jugadorAdversario.puntaje() && jugadorQueAnota.puntaje() == 40) {
            anotarEnDeuce(jugadorQueAnota, jugadorAdversario);
        } else {
            anotarNormalmente(jugadorQueAnota, jugadorAdversario);
        }
    }

    public void anotarEnDeuce(Jugador jugadorQueAnota, Jugador jugadorAdversario) {
        if (jugadorQueAnota.estaEnVentaja()) {
            jugadorQueAnota.incrementarGamesDelSetGanados();
            jugadorQueAnota.establecerVentaja(false);
            jugadorAdversario.resetearPuntaje();
        } else {
            jugadorQueAnota.establecerVentaja(!jugadorAdversario.estaEnVentaja());
            jugadorAdversario.establecerVentaja(false);
        }
    }

    public void anotarNormalmente(Jugador jugadorQueAnota, Jugador jugadorAdversario) {
        if (jugadorQueAnota.puntaje() == 40) {
            jugadorQueAnota.resetearPuntaje();
            jugadorAdversario.resetearPuntaje();
            jugadorQueAnota.incrementarGamesDelSetGanados();
        } else {
            jugadorQueAnota.incrementarAnotacionesDelGame();
            jugadorQueAnota.establecerPuntaje(puntajesPosibles[jugadorQueAnota.anotacionesDelGame()]);
        }
    }
}
