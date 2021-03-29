package zone;

import java.util.ArrayList;

import carte.Carte;
import zone.etatZone.EtatZoneAttaque;

public class ZoneTerrainAttaque extends ZoneTerrain {
	public ZoneTerrainAttaque() {
		super(EtatZoneAttaque.getInstance());
		this.cartes = new ArrayList<>(3);
	}
	
	/** Retourne la carte de la liste en position 1 (la position influe sur celle du terrain)
	 * 
	 * @return La première carte de la liste (peut être null)
	 */
	public Carte getCarte1() {
		return this.cartes.get(0);
	}

	/** Retourne la carte de la liste en position 2 (la position influe sur celle du terrain)
	 * 
	 * @return La deuxième carte de la liste (peut être null)
	 */
	public Carte getCarte2() {
		return this.cartes.get(1);
	}

	/** Retourne la carte de la liste en position 3 (la position influe sur celle du terrain)
	 * 
	 * @return La troisième carte de la liste (peut être null)
	 */
	public Carte getCarte3() {
		return this.cartes.get(2);
	}
	
	public void combattre(Carte carte) {
		
	}
}
