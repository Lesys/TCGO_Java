package view;

import java.awt.event.MouseEvent;

import carte.CarteJeu;
import ensemble.Main;
import zone.Zone;

public class ZoneListener implements IEnsembleListener {
	protected Main main;
	protected Zone zone;
	
	protected WindowPopupCarteView popup;
	
	public ZoneListener(Main main, Zone zone) {
		this.main = main;
		this.zone = zone;

		this.zone.iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.zone.addListener(this);
	}
	
	public void onRemove(CarteJeu carteRemoved) {
		System.out.println("On Remove ZoneListener");
		carteRemoved.removeMouseListener(this);
	}

	public void onAdd(CarteJeu carteAdded) {
		System.out.println("On add ZoneListener");
		carteAdded.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("ZoneListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
