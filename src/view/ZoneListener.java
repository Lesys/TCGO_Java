package view;

import java.awt.event.MouseEvent;
import java.util.Optional;

import javax.swing.SwingUtilities;

import carte.CarteJeu;
import carte.CartePerso;
import ensemble.Main;
import joueur.Joueur;
import ensemble.zone.Zone;

public class ZoneListener implements IEnsembleListener {
	protected Main main;
	protected Zone zone;
	protected Joueur joueur;
	
	protected WindowPopupCarteView popup;
	
	public ZoneListener(Main main, Zone zone, Joueur joueur) {
		this.main = main;
		this.zone = zone;
		this.joueur = joueur;

		this.zone.iterator().forEachRemaining(carte -> {carte.addMouseListener(this); });
		this.zone.addListener(this);
	}

	@Override
	public void onRemove(CarteJeu carteRemoved) {
		System.out.println("On Remove ZoneListener");
		carteRemoved.removeMouseListener(this);
	}

	@Override
	public void onAdd(CarteJeu carteAdded) {
		System.out.println("On add ZoneListener");
		carteAdded.addMouseListener(this);
	}

	@Override
	public void onDestroy(CarteJeu carteDestroyed) {
    	Optional<CarteJeu> carteJeu = this.zone.recupererCarte(carteDestroyed);
		//this.main.onRemoveListener(carteJeu.get());
    	this.joueur.defausser(carteJeu.get());
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("ZoneListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso

		/*if (e.getSource() instanceof CarteJeu) {
			CarteJeu carte = (CarteJeu)e.getSource();
			if (SwingUtilities.isRightMouseButton(e)) {
				System.err.println("Affichage des cartes de la zone: " + this.zone.size());
		    	Optional<CarteJeu> carteJeu = this.zone.recupererCarte(carte);
				//this.main.onRemoveListener(carteJeu.get());
		    	this.joueur.defausser(carteJeu.get());
			}
		}*/
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {	
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
