package ar.edu.untref.dyasc;

public class Jugador {

    private int[] puntajesPosibles;
    private int puntajeActual;
    private int games;
    private boolean estaEnVentaja;

    public Jugador() {
        puntajesPosibles = new int[] { 0, 15, 30, 40 };
    }

    public int puntaje() {
        return puntajesPosibles[puntajeActual];
    }

    public void incrementarPuntaje() {
        if (puntajeActual == this.puntajesPosibles.length - 1) {
            puntajeActual = 0;
            games++;
        } else {
            puntajeActual++;
        }
    }

    public int games() {
        return games;
    }

    public boolean estaEnVentaja() {
        return estaEnVentaja;
    }

    public void establecerVentaja(boolean estaEnVentaja) {
        this.estaEnVentaja = estaEnVentaja;
    }

    public void incrementarGames() {
        games++;
    }
}
