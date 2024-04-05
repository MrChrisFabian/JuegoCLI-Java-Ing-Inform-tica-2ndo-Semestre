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
import java.util.Collection;
import java.util.Iterator;

/**
 * Esta clase implementa la ayuda para el juego Zork
 */
public class ComandoAyuda extends ComandoAbstracto {

    /**
     * Imprime a pantalla alguna informacion de ayuda.
     *
     * Aqui nosotros imprimimos algo estupido, mensajes cripticos y
     * una lista de los comandos disponibles.
     */
    @SuppressWarnings("rawtypes")
    public boolean ejecutar(Juego juego) {
        juego.imprimir("Estas en el Hotel");
        juego.imprimir("Explora...");
        juego.imprimir();
        juego.imprimir("Los comandos disponibles son:");

        // imprimir todos los comandos
        FabricaDeComandos fabrica = new FabricaDeComandos();
        Collection listaComandos = fabrica.comandosConocidos();
        for (Iterator iter = listaComandos.iterator(); iter.hasNext();) {
            juego.imprimirCont(" ");
            juego.imprimirCont((String) iter.next());
        }
        juego.imprimir();

        // no parar el juego
        return true;
    }

}
