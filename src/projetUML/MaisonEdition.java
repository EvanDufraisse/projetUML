package projetUML;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class MaisonEdition {
	
	ArrayList<Integer> DataIdOeuvre;
	ArrayList<Integer> DataIdPersonne;
	HashMap<Integer, Critique> DataCritique;
	HashMap<Integer, Auteur> DataAuteurs;
	HashMap<Integer, Personne> DataCorrecteurs;
	HashMap<Integer, Personne> DataPersonnes;
	HashMap<Integer,Oeuvre> DataOeuvre;
	Database database;
	
	
	public MaisonEdition() {
		this.database = new Database();
		this.DataPersonnes = this.database.databaseLoadPersonnes("personnes.txt");
		this.DataAuteurs = this.database.databaseLoadAuteurs("auteurs.txt", this.DataPersonnes);
		this.DataOeuvre = this.database.loa;
		this.DataCorrecteurs = this.database.databaseLoadCorrecteurs("correcteurs.txt", this.DataPersonnes, dataOeuvres)
		this.DataCritique = new HashMap<Integer, Critique>();
		this.DataIdOeuvre = new ArrayList<Integer>();
		this.DataIdPersonne = new ArrayList<Integer>();
		
		
		
	}
	public static void main(String[] args) {
		MaisonEdition Maison = new MaisonEdition();
		
		boolean loop = true;
		while(loop == true) {
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println("1) Créer une personne");
			System.out.println("2) Créer une oeuvre");
			System.out.println("3) Définir une personne comme Auteur,Critique ou Correcteur");
			Scanner keyboard = new Scanner(System.in);
			int i = keyboard.nextInt();
			}
		System.out.print("Enregistrement des modifications");
		System.out.println("Au revoir !");
		}
	
	public void creerUnePersonne() {
		HashMap<Integer, Personne> M;
		M = this.DataPersonnes;
		Set<Integer> s = M.keySet();
		Iterator<Integer> it  = s.iterator();
		int key = 1;
		while(it.hasNext()) {
			key = it.next();
			System.out.println(M.get(key).getPrenom()+" "+M.get(key).getName());
		}
		int last_key = key;
		System.out.println("Entrez le prénom de la personne");
		Scanner keyboard = new Scanner(System.in);
		String prenom = keyboard.next();
		System.out.println("Entrez le nom de la personne");
		keyboard = new Scanner(System.in);
		String name = keyboard.next();
		System.out.println("Entrez l'addresse de la personne");
		keyboard = new Scanner(System.in);
		String addresse = keyboard.next();
		int id = last_key+1;
		Personne personne_a_ajouter = new Personne(name, prenom, addresse, id);
		this.DataPersonnes.put(id, personne_a_ajouter);
		System.out.println(prenom+" "+name+" a bien été ajoutée à la base de donnée avec pour id "+id);
		
	}
	
}
