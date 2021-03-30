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
import zone.ZonePleineException;

public class MainListener implements IEnsembleListener {
	private Main main;
	private Terrain terrain;
	
	public MainListener(Main main, Terrain terrain) {
		this.main = main;
		this.terrain = terrain;
		
		this.main.iterator().forEachRemaining(carte -> {carte.addMouseListener(this); }); // Écoute chaque carte
		this.main.addListener(this);
	}
	
	@Override
	public void onRemove(CarteJeu carteRemoved) {
		carteRemoved.removeMouseListener(this);
	}

	@Override
	public void onAdd(CarteJeu carteAdded) {
		carteAdded.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("MainListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso
		
			if (e.getSource() instanceof CarteJeu) {
				CarteJeu carte = (CarteJeu)e.getSource();
				
				if (SwingUtilities.isLeftMouseButton(e)) {
					MyOptionPane optionPane = new MyOptionPane();
					
					// Si la carte à poser est un personnage, affiche une fenêtre correspondante
					if (carte instanceof CartePerso) {
		                int option = optionPane.showYesNoMessage("Choix du terrain", "Sur quel terrain voulez-vous poser la carte?", "Attaque", "Défense");
		                
		                if (option == MyOptionPane.YES) { // Attaque
		                	try {
		                		if (!this.terrain.getZoneAttaque().zonePleine()) {
				                	System.out.println("Je pose en Attaque");
				                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
				                	
				                	this.terrain.getZoneAttaque().poserCarte(((CartePerso)carteJeu.get()));
		                		}
		                	}
		                	catch (ZonePleineException ex) {
			                	System.out.println("La zone d'attaque est pleine... impossible d'y poser la carte");
		                	}
		                }
		                else if (option == MyOptionPane.NO) { // Défense
		                	try {
		                		if (!this.terrain.getZoneDefense().zonePleine()) {
				                	System.out.println("Je pose en Défense");
				                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
				                	
				                	this.terrain.getZoneDefense().poserCarte(((CartePerso)carteJeu.get()));
		                		}
		                	}
		                	catch (ZonePleineException ex) {
			                	System.out.println("La zone de défense est pleine... impossible d'y poser la carte");
		                	}
		                }
					}
					// Si la carte à poser est un sort, affiche une fenêtre correspondante
					else if (carte instanceof CarteSort){ // Sort
		                int option = optionPane.showYesNoMessage("Choix de l'emplacement du sort", "Sur quelle zone sort voulez-vous poser la carte?", "Zone 1", "Zone 2");
		                
		                if (option == MyOptionPane.YES) { // Zone 1
		                	try {
		                		if (!this.terrain.getZoneSort1().zonePleine()) {
				                	System.out.println("Je pose en Zone 1");
				                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
				                	
				                	this.terrain.getZoneSort1().poserCarte(((CarteSort)carteJeu.get()));
		                		}
		                	}
		                	catch (ZonePleineException ex) {
			                	System.out.println("La zone de sort 1 est pleine... impossible d'y poser la carte");
		                	}
		                }
		                else if (option == MyOptionPane.NO) { // Zone 2
		                	try {
		                		if (!this.terrain.getZoneSort2().zonePleine()) {
				                	System.out.println("Je pose en Zone 2");
				                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
				                	
				                	this.terrain.getZoneSort2().poserCarte(((CarteSort)carteJeu.get()));
		                		}
		                	}
		                	catch (ZonePleineException ex) {
			                	System.out.println("La zone de sort 2 est pleine... impossible d'y poser la carte");
		                	}
		                }
					}
				}
				else if (SwingUtilities.isRightMouseButton(e)) {
                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
					this.main.onRemoveListener(carteJeu.get());
				}
			}
	}

	@Override
	public void mouseEntered(MouseEvent e) { 
		if (e.getSource() instanceof CarteJeu) {
			CarteJeu carte = (CarteJeu)e.getSource();
			Rectangle r = new Rectangle(carte.getX(), carte.getY() - 50, carte.getWidth(), carte.getHeight() + 50);
			carte.setBounds(r);
		}	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource() instanceof CarteJeu) {
			CarteJeu carte = (CarteJeu)e.getSource();
			Rectangle r = new Rectangle(carte.getX(), carte.getY() + 50, carte.getWidth(), carte.getHeight() - 50);
			carte.setBounds(r);
		}		
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
