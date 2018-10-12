package ar.edu.untref.dyasc;

public class ExcepcionLimitesInvalidos extends Exception {

    public ExcepcionLimitesInvalidos() {
        super("El barco que desea aniadir no esta comprendido dentro de los limites validos del tablero");
    }
}
