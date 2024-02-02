package TP;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestorArchivoLigas {
    private List<Liga> ligas = new ArrayList<>();

    public void readLigas(List<Competidor> competidores, String path) throws TipoDeCompetidorException, PersonajeExistenteEnLigaException{

        FileReader file = null;
        BufferedReader br = null;

        try{
            file = new FileReader(path);
            br = new BufferedReader(file);

            String linea = br.readLine();
            while((linea != null)){
                Liga liga = new Liga();
                String[] split = linea.split(",");
                for(Competidor pj : competidores){
                    Personaje p = (Personaje) pj;
                    for (String nombre: split){
                        if(nombre.trim().equals(p.getNombrepj())){
                            liga.agregarCompetidor(pj);
                        }
                    }
                }

                if (liga.getCompetidores() != null){
                    ligas.add(liga);
                }

                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: No se encontro el archivo");
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
        }  finally {
            if (file != null){
                try {
                    file.close();
                } catch (IOException e) {
                    System.err.println(e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }
    }

    public void writeLigas(){
        FileWriter file = null;
        try {
            file = new FileWriter("ligas.in");
            for(Liga liga : ligas){
                Iterator<Competidor> it = liga.listar().listIterator();
                while (it.hasNext()){
                    Personaje pj = (Personaje) it.next();
                    file.write("" + pj.getNombrepj());
                    if(it.hasNext()){
                        file.write(",");
                    }
                }
                file.write("\n");
            }

        } catch (IOException e) {
            System.err.println(e.getLocalizedMessage());
            e.printStackTrace();
        } finally {
            try {
                if(file != null){
                    file.close();
                }

            } catch (IOException e) {
                System.err.println(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
    }
    
    public void crearLiga(GestorArchivoPj ga) throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
    	Scanner escaner = new Scanner(System.in);
		int opcion = 1;		
		String nombrePersonaje;
		Liga a = new Liga();
		boolean existe= false;

		
		while(opcion == 1) {
				System.out.println("Ingrese nombre del pj");
			nombrePersonaje = escaner.nextLine();
			for (Competidor r: ga.getLstPersonajes()) {
				Personaje p = (Personaje) r;
				if (p.getNombrepj().equals(nombrePersonaje)) {
                    try{
                        a.agregarCompetidor(r);
                    } catch (TipoDeCompetidorException e){
                        System.out.println("No se pudo agregar el competidor a la liga, " + e.getMessage());
                    }
					existe = true;
				}
			}
			if (!existe) {
                System.out.println("El personaje no existe, cree el personaje nuevo");
                try {
                    a.agregarCompetidor(ga.crearPj());
                } catch (TipoDeCompetidorException ex){
                    System.out.println("No se pudo agregar el competidor a la liga, " + ex.getMessage());
                }
			}
		
				System.out.println("desea agregar otro pj ?\n"+
		"1.Si\n"+
		"2.No\n");
			opcion = escaner.nextInt();
			
		}
		getLstLigas().add(a);
    }

    public List<Liga> getLstLigas() {
        return ligas;
    }

    public void setLstLigas(List<Liga> lstLigas) {
        if(lstLigas == null){
            lstLigas = new ArrayList<>();
        }
        this.ligas = lstLigas;
    }
}
