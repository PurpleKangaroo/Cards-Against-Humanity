package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;

import javax.swing.JComponent;

public class PictureComponent extends JComponent 
{
	private static final long serialVersionUID = 482010733964737901L;
	
	public PictureComponent()
	{
		
	}
	
	public void paintComponent(Graphics g, Image picture)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(picture, 100, 100, this);
	}
}
