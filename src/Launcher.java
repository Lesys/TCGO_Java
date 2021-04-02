import ensemble.FenetreCreationDeck;
import jeu.Jeu;
import jeu.JeuUI;
import joueur.Joueur;
import joueur.TypeJoueurLocal;


public class Launcher {
	public static void main(String[] args) {
		Jeu jeu = new Jeu();
		JeuUI jeuUI = new JeuUI(jeu);
		//FenetreCreationDeck fenetre = new FenetreCreationDeck();
	}
}
