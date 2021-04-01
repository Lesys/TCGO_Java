package joueur;

public class NotYourTurnException extends Exception {	
	public NotYourTurnException() {
		super("Un joueur essaie de jouer alors que ce n'est pas son tour.");
	}
	
	public NotYourTurnException(Joueur joueur) {
		super("Le joueur " + joueur.getNom() + "essaie de jouer alors que ce n'est pas son tour.");
	}
	
}
