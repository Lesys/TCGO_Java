package view;

import java.awt.GridLayout;

import zone.Zone;
import zone.ZoneSort;

public class ZoneSortView extends ZoneView {
	public ZoneSortView(Zone zone) {
		super(zone);
		
		this.setLayout(new GridLayout(1, 1));

		this.zone.iterator().forEachRemaining(carte -> this.add(carte));
	}
}
