package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import carte.CarteHeros;

public class CarteHerosView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2482754420227499229L;

	private CarteHeros carteHeros;
	
	public CarteHerosView(CarteHeros carteHeros) {
		this.carteHeros = carteHeros;

		this.setLayout(new BorderLayout());
		//this.add(new TextField("Carte héros"));
		this.add(this.carteHeros, BorderLayout.CENTER);
	}
}
