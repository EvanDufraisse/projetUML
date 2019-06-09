package projetUML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Database {
	
	static String PATH = "/home/evan/Dev/Java/Eclipse/Workspaces_school/Workspace_QualiLogiciel/projetUML/src/database/";
	
	public static ArrayList<Integer> databaseLoadId(String path) {
		ArrayList<Integer> data = new ArrayList<Integer>();
    	File file = new File(PATH+path+".txt");
    	BufferedReader reader = null;

    	try {
    	    reader = new BufferedReader(new FileReader(file));
    	    String text = null;

    	    while ((text = reader.readLine()) != null) {
    	    	data.add(Integer.parseInt(text));
    	    }
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    try {
    	        if (reader != null) {
    	            reader.close();
    	        }
    	    } catch (IOException e) {
    	    }
    	}
    	return data;
    }
	
	public static HashMap<Integer, Personne> databaseLoadPersonnes(String path) {

		HashMap<Integer,Personne> M = new HashMap<Integer, Personne>();
    	File file = new File(PATH+"personnes.txt");
    	BufferedReader reader = null;

    	try {
    	    reader = new BufferedReader(new FileReader(file));
    	    String text = null;

    	    while ((text = reader.readLine()) != null) {
    	    	String[] parts = text.split(";");
    	    	String[] values = new String[4];
    	    	for(int i=0; i<4;i++) {
    	    		values[i] = parts[i];
    	    	}
    	    	M.put(Integer.parseInt(values[0]), new Personne(values[1],values[2],values[3],Integer.parseInt(values[0])));
    	    }
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    try {
    	        if (reader != null) {
    	            reader.close();
    	        }
    	    } catch (IOException e) {
    	    }
    	}
    	return M;
    }
	
	public static HashMap<Integer, Auteur> databaseLoadAuteurs(String path, HashMap<Integer,Personne> data) {

		HashMap<Integer, Auteur> M = new HashMap<Integer, Auteur>();
    	File file = new File(PATH+"auteurs.txt");
    	BufferedReader reader = null;

    	try {
    	    reader = new BufferedReader(new FileReader(file));
    	    String text = null;

    	    while ((text = reader.readLine()) != null) {
    	    	String[] parts = text.split(";");
    	    	ArrayList<String> values = new ArrayList<String>();

    	    	for(int i=1; i<parts.length;i++) {
    	    		values.add(parts[i]);
    	    	}
    	    	int key = Integer.parseInt(parts[0]);
    	    	M.put(key, new Auteur(values,data.get(key)));
    	    }
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    try {
    	        if (reader != null) {
    	            reader.close();
    	        }
    	    } catch (IOException e) {
    	    }
    	}
    	return M;
    }
	
	public static HashMap<Integer, Correcteur> databaseLoadCorrecteurs(String path, HashMap<Integer,Personne> data, HashMap<Integer,Oeuvre>  dataOeuvres) {

		HashMap<Integer, Correcteur> M = new HashMap<Integer, Correcteur>();
    	File file = new File(PATH+"correcteurs.txt");
    	BufferedReader reader = null;

    	try {
    	    reader = new BufferedReader(new FileReader(file));
    	    String text = null;

    	    while ((text = reader.readLine()) != null) {
    	    	String[] parts = text.split(";");
    	    	ArrayList<Integer> values = new ArrayList<Integer>();
    	    	 parts[1]= parts[1].replace("[", "").replace("]", "");
    	    	 String[] Temp = parts[1].split(",");
    	    	for(String s : Temp) {
    	    		values.add(Integer.parseInt(s));
    	    	}
    	    	ArrayList<Oeuvre> listeOeuvres = new ArrayList<Oeuvre>();
    	    	for(int i : values) {
    	    		listeOeuvres.add(dataOeuvres.get(i));
    	    	}
    	    	int key = Integer.parseInt(parts[0]);
    	    	M.put(key, new Correcteur(listeOeuvres,data.get(key)));
    	    }
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    try {
    	        if (reader != null) {
    	            reader.close();
    	        }
    	    } catch (IOException e) {
    	    }
    	}
    	return M;
    }
	
	public static HashMap<Integer, Critique> databaseLoadCritiques(String path, HashMap<Integer,Personne> data) {

		HashMap<Integer, Critique> M = new HashMap<Integer, Critique>();
    	File file = new File(PATH+"critiques.txt");
    	BufferedReader reader = null;

    	try {
    	    reader = new BufferedReader(new FileReader(file));
    	    String text = null;

    	    while ((text = reader.readLine()) != null) {
    	    	String[] parts = text.split(";");
    	    	ArrayList<Integer> values = new ArrayList<Integer>();
    	    	 parts[1]= parts[1].replace("[", "").replace("]", "");
    	    	 String[] Temp = parts[1].split(",");
    	    	for(String s : Temp) {
    	    		values.add(Integer.parseInt(s));
    	    	}
    	    	parts[2]=parts[2].replace("[", "").replace("]", "");
    	    	String[] Temp2 = parts[2].split(",");
    	    	ArrayList<String> domaines = new ArrayList<String>();
    	    	for(String s : Temp2) {
    	    		domaines.add(s);
    	    	}

    	    	int key = Integer.parseInt(parts[0]);
    	    	M.put(key, new Critique(domaines,data.get(key),values));
    	    }
    	} catch (FileNotFoundException e) {
    	    e.printStackTrace();
    	} catch (IOException e) {
    	    e.printStackTrace();
    	} finally {
    	    try {
    	        if (reader != null) {
    	            reader.close();
    	        }
    	    } catch (IOException e) {
    	    }
    	}
    	return M;
    }
	
	public void savePersonne(HashMap<Integer, Personne> M, String pathName) throws FileNotFoundException, UnsupportedEncodingException{
		
		PrintWriter writer = new PrintWriter(PATH+"personnes.txt", "UTF-8");
		Set<Integer> s = M.keySet();
		Iterator<Integer> It = s.iterator();
		while(It.hasNext()) {
			Integer currentKey = It.next();
			Personne p = M.get(currentKey);
			String str = ""+currentKey;
			str += ";"+p.getName()+";"+p.getPrenom()+";"+p.getAdresse();
			writer.println(str);
		}
		writer.close();}
	
public void saveAuteurs(HashMap<Integer, Auteur> M, String pathName) throws FileNotFoundException, UnsupportedEncodingException{
		
		PrintWriter writer = new PrintWriter(PATH+"auteurs.txt", "UTF-8");
		Set<Integer> s = M.keySet();
		Iterator<Integer> It = s.iterator();
		while(It.hasNext()) {
			Integer currentKey = It.next();
			Auteur c = M.get(currentKey);
			String str = ""+currentKey;
			String[] domaines = new String[c.getDomaines().size()];
			domaines = c.getDomaines().toArray(domaines);
			str += ";"+Arrays.toString(domaines);
			writer.println(str);
		}
		writer.close();}
	
	
public void saveCritique(HashMap<Integer, Critique> M, String pathName) throws FileNotFoundException, UnsupportedEncodingException{
		
		PrintWriter writer = new PrintWriter(PATH+"critiques.txt", "UTF-8");
		Set<Integer> s = M.keySet();
		Iterator<Integer> It = s.iterator();
		while(It.hasNext()) {
			Integer currentKey = It.next();
			Critique c = M.get(currentKey);
			String str = ""+currentKey;
			Integer[] ref = new Integer[c.getRef().size()];
			ref = c.getRef().toArray(ref);
			String[] domaines = new String[c.getDomaines().size()];
			domaines = c.getDomaines().toArray(domaines);
			str += ";"+Arrays.toString(ref)+";"+ Arrays.toString(domaines);
			writer.println(str);
		}
		writer.close();}
	
public void saveCorrecteur(HashMap<Integer, Correcteur> M, String pathName) throws FileNotFoundException, UnsupportedEncodingException{
	
	PrintWriter writer = new PrintWriter(PATH+"correcteurs.txt", "UTF-8");
	Set<Integer> s = M.keySet();
	Iterator<Integer> It = s.iterator();
	while(It.hasNext()) {
		Integer currentKey = It.next();
		Correcteur c = M.get(currentKey);
		ArrayList<Oeuvre> L = c.getOeuvres();
		long[] refOeuvres = new long[L.size()];
		for(int i=0; i<L.size();i++) {
			refOeuvres[i] = L.get(i).reference;
		}
		String str = ""+currentKey;

		str += ";"+Arrays.toString(refOeuvres);
		writer.println(str);
	}
	writer.close();}	
	

public static void saveDatabase() throws FileNotFoundException, UnsupportedEncodingException {
	HashMap<Integer,Personne> DataPersonne = new HashMap<Integer, Personne>();
	HashMap<Integer, Auteur> DataAuteurs = new HashMap<Integer, Auteur>();
	HashMap<Integer, Personne> DataCorrecteurs = new HashMap<Integer, Personne>();
	HashMap<Integer, Critique> DataCritique = new HashMap<Integer, Critique>();
	ArrayList<Integer> DataIdOeuvre = new ArrayList<Integer>();
	ArrayList<Integer> DataIdPersonne = new ArrayList<Integer>();
	HashMap<Long, Oeuvre> DataOeuvre = new HashMap<Long, Oeuvre>();
	Personne p1 = new Personne("Dufraisse","Evan","Nantes",1);
	Personne p2 = new Personne("Cheneau", "Florent", "Nantes",2);
	Personne p3 = new Personne("Friedel", "Paul", "Brest",3);
	Auteur a1 = new Auteur(new ArrayList<String>(Arrays.asList(new String[]{"Physique","Géopolitique"})),p1);
	Critique c1 = new Critique(new ArrayList<String>(Arrays.asList(new String[]{"Mathématiques","Astrologie"})), p2);
	Oeuvre o1 = new Oeuvre_collective(1,"Tutos faciles","url:deihzfiehofhao");
	Correcteur c2 = new Correcteur(new ArrayList<Oeuvre>(Arrays.asList(new Oeuvre[]{o1})),p3);
	DataPersonne.put(p1.getId(), p1);
	DataPersonne.put(p2.getId(), p2);
	DataPersonne.put(p3.getId(), p3);
	DataAuteurs.put(p1.getId(), a1);
	Database d = new Database();
	d.savePersonne(DataPersonne, "personnes");
	d.saveAuteurs(DataAuteurs, "auteurs");
	

}
public static void retrieveDatabase() {
	HashMap<Integer, Personne> M;
	M = databaseLoadPersonnes("personnes");
	Set<Integer> s = M.keySet();
	Iterator<Integer> it  = s.iterator();
	while(it.hasNext()) {
		int key = it.next();
		System.out.println(M.get(key).getPrenom()+" "+M.get(key).getName());
	}
	HashMap<Integer, Auteur> Mauteurs;
	Mauteurs = databaseLoadAuteurs("auteurs.txt",M);
	Set<Integer> setKeyAuteurs = Mauteurs.keySet();
	Iterator<Integer> itauteurs = setKeyAuteurs.iterator();
	while(itauteurs.hasNext()) {
		int key = itauteurs.next();
		System.out.println(Mauteurs.get(key).getDomaines()+" "+Mauteurs.get(key).getPersonne().getPrenom());
	}
	
}
	
public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
	saveDatabase();
	retrieveDatabase();
	
}

}
