package view;

import java.awt.event.MouseEvent;
import java.util.Optional;

import javax.swing.SwingUtilities;

import carte.CarteJeu;
import carte.CartePerso;
import carte.CarteSort;
import ensemble.Main;
import joueur.Joueur;
import zone.ZonePleineException;
import zone.ZoneTerrain;

public class ZoneTerrainAttaqueListener extends ZoneListener {

	public ZoneTerrainAttaqueListener(Main main, ZoneTerrain zoneTerrain, Joueur joueur) {
		super(main, zoneTerrain, joueur);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	//	super.mouseClicked(e);
		System.out.println("Ceci est une attaque");
		
		if (e.getSource() instanceof CartePerso) {
			CartePerso carte = (CartePerso)e.getSource();
			
			if (SwingUtilities.isLeftMouseButton(e)) {
				if (this.joueur.getAdversaire().getTerrain().isAucunPerso()) {
					System.out.println("DIRECT ATTAQUE");
					carte.combattre(this.joueur.getHeros());
					System.out.println("Stats du Héros après combat: " + this.joueur.getHeros().infosToString());
				}
				else {
					MyOptionPane optionPane = new MyOptionPane();
					
	                int option = optionPane.showZoneTerrainMessage("Choix de l'attaque", "Sur quelle carte voulez-vous attaquer?", this.joueur.getAdversaire().getTerrain());

	                if (option == MyOptionPane.ATQ1) { // Attaque
	                	System.out.println("Attaque 1 !!");
	                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneAttaque().getCarte1());
	                }
	                else if (option == MyOptionPane.ATQ2) {
	                	System.out.println("Attaque 2 !!");
	                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneAttaque().getCarte2());
	                }
	                else if (option == MyOptionPane.ATQ3) {
	                	System.out.println("Attaque 3 !!");
	                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneAttaque().getCarte3());
	                }
	                if (option == MyOptionPane.DEF1) { // Défense
	                	System.out.println("Défense 1 !!");
	                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneDefense().getCarte1());
	                }
	                else if (option == MyOptionPane.DEF2) {
	                	System.out.println("Défense 2 !!");
	                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneDefense().getCarte2());
	                }
	                else if (option == MyOptionPane.DEF3) {
	                	System.out.println("Défense 3 !!");
	                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneDefense().getCarte3());
	                }
	                else {
	                	System.out.println("Exit");
	                }
				}
			}
		}
	}
}
