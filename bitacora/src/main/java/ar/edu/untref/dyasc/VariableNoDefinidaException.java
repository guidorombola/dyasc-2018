package ar.edu.untref.dyasc;

public class VariableNoDefinidaException extends Exception {

    public VariableNoDefinidaException() {
        super("Variable de entorno bitacora.destino no definida");
    }
}
