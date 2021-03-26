package view;

import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JPanel;

import carte.CartePerso;
import ensemble.Defausse;
import ensemble.Main;

public class DefausseView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364894121304621440L;

	private Defausse defausse;
	
	public DefausseView(Defausse defausse) {
		this.defausse = defausse;
		//this.testMainView();
		
		this.add(new TextField(Integer.toString(defausse.size())));
	}
}
