package view;

import java.awt.GridLayout;

import javax.swing.JFrame;

import images.ImagePanel;

public class WindowPopupCarteView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8109669179344693030L;

	public WindowPopupCarteView(ImagePanel image) {
		this.setLayout(new GridLayout());
		this.setTitle("Zoom sur la carte");		
		this.setSize(500, 800);
		
		// Ajoute toutes les cartes à la JFrame
		this.add(image);
	}	
}