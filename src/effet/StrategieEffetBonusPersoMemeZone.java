package effet;

import carte.CartePerso;
import java.util.*;

public class StrategieEffetBonusPersoMemeZone extends StrategieEffet {
	protected int attaque;
	protected int pv;
	protected List<String> noms;
	protected boolean effetActif;
	
	public StrategieEffetBonusPersoMemeZone(CartePerso carte, int attaque, int pv) {
		super(carte);
		
		this.attaque = attaque;
		this.pv = pv;
		
		this.noms = new ArrayList<>();
		
		this.effetActif = false;
	}
	
	/** Ajoute un nom de carte comme requit pour que l'effet soit possible
	 * 
	 * @param nom		Le nom d'une carte
	 */
	public void ajouterCarte(String nom) {
		this.noms.add(nom);
	}
	
	@Override
	public void effetPassif() {
		/*
		 * Si effetActif faux:
		 * 		Si un des noms est présent sur une carte dans la même zone que cette carte:
		 * 			ajoute l'attaque et le vie à la carte
		 * 			change le boolean à vrai
		 * si vrai:
		 * 		Si nons pas présents
		 * 			enlève les bonus
		 * 			change le boolean à faux
		 * 
		 * Pour optimiser: changer la fonction au lieu du boolean
		 * 
		 */
	}
}
