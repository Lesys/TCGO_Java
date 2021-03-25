package ensemble;

public class PiochePleineException extends Exception {
	public PiochePleineException() {
		super();
	}
	
	public PiochePleineException(String text) {
		super("La pioche " + text + " est pleine.");
	}
}
