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
				MyOptionPane optionPane = new MyOptionPane();
				
                int option = optionPane.showZoneTerrainMessage("Choix de l'attaque", "Sur quelle carte voulez-vous attaquer?", this.joueur.getAdversaire().getTerrain().getZoneAttaque());
                
                if (option == MyOptionPane.ZERO) { // Attaque
                	System.out.println("Attaque 1 !!");
                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneAttaque().getCarte1());
                }
                else if (option == MyOptionPane.UN) {
                	System.out.println("Attaque 2 !!");
                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneAttaque().getCarte2());
                }
                else if (option == MyOptionPane.DEUX) {
                	System.out.println("Attaque 3 !!");
                	carte.combattre(this.joueur.getAdversaire().getTerrain().getZoneAttaque().getCarte3());
                }
                else {
                	System.out.println("Exit");
                }
			}
		}
	}
}
