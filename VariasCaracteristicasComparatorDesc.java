package TP;

import java.util.Comparator;
import java.util.List;

public class VariasCaracteristicasComparatorDesc implements java.util.Comparator<Competidor> {

    PersonajeVelocidadComparatorDesc vc;
    PersonajeFuerzaComparatorDesc fc;
    PersonajeResistenciaComparatorDesc rc;
    PersonajeDestrezaComparatorDesc dc;
    List<Caracteristica> lstCaracteristicas;
    Comparator[] arrComparator;

    public VariasCaracteristicasComparatorDesc(List<Caracteristica> lstCarac){
        this.vc = new PersonajeVelocidadComparatorDesc();
        this.fc = new PersonajeFuerzaComparatorDesc();
        this.rc = new PersonajeResistenciaComparatorDesc();
        this.dc = new PersonajeDestrezaComparatorDesc();
        arrComparator = new Comparator[]{vc, fc, rc, dc};
        this.lstCaracteristicas = lstCarac; //DESTREZA, FUERZA
    }

    @Override
    public int compare(Competidor p1, Competidor p2) {
        int cont = 0;
        int res = 0;
        while (res == 0 && cont < lstCaracteristicas.size()){
            res = arrComparator[lstCaracteristicas.get(cont).ordinal()].compare(p1, p2);
            cont++;
        }
        return res;
    }
}
