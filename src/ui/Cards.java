package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cards.Deck;
import cards.DeckBuilder;
import cards.Decks;
import cards.QuestionCard;
import javax.swing.ListSelectionModel;

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
	 * The header for the question cards.
	 */
	private String qHeading;
	
	/**
	 * The iterator for the lists.
	 */
	private AttributedCharacterIterator iterator;
	
	/**
	 * Create the pane.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public Cards() throws URISyntaxException, IOException
	{
		createDecks();
		
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
		
		JScrollPane OriginalQ = new JScrollPane();
		OriginalQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Original.addTab("Black Cards", null, OriginalQ, null);
		
		ArrayList<QuestionCard> ArrLiOriginalQ = original.getQuestionCardList();
		
		String[] arrOriginalQ = new String[ArrLiOriginalQ.size()];
		
		for(int i = 0; i < ArrLiOriginalQ.size(); i++)
		{
			System.out.println(ArrLiOriginalQ.get(i).getCardString());
			arrOriginalQ[i] = formatQ(ArrLiOriginalQ.get(i).getCardString(), ArrLiOriginalQ.get(i).getDraw(), ArrLiOriginalQ.get(i).getPick());
		}
		
		JList OriginalQList = new JList(arrOriginalQ);
		OriginalQList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		OriginalQList.setVisibleRowCount(arrOriginalQ.length);
		OriginalQ.setViewportView(OriginalQList);
		
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
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{label, OriginalAnsList, tabbedPane, Original, OriginalQ, OriginalQList, OriginalAns, Expansion1, Expansion1Q, Expansion1Ans}));

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
		String str = new String();
		cardStr = cardStr.replaceAll("_", "______");
		
		for(int i = 0; i < 80; i++)
		{
			if(i < cardStr.length() && i < 86)
			{
				str = str + cardStr.charAt(i);
			}
			
			else if(i < cardStr.length())
			{
				str = str + ".";
			}
		}
		return str;
	}
}
