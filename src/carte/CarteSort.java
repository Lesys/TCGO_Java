package carte;
import effet.StrategieEffet;


public class CarteSort extends CarteJeu {
	/** Constructeur par défaut initialisant les paramètres basiques d'une carte 
	 * 
	 * @param reference		La référence (ALPHABET + NUMERIQUE) de la carte
	 * @param nom			Le nom de la carte
	 * @param anime			L'animé d'où provient la carte
	 * @param effet			L'effet (Stratégie) de la carte
	 * @param nbExemplaire	Le nombre d'exemplaire maximum de cette carte dans un deck
	 * @param cout			Le coût initial de la carte
	 */
	public CarteSort(String reference, String nom, String anime, StrategieEffet effet, int nbExemplaire, int cout) {
		super(reference, nom, anime, effet, nbExemplaire, cout);
	}

	@Override
	public void reinitialisation() {
		//super.reinitialisation();
		this.cout = this.coutInit;
	}
	
	@Override
	public void combattre(Carte c) {
		// Une carte sort ne combat pas (normalement)
	}

	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public String toStringSave() {
		return this.reference + ";" + this.nbExemplaire + ";Sort;" + this.nom + ";" + this.anime
			+ ";" + "X;X;" + this.cout + ";" + this.effet;
	}

	@Override
	public void lancerAttaque(Carte carte) {
		// Rien
		
	}

	@Override
	public void subirAttaque(Carte carte) {
		// Rien
		
	}
}
