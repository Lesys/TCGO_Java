package zone;

import carte.Carte;
import zone.etatZone.EtatZone;

public abstract class ZoneTerrain extends Zone {

	public ZoneTerrain(EtatZone etatZone) {
		super(etatZone);
	}

	public void combattre(Carte carte) {
		// Demande à l'effet s'il peut combattre
		//if (carte.getEffet().peutAttaquer())
			// Attaque avec l'effet (s'il y en a un)
			carte.getEffet().effetCombatAttaquant(carte);
	}
	
	public void changerEtatZone() {
		this.etatZone = this.etatZone.changerEtatZone();
	}
}
