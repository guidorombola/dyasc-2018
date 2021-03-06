package ar.edu.untref.dyasc;

public class Casillero {

    private int coordenadaX;
    private int coordenadaY;

    public Casillero(int x, int y) {
        coordenadaX = x;
        coordenadaY = y;
    }

    public int coordenadaX() {
        return coordenadaX;
    }

    public int coordenadaY() {
        return coordenadaY;
    }

    @Override
    public int hashCode() {
        final int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + coordenadaX;
        resultado = primo * resultado + coordenadaY;
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        } else {
            Casillero coordenada = (Casillero) obj;
            return (this.coordenadaX() == coordenada.coordenadaX()) && (this.coordenadaY() == coordenada.coordenadaY());
        }
    }

}
