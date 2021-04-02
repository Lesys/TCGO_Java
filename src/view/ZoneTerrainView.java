package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import carte.CarteJeu;
import ensemble.zone.ZoneTerrain;
import images.ImagePanel;

public class ZoneTerrainView extends ZoneView implements IEnsembleListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2275188826918066957L;

	public ZoneTerrainView(ZoneTerrain zone) {
		super(zone);
		GridLayout layout = new GridLayout(1, 3);
		layout.setHgap(15);
		this.setLayout(layout);
			/*
		this.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		
		for (int i = 0; i < 3; i++) {
			ImagePanel image = new ImagePanel("johan_card_verso.png");
			image.setVisible(true);
			this.add(image);
		    image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}*/
		//this.setLayout(new GridBagLayout());
		
		this.zone.iterator().forEachRemaining(carte -> this.add(carte));
		
		this.zone.addListener(this);
	}


	@Override
	public void onRemove(CarteJeu carteRemoved) {
		this.remove(carteRemoved);

		System.out.println("On remove ZoneTerrainView");
		
		this.refresh();
	}

	@Override
	public void onAdd(CarteJeu carteAdded) {
		this.add(carteAdded);

		System.out.println("On add ZoneTerrainView");

		this.refresh();
	}

	@Override
	public void onDestroy(CarteJeu carteDestroyed) {
		System.err.println("Destroying in terrain");
		this.onRemove(carteDestroyed);
	}
	
	//TODO Ajouter comme les autres view pour rafraîchir + un listener
}
