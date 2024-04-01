import java.util.ArrayList;

public class Inventario {
    public Inventario() {
        inventario = new ArrayList<>();
    }

    public void AddElement(Item objeto) {
        if (checkEspacio(objeto)) {
            inventario.add(objeto);
            pesoActual += objeto.getPeso();
        }
    }

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

    private boolean checkEspacio(Item objeto) {
        return ((objeto.getPeso() + pesoActual) < pesoMax);
    }

    private ArrayList<Item> inventario;
    private final int pesoMax = 10;
    private int pesoActual = 0;

}