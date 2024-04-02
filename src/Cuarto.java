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
        this.objetosDelCuarto.add(objetoDelCuarto);
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
                + ".\n";
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
     * Returns the items in the room
     */
    public ArrayList<Item> getObjetosDelCuarto() {
        return objetosDelCuarto;
    }

    /**
     * Set a items in the room
     * 
     */
    public void setObjetosDelCuarto(Item objeto) {
        objetosDelCuarto.add(objeto);
    }

    // public String mostrarElementosString() {
    //     String mensaje = "Los Elementos de la habitacion son: \n";
    //     for (Item i : objetosDelCuarto) {
            
    //     }
    // }

    // la descripcion del cuarto
    private String descripcion;
    // las salidas del cuarto
    private Salida salidas;
    private ArrayList<Item> objetosDelCuarto = new ArrayList<Item>();
    
}