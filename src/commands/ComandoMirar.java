package commands;

import dist.Juego;
/**
 * Nos da una descripción larga del Cuarto en donde nos encontramos
 */
public class ComandoMirar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        juego.imprimir(juego.getCuartoActual().descripcionLarga());
        return true;
    }
}
