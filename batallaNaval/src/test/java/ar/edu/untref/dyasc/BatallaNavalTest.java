package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void atacarEnUnaPosicionDondeHayAgua() {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirBote(4,3);
        
        InformeDeAtaque informe = batalla.atacar(3, 6);

        assertEquals(InformeDeAtaque.AGUA, informe);
    }

    @Test
    public void siAtacoAUnaPosicionDondeHayUnBoteLoHundo() {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirBote(4,3);

        InformeDeAtaque informe = batalla.atacar(4, 3);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }

    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaAbajoQueNoHabiaSidoAtacadoPreviamenteCausoUnaAveria() {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);
        
        InformeDeAtaque informe = batalla.atacar(4, 3);
        assertEquals(InformeDeAtaque.TOCADO, informe);
    }

    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaAbajoQueTeniaUnAtaquePrevioVuelveADarUnInfromeDeAveria() {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);
        
        batalla.atacar(4, 3);
        InformeDeAtaque informe = batalla.atacar(4, 4);

        assertEquals(InformeDeAtaque.TOCADO, informe);
    }

    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaAbajoEnSusTresPosicionesSeInformaHundimiento() {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);

        batalla.atacar(4, 3);
        batalla.atacar(4, 4);
        InformeDeAtaque informe = batalla.atacar(4, 5);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }

    @Test
    public void siHundoAUnCruceroDesplegadoHaciaAbajoDebeEliminarseDelTablero() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(4, 3), false);
        ubicacionEnTablero.put(new Casillero(4, 4), false);
        ubicacionEnTablero.put(new Casillero(4, 5), false);
        Barco barcoQueSeEsperaQueHayaSidoEliminado = new Barco(ubicacionEnTablero);
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);

        batalla.atacar(4, 3);
        batalla.atacar(4, 4);
        batalla.atacar(4, 5);

        assertFalse(batalla.barcosAnclados().contains(barcoQueSeEsperaQueHayaSidoEliminado));
    }
    
    @Test
    public void siHundoAUnCruceroDesplegadoHaciaArribaDebeEliminarseDelTablero() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(4, 1), false);
        ubicacionEnTablero.put(new Casillero(4, 2), false);
        ubicacionEnTablero.put(new Casillero(4, 3), false);
        Barco barcoQueSeEsperaQueHayaSidoEliminado = new Barco(ubicacionEnTablero);
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ARRIBA);

        batalla.atacar(4, 1);
        batalla.atacar(4, 2);
        batalla.atacar(4, 3);

        assertFalse(batalla.barcosAnclados().contains(barcoQueSeEsperaQueHayaSidoEliminado));
    }
    
    @Test
    public void siHundoAUnCruceroDesplegadoHaciaDerechaDebeEliminarseDelTablero() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(4, 3), false);
        ubicacionEnTablero.put(new Casillero(5, 3), false);
        ubicacionEnTablero.put(new Casillero(6, 3), false);
        Barco barcoQueSeEsperaQueHayaSidoEliminado = new Barco(ubicacionEnTablero);
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_DERECHA);

        batalla.atacar(4, 3);
        batalla.atacar(5, 3);
        batalla.atacar(6, 3);

        assertFalse(batalla.barcosAnclados().contains(barcoQueSeEsperaQueHayaSidoEliminado));
    }

}
