package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import carte.CarteJeu;


public interface IMainListener extends MouseListener{
	@Override
	public void mouseClicked(MouseEvent e);

	@Override
	public void mouseEntered(MouseEvent e);

	@Override
	public void mouseExited(MouseEvent e);

	@Override
	public void mousePressed(MouseEvent e);

	@Override
	public void mouseReleased(MouseEvent e);
	
	public void onRemove(CarteJeu carteRemoved);
	public void onAdd(CarteJeu carteAdded);
}
