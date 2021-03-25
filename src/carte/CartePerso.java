package carte;
import effet.StrategieEffet;


public class CartePerso extends CarteJeu {
	private int pv;
	private int pvMax;
	private int attaque;
	private int attaqueInit;

	private int nbAttaqueRestantes;
	private int nbAttaqueMax;

	/** Constructeur par défaut initialisant les paramètres basiques d'une carte 
	 * 
	 * @param reference		La référence (ALPHABET + NUMERIQUE) de la carte
	 * @param nom			Le nom de la carte
	 * @param anime			L'animé d'où provient la carte
	 * @param effet			L'effet (Stratégie) de la carte
	 * @param nbExemplaire	Le nombre d'exemplaire maximum de cette carte dans un deck
	 * @param pv			Le nombre de PV maximum de la carte
	 * @param attaque		L'attaque initiale de la carte
	 * @param cout			Le coût initial de la carte
	 */
	public CartePerso(String reference, String nom, String anime, StrategieEffet effet, int nbExemplaire, int pv, int attaque, int cout) {
		super(reference, nom, anime, effet, nbExemplaire, cout);
		this.pv = this.pvMax = pv;
		this.attaque = this.attaqueInit = attaque;
	}

	/** Accesseur (getter) sur les PV
	 * 
	 * @return	Les PV actuels de cette carte
	 */
	public int getPv() {
		return this.pv;
	}

	/** Accesseur (getter) sur l'attaque
	 * 
	 * @return	L'attaque actuelle de cette carte
	 */
	public int getAttaque() {
		return this.attaque;
	}

	/** Accesseur (getter) sur le nombre d'attaques restantes
	 * 
	 * @return	Le nombre d'attaques restantes de cette carte
	 */
	public int getNbAttaqueRestantes() {
		return this.nbAttaqueRestantes;
	}
	
	@Override
	public void reinitialisation() {
		super.reinitialisation();
		this.pv = this.pvMax;
		this.attaque = this.attaqueInit;
		this.reinitialisationNbAttaque();
	}
	
	/** Permet de réinitialiser le nombre d'attaques du perso (ex: au début du tour)
	 */
	public void reinitialisationNbAttaque() {
		this.nbAttaqueRestantes = this.nbAttaqueMax;
	}
	
	/** Permet de savoir si cette carte peut attaquer
	 * 
	 * @return	Vrai si cette carte a au moins une attaque, faux sinon
	 */
	public boolean peutAttaquer() {
		return this.nbAttaqueRestantes > 0 && this.effet.peutAttaquer();
	}

	@Override
	public void combattre(Carte c) {
		this.zone.combattre(c);
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public String toStringSave() {
		return this.reference + ";" + this.nbExemplaire + ";Perso;" + this.nom + ";" + this.anime + ";"
			+ this.attaque + ";" + this.pv + ";" + this.cout + ";" + this.effet;
	}
}
