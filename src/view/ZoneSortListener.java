package view;

import java.awt.event.MouseEvent;

import ensemble.Main;
import joueur.Joueur;
import zone.ZoneSort;

public class ZoneSortListener extends ZoneListener {
	protected Main main;
	protected ZoneSort zoneSort;
	
	protected WindowPopupCarteView popup;
	
	public ZoneSortListener(Main main, ZoneSort zoneSort, Joueur joueur) {
		super(main, zoneSort, joueur);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("ZoneSortListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso
	}
}
