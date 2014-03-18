package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import cards.AnswerCard;
import cards.DeckBuilder;
import cards.Decks;
import cards.QuestionCard;

/**
 * A class of object that represents the layered pane that contains information about a players statistics.
 * <html><p><img src="https://raw.github.com/PurpleKangaroo/Cards-Against-Humanity/master/Screenshots/CardsViewer.png" height="300px" width="562px"/>
 * </p>
 * <p>
 * A picture of the card viewer's screen.
 * </html>
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Cards extends JLayeredPane
{
	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -5121016324694808164L;

	/**
	 * The card being displayed.
	 */
	private UICard card;
	
	/**
	 * The tabbed pane with all the decks tabs.
	 */
	private JTabbedPane decksTabbed;
	
	/**
	 * The tabbed pane for the original deck.
	 */
	private JTabbedPane originalDeck;
	
	/**
	 * The scroll pane for the original CAH deck's questions.
	 */
	private JScrollPane originalQscr;
	
	/**
	 * The scroll pane for the original CAH deck's answers.
	 */
	private JScrollPane originalAnsScr;
	
	/**
	 * The list with all of the questions for CAH's original deck.
	 */
	@SuppressWarnings("rawtypes")
	private JList qList;
	
	/**
	 * The list with all of the answers for CAH's original deck.
	 */
	@SuppressWarnings("rawtypes")
	private JList originalAns;

	/**
	 * The JTabbedPane for the first CAH expansion.
	 */
	private JTabbedPane Expansion1;

	/**
	 * The JTabbedPane for the second CAH expansion.
	 */
	private JTabbedPane Expansion2;
	
	/**
	 * The JTabbedPane for the third CAH expansion.
	 */
	private JTabbedPane Expansion3;
	
	/**
	 * The JTabbedPane for the fourth CAH expansion.
	 */
	private JTabbedPane Expansion4;
	
	/**
	 * The JTabbedPane for the CAH Holiday expansion.
	 */
	private JTabbedPane HolidayExpansion;

	/**
	 * The JScrollPane for the First CAH expansion's Answers.
	 */
	private JScrollPane Expansion1ScrA;

	/**
	 * The AList for the first expansions white cards.
	 */
	private AList Exp1AList;

	/**
	 * The QColumned List for Expansion1.
	 */
	private QColumnedList Exp1QList;

	/**
	 * The scroll pane for the first expansion black cards.
	 */
	private JScrollPane Expansion1ScrQ;
	
	/**
	 * The scroll pane for the second expansion black cards.
	 */
	private JScrollPane Expansion2ScrQ;
	
	/**
	 * The JScrollPane for the Second CAH expansion's Answers.
	 */
	private JScrollPane Expansion2ScrA;

	/**
	 * The AList for the second expansions white cards.
	 */
	private AList Exp2AList;

	/**
	 * The QColumned List for Expansion2.
	 */
	private QColumnedList Exp2QList;
	/**
	 * The scroll pane for the second expansion black cards.
	 */
	private JScrollPane Expansion3ScrQ;
	
	/**
	 * The JScrollPane for the Second CAH expansion's Answers.
	 */
	private JScrollPane Expansion3ScrA;

	/**
	 * The AList for the second expansions white cards.
	 */
	private AList Exp3AList;

	/**
	 * The QColumned List for Expansion2.
	 */
	private QColumnedList Exp3QList;
	
	/**
	 * The scroll pane for the fourth expansion black cards.
	 */
	private JScrollPane Expansion4ScrQ;
	
	/**
	 * The JScrollPane for the fourth CAH expansion's Answers.
	 */
	private JScrollPane Expansion4ScrA;

	/**
	 * The AList for the fourth expansions white cards.
	 */
	private AList Exp4AList;

	/**
	 * The QColumned List for Expansion4.
	 */
	private QColumnedList Exp4QList;
	/**
	 * The scroll pane for the 2012 CAH Holiday Expansion's black cards.
	 */
	private JScrollPane ExpansionHScrQ;
	
	/**
	 * The JScrollPane for the 2012 CAH Holiday Expansion's white cards.
	 */
	private JScrollPane ExpansionHScrA;

	/**
	 * The AList for the for the 2012 CAH Holiday Expansion.
	 */
	private AList ExpHAList;

	/**
	 * The QColumned List for the 2012 CAH Holiday Expansion.
	 */
	private QColumnedList ExpHQList;
	
	/**
	 * The JTabbedPane for the pax expansion.
	 */
	private JTabbedPane PAX_Expansion;
	
	/**
	 * The JScrollPane for the 2013 CAH Pax East Expansion Answers.
	 */
	private JScrollPane PAXScrA;
	
	/**
	 * The JScrollPane for the 2013 CAH Pax East Expansion Questions.
	 */
	private JScrollPane PAXScrQ;
	/**
	 * The AList for the for the 2013 CAH PAX Expansion.
	 */
	private AList ExpPAXAList;

	/**
	 * The QColumned List for the 2012 CAH PAX Expansion.
	 */
	private QColumnedList ExpPAXQList;
	
	
	/**
	 * A number that needs to be included as a field for the bounce ActionListner to access it and change it.
	 */
	private int count;
	
	/**
	 * Creates the pane.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public CAH_Cards() throws URISyntaxException, IOException
	{
		originalQscr = new JScrollPane();
		originalQscr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		setOpaque(true);
		setBorder(null);
		setBackground(Color.BLACK);
		setMaximumSize(new Dimension(1450, 700));
		setBounds(new Rectangle(0, 0, 1450, 700));
		final JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		
		decksTabbed = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.setBounds(84, 190, 883, 494);
		add(decksTabbed);
		
		originalDeck = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Original", null, originalDeck, null);
		
		Expansion1 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 1", null, Expansion1, null);
		
		Expansion1ScrQ = new JScrollPane();
		Expansion1ScrQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion1.addTab("Black Cards", null, Expansion1ScrQ, null);
		
		Expansion1ScrA = new JScrollPane();
		Expansion1ScrA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion1.addTab("White Cards", null, Expansion1ScrA, null);
		Exp1QList = new QColumnedList(Decks.EXPANSION1);
		Expansion1ScrQ.setViewportView(Exp1QList);
		Exp1AList = new AList(Decks.EXPANSION1);
		Expansion1ScrA.setViewportView(Exp1AList);
		
		Expansion2 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 2", null, Expansion2, null);
		
		Expansion2ScrQ = new JScrollPane();
		Expansion2ScrQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion2.addTab("Black Cards", null, Expansion2ScrQ, null);
		
		Expansion2ScrA = new JScrollPane();
		Expansion2ScrA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion2.addTab("White Cards", null, Expansion2ScrA, null);
		Exp2QList = new QColumnedList(Decks.EXPANSION2);
		Expansion2ScrQ.setViewportView(Exp2QList);
		Exp2AList = new AList(Decks.EXPANSION2);
		Expansion2ScrA.setViewportView(Exp2AList);
		
		Expansion3 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 3", null, Expansion3, null);
		Expansion3ScrQ = new JScrollPane();
		Expansion3ScrQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion3.addTab("Black Cards", null, Expansion3ScrQ, null);
		Expansion3ScrA = new JScrollPane();
		Expansion3ScrA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion3.addTab("White Cards", null, Expansion3ScrA, null);
		Exp3QList = new QColumnedList(Decks.EXPANSION3);
		Expansion3ScrQ.setViewportView(Exp3QList);
		Exp3AList = new AList(Decks.EXPANSION3);
		Expansion3ScrA.setViewportView(Exp3AList);
		
		Expansion4 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 4", null, Expansion4, null);
		Expansion4ScrQ = new JScrollPane();
		Expansion4ScrQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion4.addTab("Black Cards", null, Expansion4ScrQ, null);
		Expansion4ScrA = new JScrollPane();
		Expansion4ScrA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		Expansion4.addTab("White Cards", null, Expansion4ScrA, null);
		Exp4QList = new QColumnedList(Decks.EXPANSION4);
		Expansion4ScrQ.setViewportView(Exp4QList);
		Exp4AList = new AList(Decks.EXPANSION4);
		Expansion4ScrA.setViewportView(Exp4AList);
		
		HolidayExpansion = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Holiday Expansion", null, HolidayExpansion, null);
		ExpansionHScrQ = new JScrollPane();
		ExpansionHScrQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		HolidayExpansion.addTab("Black Cards", null, ExpansionHScrQ, null);
		ExpansionHScrA = new JScrollPane();
		ExpansionHScrA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		HolidayExpansion.addTab("White Cards", null, ExpansionHScrA, null);
		ExpHQList = new QColumnedList(Decks.HOLIDAYEXPANSION);
		ExpansionHScrQ.setViewportView(ExpHQList);
		ExpHAList = new AList(Decks.HOLIDAYEXPANSION);
		ExpansionHScrA.setViewportView(ExpHAList);
		
		PAX_Expansion = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("PAX East Expansion", null, PAX_Expansion, null);
		PAXScrQ = new JScrollPane();
		PAXScrQ.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		PAX_Expansion.addTab("Black Cards", null, PAXScrQ, null);
		PAXScrA = new JScrollPane();
		PAXScrA.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		PAX_Expansion.addTab("White Cards", null,PAXScrA, null);
		ExpPAXQList = new QColumnedList(Decks.PAXEXPANSION);
		PAXScrQ.setViewportView(ExpPAXQList);
		ExpPAXAList = new AList(Decks.PAXEXPANSION);
		PAXScrA.setViewportView(ExpPAXAList);
		
		GridBagLayout qScrollLayout = new GridBagLayout();
		GridBagConstraints qScrollConstraints = new ListScrConstraints();
		
		qScrollLayout.setConstraints(originalQscr, qScrollConstraints);
		
		GridBagLayout Exp1qScrollLayout = new GridBagLayout();
		GridBagConstraints Exp1qScrollConstraints = new ListScrConstraints();
		Exp1qScrollLayout.setConstraints(Expansion1ScrQ,Exp1qScrollConstraints);
		
		originalDeck.addTab("Black Cards", null, originalQscr, null);
		
		qList = new QColumnedList(Decks.ORIGINAL);
		
		originalQscr.setViewportView(qList);
		
		JLabel lblCardText = new JLabel("Card Text" +
										"                                                                                                                         " + 
										"                                                                                                                   " +
										"Draw" + "          " + "Pick");
		lblCardText.setHorizontalTextPosition(SwingConstants.LEFT);
		originalQscr.setColumnHeaderView(lblCardText);
		Expansion1ScrQ.setColumnHeaderView(new JLabel("Card Text" +
				"                                                                                                                         " + 
				"                                                                                                                   " +
				"Draw" + "          " + "Pick"));
		
		Expansion2ScrQ.setColumnHeaderView(new JLabel("Card Text" +
				"                                                                                                                         " + 
				"                                                                                                                   " +
				"Draw" + "          " + "Pick"));
		
		Expansion3ScrQ.setColumnHeaderView(new JLabel("Card Text" +
				"                                                                                                                         " + 
				"                                                                                                                   " +
				"Draw" + "          " + "Pick"));
		
		Expansion4ScrQ.setColumnHeaderView(new JLabel("Card Text" +
				"                                                                                                                         " + 
				"                                                                                                                   " +
				"Draw" + "          " + "Pick"));
		
		ExpansionHScrQ.setColumnHeaderView(new JLabel("Card Text" +
				"                                                                                                                         " + 
				"                                                                                                                   " +
				"Draw" + "          " + "Pick"));
		PAXScrQ.setColumnHeaderView(new JLabel("Card Text" +
				"                                                                                                                         " + 
				"                                                                                                                   " +
				"Draw" + "          " + "Pick"));
		
		originalAnsScr = new JScrollPane();
		originalAnsScr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		GridBagLayout AnsScrollLayout = new GridBagLayout();
		GridBagConstraints AnsScrollConstraints = new GridBagConstraints();
		
		AnsScrollLayout.setConstraints(originalAnsScr, AnsScrollConstraints);
		
		GridBagLayout Exp1ScrollLayouta = AnsScrollLayout;
		GridBagConstraints ExpScrollConstraintsa = AnsScrollConstraints;
		Exp1ScrollLayouta.setConstraints(Expansion1ScrA, ExpScrollConstraintsa);
		
		
		originalDeck.addTab("Black Cards", null, originalAnsScr, null);
		
		originalAns = new AList(Decks.ORIGINAL);
		
		originalDeck.addTab("White Cards", null, originalAnsScr, null);
		
		originalAnsScr.setViewportView(originalAns);
		
		qList.setSelectedIndex(0);
		
		setCard();
		
		decksTabbed.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		originalDeck.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		Expansion1.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		Expansion2.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		Expansion3.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		Expansion4.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		HolidayExpansion.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
		
		PAX_Expansion.addChangeListener(new ChangeListener()
		{
			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				setCard();
			}
			
		});
	}
	
	/**
	 * A class of object that represents a list of answer cards.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	@SuppressWarnings("rawtypes")
	public class AList extends JList
	{
		/**
		 * Serial Version ID.
		 */
		private static final long serialVersionUID = 708725502667733498L;
		/**
		 * The data that the list contains.
		 * In this case the data is the {@linkplain cards.AnswerCard}s' card strings.
		 */
		private String[] data;

		/**
		 * Creates the list.
		 * @author Holt Maki
		 * @since CAH1.0
		 * @param deck the deck that is having its cards' data represented in the list.
		 * @throws URISyntaxException
		 * @throws IOException
		 */
		@SuppressWarnings("unchecked")
		public AList(Decks deck) throws URISyntaxException, IOException
		{
			findData(deck);
			super.setListData(this.data);
			super.setCellRenderer(new AListCellRenderer());
			super.setSelectedIndex(0);
			super.setSelectionBackground(new Color(0, 153, 255));
			setSelectedIndex(0);
			addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent arg0)
				{
					setCard();
				}
				
			});
			
		}
		
		/**
		 * Finds the data for the list.
		 * @param deck the deck that is having its data found.
		 * @since CAH1.0
		 * @author Holt Maki
		 * @throws URISyntaxException
		 * @throws IOException
		 */
		private void findData(Decks deck) throws URISyntaxException, IOException
		{
			DeckBuilder deckBuild = new DeckBuilder(new Decks[] {deck});
			ArrayList<AnswerCard> aCards = deckBuild.getDeck().getAnswerCardList();
			data = new String[aCards.size()];
			for(int i = 0; i < aCards.size(); i++)
			{
				data[i] = aCards.get(i).getCardString();
			}
		}
	}
	
	/**
	 * A class of object that represents a columned list.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	@SuppressWarnings({"rawtypes" })
	private class QColumnedList extends JList
	{
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 9052427212230650147L;
		/**
		 * The data that the list contains.
		 */
		private String[][] data;
		
		/**
		 * Creates a new QColumnedList.
		 * @since CAH1.0
		 * @author Holt Maki
		 * @param deck the deck whose cards will be represented in the columns
		 * @throws IOException 
		 * @throws URISyntaxException 
		 */
		@SuppressWarnings("unchecked")
		public QColumnedList(Decks deck) throws URISyntaxException, IOException
		{
			findData(deck);
			super.setListData(this.data);
			super.setCellRenderer(new QListCellRenderer());
			super.setForeground(Color.WHITE);
			super.setSelectionBackground(new Color(0, 153, 255));
			super.setSelectionForeground(Color.WHITE);
			
			super.setBackground(new Color(3,3,3));
			super.setAutoscrolls(false);
			super.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			setFixedCellWidth(1532);
			setSelectedIndex(0);
			
			addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent arg0)
				{
					setCard();
				}
				
			});
		}
		
		/**
		 * Finds the list data for the deck.
		 * @param deck the deck that {@linkplain #getData(Decks[]) will find.
		 * @since CAH1.0
		 * @throws URISyntaxException
		 * @throws IOException
		 */
		private void findData(Decks deck) throws URISyntaxException, IOException
		{
			DeckBuilder deckBuild = new DeckBuilder(new Decks[] {deck});
			ArrayList<QuestionCard> qCards = deckBuild.getDeck().getQuestionCardList();
			data = new String[qCards.size()][2];
			for(int i = 0; i < qCards.size(); i++)
			{
				data[i][0] = "<html><body style=\"color:WHITE\">" + qCards.get(i).getCardString() + "</body></html>";
				data[i][1] = "    "+ qCards.get(i).getDraw() + "               " + qCards.get(i).getPick() + "";
			}
		}
	}
	
	/**
	 * A class of object that renders the cells of the {@linkplain cards.QuestionCard}s {@linkplain javax.swing.JList}.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 * @see QColumnedList
	 * @see CAH_NewGame.PlayerListCellRenderer
	 *
	 */
	@SuppressWarnings("rawtypes")
	private class QListCellRenderer extends JPanel implements ListCellRenderer
	{
		/**
		 * Generated serial version UID.
		 */
		private static final long serialVersionUID = -6162000359458934287L;
		/**
		 * The {@linkplain cards.QuestionCard}s' {@linkplain cards.Card#cardString}.
		 */
		private JLabel cardStr;
		/**
		 * The number of cards drawn and the number of cards picked for the {@linkplain cards.QuestionCard}
		 */
		private JLabel drawpick;
		
		/**
		 * Creates the renderer.
		 * @since CAH1.0
		 * @author Holt Maki		
		 */
		private QListCellRenderer()
		{
			setLayout(new GridLayout(1,3));
			
			cardStr = new JLabel();
			drawpick = new JLabel();
			
			cardStr.setOpaque(true);
			drawpick.setOpaque(true);
			
			add(cardStr);
			add(drawpick);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus)
		{
			String cardStrData = ((String[])value)[0];
			String drawpickData = ((String[])value)[1];
			
			cardStr.setText(cardStrData);
			drawpick.setText(drawpickData + "");
			
			drawpick.setBounds(drawpick.getX(), drawpick.getY(), 5, drawpick.getHeight());
			
			if(isSelected)
			{
				drawpick.setBackground(list.getSelectionBackground());
				drawpick.setForeground(list.getSelectionForeground());
				
				cardStr.setBackground(list.getSelectionBackground());
				cardStr.setForeground(list.getSelectionForeground());
			}
			
			else
			{
				drawpick.setBackground(list.getBackground());
				drawpick.setForeground(list.getForeground());
				
				cardStr.setBackground(list.getBackground());
				cardStr.setForeground(list.getForeground());
			}
			
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			
			list.setFixedCellWidth(766);
			
			return this;
		}
		
	}
	
	/**
	 * An answer card list cell renderer.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	@SuppressWarnings("rawtypes")
	public class AListCellRenderer extends JPanel implements ListCellRenderer
	{
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 6935093632361065411L;
		
		/**
		 * The {@linkplain cards.AnswerCard}s' {@linkplain cards.Card#cardString}.
		 */
		private JLabel cardStr;
		
		/**
		 * Creates the renderer.
		 * @since CAH1.0
		 * @author Holt Maki		
		 */
		private AListCellRenderer()
		{
			setLayout(new GridLayout(1,1));
			
			cardStr = new JLabel();
			
			cardStr.setOpaque(true);
			
			add(cardStr);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus)
		{
			String cardStrData = (String) (value);
			
			cardStr.setText(cardStrData);
			
			if(isSelected)
			{				
				cardStr.setBackground(list.getSelectionBackground());
				cardStr.setForeground(list.getSelectionForeground());
			}
			
			else
			{				
				cardStr.setBackground(list.getBackground());
				cardStr.setForeground(list.getForeground());
			}
			
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			
			return this;
		}
		
	}
	
	/**
	 * Sets the card panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public void setCard()
	{
		try
		{
			remove(card);
			repaint();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		if(decksTabbed.getSelectedComponent().equals(originalDeck))
		{
			if(originalDeck.getSelectedComponent().equals(originalQscr))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.ORIGINAL}).getDeck().getQuestionCardList()).get(qList.getSelectedIndex()));
				}
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(originalDeck.getSelectedComponent().equals(originalAnsScr))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.ORIGINAL}).getDeck().getAnswerCardList()).get(originalAns.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(Expansion1))
		{
			if(Expansion1.getSelectedComponent().equals(Expansion1ScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.EXPANSION1}).getDeck().getQuestionCardList()).get(Exp1QList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(Expansion1.getSelectedComponent().equals(Expansion1ScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.EXPANSION1}).getDeck().getAnswerCardList()).get(Exp1AList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(Expansion2))
		{
			if(Expansion2.getSelectedComponent().equals(Expansion2ScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.EXPANSION2}).getDeck().getQuestionCardList()).get(Exp2QList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(Expansion2.getSelectedComponent().equals(Expansion2ScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.EXPANSION2}).getDeck().getAnswerCardList()).get(Exp2AList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(Expansion3))
		{
			if(Expansion3.getSelectedComponent().equals(Expansion3ScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.EXPANSION3}).getDeck().getQuestionCardList()).get(Exp3QList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(Expansion3.getSelectedComponent().equals(Expansion3ScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.EXPANSION3}).getDeck().getAnswerCardList()).get(Exp3AList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(Expansion4))
		{
			if(Expansion4.getSelectedComponent().equals(Expansion4ScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.EXPANSION4}).getDeck().getQuestionCardList()).get(Exp4QList.getSelectedIndex()));
				} 
				catch (URISyntaxException e)
				{
					e.printStackTrace();
				} 
				catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(Expansion4.getSelectedComponent().equals(Expansion4ScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.EXPANSION4}).getDeck().getAnswerCardList()).get(Exp4AList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(HolidayExpansion))
		{
			if(HolidayExpansion.getSelectedComponent().equals(ExpansionHScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.HOLIDAYEXPANSION}).getDeck().getQuestionCardList()).get(ExpHQList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(HolidayExpansion.getSelectedComponent().equals(ExpansionHScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.HOLIDAYEXPANSION}).getDeck().getAnswerCardList()).get(ExpHAList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(PAX_Expansion))
		{
			if(PAX_Expansion.getSelectedComponent().equals(PAXScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.PAXEXPANSION}).getDeck().getQuestionCardList()).get(ExpPAXQList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
			else if(PAX_Expansion.getSelectedComponent().equals(PAXScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.PAXEXPANSION}).getDeck().getAnswerCardList()).get(ExpPAXAList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					e.printStackTrace();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
				bounceIn();
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{card}));
			}
		}
	}
	
	/**
	 * Makes a the card bounce into view.
	 * @since CAH1.0 
	 */
	protected void bounceIn()
	{
		firePropertyChange("STOPT", false, true);
		final int targetX = 1106;
		final int targetY = 210;
		
		(card).setBounds(1106, -260, 188, 270);
		
		this.add(card);
		this.moveToFront(card);
		card.move(targetX, targetY + 6, .1);
		
		count = 0;
		
		final ActionListener timerlistener = (new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				if(count == 0)
				{
					count++;
					card.move(targetX, targetY - 4, .1);
				}
				else if(count == 1)
				{
					card.move(targetX, targetY, .1);
				}
				else
				{
					firePropertyChange("STOPT", false, true);
				}
			}
		});
		
		final Timer t = new Timer(100, timerlistener);
		t.start();
		
		this.addPropertyChangeListener("STOPT", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent arg0)
			{
				if(!((boolean) arg0.getOldValue()) && ((boolean) arg0.getNewValue()))
				{
					t.stop();
					t.removeActionListener(timerlistener);
				}
			}
			
		});
	}
	
	/**
	 * Adds the main menu button and the background.
	 * @param button - the button being added.
	 * @since CAH1.0
	 */
	protected void addMainMenu(JComponent button)
	{
		this.add(button);
		final JLabel CardsBackground = new JLabel("");
		CardsBackground.setBounds(0, 0, 1450, 752);
		CardsBackground.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/bg.jpg")));
		add(CardsBackground);
	}
}
