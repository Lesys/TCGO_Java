package view;

import java.awt.BorderLayout;
import java.awt.TextField;

import ensemble.ZoneBannie;
import images.ImagePanel;

public class ZoneBannieView extends DefaultView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 703670730001252355L;

	private ZoneBannie zoneBannie;

	private TextField nbCarteBannie;

	
	public ZoneBannieView(ZoneBannie zoneBannie) {
		ImagePanel verso = new ImagePanel("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png");
		this.zoneBannie = zoneBannie;
		//this.testMainView();
		this.setLayout(new BorderLayout());

		this.add(verso, BorderLayout.CENTER);

		this.nbCarteBannie = new TextField(Integer.toString(this.zoneBannie.size()));
		this.add(this.nbCarteBannie, BorderLayout.SOUTH);
	}
	
	@Override
	public void refresh() {
		super.refresh();
		this.nbCarteBannie.setText(Integer.toString(this.zoneBannie.size()));
	}
}
