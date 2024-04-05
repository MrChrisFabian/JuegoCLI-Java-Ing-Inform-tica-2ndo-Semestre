package utils;

public class Item {
    public Item(String nombre, int peso, boolean esJuguete) {
        this.peso = peso;
        this.nombre = nombre;
        this.esJuguete = esJuguete;
    }

    /**
     * Retornamos el nombre del Item
     * 
     * @return
     */

    public String getNombre() {
        return nombre;
    }

    /**
     * Retornamos el Peso del Item
     * 
     * @return
     */

    public int getPeso() {
        return peso;
    }

    /**
     * Retornamos si es un Juguete el item
     * 
     * @return
     */
    public boolean esJuguete() {
        return esJuguete;
    }

    private final String nombre;
    private final int peso;
    private final boolean esJuguete;
}
