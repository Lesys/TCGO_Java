package jeu;

public class StrategieButtonExecuter implements StrategieButton {
	private static StrategieButtonExecuter instance = null;
	
	private StrategieButtonExecuter() {
		
	}
	
	public static StrategieButtonExecuter getInstance() {
		if (StrategieButtonExecuter.instance == null)
			StrategieButtonExecuter.instance = new StrategieButtonExecuter();
		
		return StrategieButtonExecuter.instance;
	}

	@Override
	public void executer(Fenetre fenetre) {
		if (fenetre instanceof JeuUI)
			this.executer((JeuUI)fenetre);
	}
	
	public void executer(JeuUI jeuUi) {
		//jeuUi.getJeu().pause();
		jeuUi.getChoixJoueursButton().setText("Exécuter");
		//jeuUi.getExecuterButton().setStrategie(new StrategieButtonPause());
	}
}