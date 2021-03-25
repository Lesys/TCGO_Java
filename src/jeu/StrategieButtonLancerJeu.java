package jeu;

public class StrategieButtonLancerJeu implements StrategieButton {
	private static StrategieButtonLancerJeu instance = null;
	
	private StrategieButtonLancerJeu() {
		
	}
	
	public static StrategieButtonLancerJeu getInstance() {
		if (StrategieButtonLancerJeu.instance == null)
			StrategieButtonLancerJeu.instance = new StrategieButtonLancerJeu();
		
		return StrategieButtonLancerJeu.instance;
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
		
		new FenetreJeu();
		
	}
}