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

import characters.Personaje;
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
        // Patio
        Cuarto patio = new Cuarto("Patio del Overlook");
        Cuarto patioDeJuegos = new Cuarto("Patio de Juegos especial para los niños!");
        Cuarto estacionamiento = new Cuarto("Estacionamiento del Hotel");
        // Planta Baja
        Cuarto vestibulo = new Cuarto("Vestibulo del Overlook");
        Cuarto salon = new Cuarto("Salón del Overlook con imponentes ventanales al frio invierno");
        Cuarto salonRojo = new Cuarto("Estas en el Salón Rojo... La muerte Roja se acerca...");
        Cuarto ascensorPB = new Cuarto("Ascensor...Planta Baja");
        // Primer Piso
        Cuarto ascensorPP = new Cuarto("Ascensor...Primer Piso");
        Cuarto pasilloPP = new Cuarto("Pasillo del Primer Piso");
        Cuarto SuitePresidencial = new Cuarto("Una elegante y exclusiva Habitación...La Suite Presidencial");
        Cuarto DogmanCuarto = new Cuarto("Este cuarto parece no estar ocupado, pero la puerta estaba abierta...");
        Cuarto pasillo217 = new Cuarto("Estas frente a la habitación 217...");
        Cuarto habitacion217 = new Cuarto("Expedición al interior de la Habitación 217...");
        Cuarto baño217 = new Cuarto("Baño de la habitación 217...");
        // Sub Suelo (Sotano)
        Cuarto ascensorSS = new Cuarto("Ascensor...Sub Suelo");
        Cuarto pasilloSS = new Cuarto("Estas en SubSuelo, un lugar oscuro y frio...");
        Cuarto habitaciónServicio = new Cuarto("Las habitaciones de la Familia Torrance");
        Cuarto Cocina = new Cuarto("La Gran Cocina del Hotel");
        Cuarto despensa = new Cuarto("Despensa del Hotel");
        Cuarto calderas = new Cuarto("Calderas del Hotel");
        // inicializar las salidas
        // Patio
        patio.setSalidas(TipoSalida.NORTE, vestibulo);
        patio.setSalidas(TipoSalida.OESTE, patioDeJuegos);
        patio.setSalidas(TipoSalida.SUR, estacionamiento);
        // Patio de Juegos
        patioDeJuegos.setSalidas(TipoSalida.ESTE, patio);
        // Estacionamiento
        estacionamiento.setSalidas(TipoSalida.NORTE, patio);
        // vestibulo
        vestibulo.setSalidas(TipoSalida.SUR, patio);
        vestibulo.setSalidas(TipoSalida.OESTE, salonRojo);
        vestibulo.setSalidas(TipoSalida.ESTE, salon);
        vestibulo.setSalidas(TipoSalida.NORTE, ascensorPB);
        // salonRojo
        salonRojo.setSalidas(TipoSalida.ESTE, vestibulo);
        // salon
        salon.setSalidas(TipoSalida.OESTE, vestibulo);
        // ascensorPB
        ascensorPB.setSalidas(TipoSalida.SUR, vestibulo);
        ascensorPB.setSalidas(TipoSalida.ARRIBA, ascensorPP);
        ascensorPB.setSalidas(TipoSalida.ABAJO, ascensorSS);
        // ascensorPP
        ascensorPP.setSalidas(TipoSalida.ABAJO, ascensorPB);
        ascensorPP.setSalidas(TipoSalida.SUR, pasilloPP);
        // pasillo
        pasilloPP.setSalidas(TipoSalida.NORTE, ascensorPP);
        pasilloPP.setSalidas(TipoSalida.OESTE, SuitePresidencial);
        pasilloPP.setSalidas(TipoSalida.ESTE, pasillo217);
        // SuitePresidencial
        SuitePresidencial.setSalidas(TipoSalida.ESTE, pasilloPP);
        // pasillo217
        pasillo217.setSalidas(TipoSalida.OESTE, pasilloPP);
        pasillo217.setSalidas(TipoSalida.ESTE, DogmanCuarto);
        pasillo217.setSalidas(TipoSalida.SUR, habitacion217);
        // habitacion217
        habitacion217.setSalidas(TipoSalida.NORTE, pasillo217);
        habitacion217.setSalidas(TipoSalida.ESTE, baño217);
        // baño217
        baño217.setSalidas(TipoSalida.OESTE, habitacion217);
        // DogmanCuarto
        DogmanCuarto.setSalidas(TipoSalida.OESTE, pasillo217);
        // ascensorSS
        ascensorSS.setSalidas(TipoSalida.ARRIBA, ascensorPB);
        ascensorSS.setSalidas(TipoSalida.SUR, pasilloSS);
        // pasilloSS
        pasilloSS.setSalidas(TipoSalida.NORTE, ascensorSS);
        pasilloSS.setSalidas(TipoSalida.OESTE, habitaciónServicio);
        pasilloSS.setSalidas(TipoSalida.ESTE, Cocina);
        pasilloSS.setSalidas(TipoSalida.SUR, calderas);
        // habitaciónServicio
        habitaciónServicio.setSalidas(TipoSalida.ESTE, pasilloSS);
        // Cocina
        Cocina.setSalidas(TipoSalida.OESTE, pasilloSS);
        Cocina.setSalidas(TipoSalida.NORTE, despensa);
        // despensa
        despensa.setSalidas(TipoSalida.SUR, Cocina);
        // calderas
        calderas.setSalidas(TipoSalida.NORTE, pasilloSS);
        // Creamos los objetos
        Item hacha = new Item("Hacha-de-Incendios", 50);
        Item palo = new Item("Palo-de-Cricket", 20);
        Item maleta = new Item("Maleta-perdida", 20);
        Item maqEscribir = new Item("Maquina-de-Escribir", 20);

        // Juguetes de Danny
        Item Triciclo = new Item("Triciclo", 9);
        Item pelota = new Item("Pelota", 2);
        Item superHeroe = new Item("Juegute-de-Batman", 2);
        Item yoyo = new Item("Yoyo", 1);
        Item autito = new Item("Autito", 3);
        // Comida
        Item Gintonic = new Item("Gintonic", 1);
        Item Flan = new Item("Flan", 1);

        // Agregamos los Objetos a los cuartos
        estacionamiento.setObjetoDelCuarto(autito);
        estacionamiento.setObjetoDelCuarto(maleta);

        patioDeJuegos.setObjetoDelCuarto(pelota);

        salon.setObjetoDelCuarto(palo);
        salon.setObjetoDelCuarto(maqEscribir);

        despensa.setObjetoDelCuarto(Flan);
        despensa.setObjetoDelCuarto(yoyo);

        pasilloPP.setObjetoDelCuarto(Triciclo);

        salonRojo.setObjetoDelCuarto(Gintonic);

        calderas.setObjetoDelCuarto(hacha);

        pasillo217.setObjetoDelCuarto(superHeroe);

        // Creamos los personajes
        Personaje halloran = new Personaje("Halloran",
                new String[] { "Hola Doc!", "Los lugares son como las personas, algunos brillan, otros no...",
                        "No te acerques a la habitación 217" });
        Personaje wendy = new Personaje("Wendy",
                new String[] { "Hola Danny, ¿Como estas?", "¿Hey Danny estas jugando con Tonny?" });
        // Agregamos los personajes a los cuartos
        // Establecemos donde inicia el juego
        cuartoActual = patio;
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
        imprimir("Gracias Por Jugar...El Overlook siempre lo espera...");
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
     * Imprime un mensaje para el usuario, pero
     * se queda en la misma linea.
     *
     * @param mensaje
     */
    public void imprimirCont(String mensaje) {
        textEffecto(mensaje);
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
                Thread.sleep(10);
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
     * Method that returns a dialog from a specific character
     * 
     * @param nombre
     * @return
     */
    public String HablarCon(String nombre) {
        return cuartoActual.getDialogoPersonaje(nombre);
    }

    public int getEspacioInventarioJugador() {
        return jugador.getEspacio();
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
