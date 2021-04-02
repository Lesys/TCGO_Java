package jeu;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import carte.Carte;
import carte.CartePerso;
import effet.StrategieEffet;
import effet.StrategieEffetBonusPersoMemeZone;
import ensemble.Main;
import joueur.*;
import view.JoueurView;
import view.PiocheView;
import view.TerrainView;
import view.ZoneTerrainView;
import ensemble.zone.ZoneTerrain;
import ensemble.zone.ZoneTerrainAttaque;

public class FenetreJeu extends JFrame implements ActionListener, Fenetre {
	/** Le bouton de création des joueurs
	 * 
	 * creationJoueurs ButtonExecuter
	 */
	/*
	private ButtonExecuter creationJoueurs;

	private JPanel joueur1;
	private JPanel joueur2;
	*/

	private JoueurView joueurView1;
	private JoueurView joueurView2;
	
	private JPanel plateauJoueur1;
	private JPanel plateauJoueur2;

	private JTextField pseudoJoueur1;
	private JTextField pseudoJoueur2;
	private ButtonExecuter buttonFinTourJ1;
	private ButtonExecuter buttonFinTourJ2;

	/*
	private JComboBox<TypeJoueur> typeJoueur1;
	private JComboBox<TypeJoueur> typeJoueur2;
	*/

	public FenetreJeu() {
		// Définit un titre pour notre fenêtre
		this.setTitle("Fenêtre de jeu");
		// Nous demandons maintenant à notre objet de se positionner au centre
		this.setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// this.jeu = new Jeu(10, 15);
		// this.jeu.initialisation();
		// Définit sa taille
		this.setSize(400, 400);

		this.setLayout(new BorderLayout());

		JPanel center = new JPanel();
		// new GridLayout(nbLignes, nbColonnes)
		center.setLayout(new GridLayout(2, 1));

		this.buttonFinTourJ1 = new ButtonExecuter("Fin du tour J1", StrategieButtonFinTour.getInstance());
		this.buttonFinTourJ1.addActionListener(this);
		this.buttonFinTourJ2 = new ButtonExecuter("Fin du tour J2", StrategieButtonFinTour.getInstance());
		this.buttonFinTourJ2.addActionListener(this);
		
		/*this.plateauJoueur1 = new JPanel();
		this.plateauJoueur1.setLayout(new GridLayout(1, 2));
		
		this.plateauJoueur2 = new JPanel();
		this.plateauJoueur2.setLayout(new GridLayout(1, 2));
*/

		this.joueurView1 = new JoueurView(1);
		this.joueurView2 = new JoueurView(2);
		
		this.buttonFinTourJ1 = new ButtonExecuter("Fin du tour J1", StrategieButtonFinTour.getInstance());
		this.buttonFinTourJ1.addActionListener(this);
		this.buttonFinTourJ2 = new ButtonExecuter("Fin du tour J2", StrategieButtonFinTour.getInstance());
		this.buttonFinTourJ2.addActionListener(this);

		JPanel viewJ1 = new JPanel(new BorderLayout());		
		viewJ1.add(this.joueurView1, BorderLayout.CENTER);
		viewJ1.add(this.buttonFinTourJ1, BorderLayout.SOUTH);
		
		JPanel viewJ2 = new JPanel(new BorderLayout());
		viewJ2.add(this.joueurView2, BorderLayout.CENTER);
		viewJ2.add(this.buttonFinTourJ2, BorderLayout.NORTH);
		
		/*JPanel buttons = new JPanel(new BorderLayout());
		buttons.add(this.buttonFinTourJ1, BorderLayout.NORTH);
		buttons.add(this.buttonFinTourJ2, BorderLayout.SOUTH);*/
		
		center.add(viewJ1);
		//center.add(buttons);
		center.add(viewJ2);


		this.joueurView1.getJoueur().setJoueurAdverse(this.joueurView2.getJoueur());
		this.joueurView2.getJoueur().setJoueurAdverse(this.joueurView1.getJoueur());
		this.joueurView1.getJoueur().debutTour();
		this.actualiser();
		
		// Tests
		// Les TextFields sont dans le bon sens (chaque joueur a sa partie 2 en dessous de la partie 1)
		//this.plateauJoueur1.add(new TextField("Zone Sort 1 joueur 1"));
		/*
		CartePerso carteTest = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest3 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/johan_card_verso.jpg", "nom", "anime", null, 1, 5, 2, 3);
		CartePerso carteTest2 = new CartePerso("/home/alexis/Documents/Java/TCGO_Java/src/images/logo.png", "nom", "anime", null, 1, 5, 2, 3);
		this.plateauJoueur1.add(carteTest);
		//carteTest.repaint();
		this.plateauJoueur1.add(new TextField("Zone Défense joueur 1 joueur 1"));
		this.plateauJoueur1.add(new TextField("Zone Sort 2 joueur 1"));
		ZoneTerrain zoneTerrainAttaque = new ZoneTerrainAttaque();
		zoneTerrainAttaque.poserCarte(carteTest);
		zoneTerrainAttaque.poserCarte(carteTest2);
		zoneTerrainAttaque.poserCarte(carteTest3);
		this.plateauJoueur1.add(new ZoneTerrainView(zoneTerrainAttaque));
		this.plateauJoueur2.add(new TextField("Zone Attaque joueur 2"));
		this.plateauJoueur2.add(new TextField("Zone Sort 2 joueur 2"));
		this.plateauJoueur2.add(new TextField("Zone Defense joueur 2"));
		this.plateauJoueur2.add(new TextField("Zone Sort 1 joueur 2"));*/
		
		// Fin tests

		this.add(center, BorderLayout.CENTER);
		
		/*
		this.creationJoueurs = new ButtonExecuter("Terminer", StrategieButtonCreationJoueurs.getInstance());
		this.creationJoueurs.addActionListener(this);
		
		this.add(center, BorderLayout.CENTER);
		//this.add(this.creationJoueurs, BorderLayout.SOUTH);

		//JPanel 
		//joueur1.add(this.pseudoJoueur1, BorderLayout.CENTER);
		
		this.pseudoJoueur1 = new JTextField();
		//this.pseudoJoueur1.addKeyListener(new KeyEnter(this.creationJoueurs));
		
		this.typeJoueur1 = new JComboBox<>();
		this.typeJoueur1.addItem(TypeJoueurLocal.getInstance());
		this.typeJoueur1.addItem(TypeJoueurBot.getInstance());
		this.typeJoueur1.addItem(TypeJoueurOnline.getInstance());

		//joueur1.add(new JLabel("Discussion", SwingConstants.CENTER), BorderLayout.NORTH);
		joueur1.add(this.pseudoJoueur1, BorderLayout.NORTH);
		joueur1.add(this.typeJoueur1, BorderLayout.SOUTH);

		this.pseudoJoueur2 = new JTextField();
		//this.pseudoJoueur2.addKeyListener(new KeyEnter(this.creationJoueurs));
		
		this.typeJoueur2 = new JComboBox<>();
		for (int i = 0; i < this.typeJoueur1.getItemCount(); i++)
			this.typeJoueur2.addItem(this.typeJoueur1.getItemAt(i));


		joueur2.add(this.pseudoJoueur2, BorderLayout.NORTH);
		joueur2.add(this.typeJoueur2, BorderLayout.SOUTH);
		*/
		this.setVisible(false);

		// Ajoute un événement sur la fermeture de la fenêtre qui enlève le pseudo des
		// connectés
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				handleClosing();
			}
		});

		// Et enfin, la rendre visible
		this.setVisible(true);
	}

	/** Permet d'activer certaines fonctionnalités lorsqu'il y a une action sur certains éléments
	 * 
	 * @param e		L'élément qui a subit l'action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		// Il n'y a qu'un seul bouton
		if (o instanceof ButtonExecuter) {
			ButtonExecuter butt = (ButtonExecuter)o;
			JoueurView jv = this.joueurView1;
			ButtonExecuter bt = this.buttonFinTourJ1;
			
			// Récupère les bons éléments en fonction du boutton appuyé
			if (butt == this.buttonFinTourJ1) {
				jv = this.joueurView1;
				bt = this.buttonFinTourJ1;
			}
			else if (butt == this.buttonFinTourJ2) {
				jv = this.joueurView2;
				bt = this.buttonFinTourJ2;
			}

			// Obligé de vérifier ici sinon l'actualisation redonne la possibilité d'attaquer
			if (jv.getJoueur().getMain().isTooMuch()) {
				JOptionPane.showMessageDialog(jv, jv.getJoueur().getNom() + ", vous devez vous débarasser d'au moins " + Integer.toString(jv.getJoueur().getMain().size() - Main.MAX_MAIN) + " avant de finir votre tour");
			}
			else {
				bt.executer(jv);
				this.actualiser();
			}
			/*
			if (!this.pseudoJoueur1.getText().equals("") && !this.pseudoJoueur2.getText().equals(""))
				((ButtonExecuter)o).executer(this);*/
		}
	}

	/** Permet de se déconnecter à la fermeture de la fenêtre
	 */
	public void handleClosing() {
		/*if (this.connectesPanel.isVisible())
			try {
				this.deconnexion();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//connectesPanel.deconnexion(this.connexionPanel.getNom());
			*/
	}
	/*
	public List<Joueur> getJoueurs() {
		List<Joueur> liste = new ArrayList<>();
		liste.add(new Joueur(this.pseudoJoueur1.getText(), (TypeJoueur)this.typeJoueur1.getSelectedItem()));
		liste.add(new Joueur(this.pseudoJoueur2.getText(), (TypeJoueur)this.typeJoueur2.getSelectedItem()));
		
		return liste;
	}*/

	@Override
	public void actualiser() {
		this.joueurView1.actualiser();
		this.joueurView2.actualiser();

		this.buttonFinTourJ1.setEnabled(this.joueurView1.getJoueur().peutJouer());
		this.buttonFinTourJ2.setEnabled(this.joueurView2.getJoueur().peutJouer());
	}
}
