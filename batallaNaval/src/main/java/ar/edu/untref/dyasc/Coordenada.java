package ar.edu.untref.dyasc;

public class Coordenada {

    private int coordenadaX;
    private int coordenadaY;
    
    public Coordenada(int x, int y) {
        coordenadaX = x;
        coordenadaY = y;
    }
    
    public int getCoordenadaX() {
        return coordenadaX;
    }
  
    public int getCoordenadaY() {
        return coordenadaY;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass()) {
            return false;
        }else {
            Coordenada coordenada = (Coordenada)obj;
            return (this.getCoordenadaX() == coordenada.getCoordenadaX()) && (this.getCoordenadaY() == coordenada.getCoordenadaY());            
        }
    }
}
