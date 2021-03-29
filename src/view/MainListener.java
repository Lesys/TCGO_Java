package view;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;

import carte.CarteJeu;
import ensemble.Main;

public class MainListener implements IMainListener {
	private Main main;
	
	public MainListener(Main main) {
		this.main = main;
		
		// MouseAdapter permettant de monter la carte si la souris passe dessus (et de la remettre en position si la souris sort) //TODO Afficher les propriétés en haut à gauche (comme YGO)
		MouseAdapter ma = new MouseAdapter() {
		     public void mouseEntered(MouseEvent e) {
		    	 //System.out.println("Dans MouseEntered ma");
		    	 
		    	 if (e.getSource() instanceof CarteJeu) {
					CarteJeu carte = (CarteJeu)e.getSource();
					Rectangle r = new Rectangle(carte.getX(), carte.getY() - 50, carte.getWidth(), carte.getHeight() + 50);
					carte.setBounds(r);
		    	 }
		     }
		     
		     public void mouseExited(MouseEvent e) {
		    	 //System.out.println("Dans MouseExited ma");
		    	 
		    	 if (e.getSource() instanceof CarteJeu) {
					CarteJeu carte = (CarteJeu)e.getSource();
					Rectangle r = new Rectangle(carte.getX(), carte.getY() + 50, carte.getWidth(), carte.getHeight() - 50);
					carte.setBounds(r);
		    	 }
		     }
		};
		
		this.main.iterator().forEachRemaining(carte -> {carte.addMouseListener(this); carte.addMouseListener(ma); });
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
				}
				else if (SwingUtilities.isRightMouseButton(e)) {
					this.main.onRemoveListener(carte);
				}
				if (carte.getCursor().getType() == 2)
					carte.setCursor(new Cursor(5));
				else
					carte.setCursor(new Cursor(2));
			}
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
