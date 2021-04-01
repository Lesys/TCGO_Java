package carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public abstract class ListeCarte extends Dictionary<String, Carte> implements Iterable<String> {
	protected Dictionary<String, Carte> listeCartes;
	private static ListeCarte instance;
	
	protected ListeCarte() {
	}
	
	public static ListeCarte getInstance() {
		return ListeCarte.instance;
	}

	@Override
	public Enumeration<Carte> elements() {
		return this.listeCartes.elements();
	}

	@Override
	public Carte get(Object key) {
		return this.listeCartes.get(key);
	}

	@Override
	public boolean isEmpty() {
		return this.listeCartes.isEmpty();
	}

	@Override
	public Enumeration<String> keys() {
		return this.listeCartes.keys();
	}

	@Override
	public Carte put(String arg0, Carte arg1) {
		return this.listeCartes.put(arg0, arg1);
	}

	@Override
	public Carte remove(Object key) {
		return this.listeCartes.remove(key);
	}

	@Override
	public int size() {
		return this.listeCartes.size();
	}
	
	public Carte getRandomCarte() throws NoSuchElementException {		
		int rdInt = (new Random()).nextInt() % this.size();
		int i;
		Enumeration<Carte> e;
		
		for (e = this.elements(), i = 0; e.hasMoreElements() && i < rdInt; e.nextElement(), i++);
		
		return e.nextElement();
		
	}

	public String getRandomRef() throws NoSuchElementException {		
		int rdInt = (new Random()).nextInt() % this.size();
		int i;
		Enumeration<String> e;
		
		for (e = this.keys(), i = 0; e.hasMoreElements() && i < rdInt; e.nextElement(), i++);
		
		return e.nextElement();
		
	}

	@Override
	public Iterator<String> iterator() { 		
		return this.getArrayString().iterator();
	}
	
	/**
	 * @return		La liste des clés du dictionnaire
	 */
	public ArrayList<String> getArrayString() {
		ArrayList<String> list = new ArrayList<>();

		for (Enumeration<String> e = this.keys(); e.hasMoreElements();)
			list.add(e.nextElement());
		
		Collections.sort(list);
		return list;
	}
}
