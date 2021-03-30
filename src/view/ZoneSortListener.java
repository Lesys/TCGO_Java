package view;

import java.awt.event.MouseEvent;

import ensemble.Main;
import zone.ZoneSort;

public class ZoneSortListener extends ZoneListener {
	protected Main main;
	protected ZoneSort zoneSort;
	
	protected WindowPopupCarteView popup;
	
	public ZoneSortListener(Main main, ZoneSort zoneSort) {
		super(main, zoneSort);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("ZoneSortListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso
	}
}
