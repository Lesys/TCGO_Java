package zone.etatZone;
import carte.Carte;


public class EtatZoneAttaque implements EtatZone {
	private Carte carte;

	private static EtatZoneAttaque instance = null;
	
	private EtatZoneAttaque() {
		
	}
	
	public static EtatZoneAttaque getInstance() {
		if (EtatZoneAttaque.instance == null)
			EtatZoneAttaque.instance = new EtatZoneAttaque();
		
		return EtatZoneAttaque.instance;
	}
	
	@Override
	public void combattre(Carte cible) {
		
	}
	
	@Override
	public EtatZone changerEtatZone() {
		return EtatZoneDefense.getInstance();
	}
}
