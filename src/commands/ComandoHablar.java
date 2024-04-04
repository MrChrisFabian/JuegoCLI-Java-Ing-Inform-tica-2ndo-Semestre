package commands;

import dist.Juego;

public class ComandoHablar extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        if (getPalabras().get("parametro") == null) {
            juego.imprimir("No se ha especificado el personaje con el que hablar");
            return true;
        }
        String nombre = (String) getPalabras().get("parametro");
        juego.imprimir(juego.HablarCon(nombre));
        return true;
    }
}
