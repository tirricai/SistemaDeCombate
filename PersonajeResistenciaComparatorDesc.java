package TP;

import java.util.Comparator;

public class PersonajeResistenciaComparatorDesc implements Comparator<Competidor> {
    @Override
    public int compare(Competidor personaje, Competidor personaje2) {
        return -Integer.compare(personaje.getValor(Caracteristica.RESISTENCIA), personaje2.getValor(Caracteristica.RESISTENCIA));
    }
}
