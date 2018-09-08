package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class LibreriaTest {
    
    Map<Integer, GeneradorProducto> catalogoProductos;
    Map<Integer, GeneradorProducto> catalogoArticulosSuscribibles;
    Map<Integer, ClienteRegistrado> clientes;
    
    @Before
    public void inicializarDatosDeClientesYProductosParaLibreria() {
        catalogoProductos = new HashMap<>();
        catalogoProductos.put(1, new ArticuloLibreriaDeCatalogo(1, 200, "Lapicera"));
        catalogoProductos.put(2, new LibroDeCatalogo(2, 100, "Libro1"));

        catalogoArticulosSuscribibles= new HashMap<>();
        catalogoArticulosSuscribibles.put(3, new ArticuloSuscribibleDeCatalogo(3, 50, "diario1", TipoArticuloSuscribible.DIARIO, 4));
        catalogoArticulosSuscribibles.put(4, new ArticuloSuscribibleDeCatalogo(4, 150, "revista1", TipoArticuloSuscribible.REVISTA, 1));

        clientes = new HashMap<>();
        clientes.put(100, new ClienteRegistrado(100,"Juan Perez", "1234"));
        clientes.put(200, new ClienteRegistrado(200,"Rodrigo Gonzalez","abcd"));
    }

    @Test
    public void unClienteRegistradoQueCompraUnArticuloDebeRecibirUnDescuentoDel5PorcientoSobreElPrecioConIva() {
        int idJuan = 100;
        int idArticuloLibreria = 1;
        float precioLapicera = 200;
        float precioLapiceraConIva = precioLapicera*1.21f;
        float precioConDescuento = precioLapiceraConIva*0.95f;
        Libreria libreria = new Libreria(clientes, catalogoProductos, catalogoArticulosSuscribibles);

        libreria.aniadirCompraProducto(idJuan, idArticuloLibreria, "Enero");

        Assert.assertEquals(libreria.obtenerTotalACobrarMensual(100, "Enero"), precioConDescuento, 0.001);  
    }
 
    @Test
    public void unClienteRegistradoQueCompraUnLibroDebeRecibirUnDescuentoDel5PorcientoPeroAlProductoNoSeLeRecargaIVA() {
        int idJuan = 100;
        int idLibro = 2;
        float precioLibroConDescuento = 100*0.95f;
        Libreria libreria = new Libreria(clientes, catalogoProductos, catalogoArticulosSuscribibles);

        libreria.aniadirCompraProducto(idJuan, idLibro, "Enero");

        Assert.assertEquals(libreria.obtenerTotalACobrarMensual(100, "Enero"), precioLibroConDescuento, 0.001);
    }
    
    @Test
    public void unClienteRegistradoQuePideUnaSuscripcionAnualDebeRecibirUnDescuentoDel20Porciento() {
        int idRodrigo = 200;
        int idDiario = 3;
        float precioMensualDeDiario = 50;
        float precioAnualConDescuento = precioMensualDeDiario * 0.8f * 12;
        Libreria libreria = new Libreria(clientes, catalogoProductos, catalogoArticulosSuscribibles);

        libreria.aniadirSuscripcion(idRodrigo, idDiario);
        Assert.assertEquals(precioAnualConDescuento, libreria.obtenerTotalACobrarAnual(idRodrigo), 0.001);
    }
    

}
