package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.FieldView;

import carte.CarteJeu;
import zone.Terrain;
import zone.ZoneTerrain;
import zone.ZoneTerrainAttaque;

public class MyOptionPane {

    public static final int YES = 0;
    public static final int NO = -1;
    public static final int MAYBE = 1;
    public static final int EXIT = -2;

    public static final int ATQ1 = 0;
    public static final int ATQ2 = 1;
    public static final int ATQ3 = 2;
    public static final int DEF1 = 3;
    public static final int DEF2 = 4;
    public static final int DEF3 = 5;

    private int choice = EXIT;
    
    private static int i = ATQ1;

    public int showYesNoMessage(String title, String message) {
    	return this.showYesNoMessage(title, message, "Yes", "No");
    }
    
    public int showYesNoMessage(String title, String message, String leftMessage, String rightMessage) {

        JLabel label = new JLabel(message);

        JButton yesButton = new JButton(leftMessage);
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = YES;
                JButton button = (JButton)e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });

        JButton noButton = new JButton(rightMessage);
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = NO;
                JButton button = (JButton)e.getSource();
                SwingUtilities.getWindowAncestor(button).dispose();
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(yesButton);
        buttons.add(noButton);

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(label, BorderLayout.CENTER);
        content.add(buttons, BorderLayout.SOUTH);

        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setTitle(title);
        dialog.getContentPane().add(content);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        return choice;
    }

    public int showZoneTerrainMessage(String title, String message, Terrain terrain) {

        JLabel label = new JLabel(message);

        //JPanel cartes = new JPanel(new GridLayout());

        JPanel zoneAttaque = new JPanel(new BorderLayout());
        JPanel zoneDefense = new JPanel(new BorderLayout());
        JPanel zones = new JPanel(new GridLayout(2, 1));
        
        zones.add(zoneAttaque);
        zones.add(zoneDefense);

        zoneAttaque.add(new JLabel("Zone d'attaque"), BorderLayout.NORTH);
        zoneAttaque.add(this.createZones(terrain.getZoneAttaque(), ATQ1), BorderLayout.CENTER); 
        zoneDefense.add(new JLabel("Zone de défense"), BorderLayout.NORTH);
        zoneDefense.add(this.createZones(terrain.getZoneDefense(), DEF1), BorderLayout.CENTER); 
        

        JPanel content = new JPanel(new BorderLayout(8, 8));
        content.add(label, BorderLayout.NORTH);
        content.add(zones, BorderLayout.CENTER);
        //content.add(zoneAttaque, BorderLayout.CENTER);
        //content.add(zoneDefense, BorderLayout.CENTER);

        JDialog dialog = new JDialog();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setTitle(title);
        dialog.getContentPane().add(content);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);

        return choice;
    }
    
    private JPanel createZones(ZoneTerrain zone, int iDebut) {
    	JPanel cartes = new JPanel(new GridLayout());
        i = iDebut;
    	zone.iterator().forEachRemaining(carte -> {
    		int j = i++;
            //JButton button = new JButton(carte.infosToString());
    		CarteJeu newCarte = (CarteJeu)carte.getCopy(); 
    		
    		newCarte.addMouseListener(new MouseListener() {
            	@Override
				public void mouseClicked(MouseEvent e) {
            		if (SwingUtilities.isLeftMouseButton(e)) {
	                    choice = j;
	                    CarteJeu carte = (CarteJeu)e.getSource();
	                    SwingUtilities.getWindowAncestor(carte).dispose();
            		}
				}

				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
            });
	
    		JPanel carteLabel = new JPanel(new BorderLayout());
    		carteLabel.add(new JLabel("Stats: " + carte.infosToString()), BorderLayout.SOUTH);
    		carteLabel.add(newCarte, BorderLayout.CENTER);
    		cartes.add(carteLabel);	
    	});
    	
    	return cartes;
    }
}