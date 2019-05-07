package projetUML;

import java.util.ArrayList;

public class Auteur extends Personne {

	private ArrayList<String> domaines;

	public Auteur(String name, String prenom, String adresse, int id, ArrayList<String> domaines) {
		super(name, prenom, adresse, id);
		this.domaines = domaines;
	}
	public Auteur(String name, String prenom, String adresse, int id) {
		super(name, prenom, adresse, id);
		this.domaines = new ArrayList<String>();
	}
	public ArrayList<String> getDomaines() {
		return this.domaines;
	}
	public void addDomaine(String dom) {
		this.getDomaines().add(dom);
	}
}
