package packnp.cadenas.abstraction;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Cadenas {
	public static final String MESSAGE_CHANGEMENT_UNITES    = "Changement chiffre unites";
	public static final String MESSAGE_CHANGEMENT_DIZAINES  = "Changement chiffre dizaines";
	public static final String MESSAGE_CHANGEMENT_CENTAINES = "Changement chiffre centaines";
	
	private PropertyChangeSupport pcs; // propriete permettant de notifier des changements du modele
	
	// VARIABLES D'INSTANCE
	// --------------------
	private int unites, dizaines, centaines; // Les chiffres visibles sur les molettes
	private int combinaisonSecrete;

	public Cadenas(int combinaisonSecrete) {
		this.unites = 0;
		this.dizaines = 0;
		this.centaines = 0;
		this.combinaisonSecrete = combinaisonSecrete;
		this.pcs = new PropertyChangeSupport(this);
	}
	
	/**
	 * @return Retourne le chiffre de la molette des unites.
	 */
	public int getUnites() {
		return this.unites;
	}
	
	/**
	 * Tourne la molette des unites vers le chiffre superieur 
	 * si elle n'est pas positionnee sur 9 
	 */
	public void incUnites() {
		System.out.println("inc unites");
		if (this.unites<9) {
			this.unites++;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_UNITES, this.unites-1, this.unites);
		}
	}
	
	/**
	 * Tourne la molette des unites jusqu'a la valeur val  
	 * si val est dans [0, 9] 
	 */
	public void setUnites(int val) {
		System.out.println("setUnites("+val+")");
		if (val>=0 && val<=9) {
			int old = this.unites;
			this.unites=val;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_UNITES, old, this.unites);
		}
	}

	/**
	 * Tourne la molette des unites vers le chiffre inferieur 
	 * si elle n'est pas positionnee sur 0 
	 */
	public void decUnites() {
		System.out.println("dec unites");
		if (this.unites>0) {
			this.unites--;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_UNITES, this.unites+1, this.unites);
		}
	}
	
	/**
	 * @return Retourne le chiffre de la molette des dizaines.
	 */
	public int getDizaines() {
		return this.dizaines;
	}
	
	/**
	 * Tourne la molette des dizaines vers le chiffre superieur 
	 * si elle n'est pas positionnee sur 9 
	 */
	public void incDizaines() {
		System.out.println("inc dizaines");
		if (this.dizaines<9) {
			this.dizaines++;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_DIZAINES, this.dizaines-1, this.dizaines);
		}
	}

	/**
	 * Tourne la molette des dizaines jusqu'a la valeur val  
	 * si val est dans [0, 9] 
	 */
	public void setDizaines(int val) {
		System.out.println("setDizaines("+val+")");
		if (val>=0 && val<=9) {
			int old = this.dizaines;
			this.dizaines=val;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_DIZAINES, old, this.dizaines);
		}
	}

	/**
	 * Tourne la molette des dizaines vers le chiffre inferieur 
	 * si elle n'est pas positionnee sur 0 
	 */
	public void decDizaines() {
		System.out.println("dec dizaines");
		if (this.dizaines>0) {
			this.dizaines--;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_DIZAINES, this.dizaines+1, this.dizaines);
		}
	}
	
	/**
	 * @return Retourne le chiffre de la molette des centaines.
	 */
	public int getCentaines() {
		return this.centaines;
	}
	
	
	/**
	 * Tourne la molette des centaines vers le chiffre superieur 
	 * si elle n'est pas positionnee sur 9 
	 */
	public void incCentaines() {
		System.out.println("inc centaines");
		if (this.centaines<9) {
			this.centaines++;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_CENTAINES, this.centaines-1, this.centaines);
		}
	}
	
	/**
	 * Tourne la molette des centaines jusqu'a la valeur val  
	 * si val est dans [0, 9] 
	 */
	public void setCentaines(int val) {
		System.out.println("setCentaines("+val+")");
		if (val>=0 && val<=9) {
			int old = this.centaines;
			this.centaines=val;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_CENTAINES, old, this.centaines);
		}
	}

	/**
	 * Tourne la molette des centaines vers le chiffre inferieur 
	 * si elle n'est pas positionnee sur 0 
	 */
	public void decCentaines() {
		System.out.println("dec centaines");
		if (this.centaines>0) {
			this.centaines--;
			this.pcs.firePropertyChange(MESSAGE_CHANGEMENT_CENTAINES, this.centaines+1, this.centaines);
		}
	}
	/**
	 * @return Retourne true si le pseudo comporte au moins 3 caracteres.
	 */
	public boolean ouvertureOK() {
		return ((this.getCentaines()*100)+(this.getDizaines()*10)+this.getUnites())==this.combinaisonSecrete;
	}
	
	/**
	 * Ajoute l a la liste des ecouteurs de la propriete propertyChangeSupport du Bot
	 * Des lors, l sera notifie de tout changement de l'etat du Bot
	 * via l'appel de sa methode propertyChange.
	 * @param l  l!=null
	 */
	public void addPropertyChangeListener(PropertyChangeListener l) {
		this.pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_UNITES, l);
		this.pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_DIZAINES, l);
		this.pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_CENTAINES, l);
	}
}
