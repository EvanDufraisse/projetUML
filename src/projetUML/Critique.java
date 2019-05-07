package projetUML;

import java.util.ArrayList;

public class Critique extends Personne{

	private ArrayList<String> domaines;
	
	public Critique(String name, String prenom, String adresse, int id) {
		super(name, prenom, adresse, id);
	}
	public Critique(String name, String prenom, String adresse, int id, ArrayList<String> domaines) {
		super(name, prenom, adresse, id);
		this.domaines = domaines;
	}
	public ArrayList<String> getDomaines() {
		return this.domaines;
	}
	public void addDomaine(String dom) {
		this.getDomaines().add(dom);
	}
}
