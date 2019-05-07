package projetUML;

import java.util.ArrayList;

public class Correcteur extends Personne{
	
	private ArrayList<Oeuvre> oeuvres;
	
	public Correcteur(String name, String prenom, String adresse, int id) {
		super(name, prenom, adresse, id);
	}
	public Correcteur(String name, String prenom, String adresse, int id, ArrayList<Oeuvre> oeuvres) {
		super(name, prenom, adresse, id);
		this.oeuvres = oeuvres;
	}
	public ArrayList<Oeuvre> getOeuvres() {
		return this.oeuvres;
	}
	public void addOeuvre(Oeuvre oeuvre) {
		this.getOeuvres().add(oeuvre);
	}
	

}
