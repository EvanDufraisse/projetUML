package projetUML;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
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
	HashMap<Integer, Correcteur> DataCorrecteurs;
	HashMap<Integer, Personne> DataPersonnes;
	HashMap<Long, Oeuvre> DataOeuvre;
	Database database;
	
	
	public MaisonEdition() {
		this.database = new Database();
		this.DataPersonnes = this.database.databaseLoadPersonnes("personnes.txt");
		this.DataAuteurs = this.database.databaseLoadAuteurs("auteurs.txt", this.DataPersonnes);
		this.DataCritique = this.database.databaseLoadCritiques("critiques.txt", this.DataPersonnes);
		this.DataOeuvre = this.database.databaseLoadOeuvres(this.DataCritique, this.DataAuteurs);
		this.DataCorrecteurs = this.database.databaseLoadCorrecteurs("correcteurs.txt", this.DataPersonnes, this.DataOeuvre);
		this.DataIdOeuvre = new ArrayList<Integer>();
		this.DataIdPersonne = new ArrayList<Integer>();
		
		
		
	}
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		MaisonEdition Maison = new MaisonEdition();
		Set<Integer> s = Maison.DataAuteurs.keySet();
		System.out.println(s.size() + " Auteurs ont été importés");
		
		boolean loop = true;
		while(loop == true) {
			System.out.println("Que souhaitez-vous faire ?");
			System.out.println("1) Créer une personne");
			System.out.println("2) Créer une oeuvre");
			System.out.println("3) Définir une personne comme Auteur,Critique ou Correcteur");
			System.out.println("4) Enregistrer et quitter");
			System.out.println("5) Quitter sans enregistrer");
			Scanner keyboard = new Scanner(System.in);
			int i = keyboard.nextInt();
			switch (i) {
			case 1:
				Maison.creerUnePersonne();
				break;
			case 2:
				Maison.creerUneOeuvre();
				break;
			case 3:
				Maison.definirFonction();
				break;
			case 4:
				System.out.println("Enregistrement en cours...");
				Maison.database.saveAuteurs(Maison.DataAuteurs, "auteurs.txt");
				Maison.database.savePersonne(Maison.DataPersonnes, "personnes.txt");
				Maison.database.saveCritique(Maison.DataCritique, "critiques.txt");
				Maison.database.saveCorrecteur(Maison.DataCorrecteurs, "correcteurs.txt");
				Maison.database.saveOeuvres(Maison.DataOeuvre, "oeuvres.txt");
				loop = false;
				System.out.println("Enregistrement des modifications effectué");
			case 5:
				loop = false;
				break;

			default:
				break;
			}
			}
		System.out.println("Au revoir !");
		}
	
	private void definirFonction() {
		System.out.println("Quelle fonction souhaitez vous attribuer ?");
		System.out.println("1) Auteur");
		System.out.println("2) Correcteur");
		System.out.println("3) Critique");
		Scanner keyboard = new Scanner(System.in);
		int i = keyboard.nextInt();
		System.out.println("### Personnes disponibles: ###");
		Set<Integer> sPersonnes = this.DataPersonnes.keySet();
		Iterator<Integer> itPersonnes = sPersonnes.iterator();
		while(itPersonnes.hasNext()) {
			Personne p = this.DataPersonnes.get(itPersonnes.next());
			System.out.println(p.getId() + " "+ p.getPrenom() + " " + p.getName());}
		System.out.println("### Fin de la liste des Personnes ###");
		System.out.println("Choisir l'Id de la personne que vous souhaiter ajouter en tant qu'Auteur");
		keyboard = new Scanner(System.in);
		int id = keyboard.nextInt();
		switch (i) {
		case 1:
			this.DataAuteurs.put(id,new Auteur(new ArrayList<String>(),this.DataPersonnes.get(id)));
			System.out.println(this.DataPersonnes.get(id).getPrenom()+" a bien été ajouté à la liste d'auteurs");	
			break;
		case 2:
			this.DataCorrecteurs.put(id,new Correcteur(new ArrayList<Oeuvre>(), this.DataPersonnes.get(id)));
			System.out.println(this.DataPersonnes.get(id).getPrenom()+" a bien été ajouté à la liste de correcteurs");	
			break;
		case 3:
			this.DataCritique.put(id,new Critique(new ArrayList<String>(), this.DataPersonnes.get(id)));
			System.out.println(this.DataPersonnes.get(id).getPrenom()+" a bien été ajouté à la liste de Critiques");
			break;
		}
		System.out.println("Retour au menu principal");

			
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
	public void creerUneOeuvre() {
		System.out.println("Titre de l'oeuvre ?");
		Scanner keyboard = new Scanner(System.in);
		String titre = keyboard.next();
		System.out.println("Url de l'oeuvre ?");
		keyboard = new Scanner(System.in);
		String uRL = keyboard.next();
		long reference = this.DataOeuvre.keySet().size();
		System.out.println("il y'a actuellement "+ reference +"oeuvres dans la base");
		reference = reference+1;
		System.out.println(reference);
		System.out.println("Souhaitez vous créer une oeuvre :");
		System.out.println("1) Collective");
		System.out.println("2) Livre");
		keyboard = new Scanner(System.in);
		int choix = keyboard.nextInt();
		if(choix == 1) {
			Oeuvre_collective oeuvre = new Oeuvre_collective(reference, titre, uRL);
			int str  = 0;
			Set<Integer> sAuteurs = this.DataAuteurs.keySet();
			Iterator<Integer> itAuteurs = sAuteurs.iterator();
			System.out.println("Auteurs disponibles:");
			while(itAuteurs.hasNext()) {
				Auteur a = this.DataAuteurs.get(itAuteurs.next());
				System.out.println(a.getPersonne().getId() + " "+ a.getPersonne().getPrenom() + " " + a.getPersonne().getName());}
			System.out.println("Fin de la liste des auteurs");
			while(str != -1) {
			System.out.println("Donner un Id d'auteur ou -1 pour terminer le processus:");
			str = keyboard.nextInt();
			if(str != -1) {
			oeuvre.ajouterAuteur(this.DataAuteurs.get(str));}
			
			
		}
			this.DataOeuvre.put(reference, oeuvre);
			}
		else if(choix == 2) {
			System.out.println("Veuillez entrer le résumé de l'oeuvre");
			keyboard = new Scanner(System.in);
			String resume = keyboard.next();
			Livre oeuvre = new Livre(reference, titre, uRL, resume);
			Set<Integer> sAuteurs = this.DataAuteurs.keySet();
			Iterator<Integer> itAuteurs = sAuteurs.iterator();
			System.out.println("Auteurs disponibles:");
			while(itAuteurs.hasNext()) {
				Auteur a = this.DataAuteurs.get(itAuteurs.next());
				System.out.println(a.getPersonne().getId() + " "+ a.getPersonne().getPrenom() + " " + a.getPersonne().getName());}
			System.out.println("Fin de la liste des auteurs");
			System.out.println("Veuillez entrer l'id de l'auteur de l'oeuvre");
			keyboard = new Scanner(System.in);
			int id = keyboard.nextInt();
			oeuvre.setAuteur(this.DataAuteurs.get(id));
			this.DataOeuvre.put(reference, oeuvre);
		}
		else {
			System.out.println("Choix d'option non-existant");
		}
		System.out.println("Il y'a maintenant "+this.DataOeuvre.keySet().size()+" oeuvres");
		System.out.println("Retour au menu principal");


	}
	
}
