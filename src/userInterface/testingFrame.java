package userInterface;

import graphics.ImageLoad;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.net.URISyntaxException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class testingFrame extends JFrame{
	
	Image backgroundImage;
	JPanel background;
	
	public testingFrame() throws URISyntaxException
	{
		super("Cards Against Humanity");
		super.setLayout(new BorderLayout());
		setBackground();
		this.add(background);
		pack();
		setVisible(true);
	}
	
	private void setBackground() throws URISyntaxException
	{
		background = new JPanel();
		backgroundImage = ImageLoad.loadImage("signupbackground.jpg");
		background.paint(getGraphics());
		this.add(background);
		background.setVisible(true);
		this.imageUpdate(backgroundImage, WIDTH, 0, 0, WIDTH, HEIGHT);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Rectangle r = new Rectangle(0, 0, this.getWidth(), this.getHeight());
		
		g2d.drawImage(backgroundImage, (int)r.getX(), (int)r.getY(), (int)backgroundImage.getWidth(this), (int)backgroundImage.getHeight(this), null);
	}
	
	public void scale()
	{
		
	}

	public static void main(String[] args) throws URISyntaxException
	{
		testingFrame a = new testingFrame();
	}
}
