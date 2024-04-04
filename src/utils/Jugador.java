package utils;

public class Jugador {
    public Jugador() {
        this.inventario = new Inventario(10);
    }

    public Item getItem(String itemName) {
        return inventario.getItem(itemName);
    }

    public String getInventarioJugador() {
        return inventario.mostrarElementos();
    }

    public boolean agregarItem(Item item) {
        return inventario.AddElement(item);
    }

    public boolean removerItemJugador(Item item) {
        return inventario.removerElemento(item.getNombre());
    }

    public int getEspacio() {
        return inventario.getPesoActual();
    }

    Inventario inventario;

}
