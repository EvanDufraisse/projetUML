package tests;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import projet.*;

public class TestAuteur {
	
	private int i = 0;
	Personne personne = new Personne("Charles", "Henry", "45 Boulevard Jacques", 1);
	ArrayList<String> domaines = new ArrayList<String>();
	
	Auteur auteur = new Auteur(domaines, personne);
	
	@ParameterizedTest
	@ValueSource(strings = {"Biologie", "Astronomie", "Cuisine", "Physique"})
	public void testaddDomaine(String domaine) {
		auteur.addDomaine(domaine);
		i++;
		assertTrue(auteur.getDomaines().size() == i && auteur.getDomaines().get(i - 1).equals(domaine));
		
	}
	
	
}
