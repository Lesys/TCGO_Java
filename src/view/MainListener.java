package view;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.swing.SwingUtilities;

import carte.CarteJeu;
import carte.CartePerso;
import carte.CarteSort;
import ensemble.Main;
import joueur.Joueur;
import zone.Terrain;
import zone.ZonePleineException;

public class MainListener implements IEnsembleListener {
	private Main main;
	private Terrain terrain;
	private Joueur joueur;
	
	public MainListener(Main main, Terrain terrain, Joueur joueur) {
		this.main = main;
		this.terrain = terrain;
		this.joueur = joueur;
		
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
	public void onDestroy(CarteJeu carteDestroyed) {
    	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carteDestroyed);
		//this.main.onRemoveListener(carteJeu.get());
    	this.joueur.defausser(carteJeu.get());
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
			                	this.joueur.jouerCarte(carte, this.terrain.getZoneAttaque());
	                		}
	                	}
	                	catch (NoSuchElementException ex) {
	                		System.out.println("Aucune carte trouvée...");
	                	}
	                }
	                else if (option == MyOptionPane.NO) { // Défense
	                	try {
	                		if (!this.terrain.getZoneDefense().zonePleine()) {
			                	System.out.println("Je pose en Défense");
			                	this.joueur.jouerCarte(carte, this.terrain.getZoneDefense());
	                		}
	                	}
	                	catch (NoSuchElementException ex) {
	                		System.out.println("Aucune carte trouvée...");
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
			                	
			                	this.joueur.jouerCarte(carte, this.terrain.getZoneSort1());
	                		}
	                	}
	                	catch (NoSuchElementException ex) {
	                		System.out.println("Aucune carte trouvée...");
	                	}
	                }
	                else if (option == MyOptionPane.NO) { // Zone 2
	                	try {
	                		if (!this.terrain.getZoneSort2().zonePleine()) {
			                	System.out.println("Je pose en Zone 2");
			                	
			                	this.joueur.jouerCarte(carte, this.terrain.getZoneSort2());
	                		}
	                	}
	                	catch (NoSuchElementException ex) {
	                		System.out.println("Aucune carte trouvée...");
	                	}
	                }
				}
			}
			else if (SwingUtilities.isRightMouseButton(e)) {
				this.onDestroy(carte);
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
