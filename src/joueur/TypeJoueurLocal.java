package joueur;

public class TypeJoueurLocal implements TypeJoueur {
	private static TypeJoueurLocal instance = null;
	
	private TypeJoueurLocal() {
		
	}
	
	public static TypeJoueurLocal getInstance() {
		if (TypeJoueurLocal.instance == null)
			TypeJoueurLocal.instance = new TypeJoueurLocal();
		
		return TypeJoueurLocal.instance;
	}
	
	@Override
	public String toString() {
		return "TypeJoueurLocal";
	}
}
