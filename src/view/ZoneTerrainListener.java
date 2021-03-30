package view;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Optional;

import javax.swing.SwingUtilities;

import carte.CarteJeu;
import carte.CartePerso;
import carte.CarteSort;
import ensemble.Main;
import zone.Terrain;

public class ZoneTerrainListener implements IEnsembleListener {
	protected Main main;
	protected Terrain terrain;
	
	protected WindowPopupCarteView popup;
	
	public ZoneTerrainListener(Main main, Terrain terrain) {
		this.main = main;
		this.terrain = terrain;

		/*this.terrain.getZoneAttaque().iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.terrain.getZoneAttaque().addListener(this);

		this.terrain.getZoneDefense().iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.terrain.getZoneDefense().addListener(this);*/

		/*
		this.terrain.getZoneSort1().iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.terrain.getZoneSort1().addListener(this);

		this.terrain.getZoneSort2().iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.terrain.getZoneSort2().addListener(this);*/
	}
	
	public void onRemove(CarteJeu carteRemoved) {
		carteRemoved.removeMouseListener(this);
	}

	public void onAdd(CarteJeu carteAdded) {
		carteAdded.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("ZoneTerrainListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso
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
