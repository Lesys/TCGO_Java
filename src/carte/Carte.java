package carte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventListener;
import java.util.List;

import javax.swing.SwingUtilities;

import effet.StrategieEffet;
import images.ImagePanel;
import view.IEnsembleListener;
import view.WindowPopupCarteView;


public abstract class Carte extends ImagePanel implements Cloneable, MouseListener {
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
		
		this.addMouseListener(this);
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
	
	public abstract Carte getCopy() ;
	
	public abstract void reinitialisation();
	
	public abstract void debutTour();
	
	@Override
	public boolean equals(Object o) {
		boolean retour = false;
		
		if (o instanceof Carte) {
			Carte c = (Carte)o;
			retour = this.reference.equals(c.reference) &&
					this.nom.equals(c.nom) &&
					this.anime.equals(c.anime) &&
					((this.effet == null && c.effet == null) || (this.effet != null && c.effet != null && this.effet.equals(c.effet))) &&
					this.nbExemplaire == c.nbExemplaire;
		}
		
		return retour;
	}
	
	public abstract void lancerAttaque(Carte carte);
	
	public abstract void subirAttaque(Carte carte);

	/** Permet de convertir la carte en chaîne de caractères qui sera sauvegardée dans un fichier texte
	 * 
	 * @return		La chaîne de caractères représentant la carte
	 */
	public abstract String toStringSave();
	
	public String infosToString() {
		return this.nom;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof CarteJeu) {
			CarteJeu carte = (CarteJeu)e.getSource();

			if (SwingUtilities.isMiddleMouseButton(e)) {
				WindowPopupCarteView popup = new WindowPopupCarteView(new ImagePanel(this.reference));
				popup.setVisible(true);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/** Événement à lancer quand la carte est détruite
	 */
	public void isDestroyed() {
		System.err.println("La carte " + this.getClass() + " doit être détruite");
		System.err.println("Nombre de listeners: " + this.getMouseListeners().length);
	}
}
