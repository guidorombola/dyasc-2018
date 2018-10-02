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
        List<Barco> barcosDelJuego = new ArrayList<>();
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        barcosDelJuego.add(barco);
        BatallaNaval batalla = new BatallaNaval(barcosDelJuego);
        
        InformeDeAtaque informe = batalla.atacar(3,6);
        
        assertEquals(informe, InformeDeAtaque.AGUA);
    }
    
    @Test
    public void atacarEnUnaPosicionDondeHayUnBote() {
        List<Barco> barcosDelJuego = new ArrayList<>();
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        Barco barco = new Barco(ubicacionEnTablero);
        barcosDelJuego.add(barco);
        BatallaNaval batalla = new BatallaNaval(barcosDelJuego);
        
        InformeDeAtaque informe = batalla.atacar(3,3);
        
        assertEquals(informe, InformeDeAtaque.HUNDIDO);
    }
    
    @Test
    public void siAtacoAUnCruceroQueNoHabiaSidoAtacadoPreviamenteCausoUnaAveria() {
        List<Barco> barcosDelJuego = new ArrayList<>();
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        barcosDelJuego.add(barco);
        BatallaNaval batalla = new BatallaNaval(barcosDelJuego);
    }
    
    @Test
    public void siAtacoAUnCruceroQueTeniaUnAtaquePrevioVuelveADarUnInfromeDeAveria() {
        List<Barco> barcosDelJuego = new ArrayList<>();
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        barcosDelJuego.add(barco);
        BatallaNaval batalla = new BatallaNaval(barcosDelJuego);
        
        batalla.atacar(3, 3);
        InformeDeAtaque informe = batalla.atacar(3, 4);
        
        assertEquals(informe, InformeDeAtaque.TOCADO);
    }
    
    @Test
    public void siAtacoAUnCruceroEnSusTresPosicionesSeInformaHundimiento() {
        List<Barco> barcosDelJuego = new ArrayList<>();
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        barcosDelJuego.add(barco);
        BatallaNaval batalla = new BatallaNaval(barcosDelJuego);
        
        batalla.atacar(3, 3);
        batalla.atacar(3, 4);
        InformeDeAtaque informe = batalla.atacar(3, 5);
        
        assertEquals(informe, InformeDeAtaque.HUNDIDO);
    }
    
    @Test
    public void siHundoAUnBarcoDebeEliminarseDelTablero() {
        List<Barco> barcosDelJuego = new ArrayList<>();
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        barcosDelJuego.add(barco);
        BatallaNaval batalla = new BatallaNaval(barcosDelJuego);
        
        batalla.atacar(3, 3);
        batalla.atacar(3, 4);
        batalla.atacar(3, 5);
        
        assertFalse(batalla.barcosAnclados().contains(barco));
    }

}
