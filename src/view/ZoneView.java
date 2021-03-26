package view;

import javax.swing.JPanel;

import zone.Zone;

public class ZoneView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4956876823561957017L;
	
	protected Zone zone;
	
	public ZoneView(Zone zone) {
		this.zone = zone;
	}
}
