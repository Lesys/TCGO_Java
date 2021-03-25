package zone.etatZone;

import carte.Carte;

public class EtatZoneSort implements EtatZone {
	private Carte carte;
	
	private static EtatZoneSort instance = null;
	
	private EtatZoneSort() {
		
	}
	
	public static EtatZoneSort getInstance() {
		if (EtatZoneSort.instance == null)
			EtatZoneSort.instance = new EtatZoneSort();
		
		return EtatZoneSort.instance;
	}
	
	@Override
	public void combattre(Carte cible) {
		// Ne fait rien car en défense, ne peut normalement pas attaquer
	}
	
	@Override
	public EtatZone changerEtatZone() {
		// Ne change pas l'état zone
		return EtatZoneSort.getInstance();
	}
}
