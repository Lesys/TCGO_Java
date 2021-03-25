package joueur;

public class TypeJoueurBot implements TypeJoueur {
	private static TypeJoueurBot instance = null;
	
	private TypeJoueurBot() {
		
	}
	
	public static TypeJoueurBot getInstance() {
		if (TypeJoueurBot.instance == null)
			TypeJoueurBot.instance = new TypeJoueurBot();
		
		return TypeJoueurBot.instance;
	}
	
	@Override
	public String toString() {
		return "TypeJoueurBot";
	}
}
