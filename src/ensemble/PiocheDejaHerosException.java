package ensemble;

public class PiocheDejaHerosException extends Exception {
	public PiocheDejaHerosException() {
		super();
	}
	
	public PiocheDejaHerosException(String text) {
		super("La pioche " + text + " possède déjà une carte Héros.");
	}
}