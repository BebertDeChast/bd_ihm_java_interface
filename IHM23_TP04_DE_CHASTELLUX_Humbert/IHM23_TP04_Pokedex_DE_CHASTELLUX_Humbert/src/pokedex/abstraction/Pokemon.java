package pokedex.abstraction;

public class Pokemon {
	private int id;
	private String nomen;
	private String nomfr;
	private String typep;
	private String types;
	private int pv;
	private int attaque;
	private int defense;
	private int attspe;
	private int defspe;
	private int vitesse;
	private int generation;
	private boolean legendaire;

	public Pokemon(int id,
			String nomen,
			String nomfr,
			String typep,
			String types,
			int pv,
			int attaque,
			int defense,
			int attspe,
			int defspe,
			int vitesse,
			int generation,
			boolean legendaire) {
		super();
		this.id = id;
		this.nomen = nomen;
		this.nomfr = nomfr;
		this.typep = typep;
		this.types = types;
		this.pv = pv;
		this.attaque = attaque;
		this.defense = defense;
		this.attspe = attspe;
		this.defspe = defspe;
		this.vitesse = vitesse;
		this.generation = generation;
		this.legendaire = legendaire;
	}

	/**
	 * @return L'identifiant du pokemon
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Le nom anglais du pokemon
	 */
	public String getNomen() {
		return nomen.toLowerCase();
	}

	/**
	 * @return Le nom francais du pokemon
	 */
	public String getNomfr() {
		return nomfr.toLowerCase();
	}

	public String getTypep() {
		return typep.toLowerCase();
	}

	public String getTypes() {
		return types == null ? null : types.toLowerCase();
	}

	public int getPv() {
		return pv;
	}

	public int getAttaque() {
		return attaque;
	}

	public int getDefense() {
		return defense;
	}

	public int getAttspe() {
		return attspe;
	}

	public int getDefspe() {
		return defspe;
	}

	public int getVitesse() {
		return vitesse;
	}

	public int getGeneration() {
		return generation;
	}

	public boolean isLegendaire() {
		return legendaire;
	}

	public boolean equals(Object o) {
		return (o instanceof Pokemon) && ((Pokemon) o).getId() == this.getId();
	}

	public String toString() {
		String res = "id : " + this.getId() + " " + this.getNomfr() + " (" + this.getNomen() + ")"
				+ (this.isLegendaire() ? " LEGENDAIRE" : "") + "\n"
				+ "Type Principal : " + this.getTypep()
				+ (this.getTypes() == null ? "" : " Type Secondaire : " + this.getTypes()) + "\n"
				+ "Points de vie  : " + String.format("%3d", this.getPv()) + "\n"
				+ "Attaque ______ : " + String.format("%3d", this.getAttaque()) + " Attaque Speciale : "
				+ String.format("%3d", this.getAttspe()) + "\n"
				+ "Defense ______ : " + String.format("%3d", this.getDefense()) + " Defense Speciale : "
				+ String.format("%3d", this.getDefspe()) + "\n"
				+ "Vitesse ______ : " + String.format("%3d", this.getVitesse()) + " Generation _____ : "
				+ String.format("%3d", this.getGeneration()) + "\n";
		return res;
	}
}
