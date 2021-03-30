package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.NoSuchElementException;

import javax.swing.SwingUtilities;

import ensemble.Main;
import ensemble.Pioche;

public class PiocheListener implements MouseListener {
	private Pioche pioche;
	private Main main;
	
	private WindowPopupEnsembleCarteView popup;
	
	public PiocheListener(Pioche pioche, Main main) {
		this.pioche = pioche;
		this.main = main;

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			if (this.popup == null || !this.popup.isVisible()) {
				this.popup = new WindowPopupEnsembleCarteView(this.pioche); // TODO Problème quand on retire une carte puis affiche avec clic droit (réglé ?)
				this.popup.setVisible(true);
			}
		}			
		else if (SwingUtilities.isLeftMouseButton(e)) {
			try {
				this.main.ajouterCarte(this.pioche.piocherDebutTour());
			} catch (NullPointerException ex) {
				System.out.println("Attendez le début du tour pour piocher");
			} catch (NoSuchElementException ex) {
				System.out.println("il n'y a plus de carte dans la pioche");
			}
			
			//System.out.println(e.getSource()); // retourne PiocheView
		}
		
		if (e.getSource() instanceof PiocheView)
			((PiocheView)e.getSource()).refresh(); // Remet l'affichage à jour
		
		e.consume(); // Empêche la carte de s'afficher (car révèlerait la carte sur le haut de la pioche)
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
