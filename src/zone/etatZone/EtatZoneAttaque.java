package zone.etatZone;
import carte.Carte;
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
	
	/*@Override
	public EtatZone changerEtatZone() {
		return EtatZoneDefense.getInstance();
	}*/
}
