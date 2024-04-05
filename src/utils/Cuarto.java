package utils;
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

import characters.Personaje;
import characters.PersonajeControl;

/**
 *
 * Un cuarto representa una ubicacion en el escenario del juego. Aunque se llama
 * "cuarto", puede representar una ubicacion que esta adentro o afuera.
 *
 * Los cuartos estan intercontectados por medio de salidas. Hay cuatro posibles
 * salidas (por el momento) para un cuarto: norte, este, sur, oeste.
 *
 * Para cada direccion, el cuarto almacena una referencia a su habitacion
 * vecina,
 * o null si no puede salir en esa direccion.
 *
 */

public class Cuarto {

    /**
     * Crea una habitacion descrita como "descripcion". Inicialmente, esta no
     * existe. "descripcion" es alguna cosa como "una cocina" o "la sala de
     * descanso" pero también Incluye un objeto que se encuentra en la habitación,
     * una dirección y un cuarto que seran su salida
     */
    public Cuarto(String descripcion, TipoSalida direccionDeSalida, Cuarto cuarto, Item objetoDelCuarto,
            Personaje personaje) {
        this.descripcion = descripcion;
        this.salidas = new Salida();
        salidas.setSalida(direccionDeSalida, cuarto);
        itemsDelCuarto = new Inventario(200);
        itemsDelCuarto.AddElement(objetoDelCuarto);
        this.personajeControl = new PersonajeControl();
        personajeControl.addPersonaje(personaje);
    }

    /**
     * Crea una habitacion descrita como "descripcion". Inicialmente, esta no
     * existe. "descripcion" es alguna cosa como "una cocina" o "la sala de
     * descanso"
     * 
     * @param description
     */
    public Cuarto(String description) {
        this.descripcion = description;
        this.salidas = new Salida();
        this.itemsDelCuarto = new Inventario(200);
        this.personajeControl = new PersonajeControl();
    }

    /**
     * Retorna la descripcion de la habitacion (alguna de las que fueron defini
     * das en el constructor).
     */
    public String descripcionCorta() {
        return descripcion;
    }

    /**
     * We Set a new value in the Salidas Object that contains everything in a
     * Hashmap
     * 
     * @param direccion
     * @param cuarto
     * @return
     */
    public void setSalidas(TipoSalida direccion, Cuarto cuarto) {
        salidas.setSalida(direccion, cuarto);
    }

    /**
     * Retorna una descripcion extensa de esta habitacion, en la forma: Tu estas
     * en ${cuarto}. Salidas: {salidas que existen}.
     */
    public String descripcionLarga() {
        return "Tu estas en " + descripcion + ".\nLas Direcciones disponibles son:"
                + salidas.getTodasSalidasDeCuarto().toString() + ".\n" + "Los Personajes en el cuarto son: "
                + personajeControl.getPersonajesNombres() + "\n" +
                "Los objetos en el cuarto son:" + getObjetosDelCuartoString();
    }

    /**
     * Retorna la habitacion alcanzada si nosotros vamos en direccion
     */
    public Cuarto siguienteCuarto(String direccion) {
        if (getSalidasDeCuarto().toString().contains(direccion)) {
            return salidas.getSalida(TipoSalida.valueOf(direccion));
        } else {
            return null;
        }

    }

    /**
     * Returns every direction that the room has
     */
    public Set<TipoSalida> getSalidasDeCuarto() {
        return salidas.getTodasSalidasDeCuarto();
    }

    /**
     * Returns the items in the room as a String
     */
    public String getObjetosDelCuartoString() {
        return itemsDelCuarto.mostrarElementos();
    }

    /**
     * Set a item in the room
     * 
     */
    public boolean setObjetoDelCuarto(Item objeto) {
        return itemsDelCuarto.AddElement(objeto);
    }

    /**
     * Return a item by his name
     * 
     * @param nombre
     * @return
     */
    public Item getObjetoDelCuarto(String nombre) {
        return itemsDelCuarto.getItem(nombre);
    }

    /**
     * Remove a item from the room by his name
     */
    public boolean removerObjetoDelCuarto(String nombre) {
        return itemsDelCuarto.removerElemento(nombre);
    }

    /**
     * Agregar un personaje al cuarto
     * 
     * @param nombre
     * @return
     */
    public void addPersonaje(Personaje personaje) {
        personajeControl.addPersonaje(personaje);
    }

    /**
     * Removemos un personaje del cuarto
     * 
     * @param personaje
     */
    public void removePersonaje(Personaje personaje) {
        personajeControl.removePersonaje(personaje);
    }

    /**
     * Method that return a personaje Dialog by his name
     */
    public String getDialogoPersonaje(String nombre) {
        return personajeControl.getPersonaje(nombre).getRandomDialogo();
    }

    /**
     * Metodo que retorna un personaje por su nombre
     * 
     * @param nombre
     * @return
     */
    public Personaje getPersonaje(String nombre) {
        return personajeControl.getPersonaje(nombre);
    }

    // la descripcion del cuarto
    private String descripcion;
    // las salidas del cuarto
    private Salida salidas;
    // Como Almacenamos los Items de un Cuarto
    private Inventario itemsDelCuarto;
    // Creamos el objeto que controlara a todos los personajes del Cuarto
    private PersonajeControl personajeControl;

}