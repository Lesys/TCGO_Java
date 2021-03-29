package view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import carte.CarteJeu;
import ensemble.Main;

public class MainListener implements MouseListener {
	private Main main;
	
	public MainListener(Main main) {
		this.main = main;
		
		this.main.iterator().forEachRemaining(carte -> carte.addMouseListener(this));
		this.main.addListener(this);
	}
	
	public void removeListener(CarteJeu carteRemoved) {
		carteRemoved.removeMouseListener(this);
	}

	public void addListener(CarteJeu carteAdded) {
		carteAdded.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
		System.out.println("MainListener a entendu quelque chose: " + e.getSource()); // retourne CartePerso
		if (e.getSource() instanceof CarteJeu) {
			CarteJeu carte = (CarteJeu)e.getSource();
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
