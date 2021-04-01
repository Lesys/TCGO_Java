package zone;

import java.util.*;

import carte.CarteJeu;
import ensemble.EnsembleCarte;
import view.IEnsembleListener;
import zone.etatZone.EtatZone;

public abstract class Zone extends EnsembleCarte {
	protected EtatZone etatZone;
	protected List<IEnsembleListener> listeners;
	protected List<CarteJeu> cartes;
	
	public Zone(EtatZone etatZone) {
		super("Zone");
		this.etatZone = etatZone;
		
		this.listeners = new ArrayList<>();
	}
	
	public abstract void poserCarte(CarteJeu carte) throws ZonePleineException;
	
	protected void poserCarte(CarteJeu carte, int max) throws ZonePleineException {
		if (this.cartes.size() < max) { // TODO Choisir l'emplacement dans ceux libres
			System.out.println("Pose de la carte en zone" + this.getClass());
			EtatZone etatCarte = this.etatZone.getConstructor(carte);
			carte.setEtatZone(etatCarte);
			System.out.println("EtatZone de la carte posée: " + carte.getEtatZone());
			
			this.ajouterCarte(carte);
			
			
			// TODO Mettre la bonne zoneEtat à la carte (faire dans chaque classe?)
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

	public boolean zoneVide() {
		return this.cartes.isEmpty();
	}
	
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
	public void reinitialisation() {
		for (CarteJeu c : this)
			if (c.getEffet() != null)
				c.getEffet().effetDebutTour();
			else
				c.debutTour();
	}
}
