package ensemble;

public class Main extends EnsembleCarte {
	public static final int DEBUT_MAIN = 5;
	public static final int MAX_MAIN = 7;
	
	public Main(String nom) {
		super("Main de " + nom);
	}
	
	public static Main initTest() {
		Main main = new Main("Main de test");
		
		return main;
	}
	
	public void reinitialisation() {
	}
	
	public boolean isTooMuch() {
		return this.size() > Main.MAX_MAIN;
	}
}
