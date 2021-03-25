package zone;

import java.util.ArrayList;

import carte.Carte;
import zone.etatZone.EtatZoneAttaque;

public class ZoneTerrainAttaque extends ZoneTerrain {
	public ZoneTerrainAttaque() {
		super(EtatZoneAttaque.getInstance());
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
	
	public void combattre(Carte carte) {
		
	}
}
