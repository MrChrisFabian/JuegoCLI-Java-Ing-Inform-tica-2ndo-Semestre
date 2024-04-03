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
    public Cuarto(String descripcion, TipoSalida direccion, Cuarto cuarto, Item objetoDelCuarto) {
        this.descripcion = descripcion;
        this.salidas = new Salida();
        salidas.setSalida(direccion, cuarto);
        itemsDelCuarto = new Inventario(200);
        itemsDelCuarto.AddElement(objetoDelCuarto);
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
        return "Tu estas en " + descripcion + ".\n" + salidas.getTodasSalidasDeCuarto().toString() + ".\n"
                + getObjetosDelCuarto();
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
    public String getObjetosDelCuarto() {
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

    // la descripcion del cuarto
    private String descripcion;
    // las salidas del cuarto
    private Salida salidas;
    // Como Almacenamso los Items de un Cuarto
    private Inventario itemsDelCuarto;

}