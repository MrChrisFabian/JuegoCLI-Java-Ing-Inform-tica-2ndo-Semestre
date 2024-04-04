package characters;

/**
 * The Personaje Class represents a Characther in the Game, that only has a name
 * and a collection of dialogues
 * 
 */

public class Personaje {
    public Personaje(String nombre, String[] dialogos) {
        this.nombre = nombre;
        this.dialogos = dialogos;
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
        return dialogos[(int) (Math.random() * dialogos.length)];
    }

    private final String nombre;
    private final String[] dialogos;

}
