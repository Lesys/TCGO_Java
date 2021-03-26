package view;

import java.awt.TextField;

import javax.swing.JPanel;

import ensemble.ZoneBannie;

public class ZoneBannieView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 703670730001252355L;

	private ZoneBannie zoneBannie;
	
	public ZoneBannieView(ZoneBannie zoneBannie) {
		this.zoneBannie = zoneBannie;
		//this.testMainView();
		
		this.add(new TextField(Integer.toString(zoneBannie.size())));
	}
}
