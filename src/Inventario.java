import java.util.ArrayList;

public class Inventario {
    public Inventario(int pesoMax) {
        this.pesoMax = pesoMax;
        inventario = new ArrayList<>();
    }

    /**
     * Mostramos todos los elementos del inventario
     * 
     * @return
     */
    public String mostrarElementos() {
        String mensaje = "";
        for (Item i : inventario) {
            mensaje += "[ ";
            mensaje += "Nombre:" + i.getNombre() + "\n";
            mensaje += "Peso:" + i.getPeso();
            mensaje += "]  " + "\n";
        }
        return mensaje;
    }

    /**
     * Metodo que remueve un item del inventario por su nombre si no fue asi retorna
     * false
     */
    public boolean removerElemento(String nombre) {
        boolean completado = false;
        Item itemEliminarAux = new Item("Handler", 0);
        if (getItem(nombre) != null) {
            pesoActual -= getItem(nombre).getPeso();
            completado = true;
            itemEliminarAux = getItem(nombre);
        }

        inventario.remove(itemEliminarAux);
        return completado;
    }

    /**
     * Agrega un item al inventario si hay espacio
     * 
     * @param objeto
     * @return
     */
    public boolean AddElement(Item objeto) {
        if (checkEspacio(objeto)) {
            inventario.add(objeto);
            pesoActual += objeto.getPeso();
            return true;
        }
        return false;
    }

    /**
     * Metodo que retorna un item por su nombre
     * 
     * @param nombre
     * @return
     */

    public Item getItem(String nombre) {
        for (Item i : inventario) {
            if (i.getNombre().equals(nombre)) {
                return i;
            }
        }
        return null;
    }

    /**
     * Metodo que verifica si hay espacio en el inventario para un nuevo item
     * 
     * @param objeto
     * @return
     */
    private boolean checkEspacio(Item objeto) {
        return ((objeto.getPeso() + pesoActual) < pesoMax);
    }

    private ArrayList<Item> inventario;
    private final int pesoMax;
    private int pesoActual = 0;

}