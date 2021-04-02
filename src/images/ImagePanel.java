package images;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

	private final int LENGTH_FIN_REF = 7;
    protected BufferedImage image;

	protected int diffSize;

    public ImagePanel(String link) {
       try {
    	   String path = "";
    	   if (!link.equals("logo.png") && !link.equals("johan_card_verso.jpg") && !link.equals("johan_card_verso.png"))
    		   path = link.substring(0, link.length() - LENGTH_FIN_REF) + "/";

    	   	image = ImageIO.read(this.getClass().getResource("/images/" + path + link));

			this.diffSize = (int)Math.round(this.image.getHeight() / 5);
       } catch (IOException ex) {
    	   ex.printStackTrace();
       }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.drawImage(image, 0, 0, 250, 370, this); // see javadoc for more info on the parameters
        int w, h;
        w = getWidth() > this.image.getWidth() ? this.image.getWidth() : this.image.getWidth() / 2;
        h = getHeight() > this.image.getHeight() ? this.image.getHeight() : this.image.getHeight() / 2;

        g.drawImage(image, 0, 0, w, h, this); // see javadoc for more info on the parameters
    }

    @Override
    public Dimension getPreferredSize() {
    	//System.out.println("Dims: " + this.image.getWidth() + " / " + this.image.getHeight());
    	return new Dimension(this.image.getWidth(), this.image.getHeight());
    }
    
    @Override
    public Dimension getMinimumSize() {
    	return new Dimension(this.image.getWidth() / 2, this.image.getHeight() / 2);
    }
    
    public int getDiffSize() {
    	return this.diffSize;
    }

    public void resize() {
		double divSize = 2.2;
	    Image tmp = this.image.getScaledInstance((int)Math.round(this.image.getWidth() / divSize), (int)Math.round(this.image.getHeight() / divSize), Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage((int)Math.round(this.image.getWidth() / divSize), (int)Math.round(this.image.getHeight() / divSize), BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();

	    this.image = dimg;
    }
    
}
