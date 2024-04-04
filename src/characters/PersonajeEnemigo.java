package characters;

public class PersonajeEnemigo extends Personaje {
    public PersonajeEnemigo(String nombre, String[] dialogos, int vida) {
        super(nombre, dialogos);
        this.vida = vida;
    }

    private final int vida;

}