package view;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import jeu.ButtonExecuter;
import jeu.Fenetre;
import jeu.Jeu;
import jeu.Observateur;
import joueur.Joueur;

public class JoueurView extends JPanel implements Observateur, ActionListener, Fenetre {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1262185793171937958L;
	/** Le joueur à qui appartient ce JPanel
	 * 
	 * @joueur Joueur
	 */
	private Joueur joueur;
	private TerrainView terrainView;
	private MainView mainView;
	private PiocheView piocheView;
	private DefausseView defausseView;
	private ZoneBannieView zoneBannieView;
	
	private CarteHerosView carteHerosView;
	
	// Listeners
	private ZoneListener zoneTerrainAttaqueListener;
	private ZoneListener zoneTerrainDefenseListener;
	private ZoneSortListener zoneSort1Listener;
	private ZoneSortListener zoneSort2Listener;
	private MainListener mainListener;
	private PiocheListener piocheListener;
	private DefausseListener defausseListener;
	private ZoneBannieListener zoneBannieListener;
	
	private JFrame window;
	
	public JoueurView(Jeu jeu) {
		//this.jeu = jeu;
/*
		this.window = new JFrame();
		// Définit un titre pour notre fenêtre
		this.window.setTitle("Jeu de la vie");
		// Nous demandons maintenant à notre objet de se positionner au centre
		this.window.setLocationRelativeTo(null);
		// Termine le processus lorsqu'on clique sur la croix rouge
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.window.setLayout(new BorderLayout());
		this.window.getContentPane().add(this, BorderLayout.CENTER);
		
		// Définit sa taille
		//this.window.setSize(this.tailleCellule * jeu.getXMax() + 200, this.window.getInsets().top + this.tailleCellule * jeu.getYMax() + 200);
		this.window.setSize(1000, 1000);*/
/*
		this.choixJoueursButton = new ButtonExecuter("Choisir joueurs", StrategieButtonChoixJoueurs.getInstance());
		this.choixJoueursButton.addActionListener(this);

		this.jouerButton = new ButtonExecuter("Lancer le jeu", StrategieButtonChoixJoueurs.getInstance());
		this.jouerButton.addActionListener(this);
*/
		/*this.slider = new JSlider(1, 10);
		this.slider.setPaintLabels(true);
		this.slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jeu.setTempsPause(slider.getValue());
			}
		});*/
		/*
		JPanel buttons, topButtons;
		this.window.getContentPane().add(buttons = new JPanel());

		buttons.setLayout(new BorderLayout());
		buttons.add(topButtons = new JPanel(), BorderLayout.NORTH);
		
		topButtons.setLayout(new GridLayout());
		topButtons.add(this.choixJoueursButton);
		topButtons.add(this.jouerButton);//, BorderLayout.NORTH);
		//topButtons.add(this.slider, BorderLayout.CENTER);
		*/

		//this.window.setVisible(true);
	}
	
	public JoueurView(int num) {
		this.joueur = Joueur.initTest();
		
		this.piocheView = new PiocheView(this.joueur.getPioche());
		
		this.mainView = new MainView(this.joueur.getMain());

		this.defausseView = new DefausseView(this.joueur.getDefausse());

		this.zoneBannieView = new ZoneBannieView(this.joueur.getZoneBannie());
		
		this.carteHerosView = new CarteHerosView(this.joueur.getHeros());
		//this.add(this.carteHerosView);
		this.setLayout(new GridLayout(2, 1));
		
		JPanel mainHeros = new JPanel();
		mainHeros.setLayout(new GridLayout(2, 1));
		
		JPanel plateau = new JPanel();
		plateau.setLayout(new GridLayout(1, 2));
		
		JPanel piocheDefausse = new JPanel();
		piocheDefausse.setLayout(new GridLayout(2, 1));
		
		JPanel defausseBannie = new JPanel();
		defausseBannie.setLayout(new GridLayout(1, 2));

		// Ajout à la fenêtre pour affichage
		if (num == 1) {

			this.terrainView = new TerrainView(this.joueur.getTerrain(), false);
			

			mainHeros.add(this.carteHerosView);
			mainHeros.add(this.mainView);
			this.add(mainHeros);
			this.add(plateau);
			plateau.add(piocheDefausse);
			plateau.add(this.terrainView);

			piocheDefausse.add(this.piocheView);
			
			defausseBannie.add(this.zoneBannieView);
			defausseBannie.add(this.defausseView);
			piocheDefausse.add(defausseBannie);
			
		}
		else {

			this.terrainView = new TerrainView(this.joueur.getTerrain(), true);

			piocheDefausse.add(defausseBannie);
			defausseBannie.add(this.defausseView);
			defausseBannie.add(this.zoneBannieView);
			
			piocheDefausse.add(this.piocheView);
			
			plateau.add(this.terrainView);
			plateau.add(piocheDefausse);
			this.add(plateau);
			this.add(mainHeros);
			mainHeros.add(this.mainView);
			mainHeros.add(this.carteHerosView);
		}
		
		// Gestion des events (Listeners)
		// Terrain
		this.zoneTerrainAttaqueListener = new ZoneTerrainAttaqueListener(this.joueur.getMain(), this.joueur.getTerrain().getZoneAttaque(), this.joueur);
		this.terrainView.getZoneAttaque().addMouseListener(this.zoneTerrainAttaqueListener);

		this.zoneTerrainDefenseListener = new ZoneTerrainDefenseListener(this.joueur.getMain(), this.joueur.getTerrain().getZoneDefense(), this.joueur);
		this.terrainView.getZoneDefense().addMouseListener(this.zoneTerrainDefenseListener);

		this.zoneSort1Listener = new ZoneSortListener(this.joueur.getMain(), this.joueur.getTerrain().getZoneSort1(), this.joueur);
		this.terrainView.getZoneSort1().addMouseListener(this.zoneSort1Listener);

		this.zoneSort2Listener = new ZoneSortListener(this.joueur.getMain(), this.joueur.getTerrain().getZoneSort2(), this.joueur);
		this.terrainView.getZoneSort2().addMouseListener(this.zoneSort2Listener);

		// Main
		this.mainListener = new MainListener(this.joueur.getMain(), this.joueur.getTerrain(), this.joueur);
		this.mainView.addMouseListener(this.mainListener);
		
		// Pioche
		this.piocheListener = new PiocheListener(this.joueur.getPioche(), this.joueur.getMain());
		this.piocheView.addMouseListener(this.piocheListener);

		// Defausse
		this.defausseListener = new DefausseListener(this.joueur.getDefausse());
		this.defausseView.addMouseListener(this.defausseListener);

		// ZoneBannie
		this.zoneBannieListener = new ZoneBannieListener(this.joueur.getZoneBannie());
		this.zoneBannieView.addMouseListener(this.zoneBannieListener);
	}
	
	public Joueur getJoueur() {
		return this.joueur;
	}

	/** Accesseur (getter) sur le jeu de la vie
	 * 
	 * @return		Le jeu de la vie joué
	 */
	/*public Jeu getJeu() {
		return this.jeu;
	}
*/
	/** Accesseur (getter) sur la fenêtre principale
	 * 
	 * @return		La fenêtre principale
	 */
	public JFrame getWindow() {
		return this.window;
	}

	/** Accesseur (getter) sur le bouton d'exécution
	 *  
	 *  @return		Le bouton d'exécution de l'interface graphique
	 */
	/*public ButtonExecuter getChoixJoueursButton() {
		return this.choixJoueursButton;
	}*/
	
	/** Permet d'activer certaines fonctionnalités lorsqu'il y a une action sur certains éléments
	 * 
	 * @param e		L'élément qui a subit l'action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o instanceof ButtonExecuter)
			((ButtonExecuter)o).executer(this);
	}

	@Override
	public void actualiser() {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		/*for (int x = 0; x < this.jeu.getXMax(); x++)
			for (int y = 0; y < this.jeu.getYMax(); y++)
				try {
					if (this.jeu.getGrilleXY(x, y).estVivante())
						g.fillOval(x * this.tailleCellule, y * this.tailleCellule, this.tailleCellule, this.tailleCellule);
				} catch (IndexOutOfBoundsException e) {
					// Normalement impossible
				}*/
	}

}
