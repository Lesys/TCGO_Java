package view;

import java.awt.GridLayout;

import javax.swing.JFrame;

import ensemble.EnsembleCarte;

public class WindowPopupEnsembleCarteView extends JFrame {
	public static int MAX_PAR_LIGNE = 6;
	/**
	 * 
	 */
	private static final long serialVersionUID = 4348263289346294559L;

	public WindowPopupEnsembleCarteView(EnsembleCarte ensemble) {
		// Affiche MAX_PAR_LIGNE par ligne et déduit le nombre de lignes nécessaires pour afficher toutes les cartes
		this.setLayout(new GridLayout((ensemble.size() / WindowPopupEnsembleCarteView.MAX_PAR_LIGNE )+ 1, WindowPopupEnsembleCarteView.MAX_PAR_LIGNE));
		
		// Ajoute toutes les cartes à la JFrame
		ensemble.iterator().forEachRemaining(carte -> this.add(carte));
	}
	
}
