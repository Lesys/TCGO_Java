package zone;

import java.util.ArrayList;

import carte.Carte;
import zone.etatZone.EtatZoneDefense;

public class ZoneTerrainDefense extends ZoneTerrain {
	public ZoneTerrainDefense() {
		super(EtatZoneDefense.getInstance());
		this.cartes = new ArrayList<>(3);
	}
	
	public Carte getCarte1() {
		return this.cartes.get(0);
	}

	public Carte getCarte2() {
		return this.cartes.get(1);
	}

	public Carte getCarte3() {
		return this.cartes.get(2);
	}
}
