package TP;

import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws NumberFormatException, CaracteristicaInvalidaException, TipoDeCompetidorException, PersonajeExistenteEnLigaException {
		Sistema nuevoJuego = new Sistema(new GestorArchivoPj(), new GestorArchivoLigas());
		nuevoJuego.juegoHeroeyVillanos();
	}
}