
package commands;

import dist.Juego;

public class ComandoInventario extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (juego.itemsJugadorString() != "") {
            juego.imprimir("Tienes los siguientes items en tu inventario:");
            juego.imprimir(juego.itemsJugadorString());
        } else {
            juego.imprimir("No tienes items en tu inventario.");
        }
        return true;
    }
}
