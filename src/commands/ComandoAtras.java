package commands;

import dist.Juego;
import utils.TipoSalida;

/**
 * Atras, nos dirijimos a la dirección para salir del cuarto actual
 */
public class ComandoAtras extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        // Buscar la direccion que coincida con getUltimoCuarto
        TipoSalida direccion = juego.getUltimoCuarto();
        switch (direccion) {
            case NORTE:
                juego.irA("SUR");
                break;
            case SUR:
                juego.irA("NORTE");

                break;
            case ESTE:
                juego.irA("OESTE");

                break;
            case OESTE:
                juego.irA("ESTE");

                break;
            case ARRIBA:
                juego.irA("ABAJO");

                break;
            case ABAJO:
                juego.irA("ARRIBA");
                break;
        }
        return true;
    }
}
