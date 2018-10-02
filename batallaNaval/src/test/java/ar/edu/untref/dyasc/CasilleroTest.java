package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasilleroTest {

    @Test
    public void dosCoordenadasConElMismoXeYDebenSerIguales() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(3,3);
        
        assertEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCoordenadasConElMismoXPeroDistintoYDebenSerDiferentes() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(3,4);
        
        assertNotEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCoordenadasConElMismoYPeroDistintoXDebenSerDiferentes() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(4,3);
        
        assertNotEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCoordenadasConDisntoXeYDebenSerDiferentes() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(4,2);
        
        assertNotEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCoordenadasConLosMismosXeYTienenElMismoHashCode() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(3,3);
        
        assertEquals(casillero1.hashCode(), casillero2.hashCode());
    }


}
