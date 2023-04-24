package motLePlusLong.abstraction;
 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public class Dico {
	private  ArrayList<String> dico;
 
	public Dico(String fichier) {
		this.dico = load(fichier);
	}
	/**
	 * @param tirage, un mot
	 * @return retourne un tableau d'Object constitue de tous les mots realisable a partir du mot tirage
	 */
	public String[] feasibleWords( String tirage  ) {
		tirage = tirage.toUpperCase();
		ArrayList<String> realisables = new ArrayList<String>();
		for (String mot : this.dico) {
			if (mot.length()<= tirage.length() && feasible(mot,tirage)) {
				realisables.add(mot);
			}
		}
		String[] t = new String[realisables.size()];
		for (int i=0; i<t.length; i++) {
			t[i]=realisables.get(i);
		}
		return t;
	}
 
	/**
	 * @param nomFichier, le nom du fichier contenant les mots du dictionnaire
	 * @return l'ArrayList formee des mots figurant dans le fichier nomFichier
	 */
	private static ArrayList<String> load(String nomFichier) {
		ArrayList<String>dictionnaire = new ArrayList<String>();
		String mot;
		try {
			BufferedReader aLire= new BufferedReader(new FileReader(nomFichier));
			do {
				mot = aLire.readLine();
				if (mot!=null) {
					dictionnaire.add(mot);
				}
			} while (mot!=null);
			aLire.close( );
		}
		catch (IOException e) {
			System.out.println("Une operation sur les fichiers a leve l'exception "+e);
		}
		return dictionnaire;
	}
	/**
	 *
	 * @param caractere, un caractere quelconque
	 * @param mot, une chaine de caractere contenant au moins une occurrence de "caractere"
	 * @return retourne le mot que l'on obtient en supprimant la premiere occurrence de caractere dans le mot mot.
	 */
	private static String removeChar( char caractere, String mot ) {
		String aRetourner = "";
		int i=0;
		while (mot.charAt(i)!=caractere) {
			aRetourner = aRetourner+mot.charAt(i);
			i++;
		}
		i++;
		for (int j=i; j<mot.length(); j++) {
			aRetourner = aRetourner+mot.charAt(j);
		}
		return aRetourner;
	}
	/**
	 *
	 * @param mot, une String quelconque
	 * @param tirage, une String quelconque
	 * @return retourne true si et seulement si il est possible de realiser le mot mot a partir des lettres de tirage.
	 */
	private static boolean feasible( String mot, String tirage ) {
		String caracteresDisponibles = tirage;
		int i=0;
		while ((i<mot.length()) && (caracteresDisponibles.contains(""+mot.charAt(i)))) {
			caracteresDisponibles = removeChar( mot.charAt(i), caracteresDisponibles);
			i++;
		}
		return (i==mot.length());
	}
 
 
}
