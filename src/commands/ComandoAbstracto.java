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

import java.util.*;

/**
 *
 * Esta clase implementa lo basico de la interfaz Comando
 *
 */
public abstract class ComandoAbstracto implements Comando, Cloneable {

    private HashMap<String, String> palabras = new HashMap<String, String>();

    /**
     * Le dice al comando cuales son las palabras del comando.
     * Ej: Lista con "ir" y "norte"
     *
     * La primera palabra siempre es el comando mismo.
     *
     * @param palabras las palabras utilizadas en el comando
     */
    public void setPalabras(HashMap<String, String> palabras) {
        if (null == palabras) {
            throw new IllegalArgumentException(
                    "El Hashmap no puede ser nula.. pero si vacia");
        }
        this.palabras = palabras;
    }

    /**
     * Retorna las palabras utilizadas en el comando. Ej:
     * Hashmap con "ir" y "norte"
     *
     */
    public HashMap<String, String> getPalabras() {
        if (null == this.palabras || this.palabras.size() < 1) {
            throw new IllegalStateException(
                    "Palabras no inicializadas correctamente");
        }
        return this.palabras;
    }

    /**
     * Devuelve una copia del comando
     *
     * @return Comando
     */
    public Comando copiar() {
        try {
            return (Comando) clone();
        } catch (CloneNotSupportedException ex) {
            // tonteria del API de Java
            throw (IllegalStateException) new IllegalStateException(
                    "No se puede clonar").initCause(ex);
        }
    }

}
