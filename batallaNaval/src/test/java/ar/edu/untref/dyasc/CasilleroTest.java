package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasilleroTest {

    @Test
    public void dosCasillerosConElMismoXeYDebenSerIguales() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(3,3);
        
        assertEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCasillerosConElMismoXPeroDistintoYDebenSerDiferentes() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(3,4);
        
        assertNotEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCasillerosConElMismoYPeroDistintoXDebenSerDiferentes() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(4,3);
        
        assertNotEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCasillerosConDisntoXeYDebenSerDiferentes() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(4,2);
        
        assertNotEquals(casillero1, casillero2);
    }
    
    @Test
    public void dosCasillerosConLosMismosXeYTienenElMismoHashCode() {
        Casillero casillero1 = new Casillero(3,3);
        Casillero casillero2 = new Casillero(3,3);
        
        assertEquals(casillero1.hashCode(), casillero2.hashCode());
    }


}
