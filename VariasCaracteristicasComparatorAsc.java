package TP;

import java.util.Comparator;
import java.util.List;

public class VariasCaracteristicasComparatorAsc implements java.util.Comparator<Competidor> {

    PersonajeVelocidadComparatorAsc vc;
    PersonajeFuerzaComparatorAsc fc;
    PersonajeResistenciaComparatorAsc rc;
    PersonajeDestrezaComparatorAsc dc;
    List<Caracteristica> lstCaracteristicas;
    Comparator[] arrComparator;


    public VariasCaracteristicasComparatorAsc(List<Caracteristica> lstCarac){
        this.vc = new PersonajeVelocidadComparatorAsc();
        this.fc = new PersonajeFuerzaComparatorAsc();
        this.rc = new PersonajeResistenciaComparatorAsc();
        this.dc = new PersonajeDestrezaComparatorAsc();
        arrComparator = new Comparator[]{vc, fc, rc, dc};
        this.lstCaracteristicas = lstCarac;
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
