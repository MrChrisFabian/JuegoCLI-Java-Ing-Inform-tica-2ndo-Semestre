package characters;

import java.util.ArrayList;

import dist.Juego;
import utils.Cuarto;

/**
 * Hereda de Personaje, agrega metodo Atacar
 */

public class PersonajeEnemigo extends Personaje {
    public PersonajeEnemigo(String nombre, ArrayList<String> dialogos, Juego juego, String mensaje,
            Cuarto cuartoDondeApareces) {
        super(nombre, dialogos);
        this.mensaje = mensaje;
        this.cuartoDondeApareces = cuartoDondeApareces;
        this.juego = juego;
    }

    /**
     * Metodo ataque que muestra un mensaje y mueve al Jugador
     * @return
     */
    public String Atacar() {
        juego.setHabitacionActual(cuartoDondeApareces);
        return mensaje;
    }

    private Cuarto cuartoDondeApareces;
    private String mensaje;
    private Juego juego;

}