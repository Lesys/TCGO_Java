package ensemble;

public class Defausse extends EnsembleCarte {

	public Defausse(String nom) {
		super("Défausse de " + nom);
	}
	
	public static Defausse initTest() {
		Defausse defausse = new Defausse("Défausse de test");
		
		return defausse;
	}

	public void reinitialisation() {
	}
}
