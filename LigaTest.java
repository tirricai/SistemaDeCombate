package TP;

import org.junit.*;

public class LigaTest {
	
	Liga ligaHeroes = new Liga();
	Liga ligaVillanos = new Liga();

	@Test
	public void crearLigaCon3HeroesTest() throws CaracteristicaInvalidaException, TipoDeCompetidorException, PersonajeExistenteEnLigaException {

		ligaHeroes.agregarCompetidor(
				new Personaje(TipoCompetidor.HEROE, "Mauricio Ponce", "The designer", 600, 0, 500, 500));
		ligaHeroes.agregarCompetidor(
				new Personaje(TipoCompetidor.HEROE, "Ricardo Darin", "The constructor", 100, 0, 400, 100));
		ligaHeroes.agregarCompetidor(
				new Personaje(TipoCompetidor.HEROE, "Jose-Maria Luz", "The lead", 300, 0, 500, 200));
		
	}
	
	@Test
	public void crearLigaCon2VillanosTest() throws CaracteristicaInvalidaException, TipoDeCompetidorException, PersonajeExistenteEnLigaException {

		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Roberto Planta", "The whisper", 100, 0, 400, 100));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Jaime Pagina", "MakeLover", 300, 0, 500, 200));
		
	}
	
	/*
	 * @Test (expected = TipoDeCompetidorException.class) public void
	 * agregarVillanoAListaDeHeroesTest() throws CaracteristicaException,
	 * TipoDeCompetidorException {
	 * 
	 * ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE,
	 * "Nathan Drake", "The adventurous", 300, 450, 280, 300));
	 * ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE,
	 * "Jaime Altozano", "The producter", 300, 250, 180, 350));
	 * ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO,
	 * "Mario Casta�eda", "The compositer", 346, 215, 142, 370));
	 * 
	 * }
	 * 
	 * @Test (expected = TipoDeCompetidorException.class) public void
	 * agregarHeroeAListaDeVillanosTest() throws CaracteristicaException,
	 * TipoDeCompetidorException {
	 * 
	 * ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO,
	 * "Nathan Drake", "The adventurous", 300, 450, 280, 300));
	 * ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO,
	 * "Jaime Altozano", "The producter", 300, 250, 180, 350));
	 * ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.HEROE,
	 * "Mario Casta�eda", "The compositer", 346, 215, 142, 370));
	 * 
	 * }
	 * 
	 * @Test(expected = TipoDeCompetidorException.class) public void
	 * ligaVillanoVsLigaVillanoTest() throws CaracteristicaException,
	 * TipoDeCompetidorException {
	 * 
	 * ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO,
	 * "Bowser", "Rey Koopa", 100, 500, 150, 150));
	 * ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO,
	 * "Mr.Bison", "El capitan", 350, 600, 420, 540));
	 * 
	 * Liga ligaVillanos2 = new Liga(); ligaVillanos2.agregarCompetidor(new
	 * Personaje(TipoCompetidor.VILLANO, "Paul McCartney", "The beatle", 40, 500,
	 * 150, 150)); ligaVillanos2.agregarCompetidor(new
	 * Personaje(TipoCompetidor.VILLANO, "Robert Pattinson", "El vampiro", 800, 600,
	 * 420, 540));
	 * 
	 * Assert.assertTrue(ligaVillanos.competirContraLiga(ligaVillanos2,
	 * Caracteristica.VELOCIDAD));
	 * 
	 * }
	 * 
	 * @Test(expected = TipoDeCompetidorException.class) public void
	 * ligaHeroesVsLigaHeroesTest() throws CaracteristicaException,
	 * TipoDeCompetidorException {
	 * 
	 * ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Bowser",
	 * "Rey Koopa", 100, 500, 150, 150)); ligaHeroes.agregarCompetidor(new
	 * Personaje(TipoCompetidor.HEROE, "Mr.Bison", "El capitan", 350, 600, 420,
	 * 540));
	 * 
	 * Liga heroes2 = new Liga(); heroes2.agregarCompetidor(new
	 * Personaje(TipoCompetidor.HEROE, "Paul McCartney", "The beatle", 40, 500, 150,
	 * 150)); heroes2.agregarCompetidor(new Personaje(TipoCompetidor.HEROE,
	 * "Robert Pattinson", "El vampiro", 800, 600, 420, 540));
	 * 
	 * Assert.assertTrue(ligaHeroes.competirContraLiga(heroes2,
	 * Caracteristica.VELOCIDAD));
	 * 
	 * }
	 */
	
	@Test
	public void ligaVillanoVsLigaHeroesPorFuerzaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
		
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 350, 450, 480));
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Luigi", "El fontanero", 250, 400, 400, 420));
		
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 100, 500, 150, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 350, 600, 420, 540));
		
		Assert.assertTrue(ligaVillanos.esGanador(ligaHeroes, Caracteristica.FUERZA));
	}
	
	@Test
	public void ligaVillanoVsLigaHeroesPorResistenciaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
		
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 350, 450, 480));
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Luigi", "El fontanero", 250, 400, 400, 420));
		
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 100, 500, 150, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 350, 600, 420, 540));
		
		Assert.assertTrue(ligaHeroes.esGanador(ligaVillanos, Caracteristica.RESISTENCIA));
	}
	
	@Test
	public void ligaVillanoVsLigaHeroesPorVelocidadTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
		
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 350, 450, 480));
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Luigi", "El fontanero", 250, 400, 400, 420));
		
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 100, 500, 150, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 350, 600, 420, 540));
		
		Assert.assertTrue(ligaHeroes.esGanador(ligaVillanos, Caracteristica.VELOCIDAD));
	}
	
	@Test
	public void ligaVillanoVsLigaHeroesPorDestrezaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
		
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 350, 450, 480));
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Luigi", "El fontanero", 250, 400, 400, 420));
		
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 100, 500, 150, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 350, 600, 420, 540));
		
		Assert.assertTrue(ligaHeroes.esGanador(ligaVillanos, Caracteristica.DESTREZA));
	}
	
	@Test
	public void promedioDeCaracteristicasTest() throws CaracteristicaInvalidaException, TipoDeCompetidorException, PersonajeExistenteEnLigaException {
		
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 350, 450, 480));
		ligaHeroes.agregarCompetidor(new Personaje(TipoCompetidor.HEROE, "Luigi", "El fontanero", 250, 400, 400, 420));
		
		Assert.assertEquals(275, ligaHeroes.getPromedioDe(Caracteristica.VELOCIDAD), 0.01);
		Assert.assertEquals(375, ligaHeroes.getPromedioDe(Caracteristica.FUERZA), 0.01);
		Assert.assertEquals(425, ligaHeroes.getPromedioDe(Caracteristica.RESISTENCIA), 0.01);
		Assert.assertEquals(450, ligaHeroes.getPromedioDe(Caracteristica.DESTREZA), 0.01);
	}
	
	@Test
	public void ligaVillanoVsHeroePorFuerzaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
		
		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 500, 450, 480);
		
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 100, 500, 150, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 350, 600, 420, 280));
		
		Assert.assertTrue(ligaVillanos.esGanador(heroe, Caracteristica.FUERZA));
	}
	
	@Test
	public void ligaVillanoVsHeroeEmpatanPorFuerzaYDefinenPorResistenciaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {
		
		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 550, 450, 480);
		
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 350, 500, 600, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 350, 600, 420, 280));
		Assert.assertTrue(ligaVillanos.esGanador(heroe, Caracteristica.FUERZA));
	}

	@Test
	public void ligaVillanoVsHeroeEmpatanPorVelocidadYFuerzaDefinenPorResistenciaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {

		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 550, 450, 480);

		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 300, 500, 600, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 300, 600, 420, 280));

		Assert.assertTrue(ligaVillanos.esGanador(heroe, Caracteristica.VELOCIDAD));
	}


	@Test
	public void ligaVillanoVsHeroeEmpatanPorVelocidadFuerzaResistenciaDefinenPorDestrezaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {

		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 550, 450, 480);

		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 300, 500, 600, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 300, 600, 300, 280));

		Assert.assertFalse(ligaVillanos.esGanador(heroe, Caracteristica.VELOCIDAD));
	}

	@Test
	public void ligaVillanoVsHeroeEmpatanPorResistenciaDefinenPorDestrezaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {

		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 550, 450, 480);

		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 300, 500, 600, 150));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 300, 600, 300, 280));

		Assert.assertFalse(ligaVillanos.esGanador(heroe, Caracteristica.RESISTENCIA));
	}

	@Test
	public void ligaVillanoVsHeroeEmpatanDevuelveFalseTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {

		Personaje heroe = new Personaje(TipoCompetidor.HEROE, "Mario", "El fontanero", 300, 550, 450, 500);

		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 300, 500, 600, 500));
		ligaVillanos.agregarCompetidor(new Personaje(TipoCompetidor.VILLANO, "Mr.Bison", "El capitan", 300, 600, 300, 500));

		Assert.assertFalse(ligaVillanos.esGanador(heroe, Caracteristica.RESISTENCIA));
	}

	@Test(expected = PersonajeExistenteEnLigaException.class)
	public void excepcionCargarPersonajeExisteEnLigaTest() throws TipoDeCompetidorException, CaracteristicaInvalidaException, PersonajeExistenteEnLigaException {

		Competidor c = new Personaje(TipoCompetidor.VILLANO, "Bowser", "Rey Koopa", 300, 500, 600, 500);

		ligaVillanos.agregarCompetidor(c);
		ligaVillanos.agregarCompetidor(c);

	}

}
