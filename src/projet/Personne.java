package projet;

public class Personne {
	String name;
	String prenom;
	String adresse;
	int Id;
	
	public Personne(String name, String prenom, String adresse, int id) {
		super();
		this.name = name;
		this.prenom = prenom;
		this.adresse = adresse;
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public static void main(String[] args) {
		String str = "Collective;ftuydy;null;ffyg;[1, 3];[];[];[];[];2";
		String[] parts = str.split(";");
		System.out.println(parts[0].length());
		String titre = parts[1];
		String type = parts[2];
		String url = parts[3];
		Long key = Long.parseLong(parts[9]);
		System.out.println(key);
	}

}
