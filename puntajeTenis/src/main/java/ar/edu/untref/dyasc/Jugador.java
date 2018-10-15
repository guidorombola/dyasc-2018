package ar.edu.untref.dyasc;

public class Jugador {

    private int puntaje;
    private int games;
    private boolean estaEnVentaja;
    private int sets;
    private int puntosDeTieBreak;
    private int anotacionesDelGame;

    public Jugador() {
        puntaje = 0;
        games = 0;
        sets = 0;
        puntosDeTieBreak = 0;
        estaEnVentaja = false;
        anotacionesDelGame = 0;
    }

    public int puntaje() {
        return puntaje;
    }

    public int games() {
        return games;
    }
    
    public void incrementarGamesDelSetGanados() {
        games++;
        puntaje = 0;
    }

    public boolean estaEnVentaja() {
        return estaEnVentaja;
    }

    public void establecerVentaja(boolean estaEnVentaja) {
        this.estaEnVentaja = estaEnVentaja;
    }

    public void resetearPuntaje() {
        puntaje = 0;
        anotacionesDelGame = 0;
    }

    public int sets() {
        return sets;
    }

    public void incrementarSets() {
        sets++;
        resetearGamesDelSetGanados();
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
    
    public void incrementarAnotacionesDelGame() {
        anotacionesDelGame++;
    }
    
    public int anotacionesDelGame() {
        return anotacionesDelGame;
    }
    
    public void establecerPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    public void resetearGamesDelSetGanados() {
        games = 0;
        puntaje = 0;
    }

}
