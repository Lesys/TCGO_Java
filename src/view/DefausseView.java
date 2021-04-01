package view;

import java.awt.BorderLayout;
import java.awt.TextField;

import carte.CarteJeu;
import ensemble.Defausse;
import images.ImagePanel;

public class DefausseView extends DefaultView implements IEnsembleListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364894121304621440L;

	private Defausse defausse;

	private TextField nbCarteDefausse;
	
	public DefausseView(Defausse defausse) {
		ImagePanel verso = new ImagePanel("PD001.png");
		this.defausse = defausse;
		//this.testMainView();
		this.setLayout(new BorderLayout());

		this.add(verso, BorderLayout.CENTER);
		this.nbCarteDefausse = new TextField(Integer.toString(this.defausse.size()));
		this.add(this.nbCarteDefausse, BorderLayout.SOUTH);

		this.defausse.addListener(this);
	}
	
	@Override
	public void refresh() {
		super.refresh();
		this.nbCarteDefausse.setText(Integer.toString(this.defausse.size()));
	}

	@Override
	public void onRemove(CarteJeu carteRemoved) {
		this.refresh();
	}

	@Override
	public void onAdd(CarteJeu carteAdded) {
		this.refresh();		
	}

	@Override
	public void onDestroy(CarteJeu carteDestroyed) {
		this.refresh();		
	}
}
