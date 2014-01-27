package userInterface;

import graphics.ImageLoad;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import cards.AnswerCard;
import cards.Deck;
import cards.DeckBuilder;
import cards.Decks;
import cards.QuestionCard;

/**
 * An applet that shows different sets of cards on the side of the screen. (See the Cards Against Humanity Website to
 * get an idea of what we're aiming for here)
 * @author Holt Maki
 * @version CAH1.0
 * @since CAH1.0
 *
 */
public class CardComboApplet extends Applet /*implements Runnable*/ {
	private static final long serialVersionUID = 4209231469006359878L;
	/**
	 * The main deck.
	 */
	private Deck deck;
	/**
	 * The deck used for the holiday expansion.
	 */
	private Deck holiday;
	/**
	 * Whether or not it is the holiday season.
	 */
	private boolean holidaySeason;
	
	/**
	 * The image used for the white cards.
	 */
	private Image whiteCardImg;
	
	/**
	 * The image used for the CAH logo on white cards.
	 */
	private Image whiteLogo;
	
	/**
	 * The image used for the black cards.
	 */
	private Image blackCardImg;
	
	/**
	 * The image used for the CAH logo on black cards.
	 */
	private Image blackLogo;
	
	/**
	 * The queue of black cards' Strings.
	 */
	private Queue<QuestionCard> blackCards;
	
	/**
	 * The queue of white cards' Strings.
	 */
	private Queue<AnswerCard> whiteCards;
	
	/**
	 * The iterator.
	 */
	private AttributedCharacterIterator iterator;
	
	private Font font = new Font("Helvetica", Font.PLAIN, 12);
	
	/**
	 * Creates an applet that shows different combinations of cards against humanity cards.
	 * @throws URISyntaxException
	 * @throws IOException
	 * @since CAH1.0
	 */
	public CardComboApplet() throws URISyntaxException, IOException
	{
		setSize(500,300);
		
		this.setFont(font);
		
		whiteCards = new LinkedList<AnswerCard>();
		blackCards = new LinkedList<QuestionCard>();
		
		setHolidaySeason();
		createDecks();
		getImages();
		fillCardQueues();
	}
	
	/**
	 * Creates an applet that shows different combinations of cards against humanity cards.
	 * This constructor allows the dimensions to be set.
	 * @throws URISyntaxException
	 * @throws IOException
	 * @since CAH1.0
	 */
	public CardComboApplet(Dimension dimensions) throws URISyntaxException, IOException
	{
		setSize(dimensions);
		
		this.setFont(font);
		
		whiteCards = new LinkedList<AnswerCard>();
		blackCards = new LinkedList<QuestionCard>();
		
		setHolidaySeason();
		createDecks();
		getImages();
		fillCardQueues();
	}
	
	/**
	 * Gets whether or not it is currently the holiday season.
	 * @since CAH1.0
	 */
	@SuppressWarnings("static-access")
	private void setHolidaySeason()
	{
		Calendar currentTime = new GregorianCalendar();
		
		int month = currentTime.MONTH;
		int date = currentTime.DATE;
		
		if((month == 11 && date >= 29) || month == 12 || (month == 1 && date <= 6))
		{
			holidaySeason = true;
		}
	}
	
	/**
	 * Creates the decks.
	 * @throws URISyntaxException
	 * @throws IOException
	 * @since CAH1.0
	 */
	private void createDecks() throws URISyntaxException, IOException
	{
		Decks[] decklist = {Decks.ORIGINAL, Decks.EXPANSION1_0,	Decks.EXPANSION1_2, Decks.EXPANSION1, Decks.EXPANSION2, Decks.EXPANSION3, Decks.EXPANSION4};
		deck = new DeckBuilder(decklist).getDeck();
		Decks[] holidayDecks = {Decks.HOLIDAYEXPANSION};
		holiday = new DeckBuilder(holidayDecks).getDeck();
	}
	
	/**
	 * Gets the images that the applet needs.
	 * @since CAH1.0
	 */
	private void getImages()
	{
		blackCardImg = ImageLoad.loadImage("bc.png");
		whiteCardImg = ImageLoad.loadImage("wc.png");
		
		blackLogo = ImageLoad.loadImage("icon_b.png");
		whiteLogo = ImageLoad.loadImage("icon_w.png");
	}
	
	/**
	 * Fills the cardQueues ({@linkplain #blackCards} and {@linkplain #whiteCards}).
	 * This prevents one card from coming up too often.
	 * @since CAH1.0
	 */
	private void fillCardQueues()
	{
		while(blackCards.size() < 12)
		{
			Deck cardDeck = getDeck();
			QuestionCard blackCard = cardDeck.drawQuestionCard();
			
			if(!blackCards.contains(blackCard))
			{
				blackCards.add(blackCard);
			}
		}
		
		while(whiteCards.size() < blackCards.peek().getDraw() * 6)
		{
			Deck cardDeck = getDeck();
			AnswerCard whiteCard = cardDeck.drawAnswerCard();
			
			if(!whiteCards.contains(whiteCard))
			{
				whiteCards.add(whiteCard);
			}
		}
	}
	
	/**
	 * Gets a deck based on the time of year.
	 * If it is the holiday season, the deck has a 50% chance of being the holiday expansion.
	 * Durring the holiday season, if the holiday deck is not selected, then the deck will be the main deck and the non-holiday expansions.
	 * At other times of the year the deck will be the main deck with all the expansions except for the holiday expansion.
	 * @since CAH1.0
	 * @return cardDeck - the deck that the method gets based on randomness and the time of the year.
	 */
	private Deck getDeck()
	{
		Random r = new Random();
		
		Deck cardDeck;
		
		if(holidaySeason)
		{
			if(r.nextBoolean() == true)
			{
				cardDeck = holiday;
			}
			
			else
			{
				cardDeck = deck;
			}
			
		}
		
		else
		{
			cardDeck = deck;
		}
		
		return cardDeck;
	}
	
	/**
	 * Paints the applet.
	 * @param g - The graphics. (use {@code this.getGraphics()} in the paramater)
	 * @since CAH1.0
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		FontRenderContext frc = g2d.getFontRenderContext(); //gets font render context, used to properly wrap text onto cards.
		
		int start;
		int end;
		
		int numberOfCards = blackCards.peek().getDraw();
		
		int x = this.getWidth() / 40;
		int cardWidth = (this.getWidth() - (2*x)) / (numberOfCards + 1);
		
		Rectangle r; 
		for (int i = 1; i <= numberOfCards; i++)  // this loop draws each card and then the text on top of it, works for any number of cards(within reason).
		{
			r = new Rectangle(x + ((i-1)*(cardWidth)), (this.getHeight() / 2) + (whiteCardImg.getHeight(null) / 2), cardWidth, whiteCardImg.getHeight(null));
			g2d.drawImage(whiteCardImg, (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), null);
			
			AttributedString text = new AttributedString(whiteCards.remove().getCardString());
			
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
		
		r = new Rectangle(x + ((numberOfCards)*(cardWidth)), (this.getHeight() / 2) + (blackCardImg.getHeight(null) / 2), cardWidth, whiteCardImg.getHeight(null));
		g2d.drawImage(blackCardImg, (int)r.getX(), (int)r.getY(), (int)r.getWidth(), (int)r.getHeight(), null);
		
		AttributedString text = new AttributedString(blackCards.remove().getCardString());
		
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
	
	/**
	 * Runs the applet.
	 * @since CAH1.0
	 */
	/*
	@Override
	public void run() 
	{
		
	}
	*/
}