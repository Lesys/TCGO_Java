package view;

import java.awt.GridLayout;

import zone.ZoneTerrain;

public class ZoneTerrainView extends ZoneView {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2275188826918066957L;

	public ZoneTerrainView(ZoneTerrain zone) {
		super(zone);
		
		this.setLayout(new GridLayout(1, 3));
		
		this.zone.iterator().forEachRemaining(carte -> this.add(carte));
	}
}
