import java.util.*;
import java.util.Set;

public class Salida {
    private TipoSalida direccion;
    private Cuarto cuarto;
    private HashMap<TipoSalida, Cuarto> salida = new HashMap<TipoSalida, Cuarto>();

    /**
     * The Constructor for the class Salida
     * 
     * @param direccion
     * @param cuarto
     */
    public Salida(TipoSalida direccion, Cuarto cuarto) {
        this.salida = new HashMap<>();
        this.direccion = direccion;
        this.cuarto = cuarto;
        salida.put(this.direccion, this.cuarto);
    }

    public Salida() {
        this.salida = new HashMap<>();
    }

    /**
     * Returns a set of TipoSalida objects representing the available exits from the
     * room.
     *
     * @return a set of TipoSalida objects representing the available exits from the
     *         room
     */
    public Set<TipoSalida> getTodasSalidasDeCuarto() {
        return salida.keySet();
    }

    /**
     * We return a Cuarto object depending of the direction we receive
     * 
     * @param direccion
     * @return
     */
    public Cuarto getSalida(TipoSalida direccion) {
        return salida.get(direccion);
    }

    /**
     * We set a new value in the Salida Object that contains everything in a Hashmap
     * 
     * @param direccion
     * @param cuarto
     */
    public void setSalida(TipoSalida direccion, Cuarto cuarto) {
        salida.put(direccion, cuarto);
    }
}
