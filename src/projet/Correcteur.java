package projet;

import java.util.ArrayList;

public class Correcteur{
	
	private ArrayList<Oeuvre> oeuvres;
	private Personne personne;
	
	
	
	public Correcteur(ArrayList<Oeuvre> oeuvres, Personne personne) {
		this.oeuvres = oeuvres;
		this.personne = personne;
	}
	public Correcteur(String name, String prenom, String adresse, int id) {
		this.personne = new Personne(name, prenom, adresse, id);
	}
	public Correcteur(String name, String prenom, String adresse, int id, ArrayList<Oeuvre> oeuvres) {
		this.personne = new Personne(name, prenom, adresse, id);
		this.oeuvres = oeuvres;
	}
	public ArrayList<Oeuvre> getOeuvres() {
		return this.oeuvres;
	}
	public void addOeuvre(Oeuvre oeuvre) {
		this.getOeuvres().add(oeuvre);
	}
	

}
