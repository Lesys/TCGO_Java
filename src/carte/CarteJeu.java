package carte;
import zone.ZoneTerrain;
import effet.StrategieEffet;


public abstract class CarteJeu extends Carte {
	protected int cout;
	protected int coutInit;
	
	protected ZoneTerrain zone;

	/** Constructeur par défaut initialisant les paramètres basiques d'une carte 
	 * 
	 * @param reference		La référence (ALPHABET + NUMERIQUE) de la carte
	 * @param nom			Le nom de la carte
	 * @param anime			L'animé d'où provient la carte
	 * @param effet			L'effet (Stratégie) de la carte
	 * @param nbExemplaire	Le nombre d'exemplaire maximum de cette carte dans un deck
	 * @param cout			Le coût initial de la carte
	 */
	public CarteJeu(String reference, String nom, String anime, StrategieEffet effet, int nbExemplaire, int cout) {
		super(reference, nom, anime, effet, nbExemplaire);
		this.cout = this.coutInit = cout;
	}
	
	/** Accesseur (getter) sur le coût
	 * 
	 * @return	Le coût actuel de cette carte
	 */
	public int getCout() {
		return this.cout;
	}
	/** Accesseur (getter) sur l'état de la zone
	 * 
	 * @return	L'état de la zone
	 */
	public ZoneTerrain getZone() {
		return this.zone;
	}

	/** Accesseur (setter) sur la zone
	 * 
	 * @param zone		La nouvelle zone
	 */
	public void setZone(ZoneTerrain zone) {
		this.zone = zone;
	}
	
	@Override
	public void reinitialisation() {
		//super.reinitialisation();
		this.cout = this.coutInit;
	}
	
	public abstract void combattre(Carte c);
	
	@Override
	public String toString() {
		return super.toString() + "";
	}
}
