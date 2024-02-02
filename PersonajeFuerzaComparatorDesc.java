package TP;

import java.util.Comparator;

public class PersonajeFuerzaComparatorDesc implements Comparator<Competidor> {
    @Override
    public int compare(Competidor p, Competidor p2) {
        return -Integer.compare(p.getValor(Caracteristica.FUERZA), p2.getValor(Caracteristica.FUERZA));
    }
}
