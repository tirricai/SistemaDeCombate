package TP;

import java.util.ArrayList;
import java.util.List;

public class Liga implements Competidor {

	private List<Competidor> competidores;

	public void agregarCompetidor(Competidor pj) throws TipoDeCompetidorException, PersonajeExistenteEnLigaException {
		if (competidores == null) {
			competidores = new ArrayList<>();
			competidores.add(pj);
		} else {
			if (competidores.contains(pj)) {
				 throw new PersonajeExistenteEnLigaException("Personaje existente en la liga");
			}
			Personaje pNuevo = (Personaje) pj;
			Personaje pLst = (Personaje) competidores.get(0);
			if (pLst.getTipo().name().equals(pNuevo.getTipo().name())) {
				competidores.add(pj);
			} else {
				throw new TipoDeCompetidorException("El tipo de competidor no se acepta en esta Liga");
			}
		}
	}

	@Override
	public String toString() {
		return "Liga [competidores=" + competidores + "]";
	}

	public TipoCompetidor obtenerPrimerTipo() {
		TipoCompetidor aux = null;
		if (this.competidores.get(0) != null) {
			aux = ((Personaje) competidores.get(0)).getTipo();
		}
		return aux;
	}

	public Caracteristica getNombreCaracteristica(double posicion) {
		if (posicion == 0) {
			return Caracteristica.VELOCIDAD;
		} else if (posicion == 1) {
			return Caracteristica.FUERZA;
		} else if (posicion == 2) {
			return Caracteristica.RESISTENCIA;
		} else {
			return Caracteristica.DESTREZA;
		}
	}

	public Integer getPromedioDe(Caracteristica caracteristica) {
		int suma = 0;
		for (Competidor competidor : competidores) {
			Personaje c = (Personaje) competidor;
			suma += c.getCaracteristica(caracteristica);
		}
		return suma / competidores.size();
	}

	public Integer tamanio() {
		return competidores.size();
	}

	public List<Competidor> listar() {
		if (competidores == null) {
			competidores = new ArrayList<>();
		}
		return competidores;
	}
	
	public List<Competidor> getCompetidores(){
		return this.competidores;
	}

	@Override
	public boolean esGanador(Competidor compe, Caracteristica atr) throws TipoDeCompetidorException{

		if (this.obtenerPrimerTipo() == compe.getAfilacion()){
			System.out.println("No es posible la pelea");
			System.out.println("Los competidores son de la misma afilacion");
			return false;
		}

		if (Integer.compare(this.getPromedioDe(atr), compe.getValor(atr)) == -1){
			System.out.println("Su liga PERDIO");
			return false;
		} else if (Integer.compare(this.getPromedioDe(atr), compe.getValor(atr)) == 1){
			System.out.println("Su liga GANO");
			return true;
		} else {
			System.out.println("Hay empate entre la caracteristica elegida, se definiran por las siguientes");
			int cont = 0;
			double posicion = atr.ordinal();
			//posicion = 3
			while (cont < 4) {
				Caracteristica carac = this.getNombreCaracteristica(posicion);
				double v1 = this.getPromedioDe(carac);
				double v2 = compe.getValor(carac);
				if (v2 > v1) {
					System.out.println("Su liga PERDIO!");
					System.out.println("Por la caracteristica: " + carac);
					return false;
				} else if (v1 > v2) {
					System.out.println("Su liga GANO!");
					System.out.println("Por la caracteristica: " + carac);
					return true;
				}
				posicion++;
				if (posicion >= 4){
					posicion = 0;
				}
				cont++;
			}
		}
		System.out.println("EMPATE");
		return false;
	}

	@Override
	public Integer getValor(Caracteristica c) {
		return this.getPromedioDe(c);
	}

	@Override
	public TipoCompetidor getAfilacion() {
		return this.obtenerPrimerTipo();
	}

}















