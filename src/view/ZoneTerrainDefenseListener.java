package view;

import ensemble.Main;
import zone.Terrain;

public class ZoneTerrainDefenseListener extends ZoneTerrainListener {
	public ZoneTerrainDefenseListener(Main main, Terrain terrain) {
		super(main, terrain);

		this.terrain.getZoneDefense().iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.terrain.getZoneDefense().addListener(this);
	}
}
