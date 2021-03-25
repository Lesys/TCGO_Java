package jeu;

import java.awt.event.WindowEvent;
import java.util.*;

import joueur.Joueur;

public class StrategieButtonCreationJoueurs implements StrategieButton {
	private static StrategieButtonCreationJoueurs instance = null;
	
	private StrategieButtonCreationJoueurs() {
		
	}
	
	public static StrategieButtonCreationJoueurs getInstance() {
		if (StrategieButtonCreationJoueurs.instance == null)
			StrategieButtonCreationJoueurs.instance = new StrategieButtonCreationJoueurs();
		
		return StrategieButtonCreationJoueurs.instance;
	}
	
	@Override
	public void executer(Fenetre fenetre) {
		if (fenetre instanceof FenetreCreationJoueurs)
			this.executer((FenetreCreationJoueurs)fenetre);
	}
	
	public void executer(FenetreCreationJoueurs fenetre) {
		//jeuUi.getJeu().pause();
		//jeuUi.getExecuterButton().setText("Exécuter");
		//jeuUi.getExecuterButton().setStrategie(new StrategieButtonPause());
		
		List<Joueur> joueurs = fenetre.getJoueurs();
		
		for (Joueur j : joueurs)
			System.out.println(j);
		
		//fenetre.dispatchEvent(new WindowEvent(fenetre, WindowEvent.WINDOW_CLOSING));
	}
}