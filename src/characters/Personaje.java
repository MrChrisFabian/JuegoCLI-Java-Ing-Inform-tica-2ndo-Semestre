package characters;

import java.util.ArrayList;

/**
 * The Personaje Class represents a Characther in the Game, that only has a name
 * and a collection of dialogues
 * 
 */

public class Personaje {
    public Personaje(String nombre, ArrayList<String> dialogos) {
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
        return dialogos.get((int) (Math.random() * dialogos.size()));
    }

    public void addDialog(String newDialog) {
        dialogos.add(newDialog);
    }

    private final String nombre;
    private final ArrayList<String> dialogos;

}
