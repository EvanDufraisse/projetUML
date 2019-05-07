package projetUML;

import java.util.ArrayList;

public class Auteur {

	private ArrayList<String> domaines;
	private Personne personne;
	
	
	

	public Auteur(ArrayList<String> domaines, Personne personne) {
		this.domaines = domaines;
		this.personne = personne;
	}
	public Auteur(String name, String prenom, String adresse, int id, ArrayList<String> domaines) {
		this.personne =new Personne(name, prenom, adresse, id);
		this.domaines = domaines;
	}
	public Auteur(String name, String prenom, String adresse, int id) {
		this.personne =new Personne(name, prenom, adresse, id);
		this.domaines = new ArrayList<String>();
	}
	public ArrayList<String> getDomaines() {
		return this.domaines;
	}
	public void addDomaine(String dom) {
		this.getDomaines().add(dom);
	}
}
