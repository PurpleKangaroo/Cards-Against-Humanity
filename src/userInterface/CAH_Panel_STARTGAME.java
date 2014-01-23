package userInterface;

import game.CAH_Game;
import game.HouseRules;
import game.RuleConflictException;
import game.Rules;
import graphics.ImageLoad;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import cards.DeckBuilder;

public class CAH_Panel_STARTGAME extends JPanel{
	
	/**
	 * The background of this start screen.
	 */
	private JPanel background;
	
	/**
	 * The image that appears in the background
	 */
	private Image backgroundImage;
	
	/**
	 * The menu for choosing the games settings
	 */
	private CAH_Panel_STARTGAME_MENU menu;
	
	/**
	 * Creates an object that represents the start screen for Cards Against Humanity.
	 * @throws URISyntaxException 
	 * @since CAH1.0
	 */
	
	public CAH_Panel_STARTGAME() throws URISyntaxException
	{
		setBackground();
		
		menu = new CAH_Panel_STARTGAME_MENU();
		
		background.add(menu);
		
	}
	
	/**
	 * Paints the background of the panel
	 * @throws URISyntaxException
	 * @since CAH1.0
	 */
	private void setBackground() throws URISyntaxException
	{
		background = new JPanel();
		backgroundImage = ImageLoad.loadImage("signupbackground.jpg");
		background.paint(getGraphics());
		this.add(background);
		background.setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Rectangle r = new Rectangle(0, 0, this.getWidth(), this.getHeight());
		
		g2d.drawImage(backgroundImage, (int)r.getX(), (int)r.getY(), (int)backgroundImage.getWidth(this), (int)backgroundImage.getHeight(this), null);
	}

	public CAH_Game getGame() throws RuleConflictException, URISyntaxException, IOException
	{
		return menu.getGame();
	}
}
