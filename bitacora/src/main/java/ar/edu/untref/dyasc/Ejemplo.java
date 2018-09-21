package ar.edu.untref.dyasc;

public class Ejemplo {
    public static void main(String[] args) {
        Bitacora b = new Bitacora();
        try {
            b.registrarEvento("Inicio sesion");
            b.registrarEvento("Cierre sesion");
        } catch (VariableNoDefinidaException e) {
            System.out.print(e.getMessage());
        }
    }
}
