package ar.edu.untref.dyasc;

import java.util.HashMap;
import java.util.Map;

public class MainLibreria {

    public static void main(String[] args) {
        Map<Integer, GeneradorProducto> catalogoProductos = new HashMap<Integer, GeneradorProducto>();
        catalogoProductos.put(1, new ArticuloLibreriaDeCatalogo(1, 200, "Lapicera"));
        catalogoProductos.put(2, new LibroDeCatalogo(2, 100, "Libro1"));
        Map<Integer, GeneradorProducto> catalogoArticulosSuscribibles= new HashMap<Integer, GeneradorProducto>();
        catalogoArticulosSuscribibles.put(3, new ArticuloSuscribibleDeCatalogo(3, 1000, "diario1", TipoArticuloSuscribible.DIARIO, 4));
        catalogoArticulosSuscribibles.put(4, new ArticuloSuscribibleDeCatalogo(4, 1000, "revista1", TipoArticuloSuscribible.REVISTA, 1));
        Map<Integer, ClienteRegistrado> clientes = new HashMap<>();
        clientes.put(100, new ClienteRegistrado(100,"Juan Perez", "1234"));
        clientes.put(101, new ClienteRegistrado(101,"Rodrigo Gonzalez", "abcd"));
        Libreria l = new Libreria(clientes, catalogoProductos, catalogoArticulosSuscribibles);

        l.aniadirCompraProducto(100, 1, "Mayo");
        l.aniadirSuscripcion(101, 3);
        l.aniadirSuscripcion(101, 4, "Enero");
        System.out.println(l.obtenerImportesACobrarPorClienteMensual("Enero").toString());

    }
}
