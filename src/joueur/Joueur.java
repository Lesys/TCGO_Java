package joueur;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

import carte.CarteHeros;
import carte.CarteJeu;
import zone.Terrain;
import ensemble.Defausse;
import ensemble.Main;
import ensemble.Pioche;
import ensemble.ZoneBannie;


public class Joueur {
	private String nom;
	private TypeJoueur type;
	private int energie;
	private int energieMax;
	
	private int energieSupp;
	
	public static int energieBase = 5;
	
	private boolean abandon;
	
	private Terrain terrain;
	private Main main;
	private Pioche pioche;
	private Defausse defausse;
	private ZoneBannie zoneBanie;
	
	private CarteHeros heros;
	
	/** Permet de créer un joueur sans paramètre, directement en demandant au joueur ce qu'il est
	 * 
	 * @return		Le joueur créé
	 */
	public static Joueur creer() {
		String nom;
		TypeJoueur type;
		
		int typeJ = 0;
		boolean retry = true;
		
		System.out.println("Entrez le nom du joueur: ");
		Scanner sc = new Scanner(System.in);
		nom = sc.nextLine();
		
		System.out.println("Nom du joueur: " + nom);

		// Permet de refaire la boucle si ce n'est pas un nombre qui a été donné
		while (retry) {
			try {
				System.out.println("Entrez le type du joueur:\n1°) Local\t2°) Bot\t3°) Online");
				typeJ = Integer.parseInt(sc.nextLine());
				retry = false;
			} catch (NumberFormatException e) {
				System.out.println("Veuillez saisir un des nombre demandé...");
			}
		}

		sc.close();
		
		// Récupère le type choisi (sauf si pas dans les choix ==> défaut)
		switch (typeJ) {
			case 1: type = TypeJoueurLocal.getInstance();
				break;
			case 2: type = TypeJoueurBot.getInstance();
				break;
			case 3: type = TypeJoueurOnline.getInstance();
				break;
			default: System.out.println("Le nombre " + typeJ + " n'est pas un nombre demandé. Sélection par défaut du type...");
				type = TypeJoueurLocal.getInstance();
				break;
		}
		
		System.out.println("Le type choisi est " + type);
		
		return new Joueur(nom, type);
	}
	
	public static void creerUI() {
		
	}
	
	public Joueur(String nom, TypeJoueur type) {
		this.nom = nom;
		this.type = type;

		// Création des différents ensembles de cartes
		this.main = new Main(this.nom);
		this.pioche = new Pioche(this.nom);
		this.defausse = new Defausse(this.nom);
		this.zoneBanie = new ZoneBannie(this.nom);
		
		this.terrain = new Terrain("Terrain de " + this.nom);
		
		this.reinitialisation();
		//this.refil();
	}

	public void jouerCarte(CarteJeu carte) {
		try {
			if (this.energie < carte.getCout())
				throw new NotEnoughtEnergieException(this.energie, carte.getCout());
			
			// Poser carte sur une case du terrain
		} catch (NotEnoughtEnergieException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void selectionDeck() {
		//this.heros = heros;
	}
	
	public void ajouterEnergieSupp(int ajout) {
		this.energieSupp += ajout;
	}

	public void retirerEnergieSupp(int retrait) {
		this.energieSupp -= this.energieSupp - retrait > 0 ? retrait : this.energieSupp;
	}
	
	/** Réinitialise le joueur pour une nouvelle partie (!= refil)
	 */
	public void reinitialisation() {
		this.abandon = false;
		this.energieMax = Joueur.energieBase;
		this.energieSupp = 0;
	}
	
	/** Recharge le joueur pour le début d'un tour
	 */
	public void refil() {
		// Augmente l'énergie max si la carte héros est suffisamment endommagé
		if (this.heros.getNbEnergie() > (this.energieMax - this.energieBase))
			this.energieMax += this.heros.getNbEnergie();
		
		this.energie = this.energieMax + this.energieSupp;
		this.terrain.reinitialiser();
	}
	
	@Override
	public String toString() {
		return "<Joueur> " + this.nom + " de type " + this.type;
	}
}