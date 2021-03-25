package zone.etatZone;
import carte.Carte;


public interface EtatZone {
	public void combattre(Carte cible);
	
	public EtatZone changerEtatZone();
}
