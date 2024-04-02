public class ComandoGuardar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        // arraylist de objetos del cuarto actual
        System.out.print(juego.getCuartoActual().getObjetosDelCuarto());

        return true;
    }
}
