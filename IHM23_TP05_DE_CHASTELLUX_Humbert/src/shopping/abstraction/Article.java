package shopping.abstraction;
import java.io.File;

public class Article {
	private String iconFile; 
	private double width, depth, height;
	private String description;
	private int reference;
	private double price;
	private int inStock;
	
	public Article(String nomFichier, double largeur, double profondeur, double hauteur, String descriptif, int reference, double prix, int quantite) {
		this.iconFile = "images"+File.separator+"ico"+nomFichier;
		this.width = largeur; 
		this.depth = profondeur; 
		this.height = hauteur; 
		this.description = descriptif; 
		this.reference = reference; 
		this.price = prix; 
		this.inStock = quantite;
	}
	/**
	 * @return Retourne le chemin de l'image de l'article
	 */
	public String getIconFile() {
		return this.iconFile;
	}
	
	/**
	 * @return Retourne la quantite en stock de l'article
	 */
	public int getInStock() {
		return this.inStock;
	}
	
	/**
	 * @return Retourne le prix de l'article
	 */
	public double getPrice() {
		return this.price;
	}
	
	/**
	 * @return Retourne la description de l'article
	 */
    public String getDescription() {
    	return "<html><body><p><font face=\"Arial\" color=\"blue\"><b>Reference :</b></font>"+this.reference+"<br>"
    			+"<font face=\"Arial\" color=\"blue\"><b>Description :</b></font>"+this.description+"<br>"
                +"<font face=\"Arial\" color=\"blue\"><b>Dimensions :</b></font>"+this.width+"x"+this.depth+"x"+this.height+" cm<br>"
    			+"<font face=\"Arial\" color=\"blue\"><b>Prix :</b></font>"+this.price+"</p></body></html>";
    }
}
