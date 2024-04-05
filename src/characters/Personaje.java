package characters;

import java.util.ArrayList;

/**
 * La clase Personaje representa un personaje en el juego
 * 
 */

public class Personaje {
    public Personaje(String nombre, ArrayList<String> dialogos) {
        this.nombre = nombre;
        this.dialogos = dialogos;
    }

    /**
     * Retorna el nombre del personaje
     * 
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retornamos un dialogo aleatorio de la colección de dialogos del personaje
     * 
     * @return
     */

    public String getRandomDialogo() {
        return dialogos.get((int) (Math.random() * dialogos.size()));
    }
    /**
     * Agregamos un nuevo dialogo a la colección 
     * @param newDialog
     */

    public void addDialog(String newDialog) {
        dialogos.add(newDialog);
    }

    private final String nombre;
    private final ArrayList<String> dialogos;

}
