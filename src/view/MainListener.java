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

public class MainListener implements IEnsembleListener {
	private Main main;
	private Terrain terrain;
	
	
	private WindowPopupCarteView popup;
	
	public MainListener(Main main, Terrain terrain) {
		this.main = main;
		this.terrain = terrain;
		
		this.main.iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.main.addListener(this);
	}
	
	public void onRemove(CarteJeu carteRemoved) {
		carteRemoved.removeMouseListener(this);
	}

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
					
					if (carte instanceof CartePerso) {
		                int option = optionPane.showYesNoMessage("Choix du terrain", "Sur quel terrain voulez-vous poser la carte?", "Attaque", "Défense");
		                
		                if (option == MyOptionPane.YES) { // Attaque
		                	System.out.println("Je pose en Attaque");
		                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
		                	
		                	this.terrain.getZoneAttaque().poserCarte(((CartePerso)carteJeu.get()));
		                }
		                else if (option == MyOptionPane.NO) { // Défense
		                	System.out.println("Je pose en Défense");
		                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
		                	
		                	this.terrain.getZoneDefense().poserCarte(((CartePerso)carteJeu.get()));
		                }
					}
					else if (carte instanceof CarteSort){ // Sort
		                int option = optionPane.showYesNoMessage("Choix de l'emplacement du sort", "Sur quelle zone sort voulez-vous poser la carte?", "Zone 1", "Zone 2");
		                
		                if (option == MyOptionPane.YES) { // Zone 1
		                	System.out.println("Je pose en Zone 1");
		                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
		                	
		                	this.terrain.getZoneSort1().poserCarte(((CarteSort)carteJeu.get()));
		                }
		                else if (option == MyOptionPane.NO) { // Zone 2
		                	System.out.println("Je pose en Zone 2");
		                	Optional<CarteJeu> carteJeu = this.main.recupererCarte(carte);
		                	
		                	this.terrain.getZoneSort2().poserCarte(((CarteSort)carteJeu.get()));
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
