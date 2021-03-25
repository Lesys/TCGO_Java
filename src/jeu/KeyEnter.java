package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class KeyEnter implements KeyListener{
	/**	Le bouton à activer
	 * @button JButton
	 */
	private JButton button;
	
	/** Constructeur par défaut
	 * 
	 * @param button	Le bouton à activer
	 */
	public KeyEnter(JButton button) {
		this.button = button;
	}
	
	@Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        	button.doClick();
        	e.consume();
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}