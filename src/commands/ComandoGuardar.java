package commands;

import dist.Juego;

public class ComandoGuardar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().get("parametro") == null) {
            juego.imprimir("No se ha especificado el item a guardar");
            return true;
        }
        String itemName = (String) getPalabras().get("parametro");
        boolean check = juego.agregarItemJugador(itemName);
        if (check) {
            juego.removerItemCuarto(itemName);
            juego.imprimir("Has guardado el item: " + itemName + " en tu inventario");
        } else {
            juego.imprimir("No tienes espacio suficiente en tu inventario");
        }
        return true;
    }
}