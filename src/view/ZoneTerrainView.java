package view;

import java.awt.GridLayout;

import carte.CarteJeu;
import zone.ZoneTerrain;

public class ZoneTerrainView extends ZoneView implements IEnsembleListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2275188826918066957L;

	public ZoneTerrainView(ZoneTerrain zone) {
		super(zone);
		
		this.setLayout(new GridLayout(1, 3));
		
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
	
	//TODO Ajouter comme les autres view pour rafraîchir + un listener
}
