package dist;
/*
 * Universidad Nacional de Itapua.
 * Proyecto Zork.
 *
 * Autor Original: Michael Kolling, Universidad de Monash
 * Version: 1.1
 * Date: March 2000
 * Copyright (c) Michael Kolling
 *
 * Nombre del Alumno: Christopher Fabián Mendoza López
 *
 */

/**
 * La unica funcion de esta clase es contener el main().
 */
public class JugarJuego {
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}
