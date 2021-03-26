package view;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JPanel;

import ensemble.Defausse;

public class DefausseView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364894121304621440L;

	private Defausse defausse;
	
	public DefausseView(Defausse defausse) {
		this.defausse = defausse;
		//this.testMainView();
		this.setLayout(new BorderLayout());
		
		this.add(new TextField(Integer.toString(this.defausse.size())));
	}
}
