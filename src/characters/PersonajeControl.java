package characters;

import java.util.ArrayList;
    /**
     * Clase Controladora para los clases de tipo Personaje
     */
public class PersonajeControl {
    public PersonajeControl() {
    }

    /**
     * Agregar un personaje al controlador
     * 
     * @param personaje
     */
    public void addPersonaje(Personaje personaje) {
        personajes.add(personaje);
    }

    /**
     * Retornamos todos los Personajes en el controlador
     * 
     * @return
     */

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    /**
     * Metodo que devuelve todos los nombres de los personajes en el controlador
     * 
     * @param nombre
     * @return
     */
    public String getPersonajesNombres() {
        String nombres = "";
        for (Personaje p : personajes) {
            nombres += p.getNombre() + "\n";
        }
        return nombres;
    }

    /**
     * Removemos un Personaje
     * 
     * @param nombre
     * @return
     */
    public boolean removePersonaje(Personaje personaje) {
        return personajes.removeIf(p -> p.equals(personaje));
    }

    /**
     * Metodo que retorna un personaje por su nombre
     * 
     * @param nombre
     * @return
     */
    public Personaje getPersonaje(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    private ArrayList<Personaje> personajes = new ArrayList<>();
}
