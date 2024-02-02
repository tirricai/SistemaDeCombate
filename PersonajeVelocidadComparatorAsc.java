package TP;

import java.util.Comparator;

public class PersonajeVelocidadComparatorAsc implements Comparator<Competidor> {
    @Override
    public int compare(Competidor personaje, Competidor personaje2) {
        return Integer.compare(personaje.getValor(Caracteristica.VELOCIDAD), personaje2.getValor(Caracteristica.VELOCIDAD));
    }
}
