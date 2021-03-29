package view;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.MouseEvent;

import ensemble.Pioche;
import images.ImagePanel;

public class PiocheView extends DefaultView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1080764309201388514L;

	private Pioche pioche;
	
	public PiocheView(Pioche pioche) {
		ImagePanel verso = new ImagePanel("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png");
		this.pioche = pioche;

		this.strategieView = StrategieViewAfficherProprieteCarte.getInstance();

		this.setLayout(new BorderLayout());
		this.add(verso, BorderLayout.CENTER);
		this.add(new TextField(Integer.toString(this.pioche.size())), BorderLayout.SOUTH);
		
		//this.addMouseListener(this);
	}
}
