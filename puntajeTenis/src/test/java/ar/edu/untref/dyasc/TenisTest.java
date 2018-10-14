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

        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
    }

    @Test
    public void elJugadorUnoAnotaLaPrimeraPelotaExitosaYObtiene15Puntos() {

        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertEquals(15, partido.obtenerPuntaje(NumeroDeJugador.UNO));
        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
    }

    @Test
    public void elPrimerJugadorAnotaDosPelotasExitosasYObtiene30Puntos() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertEquals(30, partido.obtenerPuntaje(NumeroDeJugador.UNO));
    }

    @Test
    public void elJugadorUnoAnotaTresPelotasExitosasConsecutivasYObtiene40Puntos() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.UNO));
    }

    @Test
    public void elPrimerJugadorAnotaCuatroPelotasExitosasYGanaElGame() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
        Assert.assertEquals(1, partido.obtenerGames(NumeroDeJugador.UNO));
    }

    @Test
    public void losDosJugadoresLleganACuarentaPuntosYElJugadorUnoAnotaNuevamenteYNoGanaElGame() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.UNO));
        Assert.assertEquals(40, partido.obtenerPuntaje(NumeroDeJugador.UNO));
    }

    @Test
    public void estandoEnDeuceElJugadorUnoAnotaYSePoneEnVentajaYElJugadorDosNo() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertTrue(partido.estaEnVentaja(NumeroDeJugador.UNO));
        Assert.assertFalse(partido.estaEnVentaja(NumeroDeJugador.DOS));
    }

    @Test
    public void cuandoEstanEnDeuceYElJugadorUnoAnotaElJugadorDosAnotaTambienYNingunoQuedaEnVentaja() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.DOS);

        Assert.assertFalse(partido.estaEnVentaja(NumeroDeJugador.UNO));
        Assert.assertFalse(partido.estaEnVentaja(NumeroDeJugador.DOS));
    }

    @Test
    public void estandoEnDeuceElJugadorUnoAnotaDosVecesSeguidasYGanaElGame() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertEquals(1, partido.obtenerGames(NumeroDeJugador.UNO));
        Assert.assertEquals(0, partido.obtenerGames(NumeroDeJugador.DOS));
    }

    @Test
    public void elJugadorUnoGanaElGameEstandoEnDeuceYAmbosEstanSinVentajaYSinPuntos() {
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.DOS);
        partido.anotar(NumeroDeJugador.UNO);
        partido.anotar(NumeroDeJugador.UNO);

        Assert.assertFalse(partido.estaEnVentaja(NumeroDeJugador.UNO));
        Assert.assertFalse(partido.estaEnVentaja(NumeroDeJugador.DOS));
        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.UNO));
        Assert.assertEquals(0, partido.obtenerPuntaje(NumeroDeJugador.DOS));
    }
    
    @Test
    public void elJugadorUnoGanaUnSetEnCondicionesNormales() {
        final int anotacionesSinDeuceParaGanarUnGame = 4;
        final int gamesAnotadosParaElJugadorUno = 6;
        for(int i=0; i<anotacionesSinDeuceParaGanarUnGame*gamesAnotadosParaElJugadorUno; i++) {
            partido.anotar(NumeroDeJugador.UNO);
        }
        
        Assert.assertEquals(1, partido.obtenerSets(NumeroDeJugador.UNO));
    }
}
