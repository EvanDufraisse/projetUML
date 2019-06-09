package projetUML;

import java.util.ArrayList;

public abstract class  Oeuvre {
	
	long reference;
	String titre;
	String URL;
	String type;
	Correcteur[] correcteurs;
	ArrayList<String> chapitres;
	ArrayList<String>  domaines;
	ArrayList<Critique> critiques;
	
	public Oeuvre(long reference, String titre, String uRL) {
		super();
		this.reference = reference;
		this.titre = titre;
<<<<<<< HEAD
		URL = uRL;
		this.chapitres = new ArrayList<String>();
		this.domaines = new ArrayList<String>();
		this.critiques = new ArrayList<Critique>();
=======
		this.URL = uRL;
>>>>>>> master
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getChapitres() {
		return chapitres;
	}

	public void setChapitres(ArrayList<String> chapitres) {
		this.chapitres = chapitres;
	}

	public ArrayList<String> getDomaines() {
		return domaines;
	}

	public void setDomaines(ArrayList<String> domaines) {
		this.domaines = domaines;
	}

	public long getReference() {
		return reference;
	}
	public Correcteur[] getCorrecteurs() {
		return correcteurs;
	}

	public void setCorrecteurs(Correcteur[] correcteurs) {
		this.correcteurs = correcteurs;
	}
	public ArrayList<Critique> getCritiques(){
		return this.critiques;
	}
	public void setCritiques(ArrayList<Critique> critiques) {
		this.critiques = critiques;
	}
	public void addCritique(Critique crit) {
		this.getCritiques().add(crit);
	}
	
	

}
