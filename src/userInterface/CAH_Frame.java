package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import graphics.PictureComponent;
import import_export.pathFinder;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComponent;

/**
 * A class of object that makes the frame that a Cards Against Humanity game is run in.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Frame extends JFrame{
	
	/**
	 * Creates a new frame in which a cards against of humanity game is shown in.
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public CAH_Frame() throws IOException, URISyntaxException
	{
		super("Cards Against Humanity");
		pathFinder a = new pathFinder();
		setDefaultLookAndFeelDecorated(true);
		setIconImage(new ImageIcon(a.getCAH_Path("/Cards Against Humanity/src/CAH_GraphicsFiles/CAHIcon.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setMinimumSize(new Dimension(800,600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	/**
	 * Paints the frame.
	 * @param g - the graphics that will be painted onto the frame
	 * @since CAH1.0
	 */
	public void Paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
	}
	
	public static void main(String [] args) throws URISyntaxException, IOException
	{
		pathFinder a = new pathFinder();
		CAH_Frame b = new CAH_Frame();
	}

}
