package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ensemble.ZoneBannie;

public class ZoneBannieListener implements MouseListener {
	private ZoneBannie zoneBannie;
	
	private WindowPopupEnsembleCarteView popup;
	
	public ZoneBannieListener(ZoneBannie zoneBannie) {
		this.zoneBannie = zoneBannie;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!this.zoneBannie.estVide()) {
			if (this.popup == null || !this.popup.isVisible()) {
				this.popup = new WindowPopupEnsembleCarteView(this.zoneBannie); // TODO Problème quand on retire une carte puis affiche avec clic droit (??)
				this.popup.setVisible(true);
				System.out.println("ZoneBannieListener !" + this.zoneBannie.size());
			}
		}
		else {
			JOptionPane.showMessageDialog(new JFrame(), this.zoneBannie.getNom() + " est vide");
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
