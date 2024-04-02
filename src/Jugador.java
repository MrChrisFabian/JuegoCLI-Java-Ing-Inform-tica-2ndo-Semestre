public class Jugador {
    public Jugador() {
    }

    public String getInventarioJugador() {
        return inventario.mostrarElementos();
    }

    public boolean agregarItemJugador(Item item) {
        return inventario.AddElement(item);
    }

    // public boolean removerItemJugador(Item item) {

    // }

    Inventario inventario = new Inventario(10);

}
