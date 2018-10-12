package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void siAtacoEnUnaPosicionDondeNoHayBarcosInformaAgua() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirBote(4,3);
        
        InformeDeAtaque informe = batalla.atacar(3, 6);

        assertEquals(InformeDeAtaque.AGUA, informe);
    }

    @Test
    public void siAtacoAUnaPosicionDondeHayUnBoteLoHundo() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirBote(4,3);

        InformeDeAtaque informe = batalla.atacar(4, 3);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }

    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaAbajoQueNoHabiaSidoAtacadoPreviamenteCausoUnaAveria() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);
        
        InformeDeAtaque informe = batalla.atacar(4, 3);
        assertEquals(InformeDeAtaque.TOCADO, informe);
    }

    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaAbajoQueTeniaUnAtaquePrevioVuelveADarUnInfromeDeAveria() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);
        
        batalla.atacar(4, 3);
        InformeDeAtaque informe = batalla.atacar(4, 4);

        assertEquals(InformeDeAtaque.TOCADO, informe);
    }

    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaAbajoEnSusTresPosicionesSeInformaHundimiento() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ABAJO);

        batalla.atacar(4, 3);
        batalla.atacar(4, 4);
        InformeDeAtaque informe = batalla.atacar(4, 5);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }
    
    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaArribaEnDosDeSusPosicionesInformaAveria() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ARRIBA);

        batalla.atacar(4, 3);
        InformeDeAtaque informe = batalla.atacar(4, 2);

        assertEquals(InformeDeAtaque.TOCADO, informe);
    }
    
    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaArribaEnSusTresPosicionesSeInformaHundimieno() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_ARRIBA);

        batalla.atacar(4, 3);
        batalla.atacar(4, 2);
        InformeDeAtaque informe = batalla.atacar(4, 1);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }
    
    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaDerechaEnDosDeSusPosicionesInformaAveria() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_DERECHA);

        batalla.atacar(4, 3);
        InformeDeAtaque informe = batalla.atacar(5, 3);

        assertEquals(InformeDeAtaque.TOCADO, informe);
    }
    
    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaDerechaEnSusTresPosicionesSeInformaHundimieno() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_DERECHA);

        batalla.atacar(4, 3);
        batalla.atacar(5, 3);
        InformeDeAtaque informe = batalla.atacar(6, 3);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }
    
    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaIzquierdaEnDosDeSusPosicionesInformaAveria() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_IZQUIERDA);

        batalla.atacar(4, 3);
        InformeDeAtaque informe = batalla.atacar(3, 3);

        assertEquals(InformeDeAtaque.TOCADO, informe);
    }
    
    @Test
    public void siAtacoAUnCruceroDesplegadoHaciaIzquierdaEnSusTresPosicionesSeInformaHundimieno() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_IZQUIERDA);

        batalla.atacar(4, 3);
        batalla.atacar(3, 3);
        InformeDeAtaque informe = batalla.atacar(2, 3);

        assertEquals(InformeDeAtaque.HUNDIDO, informe);
    }

    @Test
    public void siHundoAUnCruceroDesplegadoHaciaAbajoDebeEliminarseDelTablero() throws ExcepcionLimitesInvalidos {
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
    public void siHundoAUnCruceroDesplegadoHaciaArribaDebeEliminarseDelTablero() throws ExcepcionLimitesInvalidos {
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
    public void siHundoAUnCruceroDesplegadoHaciaDerechaDebeEliminarseDelTablero() throws ExcepcionLimitesInvalidos {
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
    
    @Test
    public void siHundoAUnCruceroDesplegadoHaciaIzquierdaDebeEliminarseDelTablero() throws ExcepcionLimitesInvalidos {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(4, 3), false);
        ubicacionEnTablero.put(new Casillero(3, 3), false);
        ubicacionEnTablero.put(new Casillero(2, 3), false);
        Barco barcoQueSeEsperaQueHayaSidoEliminado = new Barco(ubicacionEnTablero);
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(4, 3, DireccionDeDespliegue.HACIA_IZQUIERDA);

        batalla.atacar(4, 3);
        batalla.atacar(3, 3);
        batalla.atacar(2, 3);

        assertFalse(batalla.barcosAnclados().contains(barcoQueSeEsperaQueHayaSidoEliminado));
    }
    
    @Test(expected = ExcepcionLimitesInvalidos.class)
    public void siQuieroAniadirUnBoteFueraDeLosLimitesDelTableroArrojaExcepcion() throws ExcepcionLimitesInvalidos {
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirBote(20, 20);
    }
    
    @Test(expected = ExcepcionLimitesInvalidos.class)
    public void siQuieroAniadirUnCruceroDesplegadoHaciaAbajoFueraDeLosLimitesDelTableroArrojaExcepcion() throws ExcepcionLimitesInvalidos{
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(5, 10, DireccionDeDespliegue.HACIA_ABAJO);
    }
    
    @Test(expected = ExcepcionLimitesInvalidos.class)
    public void siQuieroAniadirUnCruceroDesplegadoHaciaArribaFueraDeLosLimitesDelTableroArrojaExcepcion() throws ExcepcionLimitesInvalidos{
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(5, 0, DireccionDeDespliegue.HACIA_ARRIBA);
    }
    
    @Test(expected = ExcepcionLimitesInvalidos.class)
    public void siQuieroAniadirUnCruceroDesplegadoHaciaDerechaFueraDeLosLimitesDelTableroArrojaExcepcion() throws ExcepcionLimitesInvalidos{
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(9, 5, DireccionDeDespliegue.HACIA_DERECHA);
    }
    
    @Test(expected = ExcepcionLimitesInvalidos.class)
    public void siQuieroAniadirUnCruceroDesplegadoHaciaIzquierdaFueraDeLosLimitesDelTableroArrojaExcepcion() throws ExcepcionLimitesInvalidos{
        BatallaNaval batalla = new BatallaNaval();
        batalla.aniadirCrucero(1, 5, DireccionDeDespliegue.HACIA_IZQUIERDA);
    }

}
