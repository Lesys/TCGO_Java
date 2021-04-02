package carte;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.NoSuchElementException;

public class ListeCarteSort extends ListeCarte {
	
	private static ListeCarteSort instance;
	
	protected ListeCarteSort() {
		super();
		
		this.listeCartes = new Hashtable<String, Carte>();
		
		String ref = "PD";
		String extension = ".png";
		
		// TODO automatiser avec la BDD
		CarteSort[] tab = {new CarteSort("PD009.png", "Encore", "Love Live!", null, 1, 2),
			new CarteSort("PD010.png", "Recrutement", "Love Live!", null, 1, 3),
			new CarteSort("PD020.png", "Ene", "Mekakucity Actors", null, 1, 2),
			new CarteSort("PD021.png", "Locking Eyes", "Mekakucity Actors", null, 1, 3)
		};
		
		
		for (int i = 1; i <= 3; i++)
			this.listeCartes.put(tab[i - 1].getReference(), tab[i - 1]);
		
		for (Enumeration<Carte> e = this.elements(); e.hasMoreElements();)
			System.err.println("CartePerso: " + e.nextElement().infosToString());
	}
	
	public static ListeCarteSort getInstance() {
		if (ListeCarteSort.instance == null)
			ListeCarteSort.instance = new ListeCarteSort();
		
		return ListeCarteSort.instance;
	}
	
	@Override
	public CarteSort getRandomCarte() throws NoSuchElementException {
		return (CarteSort)super.getRandomCarte();
	}
}
