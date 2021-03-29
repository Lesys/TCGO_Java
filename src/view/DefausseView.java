package view;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JPanel;

import ensemble.Defausse;
import images.ImagePanel;

public class DefausseView extends DefaultView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364894121304621440L;

	private Defausse defausse;
	
	public DefausseView(Defausse defausse) {
		ImagePanel verso = new ImagePanel("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png");
		this.defausse = defausse;
		//this.testMainView();
		this.setLayout(new BorderLayout());

		this.add(verso, BorderLayout.CENTER);
		this.add(new TextField(Integer.toString(this.defausse.size())), BorderLayout.SOUTH);
	}
}
