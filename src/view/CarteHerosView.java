package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import carte.CarteHeros;

public class CarteHerosView extends DefaultView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2482754420227499229L;

	private CarteHeros carteHeros;
	
	public CarteHerosView(CarteHeros carteHeros) {
		this.carteHeros = carteHeros;
		
		this.strategieView = StrategieViewAfficherProprieteCarte.getInstance();

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setPreferredSize(this.carteHeros.getPreferredSize());
        
		//this.add(new TextField("Carte héros"));
		this.add(this.carteHeros, c);
		
		this.addMouseListener(this);
	}
	
	public void afficherProp() {
		System.out.println(this.carteHeros);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//this.carteHeros.mouseClicked(e);
	}
}
