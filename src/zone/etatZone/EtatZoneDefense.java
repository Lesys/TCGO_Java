package zone.etatZone;
import carte.Carte;


public class EtatZoneDefense implements EtatZone {
	private Carte carte;
	
	private static EtatZoneDefense instance = null;
	
	private EtatZoneDefense() {
		
	}
	
	public static EtatZoneDefense getInstance() {
		if (EtatZoneDefense.instance == null)
			EtatZoneDefense.instance = new EtatZoneDefense();
		
		return EtatZoneDefense.instance;
	}
	
	@Override
	public void combattre(Carte cible) {
		// Ne fait rien car en défense, ne peut normalement pas attaquer
	}
	
	@Override
	public EtatZone changerEtatZone() {
		return EtatZoneAttaque.getInstance();
	}
}
