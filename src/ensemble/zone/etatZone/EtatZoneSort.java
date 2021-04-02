package ensemble.zone.etatZone;

import carte.Carte;

public class EtatZoneSort extends EtatZone {
	//private static EtatZoneSort instance = null;
	
	public EtatZoneSort(Carte carte) {
		super(carte);
	}
	
	/*public static EtatZoneSort getInstance() {
		if (EtatZoneSort.instance == null)
			EtatZoneSort.instance = new EtatZoneSort();
		
		return EtatZoneSort.instance;
	}*/
	
	@Override
	public void combattre(Carte cible) {
		// Ne fait rien car carte sort (normalement)
	}

	@Override
	public void repliquer(Carte cible) {
		// Ne fait rien car carte sort (normalement)
	}
	
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	/*@Override
	public EtatZone changerEtatZone() {
		// Ne change pas l'état zone
		return EtatZoneSort.getInstance();
	}*/

	@Override
	public EtatZone getConstructor(Carte carte) {
		return new EtatZoneSort(carte);
	}
}
