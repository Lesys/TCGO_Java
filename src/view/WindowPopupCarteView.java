package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import carte.Carte;
import images.ImagePanel;

public class WindowPopupCarteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8109669179344693030L;

	public WindowPopupCarteView(Carte carte) {
		this.setLayout(new BorderLayout());
		this.setTitle("Zoom sur la carte " + carte.getNom());		
		this.setSize(500, 800);
		
		ImagePanel image = new ImagePanel(carte.getReference());
		
		this.add(image, BorderLayout.CENTER);
		this.add(new JLabel(carte.infosToString()), BorderLayout.NORTH);
	}	
}