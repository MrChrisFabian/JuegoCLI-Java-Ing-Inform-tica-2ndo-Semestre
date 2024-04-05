package utils;

/**
 * Representa a un Jugador con su Inventario
 */
public class Jugador {
    public Jugador() {
        this.inventario = new Inventario(10);
    }

    /**
     * Obtenemos un item por su nombre del inventario
     * 
     * @param itemName
     * @return
     */
    public Item getItem(String itemName) {
        return inventario.getItem(itemName);
    }

    /**
     * Obtenemos un String que describe el inventario completo del Jugador
     * 
     * @return
     */
    public String getInventarioJugador() {
        return inventario.mostrarElementos();
    }

    /**
     * Agregamos un item al inventario del Jugador
     * 
     * @param item
     * @return
     */
    public boolean agregarItem(Item item) {
        return inventario.AddElement(item);
    }

    /**
     * Eliminamos un item del inventario del jugador
     * 
     * @param item
     * @return
     */
    public boolean removerItemJugador(Item item) {
        return inventario.removerElemento(item.getNombre());
    }

    /**
     * Obtenemos el espacio actual que se esta utilizando
     * @return
     */
    public int getEspacio() {
        return inventario.getPesoActual();
    }

    Inventario inventario;

}
