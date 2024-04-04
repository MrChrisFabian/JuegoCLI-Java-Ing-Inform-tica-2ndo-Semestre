package utils;

/**
 * The Personaje Class represents a Characther in the Game, that only has a name
 * and a collection of dialogues
 * 
 */

public class Personaje {
    public Personaje(String nombre, String[] Dialogos) {
        this.nombre = nombre;
        this.Dialogos = Dialogos;
    }

    /**
     * We return the name of the character
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * We return a random dialog from the array of dialogues
     * 
     * @return
     */

    public String getRandomDialogo() {
        return Dialogos[(int) (Math.random() * Dialogos.length)];
    }

    private final String nombre;
    private final String[] Dialogos;

}
