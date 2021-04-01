package zone;

import carte.CarteJeu;
import carte.CartePerso;
import carte.CarteSort;

public class Terrain {
	private String nom;
	private ZoneTerrainAttaque zoneAttaque;
	private ZoneTerrainDefense zoneDefense;
	private ZoneSort zoneSort1;
	private ZoneSort zoneSort2;
	
	public Terrain(String nom) {
		this.nom = nom;
		this.zoneAttaque = new ZoneTerrainAttaque();
		this.zoneDefense = new ZoneTerrainDefense();
		this.zoneSort1 = new ZoneSort();
		this.zoneSort2 = new ZoneSort();
	}
	
	public boolean isAucunPerso() {
		return this.zoneAttaque.zoneVide() && this.zoneDefense.zoneVide();
	}
	
	
	/** Réinitialise toutes les cartes sur le terrain (== début du tour)
	 */
	public void reinitialiser() {
		System.out.println("Réinitialisation " + this.nom);
		this.zoneAttaque.reinitialisation();

		for (CarteJeu c : this.zoneDefense)
			if (c.getEffet() != null)
				c.getEffet().effetDebutTour();
			else
				c.debutTour();

		for (CarteJeu c : this.zoneSort1)
			if (c.getEffet() != null)
				c.getEffet().effetDebutTour();
			else
				c.debutTour();

		for (CarteJeu c : this.zoneSort2)
			if (c.getEffet() != null)
				c.getEffet().effetDebutTour();
			else
				c.debutTour();
	}
	
	public ZoneTerrainAttaque getZoneAttaque() {
		return this.zoneAttaque;
	}	

	public ZoneTerrainDefense getZoneDefense() {
		return this.zoneDefense;
	}

	public ZoneSort getZoneSort1() {
		return this.zoneSort1;
	}

	public ZoneSort getZoneSort2() {
		return this.zoneSort2;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public static Terrain initTest() {
		Terrain terrain = new Terrain("Terrain de test");
		/*
		CartePerso carteTest = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest2 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest3 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest4 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest5 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest6 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CarteSort carteSort = new CarteSort("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 3);
		CarteSort carteSort2 = new CarteSort("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 3);

		terrain.zoneSort1.poserCarte(carteSort);
		
		terrain.zoneSort2.poserCarte(carteSort2);
		
		//carteTest.repaint();
		
		terrain.zoneDefense.poserCarte(carteTest3);
		terrain.zoneDefense.poserCarte(carteTest);
		terrain.zoneDefense.poserCarte(carteTest2);
		
		
		terrain.zoneAttaque.poserCarte(carteTest4);
		terrain.zoneAttaque.poserCarte(carteTest5);
		terrain.zoneAttaque.poserCarte(carteTest6);*/
		
		return terrain;
	}
}
