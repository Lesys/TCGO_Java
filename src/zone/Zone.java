package zone;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import carte.CarteJeu;
import ensemble.ExemplaireMaximumException;
import view.IEnsembleListener;
import zone.etatZone.EtatZone;

public abstract class Zone implements Iterable<CarteJeu>, MouseListener {
	protected EtatZone etatZone;
	protected List<IEnsembleListener> listeners;
	protected List<CarteJeu> cartes;
	
	public Zone(EtatZone etatZone) {
		this.etatZone = etatZone;
		
		this.listeners = new ArrayList<>();
	}
	
	protected void poserCarte(CarteJeu carte, int max) throws ZonePleineException {
		if (this.cartes.size() < max) { // TODO Choisir l'emplacement dans ceux libres
			this.cartes.add(carte);
			this.onAddListener(carte);
		}
		else {
			System.out.println("La capacité maximale a été atteinte pour la zone");
			throw new ZonePleineException("ZoneAttaque: Pose de " + carte.getNom());
		}
	}
	
	@Override
	public Iterator<CarteJeu> iterator() {
		return this.cartes.iterator();
	}

	public abstract boolean zonePleine();
	
	public void addListener(IEnsembleListener l) {
		this.listeners.add(l);
	}

	public void removeListener(IEnsembleListener l) {
		this.listeners.remove(l);
	}

	public void onRemoveListener(CarteJeu carteRemoved) {
		this.listeners.forEach(l -> l.onRemove(carteRemoved));
	}
	
	public void onAddListener(CarteJeu carteAdded) {
		this.listeners.forEach(l -> l.onAdd(carteAdded));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
