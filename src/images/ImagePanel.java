package images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private final int LENGTH_FIN_REF = 7;
    private BufferedImage image;

    public ImagePanel(String link) {
       try {
    	   String path = "";
    	   if (!link.equals("logo.png") && !link.equals("johan_card_verso.jpg"))
    		   path = link.substring(0, link.length() - LENGTH_FIN_REF) + "/";
    	   //System.out.println("path: " + path);
          image = ImageIO.read(this.getClass().getResource("/images/" + path + link));
       } catch (IOException ex) {
    	   ex.printStackTrace();
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}
