package ensemble;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jeu.ButtonExecuter;
import joueur.*;

public class FenetreCreationDeck extends JFrame implements ActionListener, Fenetre {
	/** Le bouton de création du deck
	 * 
	 * creationDeck ButtonExecuter
	 */
	private ButtonExecuter creationDeck;

	private JTextField pseudoJoueur1;
	private JTextField pseudoJoueur2;

	private JComboBox<TypeJoueur> typeJoueur1;
	private JComboBox<TypeJoueur> typeJoueur2;
	
	public FenetreCreationDeck() {
		// Définit un titre pour notre fenêtre
		this.setTitle("Enregistrement des joueurs");
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
		//center.setLayout(new GridLayout(2, 1));
		
		JPanel joueur1 = new JPanel();
		joueur1.setLayout(new GridLayout(2, 1));
		
		JPanel joueur2 = new JPanel();
		joueur2.setLayout(new GridLayout(2, 1));

		center.add(joueur1);
		center.add(joueur2);
		
		this.creationJoueurs = new ButtonExecuter("Terminer", StrategieButtonCreationJoueurs.getInstance());
		this.creationJoueurs.addActionListener(this);
		
		this.add(center, BorderLayout.CENTER);
		this.add(this.creationJoueurs, BorderLayout.SOUTH);

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
			if (!this.pseudoJoueur1.getText().equals("") && !this.pseudoJoueur2.getText().equals(""))
				((ButtonExecuter)o).executer(this);
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
	
	public List<Joueur> getJoueurs() {
		List<Joueur> liste = new ArrayList<>();
		liste.add(new Joueur(this.pseudoJoueur1.getText(), (TypeJoueur)this.typeJoueur1.getSelectedItem()));
		liste.add(new Joueur(this.pseudoJoueur2.getText(), (TypeJoueur)this.typeJoueur2.getSelectedItem()));
		
		return liste;
	}
}
