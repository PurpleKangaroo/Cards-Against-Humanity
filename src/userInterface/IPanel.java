package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JPanel;

/**
 * A class of object that represents a panel that contains an image for a background.
 * @author Holt Maki
 *
 */
public class IPanel extends JPanel{
	private Image background;
	
	public IPanel(Image background)
	{
		this.background = background;
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, null);
	}

}
