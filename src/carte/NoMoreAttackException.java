package carte;

public class NoMoreAttackException extends Exception {	
	public NoMoreAttackException() {
		super("La carte essaie d'attaquer alors qu'elle ne possède plus d'attaque ou de PV.");
	}
	
	public NoMoreAttackException(CartePerso carte) {
		super("La carte " + carte.getNom() + " essaie d'attaquer alors qu'il ne lui reste " + (carte.getNbAttaqueRestantes() == 0 ? "plus d'attaques" : (carte.getPv() <= 0 ? "plus de PV" : "???")));
	}
	
}
