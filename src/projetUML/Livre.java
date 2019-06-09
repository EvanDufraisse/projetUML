package projetUML;

public class Livre extends Oeuvre {

	String resume;
	Auteur auteur;
	
	public Livre(long reference, String titre, String uRL, String resume, Auteur auteur) {
		super(reference, titre, uRL);
		this.resume = resume;
		this.auteur = auteur;
	}
	public Auteur getAuteur() {
		return this.auteur;
	}
	public void setAuteur(Auteur aut) {
		this.auteur = aut;
	}
	public String getResume() {
		return this.resume;
	}
	public void setResume(String res) {
		this.resume = res;
	}
	
	

}
