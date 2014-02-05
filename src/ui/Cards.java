package ui;

import javax.swing.JLayeredPane;

import java.awt.Rectangle;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Point;
import java.awt.Dimension;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.ListModel;

import cards.Deck;
import cards.DeckBuilder;
import cards.Decks;
import cards.QuestionCard;

/**
 * A class of object that represents the JLayeredPane that contains the information about each of the cards and their decks.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class Cards extends JLayeredPane
{

	/**
	 * The original Cards Against Humanity deck.
	 */
	private Deck original;
	
	/**
	 * Create the pane.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public Cards()
	{
		setMaximumSize(new Dimension(1450, 700));
		setOpaque(true);
		setBackground(Color.BLACK);
		setBounds(new Rectangle(0, 0, 1450, 700));
		
		JLabel label = new JLabel("Cards Against Humanity");
		label.setLocation(new Point(83, 43));
		label.setBounds(new Rectangle(83, 43, 1024, 139));
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial Black", Font.BOLD, 70));
		label.setBounds(83, 43, 1024, 139);
		add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(90, 179, 533, 480);
		add(tabbedPane);
		
		JTabbedPane Original = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Original", null, Original, null);
		
		JPanel OriginalQ = new JPanel();
		Original.addTab("Black Cards", null, OriginalQ, null);
		ArrayList<QuestionCard> ArrLiOriginalQ = original.getQuestionCardList();
		
		String[] arrOriginalQ = new String[ArrLiOriginalQ.size()];
		
		for(int i = 0; i < ArrLiOriginalQ.size(); i++)
		{
			arrOriginalQ[i] = 
		}
		
		JList OriginalQList = new JList();
		OriginalQ.add(OriginalQList);		
		
		JPanel OriginalAns = new JPanel();
		Original.addTab("White Cards", null, OriginalAns, null);
		
		JList OriginalAnsList = new JList();
		OriginalAns.add(OriginalAnsList);
		
		JTabbedPane Expansion1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addTab("Expansion 1", null, Expansion1, null);
		
		JPanel Expansion1Q = new JPanel();
		Expansion1.addTab("Black Cards", null, Expansion1Q, null);
		
		JPanel Expansion1Ans = new JPanel();
		Expansion1.addTab("White Cards", null, Expansion1Ans, null);

	}
	
	/**
	 * Creates the decks.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	private void createDecks() throws URISyntaxException, IOException
	{
		DeckBuilder originalDeckBuilder = new DeckBuilder(new Decks[]{Decks.ORIGINAL});
		original = originalDeckBuilder.getDeck();
	}
	
	/**
	 * Formats a string for the lists.
	 * @param cardStr - the card string that is being formatted.
	 * @param draw - the integer that says how many cards are drawn for a certain question card.
	 * @param play - the integer that says how many cards are played for a certain question card.
	 * @return str - the now formatted String.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	private String formatQ(String cardStr, int draw, int play)
	{
		for(int i = 0; i < 50; i++)
		{
			
		}
	}
}
