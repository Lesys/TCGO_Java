package ensemble;

public class Main extends EnsembleCarte {
	public static final int debutMain = 5;
	public static final int maxMain = 7;
	
	public Main(String nom) {
		super("Main de " + nom);
	}
	
	public static Main initTest() {
		Main main = new Main("Main de test");
		
		return main;
	}
	
	public void reinitialisation() {
	}
}
