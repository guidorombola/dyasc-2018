package ar.edu.untref.dyasc;

public class Jugador {

    private int[] puntajesPosibles;
    private int puntajeActual;
    private int games;
    private boolean estaEnVentaja;
    private int sets;
    private int puntosDeTieBreak = 0;

    public Jugador() {
        puntajesPosibles = new int[] { 0, 15, 30, 40 };
    }

    public int puntaje() {
        return puntajesPosibles[puntajeActual];
    }

    public void incrementarPuntaje() {
        if (puntajeActual == this.puntajesPosibles.length - 1) {
            resetearPuntaje();
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

    public void resetearPuntaje() {
        puntajeActual = 0;
    }

    public int sets() {
        return sets;
    }

    public void incrementarSets() {
        sets++;
    }
    
    public int puntosDeTieBreak() {
        return puntosDeTieBreak;
    }
    
    public void incrementarPuntosTieBreak() {
        puntosDeTieBreak++;
    }
    
    public void resetearPuntosTieBreak() {
        puntosDeTieBreak = 0;
    }

}
