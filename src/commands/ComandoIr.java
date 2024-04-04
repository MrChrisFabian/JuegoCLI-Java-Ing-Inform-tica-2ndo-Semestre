package commands;
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

import dist.Juego;

/**
 * Esta clase es un comando que cambia el cuarto actual del protagonista
 * del juego.
 *
 */
public class ComandoIr extends ComandoAbstracto {

    /**
     * Intenta ir en la direccion indicada.
     * class ComandoAtras
     */
    public boolean ejecutar(Juego juego) {
        // Revisa si
        if (getPalabras().keySet().size() < 2) {
            throw new IllegalArgumentException("Faltan palabras");
        }
        String direccion = (String) getPalabras().get("parametro");
        juego.irA(direccion);
        return true;
    }

}
