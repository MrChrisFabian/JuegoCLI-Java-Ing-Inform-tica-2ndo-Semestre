public class ComandoGuardar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String itemName = (String) getPalabras().get("parametro");
        juego.agregarItemJugador(itemName);
        juego.removerItemCuarto(itemName);
        juego.imprimir(juego.itemsJugadorString());
        return true;
    }
}
