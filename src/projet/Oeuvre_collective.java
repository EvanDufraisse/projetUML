package projet;

import java.util.ArrayList;

public class Oeuvre_collective extends Oeuvre {
	
	ArrayList<String> resumes;
	ArrayList<Auteur> auteurs;
	Correcteur[] correcteurs;

	public Oeuvre_collective(long reference, String titre, String uRL) {
		super(reference, titre, uRL);
		this.resumes = new ArrayList<String>();
		this.correcteurs = new Correcteur[2];
		this.auteurs = new ArrayList<Auteur>();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<String> getResumes() {
		return resumes;
	}

	public void setResumes(ArrayList<String> resumes) {
		this.resumes = resumes;
	}

	public ArrayList<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(ArrayList<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Correcteur[] getCorrecteurs() {
		return correcteurs;
	}

	public void setCorrecteurs(Correcteur[] correcteurs) {
		this.correcteurs = correcteurs;
	}
	
	public void ajouterAuteur(Auteur a) {
		this.auteurs.add(a);
	}
	public void supprimerAuteur(Auteur a) {
		this.auteurs.remove(a);
	}
	
	

}
