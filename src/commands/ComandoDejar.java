package commands;

import dist.Juego;

public class ComandoDejar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().get("parametro") == null) {
            juego.imprimir("No se ha especificado el item a dejar");
            return true;
        }
        String itemName = (String) getPalabras().get("parametro");
        juego.addItemCuarto(juego.getItemJugador(itemName));
        juego.removerItemJugador(itemName);
        juego.imprimir(
                "Has dejado el item: " + itemName + " en el cuarto:" + juego.getCuartoActual().descripcionCorta());
        return true;
    }
}
