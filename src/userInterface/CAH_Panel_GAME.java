package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import users.Player;

/**
 * A class of object that represents the panel for the Game's UI.
 * @author Nick Walker
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
@SuppressWarnings("serial")
public class CAH_Panel_GAME extends JPanel {
	
	private Image blackCard;
	private Image whiteCard;
	private Font font = new Font("Helvetica", Font.PLAIN, 12);
	//TODO the font is not doing anything right now, it actually needs to be used, we need to make the card show the font.
	//TODO Also make the font larger, and then make it autosize to be slightly smaller for the REALLY long cards until it fits well.
	private AttributedCharacterIterator iterator;
	private int numberOfCards; //TODO need variable from somewhere else to plug in here, not sure where to get it.
	
	private ArrayList<String> cards; //TODO for testing, eventually a list of cards will be passed into this class and the text for each card will be used.
	
	public CAH_Panel_GAME(int numberOfCards, Player player) //TODO probably a player object will have to be passed into the constructor so we can draw the appropriate cards on the screen. 
	{
		this.numberOfCards = numberOfCards;
		//TODO start out with nobody having white cards and have animations showing them being dealt from the white card deck.(EVENTUALLY)
		ImageIcon b = new ImageIcon(this.getClass().getResource("Black_Card.png"));
		ImageIcon w = new ImageIcon(this.getClass().getResource("White_Card.png"));
		blackCard = b.getImage();
		whiteCard = w.getImage();  //card images are loaded
		
		this.setBackground(Color.lightGray);
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		FontRenderContext frc = g2d.getFontRenderContext(); //gets font render context, used to properly wrap text onto cards.
		
		
		int start;
		int end;
		int x = this.getWidth() / 40;
		int cardWidth = (this.getWidth() - (2*x)) / (numberOfCards);
		
		
		Rectangle r; 
		for (int i = 1; i <= numberOfCards; i++)  // this loop draws each card and then the text on top of it, works for any number of cards(within reason).
		{
			r = new Rectangle(x + ((i-1)*(cardWidth)), (this.getHeight() / 2) + (whiteCard.getHeight(null) / 2), cardWidth, whiteCard.getHeight(null));
			g2d.drawImage(whiteCard, (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), null);
			
			AttributedString text = new AttributedString(cards.get(i));
			iterator = text.getIterator();
			start = iterator.getBeginIndex();
			end = iterator.getEndIndex();
			LineBreakMeasurer measurer = new LineBreakMeasurer(iterator, frc);
			measurer.setPosition(start);
			float y = 0;
			while (measurer.getPosition() < end)  // this loop creates a new line when text goes past rectangle that text is drawn in, until string is fully drawn.
			{
				TextLayout layout = measurer.nextLayout((float) (r.getWidth()*.9));
				y += layout.getAscent();	
				layout.draw(g2d,(float) (r.getX() + .05*r.width), (float)(r.getY() + r.getHeight()*.1 + y));
				y+= layout.getDescent() + layout.getLeading();
				
			}
			
		}
		
	}

}
