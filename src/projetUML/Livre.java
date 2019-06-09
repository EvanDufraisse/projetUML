package projetUML;


public class Livre extends Oeuvre {
	public String resume;
	public Auteur auteur;
	public Livre(long reference, String titre, String uRL, String resume) {
		super(reference, titre, uRL);
		this.resume = resume;
		// TODO Auto-generated constructor stub
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public void setAuteur(Auteur a) {
		this.auteur = a;
	}
	public Auteur getAuteur() {
		return this.auteur;
	}
}
