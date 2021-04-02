package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import ensemble.zone.Terrain;
public class TerrainView extends DefaultView {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7395642929409139510L;
	private Terrain terrain;
	
	private ZoneTerrainView zoneAttaque;
	private ZoneTerrainView zoneDefense;
	private ZoneSortView zoneSort1;
	private ZoneSortView zoneSort2;
	
	public TerrainView(Terrain terrain, boolean reverse) {
		this.terrain = terrain;
		this.zoneSort1 = new ZoneSortView(this.terrain.getZoneSort1());
		this.zoneSort2 = new ZoneSortView(this.terrain.getZoneSort2());
		this.zoneDefense = new ZoneTerrainView(this.terrain.getZoneDefense());
		this.zoneAttaque = new ZoneTerrainView(this.terrain.getZoneAttaque());

		JPanel zoneSort1View = new JPanel(new BorderLayout());
		zoneSort1View.add(this.zoneSort1, BorderLayout.CENTER);
		zoneSort1View.add(new JLabel("Zone Sort 1"), BorderLayout.NORTH);

		JPanel zoneSort2View = new JPanel(new BorderLayout());
		zoneSort2View.add(this.zoneSort2, BorderLayout.CENTER);
		zoneSort2View.add(new JLabel("Zone Sort 2"), BorderLayout.NORTH);

		JPanel zoneAttaqueView = new JPanel(new BorderLayout());
		zoneAttaqueView.add(this.zoneAttaque, BorderLayout.CENTER);/*
		JPanel zoneAttaqueViewLabels = new JPanel(new GridLayout(1, 3));
		zoneAttaqueViewLabels.add(new JLabel("ATQ 1"));
		zoneAttaqueViewLabels.add(new JLabel("ATQ 2"));
		zoneAttaqueViewLabels.add(new JLabel("ATQ 3"));
		zoneAttaqueView.add(zoneAttaqueViewLabels, BorderLayout.NORTH);*/

		JPanel zoneDefenseView = new JPanel(new BorderLayout());
		zoneDefenseView.add(this.zoneDefense, BorderLayout.CENTER);/*
		JPanel zoneDefenseViewLabels = new JPanel(new GridLayout(1, 3));
		zoneDefenseViewLabels.add(new JLabel("DEF 1"));
		zoneDefenseViewLabels.add(new JLabel("DEF 2"));
		zoneDefenseViewLabels.add(new JLabel("DEF 3"));
		zoneDefenseView.add(zoneDefenseViewLabels, BorderLayout.NORTH);*/
		
		this.setLayout(new GridLayout(2, 2));
		
		if (reverse) {
			// ZONE DEFENSE - ZONE SORT 2
			// ZONE ATTAQUE - ZONE SORT 1
			//this.setLayout(new BorderLayout());

			/*this.add(this.zoneSort1);
			this.add(this.zoneAttaque);
			this.add(this.zoneSort2);
			this.add(this.zoneDefense);*/
			this.add(zoneSort1View);
			this.add(zoneAttaqueView);
			this.add(zoneSort2View);
			this.add(zoneDefenseView);
		}
		else {
			// ZONE SORT 1 - ZONE ATTAQUE
			// ZONE SORT 2 - ZONE DEFENSE
			
			/*this.add(this.zoneDefense);		
			this.add(this.zoneSort2);	
			this.add(this.zoneAttaque);
			this.add(this.zoneSort1);*/

			this.add(zoneDefenseView);
			this.add(zoneSort2View);
			this.add(zoneAttaqueView);
			this.add(zoneSort1View);
		}
	}
	
	public ZoneTerrainView getZoneAttaque() {
		return this.zoneAttaque;
	}

	
	public ZoneTerrainView getZoneDefense() {
		return this.zoneDefense;
	}

	
	public ZoneSortView getZoneSort1() {
		return this.zoneSort1;
	}

	
	public ZoneSortView getZoneSort2() {
		return this.zoneSort2;
	}
}
