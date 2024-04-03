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

import commands.Comando;
import commands.Parser;
import utils.Cuarto;
import utils.Item;
import utils.Jugador;
import utils.TipoSalida;

/**
 * Esta clase es la principal para la aplicacion "Zork". Zork es un juego de
 * aventuras, simple, y basado en texto.
 *
 * En esta version, los usuarios pueden caminar através de algunos cuartos.
 * Eso es todo. Realmente el juego deberia ser extendido para volverse mas
 * interesante.
 *
 * Para jugarlo, se debe crear una instancia de esta clase y llamar el metodo
 * "jugar"
 *
 * Esta clase crea inicializa a todas las otras, aqui empieza todo: crea todos
 * los Cuartos, crea los parsers (objetos que interpretan texto) y comienza el
 * juego. Tambien evalua los comandos que devuelve el parser.
 */

public class Juego {

    private Parser parser;
    private Cuarto cuartoActual;
    private Jugador jugador;

    /**
     * Crea el juego e inicializa su mapa interno
     */
    public Juego() {
        crearCuartos();
        jugador = new Jugador();
        parser = new Parser();
    }

    /**
     * Crea todas las habitaciones y enlaza todas sus salidas
     */
    private void crearCuartos() {
        // crear los cuartos
        Cuarto afuera = new Cuarto("En el Salón Rojo...");
        Cuarto sum = new Cuarto("la Sala de Uso Multiple (SUM)", TipoSalida.ESTE, afuera, new Item("Hacha", 2));
        Cuarto baño = new Cuarto("Aca te podes Bañar", TipoSalida.ABAJO, sum, new Item("Toalla", 1));
        // inicializar las salidas
        sum.setSalidas(TipoSalida.NORTE, afuera);
        afuera.setSalidas(TipoSalida.SUR, sum);
        sum.setSalidas(TipoSalida.ARRIBA, baño);
        cuartoActual = sum;
    }

    /**
     * Rutina principal: jugar. Itera hasta el fin del juego..
     */
    public void jugar() {
        imprimir();
        imprimirBienvenida();

        // Jugar hasta que un comando me diga que ya no quiere jugar mas
        boolean continuar = true;
        while (continuar) {
            Comando comando = parser.getComando();
            continuar = comando.ejecutar(this);
        }
        System.out.println("Gracias Por Jugar...El Overlook siempre lo espera...");
    }

    /**
     * Imprime a la terminar el mensaje de bienvenida del jugador..
     */
    private void imprimirBienvenida() {
        imprimir();
        imprimir("Bienvenido al Hotel Overlook ");
        imprimir(
                "Eres Danny, el Hijo de la familia Torrance que esta cuidando este invierno el majestuoso Overlook...");
        imprimir(
                "El cual se encuentra cerrado durante el invierno, aislado en las montañas...");
        imprimir("Disfruta tu estadia, explora y lo más importante cuidate...");
        imprimir("Escriba 'ayuda' si necesita ayuda.");
        imprimir();
        imprimir(cuartoActual.descripcionLarga());
    }

    /**
     * Intenta ir en una direccion. Si esta fue una salida, entra a otra
     * habitacion, en caso contrario imprime un mensaje de error.
     * 
     */

    public void irA(String direccion) {
        if (null == direccion) {
            // si no hay direccion no sabemos a donde ir
            System.out.println("¿Ir donde?");
            return;
        }

        // Intenta salir del cuarto
        if (existInTipoSalida(direccion)) {
            direccionEntrada = TipoSalida.valueOf(direccion);
        }
        Cuarto siguienteCuarto = cuartoActual.siguienteCuarto(direccion);

        if (null == siguienteCuarto) {
            System.out.println(
                    "Eeeem... no puedo ir para allí... algo me esta bloqueando.");
        } else {
            cuartoActual = siguienteCuarto;
            System.out.println(cuartoActual.descripcionLarga());
        }
    }

    /**
     * Imprime un mensaje para el usuario
     *
     * @param mensaje
     */
    public void imprimir(String mensaje) {
        textEffecto(mensaje);
        System.out.println();
    }

    /**
     * Pasa a la siguiente linea.
     *
     */
    public void imprimir() {
        System.out.println();
    }

    /**
     * Imprime un mensaje para el usuario, pero
     * se queda en la misma linea.
     *
     * @param mensaje
     */
    public void imprimirCont(String mensaje) {
        textEffecto(mensaje);
    }

    /**
     * Method that returns the current room
     * 
     * @return
     */
    public Cuarto getCuartoActual() {
        return cuartoActual;
    }

    /**
     * Agregamos un item al jugador
     * 
     * @param mensaje
     */
    public boolean agregarItemJugador(String item) {
        return jugador.agregarItem(cuartoActual.getObjetoDelCuarto(item));
    }

    /**
     * Method that remove a item from the player and if was possible return
     * 
     * @param elemento
     * @return
     */
    public boolean removerItemJugador(String elemento) {
        return jugador.removerItemJugador(jugador.getItem(elemento));
    }

    /**
     * Method that returns all the items of the player
     * 
     * @return
     */

    public String itemsJugadorString() {
        return jugador.getInventarioJugador();
    }

    /**
     * Method that returns the items of the player
     * 
     * @return
     */

    public Item getItemJugador(String item) {
        return jugador.getItem(item);
    }

    // Effect in the way that we write in the console
    private void textEffecto(String mensaje) {
        for (int i = 0; i <= mensaje.length(); i++) {
            try {
                Thread.sleep(15);
                System.out.print(mensaje.charAt(i));
            } catch (Exception e) {

            }
        }
    }

    /**
     * Method that returns the value of the last room
     */
    public TipoSalida getUltimoCuarto() {
        return direccionEntrada;
    }

    /**
     * Method that remove a item from the current room and if was possible return
     * true
     *
     * @param item
     * @return
     */
    public boolean removerItemCuarto(String item) {
        return cuartoActual.removerObjetoDelCuarto(item);
    }

    /**
     * Method that add a item to the current room
     * 
     * @param elemento
     * @return
     */
    public boolean addItemCuarto(Item elemento) {
        return cuartoActual.setObjetoDelCuarto(elemento);
    }

    /**
     * Metodo que devuelve si existe en el enum TipoSalida
     * 
     * @param elemento
     * @return
     */
    private boolean existInTipoSalida(String elemento) {
        boolean existe = false;
        for (TipoSalida salida : TipoSalida.values()) {
            if (salida.name().equals(elemento)) {
                existe = true;
            }
        }
        return existe;
    }

    // Objeto donde Guardamos las direcciones
    private TipoSalida direccionEntrada;

}