package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BarcoTest {

    @Test
    public void siAtacoAUnBoteSeHunde() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(5,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        
        InformeDeAtaque informe = barco.recibirAtaque(5,5);
        
        assertEquals(informe, InformeDeAtaque.HUNDIDO);
    }
    
    @Test
    public void siAtacoAUnCruceroQueNoHabiaSidoAtacadoPreviamenteCausoUnaAveria() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        
        InformeDeAtaque informe = barco.recibirAtaque(3,3);
        
        assertEquals(informe, InformeDeAtaque.TOCADO);
    }
    
    @Test
    public void siAtacoAUnCruceroQueTeniaUnAtaquePrevioVuelveADarUnInfromeDeAveria() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        
        barco.recibirAtaque(3, 3);
        InformeDeAtaque informe = barco.recibirAtaque(3,4);
        
        assertEquals(informe, InformeDeAtaque.TOCADO);
    }
    
    @Test
    public void siAtacoAUnCruceroEnSusTresPosicionesSeInformaHundimiento() {
        Map<Casillero, Boolean> ubicacionEnTablero = new HashMap<>();
        ubicacionEnTablero.put(new Casillero(3,3), false);
        ubicacionEnTablero.put(new Casillero(3,4), false);
        ubicacionEnTablero.put(new Casillero(3,5), false);
        Barco barco = new Barco(ubicacionEnTablero);
        
        barco.recibirAtaque(3, 3);
        barco.recibirAtaque(3, 4);
        InformeDeAtaque informe = barco.recibirAtaque(3, 5);
        
        assertEquals(informe, InformeDeAtaque.HUNDIDO);
    }

}
