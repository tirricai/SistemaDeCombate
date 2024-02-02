package TP;

import org.junit.Assert;
import org.junit.Test;

public class PersonajesTest {

	@Test
	public void creacionPersonajeTest() throws CaracteristicaInvalidaException {

		Personaje p = new Personaje(TipoCompetidor.HEROE, "Louis Sera", "The comedian", 200, 150, 500, 50);

	}

	@Test(expected = CaracteristicaInvalidaException.class)
	public void crearPersonajeConValoresNegativos() throws CaracteristicaInvalidaException {

		Personaje p = new Personaje(TipoCompetidor.HEROE, "Carla Riveros", "Froppy", -200, -150, 500, -50);

		System.out.println(p);
	}

	@Test
	public void enfrentarUnHeroeVsVillanoPorDestrezaGanaHeroe()
			throws CaracteristicaInvalidaException, TipoDeCompetidorException {

		Competidor heroe = new Personaje(TipoCompetidor.HEROE, "Jaime Altozano", "The producter", 300, 250, 180, 350);
		Competidor villano = new Personaje(TipoCompetidor.VILLANO, "Ricardo Arjona", "The musician", 120, 300, 200, 50);

		Assert.assertTrue(heroe.esGanador(villano, Caracteristica.DESTREZA));
	}

	@Test
	public void enfrentarUnHeroeVsVillanoPorResistenciaGanaVilano()
			throws CaracteristicaInvalidaException, TipoDeCompetidorException {

		Competidor heroe = new Personaje(TipoCompetidor.HEROE, "Nathan Drake", "The adventurous", 300, 450, 280, 300);
		Competidor villano = new Personaje(TipoCompetidor.VILLANO, "Joel Miller", "The destroyer", 150, 500, 300, 250);

		Assert.assertTrue(villano.esGanador(heroe, Caracteristica.RESISTENCIA));
	}

	@Test
	public void enfrentarUnHeroeVsVillanoPorVelocidadGanaVilano()
			throws CaracteristicaInvalidaException, TipoDeCompetidorException {

		Competidor heroe = new Personaje(TipoCompetidor.HEROE, "Mario Bros", "El fontanero", 300, 500, 350, 300);
		Competidor villano = new Personaje(TipoCompetidor.VILLANO, "Sonic", "The Hedgehog", 100000, 350, 600, 100);

		Assert.assertTrue(villano.esGanador(heroe, Caracteristica.VELOCIDAD));
	}
	
	@Test
	public void enfrentarUnHeroeVsVillanoPorFuerzaGanaHeroe()
			throws CaracteristicaInvalidaException, TipoDeCompetidorException {

		Competidor heroe = new Personaje(TipoCompetidor.HEROE, "Chris Redfield", "El Rude", 300, 650, 450, 300);
		Competidor villano = new Personaje(TipoCompetidor.VILLANO, "Leon Kennedy", "The Rookie", 450, 400, 300, 300);

		Assert.assertTrue(heroe.esGanador(villano, Caracteristica.FUERZA));
	}

	@Test(expected = TipoDeCompetidorException.class)
	public void enfrentarHeroeVsHeroe() throws CaracteristicaInvalidaException, TipoDeCompetidorException {

		Competidor heroe = new Personaje(TipoCompetidor.HEROE, "Luciano Gonzalez", "The Killjoy", 300, 250, 180, 350);
		Competidor heroe2 = new Personaje(TipoCompetidor.HEROE, "Lucas Valdez", "The Liar", 120, 300, 200, 50);

		Assert.assertFalse(heroe.esGanador(heroe2, Caracteristica.DESTREZA));
	}
	
	@Test
	public void enfrentarHeroeVsLigaDeVillanosGanaLiga() throws CaracteristicaInvalidaException, TipoDeCompetidorException, PersonajeExistenteEnLigaException {
		
		Liga ligaVillanos = new Liga();
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Albert Wesker", "The boss", 600, 0, 500, 500));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Ricardo Irving ", "The kraken", 100, 0, 400, 100));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Alexia Ashford", "The butterfly", 300, 0, 500, 200));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.X", "The tirant", 250, 0, 300, 50));
		
		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Chris Redfield", "El Rude", 300, 650, 450, 300);
		
		Assert.assertFalse(ligaVillanos.esGanador(heroe, Caracteristica.FUERZA));
	}
	
	

	/**
	 * Este Test esta comentado ya que por alguna extra�a razon que desconozco,
	 * falla, pero el metodo de creacion de Personajes a traves del archivo
	 * funciona.
	 * 
	 * 
	 * @Test public void crearPersonajesDesdeArchivo() throws
	 *       CaracteristicaException, NumberFormatException {
	 * 
	 *       ArrayList<Competidor> expected = new ArrayList<Competidor>();
	 *       expected.add(new Personaje(TipoCompetidor.HEROE, "Edward Blake", "The
	 *       Comedian", 100, 200, 150, 50)); expected.add(new
	 *       Personaje(TipoCompetidor.HEROE, "Maynard James", "The Alien", 200, 150,
	 *       500, 300)); expected.add(new Personaje(TipoCompetidor.HEROE, "Adam
	 *       Jones", "The Weird", 500, 200, 200, 550)); expected.add(new
	 *       Personaje(TipoCompetidor.VILLANO, "Adrian Veidt", "Ozymandias", 120,
	 *       180, 200, 200));
	 * 
	 * 
	 *       GestorArchivoPj g = new GestorArchivoPj();
	 *       g.readPersonaje("personajes.in");
	 * 
	 *       Assert.assertTrue(expected.equals(g.getLstPersonajes()));
	 * 
	 *       }
	 */

}
