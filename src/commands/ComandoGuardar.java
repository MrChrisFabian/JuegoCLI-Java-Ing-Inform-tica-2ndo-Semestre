package commands;

import dist.Juego;

/**
 * Comando Guardar quita un elemento de un Cuarto y lo agrega al inventario del
 * jugador
 */
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
            // En caso de guardar un juguete de la habitación objetivo se disminuye la cantidad de juguetes 
            if (juego.getCuartoActual().descripcionCorta().equals("Las habitaciones de la Familia Torrance")
                    && juego.getCuartoActual().getObjetoDelCuarto(itemName).esJuguete()) {
                juego.menosJugueteEnCuarto();
            }
        } else {
            juego.imprimir("No tienes espacio suficiente en tu inventario");
        }
        return true;
    }
}