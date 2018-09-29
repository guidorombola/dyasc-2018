package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordenadaTest {

    @Test
    public void dosCoordenadasConElMismoXeYDebenSerIguales() {
        Coordenada coordenada1 = new Coordenada(3,3);
        Coordenada coordenada2 = new Coordenada(3,3);
        
        assertEquals(coordenada1, coordenada2);
    }

}
