package view;

import java.awt.GridLayout;

import carte.CarteJeu;
import ensemble.Main;

public class MainView extends DefaultView implements IEnsembleListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6313156717813295316L;

	private Main main;
	
	public MainView(Main main) {
		this.main = main;
		//this.testMainView();
		
		this.setLayout(new GridLayout(1, this.main.size()));
		
		this.main.iterator().forEachRemaining(carte -> { this.add(carte); });
		this.main.addListener(this);
		
		
		//this.addMouseListener(this);
	}
	/*
	private void testMainView() {
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
		this.main.ajouterCarte(CartePerso.creationCarteTest());
	}*/

	@Override
	public void onRemove(CarteJeu carteRemoved) { // Des cartes disparaissent lorsqu'on en enlève certaines (et parfois réapparaissent après un refresh...)
		this.remove(carteRemoved);

		this.refresh();
	}

	@Override
	public void onAdd(CarteJeu carteAdded) {
		this.add(carteAdded);
		
		this.refresh();
	}
}
