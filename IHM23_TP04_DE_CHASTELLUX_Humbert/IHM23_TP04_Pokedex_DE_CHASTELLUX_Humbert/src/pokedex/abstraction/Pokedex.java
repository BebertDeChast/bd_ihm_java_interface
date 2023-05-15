package pokedex.abstraction;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class Pokedex {
	public static final String MESSAGE_CHANGEMENT_POKEMON_COURANT = "Changement de pokemon courant";

	private List<Pokemon> pokemons;
	private int currentIndex;
	
	private PropertyChangeSupport pcs; // propriete permettant de notifier des changements du modele

	public Pokedex() throws Exception {
		this.currentIndex=0;
		this.pokemons = new LinkedList<Pokemon>();
		this.pcs = new PropertyChangeSupport(this);

		Class.forName( "org.hsqldb.jdbcDriver"  );

		String url = "jdbc:hsqldb:file:database"+File.separator+"pokemon;shutdown=true";
		String login = "sa";
		String password = "";
		try ( Connection connection = DriverManager.getConnection( url, login, password ) ) {
			String requete = "SELECT * FROM POKEMON";
			try ( Statement statement = connection.createStatement() ) {
				try (ResultSet resultSet = statement.executeQuery( requete ) ) {
					while( resultSet.next() ) {
						int id= resultSet.getInt( "id" );
						String nomen= resultSet.getString( "nomen" );
						String nomfr= resultSet.getString( "nomfr" );
						String typep= resultSet.getString( "typep" );
						String types= resultSet.getString( "types" );
						int pv= resultSet.getInt( "pv" );
						int attaque = resultSet.getInt( "attaque" );
						int defense = resultSet.getInt( "defense" );
						int attspe = resultSet.getInt( "attspe" );
						int defspe = resultSet.getInt( "defspe" );
						int vitesse = resultSet.getInt( "vitesse" );
						int generation = resultSet.getInt( "generation" );
						boolean legendaire = resultSet.getBoolean( "legendaire" );
						this.pokemons.add(new Pokemon(id, nomen, nomfr, typep, types, pv, attaque, defense, attspe, defspe, vitesse, generation, legendaire));
					}
				}
			}
		}
	}

	public void addPropertyChangeListener(PropertyChangeListener l) {
		pcs.addPropertyChangeListener(MESSAGE_CHANGEMENT_POKEMON_COURANT, l);
	}

	/**
	 * @return Retourne le nombre de pokemons dans le pokedex
	 */
	public int size() {
		return this.pokemons.size();
	}

	/**
	 * @return Retourne l'index du pokemon courant
	 */
	public int getCurrentIndex() {
		return this.currentIndex;
	}

	/**
	 * @return Retourne le pokemon courant
	 */
	public Pokemon getCurrentPokemon() {
		return this.pokemons.get(currentIndex);
	}

	/**
	 * Si le pokemon courant n'est pas le dernier du pokedex 
	 * alors fait du pokemon suivant le pokemon courant
	 */
	public void goNext() {
		if (this.currentIndex<this.size()-1) {
			this.currentIndex++;
			this.pcs.firePropertyChange(Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT,Integer.valueOf(this.currentIndex-1),Integer.valueOf(this.currentIndex));
		}
	}

	/**
	 * Si le pokemon courant n'est pas le premier du pokedex
	 * alors fait du pokemon precedent le pokemon courant
	 */
	public void goPrevious() {
		if (this.currentIndex>0) {
			this.currentIndex--;
			this.pcs.firePropertyChange(Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT,Integer.valueOf(this.currentIndex+1),Integer.valueOf(this.currentIndex));
		}
	}

	/**
	 * Si index est un index valide (dans [0, size()-1]) different de 
	 * l'index courant alors fait d'index l'index courant.
	 * @param index
	 */
	public void goToIndex(int index) {
		if (index>=0 && index<this.size() && this.currentIndex!=index) {
			int previous=this.currentIndex;
			this.currentIndex = index;
			this.pcs.firePropertyChange(Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT,Integer.valueOf(previous),Integer.valueOf(this.currentIndex));
		}
	}

//////////////////////////////////////////////////////////////////////
//                                                                  //
//     Les methodes ci-dessous ne sont pas utiles en debut de TP    //
//                                                                  //
//////////////////////////////////////////////////////////////////////
	
	
	
	/**
	 * S'il existe un pokemon ayant id pour identifiant alors
	 * fait de ce pokemon le pokemon courant
	 * @param id
	 */
	public void goToId(int id) {
		int i=0;
		while (i<this.size() && this.pokemons.get(i).getId()!=id) {
			i++;
		}
		if (i<this.size()) {
			int previous=this.currentIndex;
			this.currentIndex = i;
			this.pcs.firePropertyChange(Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT,Integer.valueOf(previous),Integer.valueOf(this.currentIndex));
		}
	}
	
	/**
	 * @param id
	 * @return Retourne true s'il existe un pokemon ayant id 
	 * pour identifiant (retourne false si aucun porkemon n'a
	 * id pour identifiant)
	 */
	public boolean aPokemonHasId(int id) {
		int i=0;
		while (i<this.size() && this.pokemons.get(i).getId()!=id) {
			i++;
		}
		return (i<this.size());
	}
	
	/**
	 * S'il existe un pokemon ayant nom en minuscule pour nom (francais ou anglais)
	 * alors fait de ce pokemon le pokemon courant
	 * @param nom
	 */
	public void goToName(String nom) {
		int i=0;
		String nomLower = nom.toLowerCase();
		while (i<this.size() 
				&& !this.pokemons.get(i).getNomen().toLowerCase().equals(nomLower)  
				&& !this.pokemons.get(i).getNomfr().toLowerCase().equals(nomLower)) {
			i++;
		}
		if (i<this.size()) {
			int previous=this.currentIndex;
			this.currentIndex = i;
			this.pcs.firePropertyChange(Pokedex.MESSAGE_CHANGEMENT_POKEMON_COURANT,Integer.valueOf(previous),Integer.valueOf(this.currentIndex));
		}
	}

	/**
	 * @param nom
	 * @return Retourne true s'il existe un pokemon ayant nom 
	 * en minuscules pour nom (francais ou anglais)
	 * (retourne false si aucun pokemon n'a un tel nom)
	 */
	public boolean aPokemonHasName(String nom) {
		int i=0;
		String nomLower = nom.toLowerCase();
		while (i<this.size()
				&& !this.pokemons.get(i).getNomen().toLowerCase().equals(nomLower)  
				&& !this.pokemons.get(i).getNomfr().toLowerCase().equals(nomLower)) {
			i++;
		}
		return (i<this.size());
	}
	
	/**
	 * Si idOrName correspond a un entier
	 *    alors s'il existe un pokemon ayant id pour identifiant 
	 *    fait de ce pokemon le pokemon courant.
	 * Sinon (idOrName n'est pas un entier)
	 *    alors s'il existe un pokemon ayant nom en minuscule pour
	 *    nom (francais ou anglais) fait de ce pokemon le pokemon courant
	 * @param idOrName
	 */
	public void goToIdOrName(String idOrName) {
		int id=-1;
		try { // S'il s'agit d'un id alors Integer.parseInt ne levera pas d'exception
			id = Integer.parseInt(idOrName);
		} catch (Exception e) {}
		
		if (id!=-1) {
			goToId(id);
		} else {
			goToName(idOrName);
		}
	}
	
	/**
	 * @param idOrName
	 * @return Retourne true si idOrName est un entier et il existe
	 * un pokemon ayant idOrName pour identifiant ou si idOrName n'est 
	 * pas un entier et il existe un pokemon ayant idOrName pour nom (francais ou anglais)
	 */
	public boolean aPokemonHasIdOrName(String idOrName) {
		int id=-1;
		try { // S'il s'agit d'un id alors Integer.parseInt ne levera pas d'exception
			id = Integer.parseInt(idOrName);
		} catch (Exception e) {}
		
		if (id!=-1) {
			return aPokemonHasId(id);
		} else {
			return aPokemonHasName(idOrName);
		}
	}

	/**
	 * @return Retourne une liste constituee de tous les pokemons du pokedex
	 */
	public List<Pokemon> getPokemons() {
		LinkedList<Pokemon> res = new LinkedList<Pokemon>();
		res.addAll(this.pokemons);
		return res;
	}
}
