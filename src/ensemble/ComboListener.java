package ensemble;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import carte.Carte;
import carte.ListeCarte;
import carte.ListeCartePerso;
import jeu.Fenetre;

public class ComboListener implements ActionListener {
	private JComboBox<String> combo;
	private Carte carte;
	private ListeCarte listeCarte;
	private JPanel refreshItem;
	private JLabel label;
	
	public ComboListener(JComboBox<String> combo, Carte carte, ListeCarte listeCarte, JPanel refreshItem, JLabel label) {
		super();
		this.combo = combo;
		this.listeCarte = listeCarte;
		this.carte = listeCarte.get(this.combo.getSelectedItem());
		this.refreshItem = refreshItem;
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Retire l'ancienne carte (obligatoire sinon la nouvelle carte ne s'affiche pas) et ajoute la nouvelle carte sélectionnée
		this.refreshItem.remove(this.carte);
		this.carte = this.listeCarte.get(this.combo.getSelectedItem());
		this.refreshItem.add(this.carte, BorderLayout.CENTER);
		this.label.setText(this.carte.infosToString());
		
		// Rafraîchit la carte (obligatoire) 
		this.carte.revalidate();
		this.carte.repaint();
	}
}
