package shopping.abstraction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Un panier client disposant d'un catalogue sous la forme d'une liste
 * d'articles
 * et memorisant la quantite souhaitee par le client de chaque article.
 */
public class Cart {
	public static final String MESSAGE_CHANGEMENT_ARTICLE_COURANT = "Changement d'article courant";
	public static final String MESSAGE_CHANGEMENT_CONTENU_PANIER = "Changement du contenu du panier";

	private LinkedList<Article> catalogue; // Les articles au catalogue
	private int currentIndex; // dans [0, getCatalogSize()-1], L'index de l'article courant (celui
								// actuellement selectionne)
	private HashMap<Article, Integer> quantity; // pour chaque article, la quantite actuellement dans le panier
	private PropertyChangeSupport pcs; // propriete permettant de notifier des changements du modele

	public Cart(String fichierCatalogue) {
		this.catalogue = new LinkedList<Article>();
		try {
			BufferedReader aLire = new BufferedReader(new FileReader(fichierCatalogue));
			String ligne;
			String fichier;
			double largeur, profondeur, hauteur;
			String descriptif;
			int reference;
			int quantite;
			double prix;
			do {
				ligne = aLire.readLine();
				if (ligne != null) {
					fichier = ligne;
					largeur = Double.parseDouble(aLire.readLine());
					profondeur = Double.parseDouble(aLire.readLine());
					hauteur = Double.parseDouble(aLire.readLine());
					descriptif = aLire.readLine();
					reference = Integer.parseInt(aLire.readLine());
					prix = Double.parseDouble(aLire.readLine());
					quantite = Integer.parseInt(aLire.readLine());
					this.catalogue.add(
							new Article(fichier, largeur, profondeur, hauteur, descriptif, reference, prix, quantite));
				}
			} while (ligne != null); // tant qu'on n'a pas atteint la fin du fichier aLire
			aLire.close();
		} catch (IOException e) {
			System.out.println("Une operation sur les fichiers a leve l'exception " + e);
		}
		this.currentIndex = 0;
		this.quantity = new HashMap<Article, Integer>();
		for (int i = 0; i < this.getCatalogSize(); i++) {
			this.quantity.put(this.catalogue.get(i), 0);
		}
		this.pcs = new PropertyChangeSupport(this);
	}

	/**
	 * @return Retourne le nombre d'articles differents dans le catalogue
	 */
	public int getCatalogSize() {
		return this.catalogue.size();
	}

	/**
	 * @return Retourne l'index (dans [0, this.getCatalogSize()-1]) de l'article
	 *         courant
	 */
	public int getCurrentIndex() {
		return this.currentIndex;
	}

	/**
	 * Fait de l'article d'index i l'article courant
	 * (leve une IllegalArgumentException si i n'est pas dans [0,
	 * getCatalogSize()-1])
	 * 
	 * @param i dans [0, getCatalogSize()-1]
	 */
	public void setCurrentIndex(int i) {
		System.out.println(
				"Appel a setCurrentIndex(" + i + ") (le parametre doit etre dans [0, " + (catalogue.size() - 1) + "])");
		if (i >= 0 && i < getCatalogSize()) {
			int old = this.currentIndex;
			this.currentIndex = i;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_ARTICLE_COURANT, Integer.valueOf(old), Integer.valueOf(i));
		} else {
			throw new IllegalArgumentException("Appel de setCurrentIndex(" + i
					+ ") avec un index hors limite (pas dans [0, " + (getCatalogSize() - 1) + "])");
		}
	}

	/**
	 * @return Retourne l'article courant
	 */
	public Article getCurrentArticle() {
		return this.catalogue.get(getCurrentIndex());
	}

	/**
	 * @return Retourne la quantite encore disponible de l'article courant
	 *         (la quantite en stock moins la quantite deja dans le panier)
	 */
	public int getAvailables() {
		return this.getCurrentArticle().getInStock() - this.getCurrentQuantity();
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_CONTENU_PANIER, l);
		pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_ARTICLE_COURANT, l);
	}

	// ===================================================================================
	//
	//
	//
	//
	// Les methodes ci-dessous ne sont utiles que pour la partie 2 de l'enonce
	//
	//
	//
	//
	// ===================================================================================

	/**
	 * Vide le panier
	 */
	public void clear() {
		System.out.println("Appel a clear()");
		for (Article a : this.quantity.keySet()) {
			this.quantity.put(a, 0);
		}
		this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_CONTENU_PANIER, Integer.valueOf(1), Integer.valueOf(0));
	}

	/**
	 * @return Retourne la quantite dans le panier de l'article courant
	 */
	public int getCurrentQuantity() {
		return this.quantity.get(this.getCurrentArticle());
	}

	/**
	 * @return Retourne la quantite en stock de l'article courant
	 */
	public int getCurrentInStock() {
		return this.getCurrentArticle().getInStock();
	}

	/**
	 * Fait de nb la quantite dans le panier de l'article courant
	 * (leve une IllegalArgumentException si nb n'est pas dans [0,
	 * getCurrentInStock()])
	 * 
	 * @param nb dans [0, getCurrentInStock()]
	 */
	public void setCurrentQuantity(int nb) {
		System.out.println("Appel a setCurrentQuantity(" + nb + ") (le parametre doit etre dans [0, "
				+ (getCurrentInStock()) + "])");
		if (nb < 0 || nb > getCurrentInStock()) {
			throw new IllegalArgumentException("Appel de setCurrentQuantity(nb) avec nb==" + nb
					+ " alors que nb doit etre dans [0, " + this.getCurrentInStock() + "]");
		}
		this.quantity.put(this.getCurrentArticle(), nb);
		this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_CONTENU_PANIER, Integer.valueOf(1), Integer.valueOf(0));
	}

	/**
	 * @return Retourne le prix total pour l'ensemble des articles du panier
	 */
	public double getTotalPrice() {
		double total = 0.0;
		for (Article a : this.quantity.keySet()) {
			total += this.quantity.get(a) * a.getPrice();
		}
		return ((int) (total * 100)) / 100.0;
	}

	/**
	 * @return Retourne le nombre d'articles dans le panier
	 */
	public int getCartSize() {
		int total = 0;
		for (Article a : this.quantity.keySet()) {
			total += this.quantity.get(a);
		}
		return total;
	}

}
