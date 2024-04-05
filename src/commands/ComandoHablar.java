package commands;

import characters.PersonajeEnemigo;
import dist.Juego;

/**
 * Interactuar con Personajes y obtener sus dialogos
 */
public class ComandoHablar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().get("parametro") == null) {
            juego.imprimir("No se ha especificado el personaje con el que hablar");
            return true;
        }
        // En caso de que sea un enemigo se activa su función de ataque
        String nombre = (String) getPalabras().get("parametro");
        if (juego.getPersonaje(nombre) == PersonajeEnemigo.class) {
            juego.imprimir(juego.HablarCon(nombre));
            juego.imprimir(juego.getEnemigo(nombre).Atacar());
            juego.aumentarNivelBoss();

        } else {
            juego.imprimir(juego.HablarCon(nombre));
        }
        return true;
    }
}
