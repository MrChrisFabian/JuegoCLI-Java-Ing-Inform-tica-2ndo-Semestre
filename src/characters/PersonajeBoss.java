package characters;

import java.util.ArrayList;

import dist.Juego;
import utils.Cuarto;

public class PersonajeBoss extends PersonajeEnemigo {
    public PersonajeBoss(String nombre, ArrayList<String> dialogos, Juego juego, String dialogoNivel2a1,
            String dialogoNivel2a2,
            String MensajeNivel3, Cuarto cuartoDondeApareces, Personaje personajeBueno, Personaje personajeBueno1) {
        super(nombre, dialogos, juego, MensajeNivel3, cuartoDondeApareces);
        this.dialogoNivel2a1 = dialogoNivel2a1;
        this.dialogoNivel2a2 = dialogoNivel2a2;
        this.MensajeNivel3 = MensajeNivel3;
        this.personajeBueno = personajeBueno;
        this.personajeBueno1 = personajeBueno1;
        this.juego = juego;
    }

    /**
     * Seteamos el nivel en el que se encuentra el boss actualmente
     * 
     * @param nivel
     */
    public void incrementarNivel() {
        if (this.nivel <= 4) {
            this.nivel++;
        }
    }

    /**
     * Obtenemos el nivel en el que se encuentra el boss actualmente
     * 
     * @return
     */
    public int getNivel() {
        return this.nivel;
    }

    /**
     * El comportamiento especifico del Boss en cada nivel
     */
    public void comportamiento() {
        if (nivel == 1) {
            addDialog(dialogoNivel2a1);
            addDialog(dialogoNivel2a2);
        } else if (nivel == 2) {
            juego.setPersonajeFueraDeEscena(personajeBueno);
            juego.addDialogPersonaje(personajeBueno1, "Danny, por favor Cuidate, junta tus cosas, me quiero ir!");
        } else if (nivel == 3) {
            juego.imprimir(MensajeNivel3);
            incrementarNivel();
        }
    }

    private Juego juego;
    private String dialogoNivel2a1;
    private String dialogoNivel2a2;
    private String MensajeNivel3;
    private Personaje personajeBueno;
    private Personaje personajeBueno1;
    private int nivel = 0;
}
