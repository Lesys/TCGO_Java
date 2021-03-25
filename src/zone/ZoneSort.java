package zone;

import java.util.ArrayList;

import carte.Carte;
import zone.etatZone.EtatZoneSort;

public class ZoneSort extends Zone {
	public ZoneSort() {
		super(EtatZoneSort.getInstance());
		this.cartes = new ArrayList<>(2);
	}

	public Carte getCarte1() {
		return this.cartes.get(0);
	}

	public Carte getCarte2() {
		return this.cartes.get(1);
	}
}
