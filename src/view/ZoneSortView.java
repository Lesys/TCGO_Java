package view;

import java.awt.GridLayout;

import zone.Zone;

public class ZoneSortView extends ZoneView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5441708166307473785L;

	public ZoneSortView(Zone zone) {
		super(zone);
		
		this.setLayout(new GridLayout(1, 1));

		this.zone.iterator().forEachRemaining(carte -> this.add(carte));
	}
}
