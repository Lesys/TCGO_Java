package ensemble.zone.etatZone;
import carte.Carte;


public abstract class EtatZone {
	protected Carte carte;
	
	public EtatZone (Carte carte) {
		this.carte = carte;;
	}
	public abstract void combattre(Carte cible);
	public abstract void repliquer(Carte cible);
	
	public abstract void setCarte(Carte carte);
	
	public abstract EtatZone getConstructor(Carte carte);
	
	//public EtatZone changerEtatZone();
}
