package view;

import java.awt.GridLayout;

import carte.CarteJeu;
import zone.Zone;

public class ZoneSortView extends ZoneView implements IEnsembleListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5441708166307473785L;

	public ZoneSortView(Zone zone) {
		super(zone);
		
		this.setLayout(new GridLayout(1, 1));

		this.zone.iterator().forEachRemaining(carte -> this.add(carte));
		
		this.zone.addListener(this);
	}

	@Override
	public void onRemove(CarteJeu carteRemoved) {
		carteRemoved.removeMouseListener(this);

		this.remove(carteRemoved);
		
		this.refresh();
	}

	@Override
	public void onAdd(CarteJeu carteAdded) {
		carteAdded.addMouseListener(this);

		this.add(carteAdded);

		this.refresh();
	}
}
