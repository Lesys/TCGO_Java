package zone;

import carte.Carte;
import carte.CarteJeu;
import carte.CartePerso;
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

	
	public void poserCarte(CartePerso carte) throws ZonePleineException {
		this.poserCarte(carte);
	
		//System.out.println("Cartes: " + this.cartes.size());
	}
	
	public void changerEtatZone() {
		//this.etatZone = this.etatZone.changerEtatZone();
	}
	/*
	private void initInterfaceZone() {
		this.interfaceZone = new JPanel();
		this.interfaceZone.setLayout(new GridLayout(1, 3));
	}*/
	
	@Override
	public boolean zonePleine() {
		return this.cartes.size() >= 3;
	}

	@Override
	public void poserCarte(CarteJeu carte) throws ZonePleineException {
		super.poserCarte(carte, 3);
		
	}
}
