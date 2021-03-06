package view;

import java.awt.GridLayout;

import javax.swing.JOptionPane;

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
		
		this.setLayout(new GridLayout());
		
		this.main.iterator().forEachRemaining(carte -> { this.add(carte); }); // Ajoute toutes les cartes actuelles dans la View
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

	@Override
	public void onDestroy(CarteJeu carteDestroyed) {
		this.onRemove(carteDestroyed);
	}
}
