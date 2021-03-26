package carte;
import effet.StrategieEffet;
import images.ImagePanel;


public abstract class Carte extends ImagePanel implements Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1142093430490745997L;
	
	protected String reference;
	protected String nom;
	protected String anime;
	
	protected StrategieEffet effet;
	protected int nbExemplaire;
	
	/** Constructeur par défaut initialisant les paramètres basiques d'une carte 
	 * 
	 * @param reference		La référence (ALPHABET + NUMERIQUE) de la carte
	 * @param nom			Le nom de la carte
	 * @param anime			L'animé d'où provient la carte
	 * @param effet			L'effet (Stratégie) de la carte
	 * @param nbExemplaire	Le nombre d'exemplaire maximum de cette carte dans un deck
	 */
	public Carte(String reference, String nom, String anime, StrategieEffet effet, int nbExemplaire) {
		//super(reference);
		super(reference);
		this.reference = reference;
		this.nom = nom;
		this.anime = anime;
		this.effet = effet;
		this.nbExemplaire = nbExemplaire;
	}
	
	/**
	 * @return La référence de la carte
	 */
	public String getReference() {
		return this.reference;
	}

	/**
	 * @return Le nom de la carte
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @return L'animé auquel appartient la carte
	 */
	public String getAnime() {
		return this.anime;
	}

	/**
	 * @return L'effet de la carte
	 */
	public StrategieEffet getEffet() {
		return this.effet;
	}

	/**
	 * @return Le nombre d'exemplaire maximal de cette carte dans un deck
	 */
	public int getNbExemplaire() {
		return this.nbExemplaire;
	}

	public Object clone() {
		return this.clone();
	}
	
	public abstract void reinitialisation();
	
	@Override
	public boolean equals(Object o) {
		boolean retour = false;
		
		if (o instanceof Carte) {
			Carte c = (Carte)o;
			retour = this.reference.equals(c.reference);
		}
		
		return retour;
	}

	/** Permet de convertir la carte en chaîne de caractères qui sera sauvegardée dans un fichier texte
	 * 
	 * @return		La chaîne de caractères représentant la carte
	 */
	public abstract String toStringSave();
}
