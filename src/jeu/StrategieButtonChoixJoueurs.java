package jeu;

public class StrategieButtonChoixJoueurs implements StrategieButton {
	private static StrategieButtonChoixJoueurs instance = null;
	
	private StrategieButtonChoixJoueurs() {
		
	}
	
	public static StrategieButtonChoixJoueurs getInstance() {
		if (StrategieButtonChoixJoueurs.instance == null)
			StrategieButtonChoixJoueurs.instance = new StrategieButtonChoixJoueurs();
		
		return StrategieButtonChoixJoueurs.instance;
	}

	@Override
	public void executer(Fenetre fenetre) {
		if (fenetre instanceof JeuUI)
			this.executer((JeuUI)fenetre);
	}
	
	public void executer(JeuUI jeuUi) {
		//jeuUi.getJeu().pause();
		//jeuUi.getExecuterButton().setText("Exécuter");
		//jeuUi.getExecuterButton().setStrategie(new StrategieButtonPause());
		
		// Création d'un panel pour enregistrer 2 joueurs
		
		new FenetreCreationJoueurs();
		
	}
}