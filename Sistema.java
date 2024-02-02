package TP;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Sistema {
    private GestorArchivoPj ga;
    private GestorArchivoLigas gl;
    private boolean pjCargados = false;
    private boolean ligasCargadas = false;
    public Sistema(GestorArchivoPj ga, GestorArchivoLigas gl){
        this.ga = ga;
        this.gl = gl;
    }

    public void juegoHeroeyVillanos() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {

        int opciones = 0;
        String tempS = null;
        boolean orden = true;
        int opcionEleccion = 0;
        Competidor miCompetidor = null;
        Liga miLiga;
        Liga miLigaRival;

        String lineas = ("\n"+"------------------------------------------------------------------"+"\n");
        System.out.println("Bienvenido al juego!" + "\n" +  "Seleccione que desea hacer:");
        Scanner escaner = new Scanner(System.in);

        while (opciones != 14) {
            System.out.println("---Administracion de Personajes---\n" +
                    "1.Carga desde archivo\n" +
                    "2.Creacion\n" +
                    "3.Listado\n" +
                    "4.Guardar en archivo todos los personajes\n" +
                    "---Administracion de Ligas---\n" +
                    "5.Carga desde archivo\n" +
                    "6.Creacion\n" +
                    "7.Listado\n" +
                    "8.Guardar en archivo todas las ligas\n"+
                    "---Menu de combates---\n"+
                    "9. Pelear personaje contra Personaje\n"+
                    "10. Pelear personaje contra Liga\n"+
                    "11. Pelear Liga contra Liga\n"+
                    "---Reportes---\n"+
                    "12. Personaje contra todos los personajes y ligas\n"+
                    "13. Listado ordenado por multiples caracteriscticas\n"+
                    "14. Salir");
            opciones = escaner.nextInt();

            switch (opciones){
                case 1:{
                    ga.readPersonaje("personajes.in");
                    pjCargados = true;
                    break;}
                case 2:{
                	if (pjCargados) {
                        ga.crearPj();
                        System.out.println(lineas+"El personaje se creo correctamente"+lineas);
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor vuelva a intentar"+lineas);
                	}
                    break;}
                case 3:{
                	if (pjCargados) {
                        for(Competidor p: ga.getLstPersonajes()){
                            System.out.println(lineas+p.toString()+lineas);
                        }
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                	}
                    break;}
                case 4:{
                	if(pjCargados) {
                    ga.writePersonaje();
            		}else {
            		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
            		}
                    break;}
                case 5:{
                	if (pjCargados) {
                    gl.readLigas(ga.getLstPersonajes(), "ligas.in");
                    System.out.println(lineas+"Las ligas se cargaron correctamente"+lineas);
                        ligasCargadas = true;
            		}else {
            		System.out.println(lineas+"Opcion no valida por favor cargue primero el archivo de personajes!"+lineas);
            		}
                    break;}
                case 6:{
                	if (pjCargados && ligasCargadas) {
                    gl.crearLiga(ga);
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                	}
                    break;}
                case 7:{
                	if (pjCargados && ligasCargadas) {
                    for (Liga l: gl.getLstLigas()) {
                        if (l.getCompetidores() != null){
                            System.out.println(lineas);
                            for (Competidor c: l.getCompetidores()) {
                                Personaje p = (Personaje) c;
                                System.out.println(p.toString());;
                            }
                        }

                    }
                    System.out.println(lineas);
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                	}
                    break;}
                case 8:{
                	if (pjCargados && ligasCargadas) {
                    gl.writeLigas();
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                	}
                    break;}
                case 9:{
                    if (pjCargados) {
                        boolean flag = false;
                        boolean flagE = false;
                        Competidor cEnemigo = null;
                        for (Competidor p : ga.getLstPersonajes()) {
                            System.out.println(lineas+p.toString()+lineas);
                        }

                        while (!flag) {
                            System.out.println(lineas);
                            System.out.println("Elija con que personaje desea luchar\n");
                            Scanner escanerNuevo = new Scanner(System.in);
                            tempS = escanerNuevo.nextLine();

                            for (Competidor c: ga.getLstPersonajes()) {
                                Personaje p = (Personaje) c;
                                if(p.getNombrepj().equals(tempS)) {
                                    miCompetidor = p;
                                    flag = true;
                                }
                            }
                            if (!flag ) {
                                System.out.println("El personaje no existe o esta mal tipeado reintente\n");

                            }
                        }

                        while (!flagE) {
                            System.out.println(lineas);
                            System.out.println("Elija con que personaje desea luchar\n");
                            Scanner escanerNuevo = new Scanner(System.in);
                            tempS = escanerNuevo.nextLine();

                            for (Competidor c: ga.getLstPersonajes()) {
                                Personaje p = (Personaje) c;
                                if(p.getNombrepj().equals(tempS)) {
                                    cEnemigo = p;
                                    flagE = true;
                                }
                            }
                            if (!flagE ) {
                                System.out.println("El personaje no existe o esta mal tipeado reintente\n");

                            }
                        }

                        System.out.println("Por cual caracteristica quiere que luchen ?\n"
                                +"1.Velocidad\n"+
                                "2.Fuerza\n"+
                                "3.Resistencia\n"+
                                "4.Destreza\n");
                        opcionEleccion = escaner.nextInt();

                        switch(opcionEleccion) {
                            case 1:{
                                System.out.println(lineas);
                                miCompetidor.esGanador(cEnemigo, Caracteristica.VELOCIDAD);
                                System.out.println(lineas);
                                break;
                            }
                            case 2:
                                System.out.println(lineas);
                                miCompetidor.esGanador(cEnemigo, Caracteristica.FUERZA);
                                System.out.println(lineas);
                                break;
                            case 3:
                                System.out.println(lineas);
                                miCompetidor.esGanador(cEnemigo, Caracteristica.RESISTENCIA);
                                System.out.println(lineas);
                                break;
                            case 4:
                                System.out.println(lineas);
                                miCompetidor.esGanador(cEnemigo, Caracteristica.DESTREZA);
                                System.out.println(lineas);
                                break;
                        }

                    }else {
                        System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                    }
                    break;}
                case 10:{
                	if (pjCargados && ligasCargadas) {
                    boolean flag = false;
                    for (Competidor p : ga.getLstPersonajes()) {
                        System.out.println(lineas+p.toString()+lineas);
                    }
                    while (!flag) {
                        System.out.println(lineas);
                        System.out.println("Elija con que personaje desea luchar\n");
                        Scanner escanerNuevo = new Scanner(System.in);
                        tempS = escanerNuevo.nextLine();

                        for (Competidor c: ga.getLstPersonajes()) {
                            Personaje p = (Personaje) c;
                            if(p.getNombrepj().equals(tempS)) {
                                miCompetidor = p;
                                flag = true;
                            }
                        }
                        if (!flag ) {
                            System.out.println("El personaje no existe o esta mal tipeado reintente\n");

                        }
                    }

                    for (Liga l: gl.getLstLigas()) {
                        System.out.println(lineas+"Liga numero: "+opcionEleccion+lineas);
                        for (Competidor c: l.getCompetidores()) {
                            Personaje p = (Personaje) c;
                            System.out.println(". "+p.toString());;

                        }
                        opcionEleccion++;
                    }
                    System.out.println(lineas+"Elija con que liga quiere enfrentarse\n"+lineas);
                    opcionEleccion = escaner.nextInt();
                    miLiga = gl.getLstLigas().get(opcionEleccion);

                    System.out.println("Por cual caracteristica quiere que luchen ?\n"
                            +"1.Velocidad\n"+
                            "2.Fuerza\n"+
                            "3.Resistencia\n"+
                            "4.Destreza\n");
                    opcionEleccion = escaner.nextInt();
                    switch(opcionEleccion) {
                        case 1:{
                            System.out.println(lineas);
                            miCompetidor.esGanador(miLiga, Caracteristica.VELOCIDAD);
                            System.out.println(lineas);
                            break;
                        }
                        case 2:
                            System.out.println(lineas);
                            miCompetidor.esGanador(miLiga, Caracteristica.FUERZA);
                            System.out.println(lineas);
                            break;
                        case 3:
                            System.out.println(lineas);
                            miCompetidor.esGanador(miLiga, Caracteristica.RESISTENCIA);
                            System.out.println(lineas);
                            break;
                        case 4:
                            System.out.println(lineas);
                            miCompetidor.esGanador(miLiga, Caracteristica.DESTREZA);
                            System.out.println(lineas);
                            break;

                    }
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                	}
                    opcionEleccion = 0;
                    break;}
                case 11:{
                	if (pjCargados && ligasCargadas) {

                    for (Liga l: gl.getLstLigas()) {
                        System.out.println(lineas+"Liga numero: "+opcionEleccion+lineas);
                        for (Competidor c: l.getCompetidores()) {
                            System.out.println(". "+c.toString());;
                        }
                        opcionEleccion++;
                    }

                    System.out.println(lineas+"Elija que liga quiere utilizar\n"+lineas);
                    miLiga = gl.getLstLigas().get(escaner.nextInt());
                    System.out.println(lineas+"Elija contra que liga quiere enfrentarse\n"+lineas);
                    miLigaRival = gl.getLstLigas().get(escaner.nextInt());
                    System.out.println("Por cual caracteristica quiere que luchen ?\n"
                            +"1.Velocidad\n"+
                            "2.Fuerza\n"+
                            "3.Resistencia\n"+
                            "4.Destreza\n");
                    opcionEleccion = escaner.nextInt();
                    switch(opcionEleccion) {
                        case 1:{
                            miLiga.esGanador(miLigaRival, Caracteristica.VELOCIDAD);
                            break;
                        }
                        case 2:
                            miLiga.esGanador(miLigaRival, Caracteristica.FUERZA);
                            break;
                        case 3:
                            miLiga.esGanador(miLigaRival, Caracteristica.RESISTENCIA);
                            break;
                        case 4:
                            miLiga.esGanador(miLigaRival, Caracteristica.DESTREZA);
                            break;
                    }
                    
                	}else {
                		System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                	}
                    opcionEleccion = 0;
                    break;}
                case 12:{
                	if (pjCargados && ligasCargadas) {
                        boolean flag = false;
                        for (Competidor p : ga.getLstPersonajes()) {
                        	System.out.println(lineas+p.toString()+lineas);
                        }
                        while (!flag) {
                       	System.out.println(lineas+"Ingrese con que personaje quiere hacer el reporte: "+lineas);
                            Scanner escanerNuevo = new Scanner(System.in);
                            tempS = escanerNuevo.nextLine();

                            for (Competidor c: ga.getLstPersonajes()) {
                                Personaje p = (Personaje) c;
                                if(p.getNombrepj().equals(tempS)) {
                                    miCompetidor = p;
                                    flag = true;
                                }
                            }
                            if (!flag ) {
                                System.out.println("El personaje no existe o esta mal tipeado reintente\n");

                            }
                        }
                        System.out.println("Por cual caracteristica quiere que luchen ?\n"
                                +"1.Velocidad\n"+
                                "2.Fuerza\n"+
                                "3.Resistencia\n"+
                                "4.Destreza\n");
                        opcionEleccion = escaner.nextInt();
                        switch(opcionEleccion) {
                            case 1:{
                                System.out.println("Enfrentamiento contra personajes");
                                System.out.println("Resultado");
                            	for (Competidor p : ga.getLstPersonajes()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.VELOCIDAD);
                                        System.out.println("Contra el personaje: " +p.toString());
                                        System.out.println(lineas);
                                    }
                            	}
                                System.out.println("Enfrentamiento contra ligas");
                                System.out.println("Resultado");
                            	for (Liga p: gl.getLstLigas()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.VELOCIDAD);
                                        System.out.println("Contra la liga: " + p.toString());
                                        System.out.println(lineas);
                                    }
                            	}
                                break;
                            }
                            case 2:
                                System.out.println("Enfrentamiento contra personajes");
                                for (Competidor p : ga.getLstPersonajes()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.FUERZA);
                                        System.out.println("Contra el personaje: " +p.toString());
                                        System.out.println(lineas);
                                    }
                                }
                                System.out.println("Enfrentamiento contra ligas");
                                for (Liga p: gl.getLstLigas()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.FUERZA);
                                        System.out.println("Contra la liga: " + p.toString());
                                        System.out.println(lineas);
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Enfrentamiento contra personajes");
                                for (Competidor p : ga.getLstPersonajes()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.RESISTENCIA);
                                        System.out.println("Contra el personaje: " +p.toString());
                                        System.out.println(lineas);
                                    }
                                }
                                System.out.println("Enfrentamiento contra ligas");
                                for (Liga p: gl.getLstLigas()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.RESISTENCIA);
                                        System.out.println("Contra la liga: " + p.toString());
                                        System.out.println(lineas);
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Enfrentamiento contra personajes");
                                for (Competidor p : ga.getLstPersonajes()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.DESTREZA);
                                        System.out.println("Contra el personaje: " +p.toString());
                                        System.out.println(lineas);
                                    }
                                }
                                System.out.println("Enfrentamiento contra ligas");
                                for (Liga p: gl.getLstLigas()) {
                                    if (!miCompetidor.getAfilacion().equals(p.getAfilacion())){
                                        System.out.println(lineas);
                                        miCompetidor.esGanador(p, Caracteristica.DESTREZA);
                                        System.out.println("Contra la liga: " + p.toString());
                                        System.out.println(lineas);
                                    }
                                }
                        }
                    } else {
                        System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                    }
                    break;
                }
                case 13:{
                	if (pjCargados) {
                    System.out.println("como desea ordenarlo asendente o desendente ?\n"+
                            "1.Asendente\n"+
                            "2.Desendente\n");

                    boolean ban = false;
                    while (!ban){
                        opciones = escaner.nextInt();
                        switch(opciones) {
                            case 1:{
                                orden = true;
                                ban = true;
                                break;
                            }
                            case 2:{
                                orden = false;
                                ban = true;
                                break;
                            }
                            default:{
                                System.out.println("Opcion invalida, ingrese de nuevo");
                                break;
                            }
                        }
                    }

                    List<Integer> caracElegidas = new ArrayList<>();
                    int cargar = 0;
                    while (cargar != 2){
                        System.out.println("Por cual caracteristica quiere listar ?\n"
                                +"0.Velocidad\n"+
                                "1.Fuerza\n"+
                                "2.Resistencia\n"+
                                "3.Destreza\n");
                        opciones = escaner.nextInt();
                        caracElegidas.add(opciones);

                        System.out.println("Quiere ordenar por otra caracteristica ?\n"
                        +"1.Si\n"
                        +"2.No");
                        cargar = escaner.nextInt();
                    }
                    PriorityQueue<Competidor> lstOrd = ga.listadoOrdenado(caracElegidas, orden);

                    while (!lstOrd.isEmpty()){
                        System.out.println(lstOrd.poll().toString());
                    }
                        System.out.println(lineas);
                } else {
                        System.out.println(lineas+"Opcion no valida por favor cargue primero los archivos!"+lineas);
                    }
                    break;
                }
                case 14:{
                    //opciones = 13;
                    System.out.println("Gracias por Jugar");
                    break;}
                default:
                    System.out.println("Opcion invalida, elija una opcion de la lista");
                    break;
            }
        }
    }
}

