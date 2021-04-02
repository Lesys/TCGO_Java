package ensemble.zone.etatZone;
import carte.Carte;


public class EtatZoneDefense extends EtatZone {
	//private static EtatZoneDefense instance = null;
	
	public EtatZoneDefense(Carte carte) {
		super(carte);
	}
	
	/*public static EtatZoneDefense getInstance() {
		if (EtatZoneDefense.instance == null)
			EtatZoneDefense.instance = new EtatZoneDefense();
		
		return EtatZoneDefense.instance;
	}*/
	
	@Override
	public void combattre(Carte cible) {
		// Ne fait rien car en défense, ne peut normalement pas attaquer
	}

	@Override
	public void repliquer(Carte cible) {
		System.err.println("Replique de la défense");
		// Ne peut pas répliquer (normalement)
	}
	
	public void setCarte(Carte carte) {
		this.carte = carte;
	}
	
	/*@Override
	public EtatZone changerEtatZone() {
		return EtatZoneAttaque.getInstance();
	}*/

	@Override
	public EtatZone getConstructor(Carte carte) {
		return new EtatZoneDefense(carte);
	}
}
