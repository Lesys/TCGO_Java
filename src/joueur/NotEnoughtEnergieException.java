package joueur;

public class NotEnoughtEnergieException extends Exception {	
	public NotEnoughtEnergieException() {
		super("Un joueur essaie d'utiliser une carte avec un coût plus élevé que l'énergie restante de ce joueur.");
	}
	
	public NotEnoughtEnergieException(int energieJoueur, int coutCarte) {
		super("Le joueur essaie de jouer une carte au coût de " + coutCarte + " alors qu'il ne dispose que de " + energieJoueur + " énergie(s).");
	}
	
}
