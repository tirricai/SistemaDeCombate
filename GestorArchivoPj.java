package TP;

import java.io.*;
import java.util.*;

public class GestorArchivoPj {

	private List<Competidor> lstPersonajes = new ArrayList<>();

	public void readPersonaje(String path) throws CaracteristicaInvalidaException, NumberFormatException {

		FileReader file = null;
		int cantPersonajesErroneos = 0;
		int cantPersonajesCargados = 0;
		try {
			file = new FileReader(path);
			BufferedReader br = new BufferedReader(file);

			String linea = br.readLine();
		 	while ((linea != null)) {
				String[] split = linea.split(",");
				try {
					if (split[0].equals("HEROE")) {
						lstPersonajes.add(new Personaje(TipoCompetidor.HEROE, split[1].trim(), split[2].trim(),
								Integer.parseInt(split[3].trim()), Integer.parseInt(split[4].trim()),
								Integer.parseInt(split[5].trim()), Integer.parseInt(split[6].trim())));
						cantPersonajesCargados++;
					} else if (split[0].equals("VILLANO")) {
						lstPersonajes.add(new Personaje(TipoCompetidor.VILLANO, split[1].trim(), split[2].trim(),
								Integer.parseInt(split[3].trim()), Integer.parseInt(split[4].trim()),
								Integer.parseInt(split[5].trim()), Integer.parseInt(split[6].trim())));
						cantPersonajesCargados++;
					} else {
						System.out.println("La linea: " + linea);
						System.out.println("No se pudo cargar por un error en la linea");
						cantPersonajesErroneos++;
					}

				} catch (Exception e) {
					System.out.println("La linea: " + linea);
					System.out.println("No se pudo cargar por un errror en la linea");
					System.out.println("Error: " + e.getMessage());
					cantPersonajesErroneos++;
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
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					System.err.println(e.getLocalizedMessage());
					e.printStackTrace();
				}
			}
		}
		System.out.println("Cantidad de personajes cargados desde el archivo: " + cantPersonajesCargados);
		System.out.println("Personajes NO cargados del archivo: " + cantPersonajesErroneos);
	}

	  public void writePersonaje(){ FileWriter file = null; try { file = new
	  FileWriter("personajes.in"); for(Competidor pj : lstPersonajes){
	  file.write(pj.toString()); file.write("\n"); }
	  
	  } catch (IOException e) { System.err.println(e.getLocalizedMessage());
	  e.printStackTrace(); } finally { try { if(file != null){ file.close(); }
	  
	  } catch (IOException e) { System.err.println(e.getLocalizedMessage());
	  e.printStackTrace(); } } }
	 
	public PriorityQueue<Competidor> listadoOrdenado(List<Integer> lstCaracElegidasNum, boolean asc) {
		List<Caracteristica> lstCaracElegidas = new ArrayList<>();

		for(Integer i : lstCaracElegidasNum){
			//i = 1
			if (Caracteristica.VELOCIDAD.ordinal() == i) {
				lstCaracElegidas.add(Caracteristica.VELOCIDAD);
			} else if (Caracteristica.FUERZA.ordinal() == i) {
				lstCaracElegidas.add(Caracteristica.FUERZA);
			} else if (Caracteristica.RESISTENCIA.ordinal() == i) {
				lstCaracElegidas.add(Caracteristica.RESISTENCIA);
			} else {
				lstCaracElegidas.add(Caracteristica.DESTREZA);
			}
		}
		PriorityQueue<Competidor> res = null;
		if (asc){
			res = new PriorityQueue<Competidor>(new VariasCaracteristicasComparatorAsc(lstCaracElegidas));
			res.addAll(lstPersonajes);
		} else {
			res = new PriorityQueue<Competidor>(new VariasCaracteristicasComparatorDesc(lstCaracElegidas));
			res.addAll(lstPersonajes);
		}

		return res;
	}
	
	public Personaje crearPj() throws CaracteristicaInvalidaException {
		Scanner escaner = new Scanner(System.in);
		int opcion;
		String nombreReal;
		String nombrePersonaje;
		int velocidad;
		int fuerza;
		int resistencia;
		int destreza;
		TipoCompetidor tipo = null;
		

		System.out.println("Ingrese nombre real");
		nombreReal = escaner.nextLine();
		System.out.println("Ingrese nombre del pj");
		nombrePersonaje = escaner.nextLine();
		System.out.println("Ingrese velocidad del pj");
		velocidad = escaner.nextInt();
		System.out.println("Ingrese fuerza del pj");
		fuerza = escaner.nextInt();
		System.out.println("Ingrese resistencia del pj");
		resistencia = escaner.nextInt();
		System.out.println("Ingrese destreza del pj");
		destreza = escaner.nextInt();
		System.out.println("Ingrese nombre la alineacion de su personaje");
		System.out.println("1.Heroe");
		System.out.println("2.Villano");
		opcion = escaner.nextInt();
		switch (opcion){
		case 1:{
			tipo = tipo.HEROE;
			break;}
		case 2:{
			tipo = tipo.VILLANO;
			break;}}
		Personaje nuevo = new Personaje (tipo,nombreReal,nombrePersonaje,velocidad,fuerza,resistencia,destreza);
		add (nuevo);
		return nuevo;
	}

	public List<Competidor> getLstPersonajes() {
		return lstPersonajes;
	}

	public void setLstPersonajes(List<Competidor> lstPersonajes) {
		if (lstPersonajes == null) {
			this.lstPersonajes = new ArrayList<>();
		}
		this.lstPersonajes = lstPersonajes;
	}

	public void add(Competidor c) {
		if (lstPersonajes.contains(c)) {
			System.out.println("YA EXISTE EL PERSONAJE");
		} else {
			lstPersonajes.add(c);
		}
	}

}