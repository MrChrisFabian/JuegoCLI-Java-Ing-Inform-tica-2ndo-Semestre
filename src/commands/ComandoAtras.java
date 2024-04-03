package commands;

import dist.Juego;
import utils.TipoSalida;

public class ComandoAtras extends ComandoAbstracto {
    public boolean ejecutar(Juego juego) {
        // Buscar la direccion que coincida con getUltimoCuarto
        TipoSalida direccion = juego.getUltimoCuarto();
        switch (direccion) {
            case TipoSalida.NORTE:
                juego.irA("SUR");
                break;
            case TipoSalida.SUR:
                juego.irA("NORTE");

                break;
            case TipoSalida.ESTE:
                juego.irA("OESTE");

                break;
            case TipoSalida.OESTE:
                juego.irA("ESTE");

                break;
            case TipoSalida.ARRIBA:
                juego.irA("ABAJO");

                break;
            case TipoSalida.ABAJO:
                juego.irA("ARRIBA");

                break;
        }
        return true;
    }
}
