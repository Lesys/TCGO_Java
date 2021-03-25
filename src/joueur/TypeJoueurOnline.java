package joueur;

public class TypeJoueurOnline implements TypeJoueur {
	private static TypeJoueurOnline instance = null;
	
	private TypeJoueurOnline() {
		
	}
	
	public static TypeJoueurOnline getInstance() {
		if (TypeJoueurOnline.instance == null)
			TypeJoueurOnline.instance = new TypeJoueurOnline();
		
		return TypeJoueurOnline.instance;
	}
	
	@Override
	public String toString() {
		return "TypeJoueurOnline";
	}
}
