package view;

import java.awt.GridLayout;

import javax.swing.JPanel;

import carte.CartePerso;
import ensemble.Main;

public class MainView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6313156717813295316L;

	private Main main;
	
	public MainView(Main main) {
		this.main = main;
		//this.testMainView();
		
		this.setLayout(new GridLayout(1, this.main.size()));
		
		this.main.iterator().forEachRemaining(carte -> this.add(carte));
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
}
