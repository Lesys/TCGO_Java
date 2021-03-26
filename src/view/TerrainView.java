package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.TextField;

import javax.swing.JPanel;

import carte.CartePerso;
import carte.CarteSort;
import zone.ZoneSort;
import zone.ZoneTerrain;
import zone.ZoneTerrainAttaque;
import zone.ZoneTerrainDefense;

public class TerrainView extends JPanel{
	private ZoneTerrainView zoneAttaque;
	private ZoneTerrainView zoneDefense;
	private ZoneSortView zoneSort1;
	private ZoneSortView zoneSort2;
	
	public TerrainView(boolean reverse) {
		if (reverse) {
			// ZONE DEFENSE - ZONE SORT 2
			// ZONE ATTAQUE - ZONE SORT 1
			this.setLayout(new GridLayout(2, 2));
			//this.setLayout(new BorderLayout());
			CartePerso carteTest = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest2 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest3 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest4 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest5 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest6 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
			CarteSort carteSort = new CarteSort("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 3);

			ZoneSort zoneSort1 = new ZoneSort();
			zoneSort1.poserCarte(carteSort);
			this.zoneSort1 = new ZoneSortView(zoneSort1);
			
			ZoneSort zoneSort2 = new ZoneSort();
			zoneSort2.poserCarte(carteSort);
			this.zoneSort2 = new ZoneSortView(zoneSort2);
			
			//carteTest.repaint();
			
			ZoneTerrain zoneTerrainDefense = new ZoneTerrainDefense();
			zoneTerrainDefense.poserCarte(carteTest3);
			zoneTerrainDefense.poserCarte(carteTest);
			zoneTerrainDefense.poserCarte(carteTest2);
			this.zoneDefense = new ZoneTerrainView(zoneTerrainDefense);
			
			
			ZoneTerrain zoneTerrainAttaque = new ZoneTerrainAttaque();
			zoneTerrainAttaque.poserCarte(carteTest4);
			zoneTerrainAttaque.poserCarte(carteTest5);
			zoneTerrainAttaque.poserCarte(carteTest6);
			this.zoneAttaque = new ZoneTerrainView(zoneTerrainAttaque);
			
			this.add(this.zoneAttaque);
			this.add(this.zoneSort2);
			this.add(this.zoneDefense);
			this.add(this.zoneSort1);
		}
		else {
			// ZONE SORT 1 - ZONE ATTAQUE
			// ZONE SORT 2 - ZONE DEFENSE
			this.setLayout(new GridLayout(2, 2));
			//this.setLayout(new BorderLayout());
			CartePerso carteTest = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest2 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
			CartePerso carteTest3 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
			CarteSort carteSort = new CarteSort("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 3);

			ZoneSort zoneSort1 = new ZoneSort();
			zoneSort1.poserCarte(carteSort);
			this.zoneSort1 = new ZoneSortView(zoneSort1);
			
			ZoneSort zoneSort2 = new ZoneSort();
			zoneSort2.poserCarte(carteSort);
			this.zoneSort2 = new ZoneSortView(zoneSort2);
			
			this.add(this.zoneSort1);
			//carteTest.repaint();
			
			ZoneTerrain zoneTerrainDefense = new ZoneTerrainDefense();
			zoneTerrainDefense.poserCarte(carteTest3);
			zoneTerrainDefense.poserCarte(carteTest);
			zoneTerrainDefense.poserCarte(carteTest2);
			this.zoneDefense = new ZoneTerrainView(zoneTerrainDefense);
			this.add(this.zoneDefense);
			
			this.add(this.zoneSort2);
			
			
			ZoneTerrain zoneTerrainAttaque = new ZoneTerrainAttaque();
			zoneTerrainAttaque.poserCarte(carteTest);
			zoneTerrainAttaque.poserCarte(carteTest2);
			zoneTerrainAttaque.poserCarte(carteTest3);
			this.zoneAttaque = new ZoneTerrainView(zoneTerrainAttaque);
			this.add(this.zoneAttaque);
		}
	}
}
