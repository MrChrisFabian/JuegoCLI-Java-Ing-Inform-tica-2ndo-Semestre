package commands;

import dist.Juego;

public class ComandoMirar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        juego.imprimir(juego.getCuartoActual().descripcionLarga());
        return true;
    }
}
