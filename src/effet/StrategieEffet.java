package effet;
import ensemble.zone.ZoneTerrainAttaque;
import ensemble.zone.etatZone.EtatZoneAttaque;
import carte.Carte;
import carte.CarteJeu;
import carte.CartePerso;


public abstract class StrategieEffet {
	protected Carte carte;
	
	public StrategieEffet(Carte carte) {
		this.carte = carte;
	}
	
	public void effetPioche() {
		
	}
	
	public void effetDebutTour() {
		
	}
	
	public void effetPassif() {
		
	}
	
	public void effetPose() {
		
	}

	public void effetCombatAttaquant(Carte cible) {
		if (this.carte instanceof CarteJeu && this.peutAttaquer()) {
			//((CarteJeu)this.carte).getZone().combattre(cible);
		}
	}
	
	public void effetCombatCible(Carte attaquant) {
	}

	public void effetQuitteTerrain() {
		
	}
	
	public void effetDetruite() {
		this.effetQuitteTerrain();
	}
	
	public void effetBannie() {
		this.effetQuitteTerrain();		
	}
	
	public boolean possedeEffetActif() {
		return false;
	}
	
	public void effetActivation() {
		
	}

	/** Permet de savoir si cette carte peut attaquer suivant son effet
	 * 
	 * @return	Vrai si cette carte peut attaquer, faux sinon
	 */
	public boolean peutAttaquer() {
		boolean attaque = false;
		// Normalement, ne peut attaquer que si en zone d'attaque
		if (this.carte instanceof CarteJeu)
			attaque = ((CarteJeu)this.carte).getEtatZone() instanceof EtatZoneAttaque;
		
		return attaque;
	}
	
	//public void activer();
}
