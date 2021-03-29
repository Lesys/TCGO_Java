package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import ensemble.Defausse;

public class DefausseListener implements MouseListener {
	private Defausse defausse;
	
	private WindowPopupEnsembleCarteView popup;
	
	public DefausseListener(Defausse defausse) {
		this.defausse = defausse;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (this.popup == null || !this.popup.isVisible()) {
			this.popup = new WindowPopupEnsembleCarteView(this.defausse); // TODO Problème quand on retire une carte puis affiche avec clic droit (??)
			this.popup.setVisible(true);
			System.out.println("DéfausseListener !");
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
