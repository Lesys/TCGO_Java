package view;

import java.awt.BorderLayout;
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

		this.setLayout(new BorderLayout());
		//this.add(new TextField("Carte héros"));
		this.add(this.carteHeros, BorderLayout.CENTER);
		
		this.addMouseListener(this);
	}
	
	public void afficherProp() {
		System.out.println(this.carteHeros);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.strategieView.executer(this);
	}
}
