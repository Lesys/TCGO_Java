package ensemble;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import carte.CarteJeu;


public abstract class EnsembleCarte {	
	protected LinkedList<CarteJeu> cartes;
	protected String nom;
	
	public EnsembleCarte(String nom) {
		this.nom = nom;
		this.cartes = new LinkedList<>();
	}
	
	/** Permet de mélanger le deck aléatoirement
	 */
	public void melanger() {
		for (int i = 0; i < this.cartes.size(); i++)
			// Retire l'élément à l'index "i" et l'insert à un index aléatoire
			this.cartes.add(new Random().nextInt(this.cartes.size()), this.cartes.remove(i));
	}
	
	/** Permet d'ajouter une carte à l'ensemble SI elle respecte les différents critères
	 * 
	 * @param carte		La carte à ajouter
	 */
	public void ajouterCarte(CarteJeu carte) {
		try {
			// Si la carte est déjà en nombre trop limité d'exemplaire
			if (this.count(carte) >= carte.getNbExemplaire())
				throw new ExemplaireMaximumException("La carte " + carte.getNom() + " est déjà en exemplaire maximum dans le deck " + this.nom);
			
			// Si cet ensemble est plein
			else if (this.cartes.size() >= Pioche.tailleDeck)
				throw new PiochePleineException(this.nom);
			
			// Ajoute la carte remise à zéro
			carte.reinitialisation();
			this.cartes.add(carte);
			System.out.println("Carte" + carte.getNom() + " ajoutée");
		} catch (ExemplaireMaximumException e) {
			e.printStackTrace();
		} catch (PiochePleineException e) {
			e.printStackTrace();
			
		}
	}
	
	/** Sort la carte de l'ensemble avec la référence correspondante et mélange
	 * 
	 * @param reference		La référence de la carte voulue
	 * 
	 * @return				La carte possédant la référence
	 * 
	 * @exception			NoSuchElementException si aucune carte avec la référence demandée ne se trouve dans cet ensemble
	 */
	public Optional<CarteJeu> recupererCarte(String reference) throws NoSuchElementException {
		Optional<CarteJeu> op = this.cartes.stream().filter(c -> c.getReference().equals(reference))
			.findFirst();
		
		if (this.cartes.remove(op.get()))
			this.melanger();
		else // Normalement impossible puisqu'on prend la carte depuis l'ensemble
			System.err.println("L'ensemble " + this.nom + " ne contient pas de carte " + op.get().getReference());
		
		return op;
	}
	
	/** Permet de compter combien d'exemplaires de cette carte sont présents dans cet ensemble 
	 * 
	 * @param carte		La carte qu'on veut compter
	 * 
	 * @return			Le nombre d'exemplaires de la carte dans l'ensemble
	 */
	protected int count(CarteJeu carte) {
		int compteur = 0;
		
		for (CarteJeu c : this.cartes)
			compteur += c.equals(carte)? 1 : 0;
		
		return compteur;
	}
	
	/** Permet de savoir si cet ensemble de cartes est vide
	 * 
	 * @return		Vrai s'il n'y a aucune carte dans cet ensemble de cartes, faux sinon
	 */
	public boolean estVide() {
		return this.cartes.isEmpty();
	}
}
