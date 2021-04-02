package carte;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class ListeCarteHeros extends ListeCarte {
	
	private static ListeCarteHeros instance;
	
	protected ListeCarteHeros() {
		super();
		
		this.listeCartes = new Hashtable<String, Carte>();
		
		String ref = "PD";
		String extension = ".png";
		
		// TODO automatiser avec la BDD
		CarteHeros[] tab = {new CarteHeros("PD001.png", "Aqours", "Love Live!", null, 35),
			new CarteHeros("PD002.png", "µ's", "Love Live!", null, 40)
		};
		
		for (int i = 1; i <= 2; i++)
			this.listeCartes.put(tab[i - 1].getReference(), tab[i - 1]);
		
		for (Enumeration<Carte> e = this.elements(); e.hasMoreElements();)
			System.err.println("CarteHeros: " + e.nextElement().infosToString());
	}
	
	public static ListeCarteHeros getInstance() {
		if (ListeCarteHeros.instance == null)
			ListeCarteHeros.instance = new ListeCarteHeros();
		
		return ListeCarteHeros.instance;
	}

	@Override
	public CarteHeros getRandomCarte() throws NoSuchElementException {
		return (CarteHeros)super.getRandomCarte();
	}
}
