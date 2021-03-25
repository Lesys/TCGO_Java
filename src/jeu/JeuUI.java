package jeu;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JeuUI extends JPanel implements Observateur, ActionListener, Fenetre {
	/** Taille de la cellule (en pixel ?)
	 * 
	 * @tailleCellule int
	 */
	private final int tailleCellule = 6;
	/** Le jeu de la vie à lancer
	 * 
	 * @jeu Jeu
	 */
	private Jeu jeu;
	/** Le bouton d'exécution du jeu (lancement + pause)
	 * 
	 * @choixJoueursButton ButtonExecuter
	 */
	private ButtonExecuter choixJoueursButton;
	/** Le bouton d'exécution du jeu (lancement + pause)
	 * 
	 * @choixJoueursButton ButtonExecuter
	 */
	private ButtonExecuter jouerButton;

	/** Constructeur par défaut initialisant la fenêtre du jeu, les boutons et les différents composants
	 *  
	 *  @param jeu		Le jeu à jouer
	 */
	
	private JFrame window;
	
	public JeuUI(Jeu jeu) {
		this.jeu = jeu;

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
		this.window.setSize(1000, 1000);

		this.choixJoueursButton = new ButtonExecuter("Choisir joueurs", StrategieButtonChoixJoueurs.getInstance());
		this.choixJoueursButton.addActionListener(this);

		this.jouerButton = new ButtonExecuter("Lancer le jeu", StrategieButtonChoixJoueurs.getInstance());
		this.jouerButton.addActionListener(this);

		/*this.slider = new JSlider(1, 10);
		this.slider.setPaintLabels(true);
		this.slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				jeu.setTempsPause(slider.getValue());
			}
		});*/
		
		JPanel buttons, topButtons;
		this.window.getContentPane().add(buttons = new JPanel());

		buttons.setLayout(new BorderLayout());
		buttons.add(topButtons = new JPanel(), BorderLayout.NORTH);
		
		topButtons.setLayout(new GridLayout());
		topButtons.add(this.choixJoueursButton);
		topButtons.add(this.jouerButton);//, BorderLayout.NORTH);
		//topButtons.add(this.slider, BorderLayout.CENTER);
		

		this.window.setVisible(true);
	}

	/** Accesseur (getter) sur le jeu de la vie
	 * 
	 * @return		Le jeu de la vie joué
	 */
	public Jeu getJeu() {
		return this.jeu;
	}

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
	public ButtonExecuter getChoixJoueursButton() {
		return this.choixJoueursButton;
	}
	
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
