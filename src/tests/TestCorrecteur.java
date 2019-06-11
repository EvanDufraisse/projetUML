package tests;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import projet.*;

public class TestCorrecteur {

	Livre livre = new Livre(01, "Le Dernier des Mohicans", "http://", "...");
	Personne personne = new Personne("Charles", "Henry", "45 Boulevard Jacques", 1);

	Correcteur correcteur = new Correcteur(new ArrayList<Oeuvre>(), personne);
	
	@Test
	public void addTest() {
		correcteur.addOeuvre(livre);
		assertTrue(correcteur.getOeuvres().get(0).equals(livre));
	}

}
