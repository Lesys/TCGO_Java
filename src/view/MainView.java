package view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import carte.CarteJeu;
import ensemble.Main;

public class MainView extends DefaultView implements IMainListener {

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
	
	public void onRemove(CarteJeu carteRemoved) {
		this.remove(carteRemoved);

		this.refresh();
	}

	public void onAdd(CarteJeu carteAdded) {
		this.add(carteAdded);
		
		this.refresh();
	}
	
	public void refresh() {
		this.revalidate();
		this.repaint();
	}
}
