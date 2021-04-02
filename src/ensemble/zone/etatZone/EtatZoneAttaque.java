package ensemble.zone.etatZone;
import carte.Carte;
import carte.CarteHeros;
import carte.CartePerso;


public class EtatZoneAttaque extends EtatZone {
	//private static EtatZoneAttaque instance = null;
	
	public EtatZoneAttaque(Carte carte) {
		super(carte);
	}
	
	/*public static EtatZoneAttaque getInstance() {
		if (EtatZoneAttaque.instance == null)
			EtatZoneAttaque.instance = new EtatZoneAttaque();
		
		return EtatZoneAttaque.instance;
	}*/

	@Override
	public void combattre(Carte cible) {
		// Pour le moment, combats sans effets
		System.out.println("Combat de la carte " + this.carte + " contre " + cible.infosToString());
		this.carte.lancerAttaque(cible);
		
		if (cible instanceof CartePerso) {
			((CartePerso)cible).getEtatZone().repliquer(this.carte);
		}
		
		this.checkIfDestroyed(cible);
	}

	@Override
	public void repliquer(Carte cible) {
		// L'attaque n'est pas lancée, c'est une simple reflection de dégâts (pas d'effet à appliquer normalement)
		cible.subirAttaque(this.carte);
	}
	
	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	@Override
	public EtatZone getConstructor(Carte carte) {
		return new EtatZoneAttaque(carte);
	}
	
	private void checkIfDestroyed(Carte cible) {
		if (cible instanceof CartePerso && ((CartePerso)cible).getPv() <= 0) {
			((CartePerso)cible).isDestroyed();
		}
		else if (cible instanceof CarteHeros && ((CarteHeros)cible).getPv() <= 0) {
			((CarteHeros)cible).isDestroyed();
		}

		if (this.carte instanceof CartePerso && ((CartePerso)this.carte).getPv() <= 0) {
			((CartePerso)this.carte).isDestroyed();
		}
		else if (this.carte instanceof CarteHeros && ((CarteHeros)this.carte).getPv() <= 0) {
			((CarteHeros)this.carte).isDestroyed();
		}
	}
	
	/*@Override
	public EtatZone changerEtatZone() {
		return EtatZoneDefense.getInstance();
	}*/
}
