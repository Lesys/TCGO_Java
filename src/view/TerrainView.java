package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import carte.CartePerso;
import carte.CarteSort;
import zone.Terrain;
import zone.ZoneSort;
import zone.ZoneTerrain;
import zone.ZoneTerrainAttaque;
import zone.ZoneTerrainDefense;

public class TerrainView extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7395642929409139510L;
	private Terrain terrain;
	
	private ZoneTerrainView zoneAttaque;
	private ZoneTerrainView zoneDefense;
	private ZoneSortView zoneSort1;
	private ZoneSortView zoneSort2;
	
	public TerrainView(String nomTerrain, boolean reverse) {
		this.terrain = new Terrain(nomTerrain);
		this.zoneSort1 = new ZoneSortView(this.terrain.getZoneSort1());
		this.zoneSort2 = new ZoneSortView(this.terrain.getZoneSort2());
		this.zoneDefense = new ZoneTerrainView(this.terrain.getZoneDefense());
		this.zoneAttaque = new ZoneTerrainView(this.terrain.getZoneAttaque());

		this.setLayout(new GridLayout(2, 2));
		
		if (reverse) {
			// ZONE DEFENSE - ZONE SORT 2
			// ZONE ATTAQUE - ZONE SORT 1
			//this.setLayout(new BorderLayout());
			
			this.add(this.zoneAttaque);
			this.add(this.zoneSort2);
			this.add(this.zoneDefense);
			this.add(this.zoneSort1);
		}
		else {
			// ZONE SORT 1 - ZONE ATTAQUE
			// ZONE SORT 2 - ZONE DEFENSE
			
			this.add(this.zoneSort1);
			this.add(this.zoneDefense);			
			this.add(this.zoneSort2);
			this.add(this.zoneAttaque);
		}
	}
}
