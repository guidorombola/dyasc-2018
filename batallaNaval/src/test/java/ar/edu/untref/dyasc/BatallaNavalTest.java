package ar.edu.untref.dyasc;

import static org.junit.Assert.*;

import org.junit.Test;

public class BatallaNavalTest {

    @Test
    public void atacarEnUnaPosicionDondeHayAgua() {
        BatallaNaval b = new BatallaNaval();
        InformeDeAtaque i = b.atacar(3,4);
        assertEquals(i, InformeDeAtaque.AGUA);
    }

}
