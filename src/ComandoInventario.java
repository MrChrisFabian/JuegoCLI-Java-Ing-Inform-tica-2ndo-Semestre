public class ComandoInventario extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        juego.imprimir(juego.itemsJugadorString());
        return true;
    }
}
