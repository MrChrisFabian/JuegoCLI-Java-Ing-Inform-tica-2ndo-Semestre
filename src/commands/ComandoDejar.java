package commands;

import dist.Juego;

/**
 * Comando para mover elementos de nuestro inventario al cuarto
 */
public class ComandoDejar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        // Nos Aseguramos de que el parametro recibido sea utilizable
        if (getPalabras().get("parametro") == null) {
            juego.imprimir("No se ha especificado el item a dejar");
            return true;
        }

        String itemName = (String) getPalabras().get("parametro");
        if (juego.getItemJugador(itemName) == null) {
            juego.imprimir("No tienes el item: " + itemName + " en tu inventario");
            return true;
        }
        juego.addItemCuarto(juego.getItemJugador(itemName));
        juego.removerItemJugador(itemName);
        juego.imprimir(
                "Has dejado el item: " + itemName + " en el cuarto:" + juego.getCuartoActual().descripcionCorta());
        // Realizamos un condicional en caso de que el item a dejar sea un juguete y la
        // habitación sea la objetivo
        if (juego.getCuartoActual().descripcionCorta().equals("Las habitaciones de la Familia Torrance")
                && juego.getCuartoActual().getObjetoDelCuarto(itemName).esJuguete()) {
            juego.imprimir(
                    "Has dejado un juguete en la habitacion de Danny, Recolecta los que faltan para ganar el juego.");
            juego.aumentarJugueteEnCuarto();
        }
        if (juego.juguetesEnCuarto() == 5) {
            juego.imprimir(
                    "Felicidades! Has ganado, lograste recolectar todos tus juguetes sorteando los peligros.\n Luego de lo que paso tu mamá pidio ayuda por la radio y pronto llegaran a rescatarte.");
            return false;
        }
        return true;
    }
}
