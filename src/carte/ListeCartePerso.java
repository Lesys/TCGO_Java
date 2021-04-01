package carte;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class ListeCartePerso extends ListeCarte {
	
	private static ListeCartePerso instance;
	
	protected ListeCartePerso() {
		super();
		
		this.listeCartes = new Hashtable<String, Carte>();
		
		String ref = "PD";
		String extension = ".png";
		
		// TODO automatiser avec la BDD
		CartePerso[] tab = {new CartePerso("PD003.png", "CYaRon!", "Love Live!", null, 1, 2, 4, 5),
			new CartePerso("PD004.png", "BiBi", "Love Live!", null, 1, 1, 2, 3),
			new CartePerso("PD004.png", "Guilty Kiss", "Love Live!", null, 1, 2, 4, 6)
		};
		
		
		for (int i = 1; i <= 3; i++)
			this.listeCartes.put(ref + String.format("%03d", i) + extension, tab[i - 1]);
		
		for (Enumeration<Carte> e = this.elements(); e.hasMoreElements();)
			System.err.println("CartePerso: " + e.nextElement().infosToString());
	}
	
	public static ListeCartePerso getInstance() {
		if (ListeCartePerso.instance == null)
			ListeCartePerso.instance = new ListeCartePerso();
		
		return ListeCartePerso.instance;
	}
	
	@Override
	public CartePerso getRandomCarte() throws NoSuchElementException {
		return (CartePerso)super.getRandomCarte();
	}
}
