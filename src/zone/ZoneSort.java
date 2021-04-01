package zone;

import java.util.ArrayList;

import carte.Carte;
import carte.CarteJeu;
import carte.CarteSort;
import zone.etatZone.EtatZoneSort;

public class ZoneSort extends Zone {
	public ZoneSort() {
		super(new EtatZoneSort(null));
		this.cartes = new ArrayList<>(1);
	}
	
	public void poserCarte(CarteSort carte) throws ZonePleineException {
		this.poserCarte(carte);
	}
	
	public Carte getCarte() {
		return this.cartes.get(0);
	}
/*
	public Carte getCarte2() {
		return this.cartes.get(1);
	}*/

	@Override
	public boolean zonePleine() {
		return this.cartes.size() >= 1;
	}

	@Override
	public void poserCarte(CarteJeu carte) throws ZonePleineException {
		super.poserCarte(carte, 1);
		
	}

	@Override
	public void reinitialisation() {
		for (CarteJeu c : this)
			if (c.getEffet() != null)
				c.getEffet().effetDebutTour();
			else
				c.debutTour();
		
	}
}
