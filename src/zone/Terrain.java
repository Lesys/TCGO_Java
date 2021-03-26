package zone;

import carte.CarteJeu;
import carte.CartePerso;
import carte.CarteSort;

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
		
		this.initTest();
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
	
	public ZoneTerrain getZoneAttaque() {
		return this.zoneAttaque;
	}	

	public ZoneTerrain getZoneDefense() {
		return this.zoneDefense;
	}

	public ZoneSort getZoneSort1() {
		return this.zoneSort1;
	}

	public ZoneSort getZoneSort2() {
		return this.zoneSort2;
	}
	
	private void initTest() {
		CartePerso carteTest = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest2 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest3 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest4 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest5 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest6 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CarteSort carteSort = new CarteSort("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 3);

		this.zoneSort1.poserCarte(carteSort);
		
		this.zoneSort2.poserCarte(carteSort);
		
		//carteTest.repaint();
		
		this.zoneDefense.poserCarte(carteTest3);
		this.zoneDefense.poserCarte(carteTest);
		this.zoneDefense.poserCarte(carteTest2);
		
		
		this.zoneAttaque.poserCarte(carteTest4);
		this.zoneAttaque.poserCarte(carteTest5);
		this.zoneAttaque.poserCarte(carteTest6);
	}
}
