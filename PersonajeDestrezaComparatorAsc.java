package TP;

import java.util.Comparator;

public class PersonajeDestrezaComparatorAsc implements Comparator<Competidor> {

    @Override
    public int compare(Competidor personaje, Competidor personaje2) {
        return Integer.compare(personaje.getValor(Caracteristica.DESTREZA), personaje2.getValor(Caracteristica.DESTREZA));
    }
}