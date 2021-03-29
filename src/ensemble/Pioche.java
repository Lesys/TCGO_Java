package ensemble;
import java.util.*;
import carte.CarteJeu;
import carte.CartePerso;
import effet.StrategieEffet;

public class Pioche extends EnsembleCarte {
	public static final int nbMaxExemplaire = 3;
	public static final int tailleDeck = 40;
	
	private boolean debutTour;
	
	public Pioche(String nom) {
		super("Pioche de " + nom);
		this.debutTour = true;
	}
	
	// Sélection d'un deck (== cartes + son héros)
	public void initialisation() {
		System.out.println("Veuillez sélectionner un deck: ");
		//System.out.println("Veuillez sélectionner une carte héros: ");
		
	}
	
	/** Retire la carte la plus haute sur la pile
	 * 
	 * @return		La carte piochée
	 * 
	 * @exception	NoSuchElementException s'il n'y a plus de carte dans la pioche
	 */
	public CarteJeu piocher() throws NoSuchElementException {
		return this.cartes.pop();
	}
	
	public CarteJeu piocherDebutTour() {
		CarteJeu cartePiochee = null;
		
		if (this.debutTour) {
			cartePiochee = this.piocher();
			this.debutTour = false;
		}
		else
			System.out.println("Pas début tour Pioche");
		
		return cartePiochee;
	}
	/*
	public int getNbCartesRestantes() {
		return this.cartes.size();
	}*/
	
	@Override
	public void ajouterCarte(CarteJeu carte) {
		/*try {
			// Si la carte est un héros est qu'il y a déjà un héros dans cette pioche
			if (carte instanceof CarteHeros && this.possedeHeros())
				throw new PiocheDejaHerosException(this.nom);
			*/
			super.ajouterCarte(carte);
		/*} catch (PiocheDejaHerosException e) {
			
		}*/
	}
	
	/** Récupère la carte héros de la pioche, la soustrait de la pioche et la retourne. Mélange la pioche. À n'utiliser que si this.possedeHeros() retourne vrai
	 * 
	 * @return		La carte héros de la pioche
	 * 
	 * @exception	
	 */
	/*public Optional<Carte> recupererHeros() {
		Optional<Carte> op = this.cartes.stream().filter(c -> c instanceof CarteHeros)
				.findFirst();
		
		if (this.cartes.remove(op.get()))
			this.melanger();
		else // Normalement impossible puisqu'on prend la carte depuis la pioche
			System.err.println("La pioche " + this.nom + " ne contient pas de héros.");
		
		return op;
	}*/
	
	/** Permet de savoir si cette pioche est complète (le bon nombre de cartes + un et un seul héros)
	 * 
	 * @return		Vrai si cette pioche est complète, faux sinon
	 */
	public boolean complet() {
		return (this.cartes.size() == Pioche.tailleDeck);// && this.possedeHeros();
	}
	
	/** Regarde si cette pioche possède un et un seul héros
	 * 
	 * @return		Vrai si cette pioche possède un et un seul héros, faux sinon
	 */
	/*private boolean possedeHeros() {
		return this.cartes.stream().filter(c -> c instanceof CarteHeros)
			.count() == 1 ? true : false;
	}*/
	
	public boolean isDebutTour() {
		return this.debutTour;
	}
	
	public static Pioche initTest() {
		Pioche pioche = new Pioche("Pioche de test");

		//for (int i = 0; i < 2; i++)
		//	pioche.ajouterCarte(new CartePerso(CartePerso.creationCarteTest().getReference(), "Nom nouveau", "Animé nouveau", null, 3, 6, 6, 6));
		for (int i = 0; i < 30; i++)
			pioche.ajouterCarte(CartePerso.creationCarteTest());
		//pioche.ajouterCarte(new CartePerso(CartePerso.creationCarteTest().getReference(), "Nom nouveau", "Animé nouveau", null, 3, 6, 6, 6));
		
		return pioche;
	}
	
	public void reinitialisation() {
		this.debutTour = true;
	}
}
