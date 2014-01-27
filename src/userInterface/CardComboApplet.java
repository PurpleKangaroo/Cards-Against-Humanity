package userInterface;

import graphics.ImageLoad;

import java.applet.Applet;
import java.awt.Image;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import cards.Deck;
import cards.DeckBuilder;
import cards.Decks;

/**
 * An applet that shows different sets of cards on the side of the screen. (See the Cards Against Humanity Website to
 * get an idea of what we're aiming for here)
 * @author Holt Maki
 * @version CAH1.0
 * @since CAH1.0
 *
 */
public class CardComboApplet extends Applet implements Runnable {
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
	 * The current month
	 */
	private int month;
	
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
	 * Creates an applet that shows different combinations of cards against humanity cards.
	 * @throws URISyntaxException
	 * @throws IOException
	 * @since CAH1.0
	 */
	public CardComboApplet() throws URISyntaxException, IOException
	{
		getMonth();
		createDecks();
		getImages();
	}
	
	/**
	 * Gets the current month in order to better choose the cards \
	 * (in december, there will be a 50% chance of getting a holiday card)
	 * @since CAH1.0
	 */
	@SuppressWarnings("static-access")
	private void getMonth()
	{
		Calendar currentTime = new GregorianCalendar();
		month = currentTime.MONTH;
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
	 * Runs the applet.
	 * @since CAH1.0
	 */
	@Override
	public void run() {
		
		
	}

}