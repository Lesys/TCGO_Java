package zone;

import java.util.*;

import carte.CarteJeu;
import zone.etatZone.EtatZone;

public abstract class Zone implements Iterable<CarteJeu> {
	protected EtatZone etatZone;
	protected List<CarteJeu> cartes;
	
	public Zone(EtatZone etatZone) {
		this.etatZone = etatZone;
	}
	
	protected void poserCarte(CarteJeu carte, int max) {
		if (this.cartes.size() < max)
			this.cartes.add(carte);
		else
			System.out.println("La capacité maximale a été atteinte pour la zone");
	}
	
	@Override
	public Iterator<CarteJeu> iterator() {
		return this.cartes.iterator();
	}
}
