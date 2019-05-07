package projetUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaisonEdition {
	
	ArrayList<Integer> DataIdOeuvre;
	ArrayList<Integer> DataIdPersonne;
	HashMap<String, Critique> DataCritique;
	HashMap<String, Auteur> DataAuteurs;
	HashMap<String, Personne> DataCorrecteurs;
	HashMap<String,Oeuvre> DataOeuvre;
	
	public MaisonEdition() {
		this.DataAuteurs = new HashMap<String, Auteur>();
		this.DataCorrecteurs = new HashMap<String, Personne>();
		this.DataCritique = new HashMap<String, Critique>();
		this.DataIdOeuvre = new ArrayList<Integer>();
		this.DataIdPersonne = new ArrayList<Integer>();
		this.DataOeuvre = new HashMap<String, Oeuvre>();
		
	}
	public static void main(String[] args) {
		boolean loop = true;
		while(loop == true) {
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println("1) Créer une personne");
			System.out.println("2) Créer une oeuvre");
			System.out.println("3) Définir une personne comme Auteur,Critique ou Correcteur");
			Scanner keyboard = new Scanner(System.in);
			int i = keyboard.nextInt();
			}
		}
}
