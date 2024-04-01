
public class Item {
    public Item(String nombre, int peso) {
        this.peso = peso;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPeso() {
        return peso;
    }

    private final String nombre;
    private final int peso;
}
