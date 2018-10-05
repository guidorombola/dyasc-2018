package ar.edu.untref.dyasc;

import org.junit.Assert;
import org.junit.Test;

public class TenisTest {

    @Test
    public void empiezaElPartidoYNingunJugadorTienePuntos() {
        PartidoDeTenis partido = new PartidoDeTenis();
        
        Assert.assertEquals(0, partido.obtenerPuntaje(Jugador.UNO));
        Assert.assertEquals(0, partido.obtenerPuntaje(Jugador.DOS));
    }
}
