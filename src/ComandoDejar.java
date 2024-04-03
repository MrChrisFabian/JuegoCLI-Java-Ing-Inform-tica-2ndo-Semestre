public class ComandoDejar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String itemName = (String) getPalabras().get("parametro");
        juego.addItemCuarto(juego.getItemJugador(itemName));
        juego.removerItemJugador(itemName);
        juego.imprimir(
                "Has dejado el item: " + itemName + " en el cuarto:" + juego.getCuartoActual().descripcionCorta());
        return true;
    }
}
