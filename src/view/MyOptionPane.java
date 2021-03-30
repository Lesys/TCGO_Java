package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyOptionPane {

    public static final int YES = 0;
    public static final int NO = -1;

    private int choice = NO;

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
}