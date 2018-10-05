package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenisTest {

    private PartidoDeTenis partido;

    @Before
    public void inicializarPartidoDeTenis() {
        partido = new PartidoDeTenis();
    }
    
    @Test
    public void empiezaElPartidoYNingunJugadorTienePuntos() {
        
        Assert.assertEquals(0, partido.obtenerPuntaje(Jugador.UNO));
        Assert.assertEquals(0, partido.obtenerPuntaje(Jugador.DOS));
    }

    @Test
    public void elJugadorUnoAnotaLaPrimeraPelotaExitosaYObtiene15Puntos() {
        
        partido.anotar(Jugador.UNO);
        
        Assert.assertEquals(15, partido.obtenerPuntaje(Jugador.UNO));
        Assert.assertEquals(0, partido.obtenerPuntaje(Jugador.DOS));
    }
    
    @Test
    public void elPrimerJugadorAnotaDosPelotasExitosasYObtiene30Puntos() {
        partido.anotar(Jugador.UNO);
        partido.anotar(Jugador.UNO);
        
        Assert.assertEquals(30, partido.obtenerPuntaje(Jugador.UNO));
    }
    
    @Test
    public void elJugadorUnoAnotaTresPelotasExitosasConsecutivasYObtiene40Puntos() {
        partido.anotar(Jugador.UNO);
        partido.anotar(Jugador.UNO);
        partido.anotar(Jugador.UNO);
        
        Assert.assertEquals(40, partido.obtenerPuntaje(Jugador.UNO));
    }
}
