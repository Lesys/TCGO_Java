package carte;
import effet.StrategieEffet;


public class CarteHeros extends Carte {
	private int pv;
	private int pvMax;

	/** Constructeur par défaut initialisant les paramètres basiques d'une carte 
	 * 
	 * @param reference		La référence (ALPHABET + NUMERIQUE) de la carte
	 * @param nom			Le nom de la carte
	 * @param anime			L'animé d'où provient la carte
	 * @param effet			L'effet (Stratégie) de la carte
	 * @param nbExemplaire	Le nombre d'exemplaire maximum de cette carte dans un deck
	 * @param pv			Le nombre de PV maximum de la carte
	 */
	public CarteHeros(String reference, String nom, String anime, StrategieEffet effet, int pv) {
		// Une carte héros est toujours limité à 1 exemplaire
		super(reference, nom, anime, effet, 1);
		this.pv = this.pvMax = pv;
	}

	/** Accesseur (getter) sur les PV
	 * 
	 * @return	Les PV actuels de cette carte
	 */
	public int getPv() {
		return this.pv;
	}
	
	/** Calcul l'énergie supplémentaire que devrait avoir le joueur
	 * 
	 * @return		L'énergie supplémentaire en fonction des PV de ce héros
	 */
	public int getNbEnergie() {
		// 5 == le nombre de paliers d'énergie (en comptant le palier 
		return ((this.pvMax - this.pv) * 5) / this.pvMax;
	}
	
	@Override
	public void reinitialisation() {
		//super.reinitialisation();
		this.pv = this.pvMax;
	}

	@Override
	public String infosToString() {
		return super.infosToString() + "\nHP: " + this.pv + "/" + this.pvMax;
	}
	
	@Override
	public String toString() {
		return "Carte héros: " + this.reference;
	}
	
	@Override
	public String toStringSave() {
		return this.reference + ";" + this.nbExemplaire + ";Héros;" + this.nom + ";" + this.anime + ";"
			+ "X;" + this.pv + ";" + "X;" + this.effet;
	}
	
	public static CarteHeros initTest() {
		return new CarteHeros("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "Héros de test", "anime", null, 4);
		
	}

	@Override
	public void lancerAttaque(Carte carte) {
		// Un héros ne peut (normalement) pas attaquer
	}

	@Override
	public void subirAttaque(Carte carte) {
		if (carte instanceof CartePerso) {
			CartePerso cartePerso = (CartePerso) carte;
			this.pv -= (cartePerso.getAttaque() > 0 ? cartePerso.getAttaque() : 0);
		}
	}
}
