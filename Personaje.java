package TP;

import java.util.HashMap;

public class Personaje implements Competidor {

	private TipoCompetidor tipo;
	private String nombreReal;
	private String nombrepj;
	private HashMap<Caracteristica, Integer> caracteristicas = new HashMap<Caracteristica, Integer>();

	public Personaje(TipoCompetidor tipo, String nombreReal, String nombrepj, int velocidad, int fuerza,
			int resistencia, int destreza) throws CaracteristicaInvalidaException {
		this.tipo = tipo;
		this.nombreReal = nombreReal;
		this.nombrepj = nombrepj;
		this.caracteristicas.put(Caracteristica.VELOCIDAD, setCaracteristica(velocidad));
		this.caracteristicas.put(Caracteristica.FUERZA, setCaracteristica(fuerza));
		this.caracteristicas.put(Caracteristica.RESISTENCIA, setCaracteristica(resistencia));
		this.caracteristicas.put(Caracteristica.DESTREZA, setCaracteristica(destreza));
	}
	@Override
	public boolean esGanador(Competidor compe, Caracteristica atr) throws TipoDeCompetidorException {

		if (this.getTipo() == compe.getAfilacion()){
			System.out.println("No es posible la pelea");
			System.out.println("Los competidores son de la misma afilacion");
			return false;
		}

		if (Integer.compare(this.getCaracteristica(atr), compe.getValor(atr)) == -1){
			System.out.println("Su personaje PERDIO");
			return false;
		} else if (Integer.compare(this.getCaracteristica(atr), compe.getValor(atr)) == 1){
			System.out.println("Su personaje GANO");
			return true;
		} else {
			System.out.println("Hay empate entre la caracteristica elegida, se definiran por las siguientes");
			int cont = 0;
			double posicion = atr.ordinal();
			// Ordinal devuelve el indice de los enum
			while (cont < 4) {
				Caracteristica carac = this.getNombreCaracteristica(posicion); // Tomo la caracteristica
				// correspondiente al ordinal
				double v1 = this.getCaracteristica(carac); // para obtener el valor de cada caracteristica
				double v2 = compe.getValor(carac);

				if (v1 > v2) {
					System.out.println("Su personaje GANO!");
					System.out.println("Por la caracteristica: " + carac);
					return true;
				} else if (v2 > v1) {
					System.out.println("Su personaje PERDIO!");
					System.out.println("Por la caracteristica: " + carac);
					return false;
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
		return this.getCaracteristica(c);
	}

	@Override
	public TipoCompetidor getAfilacion() {
		return this.getTipo();
	}

	public TipoCompetidor getTipo() {
		return tipo;
	}

	public void setTipo(TipoCompetidor tipo) {
		this.tipo = tipo;
	}

	private Caracteristica getNombreCaracteristica(double posicion) {
        if(posicion == 0) {
            return Caracteristica.VELOCIDAD;
        }else if(posicion == 1 ) {
            return Caracteristica.FUERZA;
        }else if(posicion == 2) {
            return Caracteristica.RESISTENCIA;
        }else {
            return Caracteristica.DESTREZA;
        }
    }
	
	public Integer getCaracteristica(Caracteristica e) {
		return (Integer) this.caracteristicas.get(e);
	}

	public void setNombrepj(String nombrepj) {
		this.nombrepj = nombrepj;
	}

	public void setNombreReal(String nombreReal) {
		this.nombreReal = nombreReal;
	}

	public int setCaracteristica(int n) throws CaracteristicaInvalidaException {

		int valor = 0;
		if (n < 0) {
			throw new CaracteristicaInvalidaException(
					"Uno de los valores ingresados para indicar su caracteristica es invalido");
		} else
			valor = n;
		return valor;

	}

	public String getNombrepj() {
		return nombrepj;
	}

	public String getNombreReal() {
		return nombreReal;
	}

	@Override
	public String toString() {
		return "" + this.tipo + ", " + this.nombreReal + ", " + this.nombrepj + ", "
				+ getCaracteristica(Caracteristica.VELOCIDAD) + ", " + getCaracteristica(Caracteristica.FUERZA) + ", "
				+ getCaracteristica(Caracteristica.RESISTENCIA) + ", " + getCaracteristica(Caracteristica.DESTREZA);
	}

}
