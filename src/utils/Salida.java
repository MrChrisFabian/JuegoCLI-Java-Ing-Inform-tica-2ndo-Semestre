package utils;

import java.util.*;
import java.util.Set;

/**
 * Representa una salida que esta conectada a un cuarto
 */
public class Salida {

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
     * Retorna todas las salidas vinculadas a un cuarto
     *
     * @return
     */
    public Set<TipoSalida> getTodasSalidasDeCuarto() {
        return salida.keySet();
    }

    /**
     * Retornamos el Cuarto según la salida que acabamos de recibir
     * 
     * @param direccion
     * @return
     */
    public Cuarto getSalida(TipoSalida direccion) {
        return salida.get(direccion);
    }

    /**
     * Agregamos un nuevo dato donde recibimos la salida y el cuarto 
     * 
     * @param direccion
     * @param cuarto
     */
    public void setSalida(TipoSalida direccion, Cuarto cuarto) {
        salida.put(direccion, cuarto);
    }

    private TipoSalida direccion;
    private Cuarto cuarto;
    private HashMap<TipoSalida, Cuarto> salida = new HashMap<TipoSalida, Cuarto>();
}
