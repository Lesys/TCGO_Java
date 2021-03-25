package jeu;

import javax.swing.*;

public class ButtonExecuter extends JButton {
	/** La stratégie adoptée par le bouton
	 *  
	 *  @strategie StrategieButton
	 */
	private StrategieButton strategie;

	/** Constructeur par défaut avec un texte et une stratégie initiale
	 *  
	 *  @param texte		Le texte affiché par le bouton
	 *  @param strategie	La stratégie initiale du bouton
	 */
	public ButtonExecuter(String texte, StrategieButton strategie) {
		super(texte);
		this.strategie = strategie;
	}

	/** Accesseur (setter) sur la strategie du bouton
	 *  
	 *  @param strategie	La novuelle stratégie à adopter par le bouton
	 */
	public void setStrategie(StrategieButton strategie) {
		this.strategie = strategie;
	}

	/** Exécute la stratégie du bouton
	 * 
	 * @param fenetre		La fenêtre en interface graphique
	 */
	public void executer(Fenetre fenetre) {
		this.strategie.executer(fenetre);
	}
}