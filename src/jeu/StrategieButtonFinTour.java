package jeu;

import view.JoueurView;

public class StrategieButtonFinTour implements StrategieButton {
	private static StrategieButtonFinTour instance = null;
	
	private StrategieButtonFinTour() {
		
	}
	
	public static StrategieButtonFinTour getInstance() {
		if (StrategieButtonFinTour.instance == null)
			StrategieButtonFinTour.instance = new StrategieButtonFinTour();
		
		return StrategieButtonFinTour.instance;
	}

	@Override
	public void executer(Fenetre fenetre) {
		if (fenetre instanceof JoueurView) {
			this.executer((JoueurView)fenetre);
		}
	}
	
	public void executer(JoueurView joueurView) {
		joueurView.getJoueur().finTour();
		//jeuUi.getJeu().pause();
		//jeuUi.getExecuterButton().setText("Exécuter");
		//jeuUi.getExecuterButton().setStrategie(new StrategieButtonPause());
		
		// Création d'un panel pour enregistrer 2 joueurs
		
		//new FenetreCreationJoueurs();
		
	}
}