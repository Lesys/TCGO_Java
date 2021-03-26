package view;

import java.awt.BorderLayout;
import java.awt.TextField;

import javax.swing.JPanel;

import carte.CartePerso;
import ensemble.Pioche;
import images.ImagePanel;

public class PiocheView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1080764309201388514L;

	private Pioche pioche;
	
	public PiocheView(Pioche pioche) {
		ImagePanel verso = new ImagePanel("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png");
		this.pioche = pioche;
		
		this.setLayout(new BorderLayout());
		this.add(verso, BorderLayout.CENTER);
		this.add(new TextField(Integer.toString(this.pioche.size())), BorderLayout.SOUTH);
	}
}
