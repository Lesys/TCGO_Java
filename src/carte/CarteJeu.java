package carte;
import zone.etatZone.EtatZone;

import java.awt.event.MouseEvent;

import effet.StrategieEffet;


public abstract class CarteJeu extends Carte {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1240026014212003112L;
	
	protected int cout;
	protected int coutInit;
	
	protected EtatZone etatZone;

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
	public EtatZone getEtatZone() {
		return this.etatZone;
	}

	/** Accesseur (setter) sur la zone
	 * 
	 * @param zone		La nouvelle zone
	 */
	public void setEtatZone(EtatZone etatZone) {
		this.etatZone = etatZone;
		this.etatZone.setCarte(this);
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

	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		System.out.println("Dans CarteJeu: " + e.getSource());
	}
}
