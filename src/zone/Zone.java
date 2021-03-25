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
	
	@Override
	public Iterator<CarteJeu> iterator() {
		return this.cartes.iterator();
	}
}
