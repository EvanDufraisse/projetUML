package projetUML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Database {
	
	ArrayList<Integer> DataIdOeuvre;
	ArrayList<Integer> DataIdPersonne;
	HashMap<String, Personne> DataCritique;
	HashMap<String, Personne> DataAuteurs;
	HashMap<String, Personne> DataCorrecteurs;
	HashMap<String,Oeuvre> DataOeuvre;
	
	public ArrayList<Integer> databaseLoadId(String path) {
		ArrayList<Integer> data = new ArrayList<Integer>();
    	File file = new File("./database/"+path+".txt");
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
	
	public HashMap<Integer, Personne> databaseLoadPersonnes(String path) {

		HashMap<Integer,Personne> M = new HashMap<Integer, Personne>();
    	File file = new File("./database/"+path+".txt");
    	BufferedReader reader = null;

    	try {
    	    reader = new BufferedReader(new FileReader(file));
    	    String text = null;

    	    while ((text = reader.readLine()) != null) {
    	    	String[] parts = text.split(";");
    	    	String[] values = new String[4];
    	    	for(int i=0; i<4;i++) {
    	    		values[i] = parts[i+1];
    	    	}
    	    	M.put(Integer.parseInt(values[3]), new Personne(values[0],values[1],values[2],Integer.parseInt(values[3])));
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
	
	public HashMap<Integer, Auteur> databaseLoadAuteurs(String path, HashMap<Integer,Personne> data) {

		HashMap<Integer, Auteur> M = new HashMap<Integer, Auteur>();
    	File file = new File("./database/"+path+".txt");
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
	
	public HashMap<Integer, Correcteur> databaseLoadCorrecteurs(String path, HashMap<Integer,Personne> data, HashMap<Integer,Oeuvre>  dataOeuvres) {

		HashMap<Integer, Correcteur> M = new HashMap<Integer, Correcteur>();
    	File file = new File("./database/"+path+".txt");
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
	
	public HashMap<Integer, Critique> databaseLoadCritiques(String path, HashMap<Integer,Personne> data) {

		HashMap<Integer, Critique> M = new HashMap<Integer, Critique>();
    	File file = new File("./database/"+path+".txt");
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
	
	
	
	
	
	
public static void main(String[] args) {
	
}

}
