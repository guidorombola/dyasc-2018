package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class BarcoTest {

    @Test
    public void dosBarcosConLosMismosCasillerosSonIguales() {
        Map<Casillero, Boolean> ubicacionEnTableroBarco1 = new HashMap<>();
        ubicacionEnTableroBarco1.put(new Casillero(4, 3), false);
        ubicacionEnTableroBarco1.put(new Casillero(4, 4), false);
        ubicacionEnTableroBarco1.put(new Casillero(4, 5), false);
        Map<Casillero, Boolean> ubicacionEnTableroBarco2 = new HashMap<>();
        ubicacionEnTableroBarco2.put(new Casillero(4, 3), false);
        ubicacionEnTableroBarco2.put(new Casillero(4, 4), false);
        ubicacionEnTableroBarco2.put(new Casillero(4, 5), false);
        Barco barco1 = new Barco(ubicacionEnTableroBarco1);
        Barco barco2 = new Barco(ubicacionEnTableroBarco2);
        
        assertEquals(barco1, barco2);    
    }
    
    @Test
    public void dosBarcosConDistintosCasillerosSonDistintos() {
        Map<Casillero, Boolean> ubicacionEnTableroBarco1 = new HashMap<>();
        ubicacionEnTableroBarco1.put(new Casillero(4, 3), false);
        ubicacionEnTableroBarco1.put(new Casillero(4, 4), false);
        ubicacionEnTableroBarco1.put(new Casillero(4, 5), false);
        Map<Casillero, Boolean> ubicacionEnTableroBarco2 = new HashMap<>();
        ubicacionEnTableroBarco2.put(new Casillero(6, 8), false);
        ubicacionEnTableroBarco2.put(new Casillero(6, 9), false);
        ubicacionEnTableroBarco2.put(new Casillero(6, 10), false);
        Barco barco1 = new Barco(ubicacionEnTableroBarco1);
        Barco barco2 = new Barco(ubicacionEnTableroBarco2);
        
        assertNotEquals(barco1, barco2);    
    }
    
    @Test
    public void dosBarcosConLosMismosCasillerosTienenElMismoHashCode() {
        Map<Casillero, Boolean> ubicacionEnTableroBarco1 = new HashMap<>();
        ubicacionEnTableroBarco1.put(new Casillero(4, 3), false);
        ubicacionEnTableroBarco1.put(new Casillero(4, 4), false);
        ubicacionEnTableroBarco1.put(new Casillero(4, 5), false);
        Map<Casillero, Boolean> ubicacionEnTableroBarco2 = new HashMap<>();
        ubicacionEnTableroBarco2.put(new Casillero(4, 3), false);
        ubicacionEnTableroBarco2.put(new Casillero(4, 4), false);
        ubicacionEnTableroBarco2.put(new Casillero(4, 5), false);
        Barco barco1 = new Barco(ubicacionEnTableroBarco1);
        Barco barco2 = new Barco(ubicacionEnTableroBarco2);
        
        assertEquals(barco1.hashCode(), barco2.hashCode());    
    }

}
