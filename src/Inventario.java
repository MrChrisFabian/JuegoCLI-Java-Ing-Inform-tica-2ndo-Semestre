import java.util.ArrayList;

public class Inventario {
    public Inventario(int pesoMax) {
        this.pesoMax = pesoMax;
        inventario = new ArrayList<>();
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
        } else {
            return false;
        }
    }

    /**
     * Mostramos todos los elementos del inventario
     * 
     * @return
     */
    public String mostrarElementos() {
        String mensaje = "Los Elementos de su inventario son: \n";
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
        for (Item i : inventario) {
            if (i.getNombre().equals(nombre)) {
                pesoActual -= i.getPeso();
                inventario.remove(i);
                completado = true;
            }
        }
        return completado;
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