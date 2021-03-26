package zone;

import carte.CarteJeu;

public class Terrain {
	private String nom;
	private ZoneTerrain zoneAttaque;
	private ZoneTerrain zoneDefense;
	private ZoneSort zoneSort1;
	private ZoneSort zoneSort2;
	
	public Terrain(String nom) {
		this.nom = nom;
		this.zoneAttaque = new ZoneTerrainAttaque();
		this.zoneDefense = new ZoneTerrainDefense();
		this.zoneSort1 = new ZoneSort();
		this.zoneSort2 = new ZoneSort();
	}
	
	/** Réinitialise toutes les cartes sur le terrain (== début du tour)
	 */
	public void reinitialiser() {
		System.out.println("Réinitialisation " + this.nom);
		for (CarteJeu c : this.zoneAttaque)
			c.getEffet().effetDebutTour();

		for (CarteJeu c : this.zoneDefense)
			c.getEffet().effetDebutTour();

		for (CarteJeu c : this.zoneSort1)
			c.getEffet().effetDebutTour();

		for (CarteJeu c : this.zoneSort2)
			c.getEffet().effetDebutTour();
	}
}
