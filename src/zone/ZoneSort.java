package zone;

import java.util.ArrayList;

import carte.Carte;
import carte.CartePerso;
import carte.CarteSort;
import zone.etatZone.EtatZoneSort;

public class ZoneSort extends Zone {
	public ZoneSort() {
		super(EtatZoneSort.getInstance());
		this.cartes = new ArrayList<>(1);
	}
	
	public void poserCarte(CarteSort carte) {
		super.poserCarte(carte, 1);
	}
	
	public Carte getCarte() {
		return this.cartes.get(0);
	}
/*
	public Carte getCarte2() {
		return this.cartes.get(1);
	}*/
}
