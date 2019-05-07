package projetUML;

import java.util.ArrayList;

public abstract class  Oeuvre {
	
	long reference;
	String titre;
	String URL;
	String type;
	ArrayList<String> chapitres;
	ArrayList<String>  domaines;
	
	public Oeuvre(long reference, String titre, String uRL) {
		super();
		this.reference = reference;
		this.titre = titre;
		URL = uRL;
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
	
	
	

}
