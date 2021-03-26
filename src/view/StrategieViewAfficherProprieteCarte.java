package view;

import javax.swing.JPanel;

public class StrategieViewAfficherProprieteCarte implements StrategieView {
	private static StrategieViewAfficherProprieteCarte instance = null;
	
	
	private StrategieViewAfficherProprieteCarte() {
		
	}
	
	public static StrategieViewAfficherProprieteCarte getInstance() {
		if (StrategieViewAfficherProprieteCarte.instance == null)
			StrategieViewAfficherProprieteCarte.instance = new StrategieViewAfficherProprieteCarte();
		
		return StrategieViewAfficherProprieteCarte.instance;
	}

	@Override
	public void executer(JPanel jpanel) {
		if (jpanel instanceof CarteHerosView) {
			((CarteHerosView)jpanel).afficherProp();
		}
	}
}
