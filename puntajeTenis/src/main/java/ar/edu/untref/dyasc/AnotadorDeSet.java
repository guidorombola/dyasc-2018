package ar.edu.untref.dyasc;

public class AnotadorDeSet {

    private boolean defineTieBreak;

    public AnotadorDeSet() {
        defineTieBreak = false;
    }

    public void anotar(Jugador jugadorQueAnota, Jugador jugadorAdversario) {
        if (jugadorQueAnota.games() == jugadorAdversario.games() && jugadorQueAnota.games() == 6) {
            if (defineTieBreak) { // Si no es la primera vez que se define tie break
                anotarEnTieBreak(jugadorQueAnota, jugadorAdversario);
            }
            defineTieBreak = true;
        } else {
            if (Math.abs((jugadorQueAnota.games() - jugadorAdversario.games())) >= 2 && jugadorQueAnota.games() >= 6) {
                jugadorQueAnota.incrementarSets();
                jugadorQueAnota.resetearGamesDelSetGanados();
                jugadorAdversario.resetearGamesDelSetGanados();
            }
        }

    }

    public void anotarEnTieBreak(Jugador jugadorQueAnota, Jugador jugadorAdversario) {
        jugadorQueAnota.incrementarPuntosTieBreak();
        if (Math.abs(jugadorQueAnota.puntosDeTieBreak() - jugadorAdversario.puntosDeTieBreak()) >= 2
                && jugadorQueAnota.puntosDeTieBreak() >= 7) {
            jugadorQueAnota.incrementarSets();
            jugadorQueAnota.resetearGamesDelSetGanados();
            jugadorAdversario.resetearGamesDelSetGanados();
            jugadorQueAnota.resetearPuntosTieBreak();
            jugadorAdversario.resetearPuntosTieBreak();
            defineTieBreak = false;
        }
    }

    public boolean defineTieBreak() {
        return defineTieBreak;
    }
}
