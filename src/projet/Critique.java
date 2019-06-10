package projet;

import java.util.ArrayList;

public class Critique{
	
	private ArrayList<Integer> ref;
	private ArrayList<Oeuvre> oeuvres;
	private ArrayList<String> domaines;
	private Personne personne;
	
	
	public Critique(ArrayList<String> domaines, Personne personne, ArrayList<Integer> ref) {
		this.domaines = domaines;
		this.personne = personne;
		this.ref = ref;
	}
	public Critique(ArrayList<String> domaines, Personne personne) {
		this.domaines = domaines;
		this.personne = personne;
		this.ref = new ArrayList<Integer>();
	}
	public Critique(String name, String prenom, String adresse, int id) {
		this.personne = new Personne(name, prenom, adresse, id);
		this.ref = new ArrayList<Integer>();
		this.domaines = new ArrayList<String>();

	}
	public Critique(String name, String prenom, String adresse, int id, ArrayList<String> domaines) {
		this.personne = new Personne(name, prenom, adresse, id);
		this.domaines = domaines;
		this.ref = new ArrayList<Integer>();

	}
	public ArrayList<String> getDomaines() {
		return this.domaines;
	}
	public void addDomaine(String dom) {
		this.getDomaines().add(dom);
	}
	public ArrayList<Integer> getRef() {
		return ref;
	}
	public Personne getPersonne() {
		return this.personne;
	}
}
