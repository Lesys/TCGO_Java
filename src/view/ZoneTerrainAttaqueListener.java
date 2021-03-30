package view;

import ensemble.Main;
import zone.Terrain;

public class ZoneTerrainAttaqueListener extends ZoneTerrainListener {
	public ZoneTerrainAttaqueListener(Main main, Terrain terrain) {
		super(main, terrain);
		
		this.terrain.getZoneAttaque().iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.terrain.getZoneAttaque().addListener(this);
	}
}
