package ensemble;

public class ZoneBannie extends EnsembleCarte {

	public ZoneBannie(String nom) {
		super("Zone bannie de " + nom);
	}

	public static ZoneBannie initTest() {
		ZoneBannie zoneBannie = new ZoneBannie("ZoneBannie de test");
		
		return zoneBannie;
	}
	
	public void reinitialisation() {
	}
}
