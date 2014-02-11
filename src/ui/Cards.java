package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

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
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class Cards extends JLayeredPane
{
	/**
	 * Serial Version ID.
	 */
	private static final long serialVersionUID = -5121016324694808164L;

	/**
	 * The card being displayed.
	 */
	private JPanel card;
	
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
	 * Creates the pane.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 * @throws IOException 
	 * @throws URISyntaxException 
	 */
	public Cards() throws URISyntaxException, IOException
	{
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
		decksTabbed.setBounds(84, 195, 883, 494);
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
		Exp1QList = new QColumnedList(Decks.EXPANSION1);//TODO Find a way of dealing with 1.0 and 1.2
		Expansion1ScrQ.setViewportView(Exp1QList);
		Exp1AList = new AList(Decks.EXPANSION1);//TODO Find a way of dealing with 1.0 and 1.2
		Expansion1ScrA.setViewportView(Exp1AList);
		
		Expansion2 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 2", null, Expansion2, null);
		
		Expansion3 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 3", null, Expansion3, null);
		
		Expansion4 = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Expansion 4", null, Expansion4, null);
		
		HolidayExpansion = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Holiday Expansion", null, HolidayExpansion, null);
		
		//TODO: Create deck and get cards for expansions
		
		GridBagLayout qScrollLayout = new GridBagLayout();
		GridBagConstraints qScrollConstraints = new QScrConstraints();
		
		qScrollLayout.setConstraints(originalQscr, qScrollConstraints);
		
		GridBagLayout Exp1qScrollLayout = new GridBagLayout();
		GridBagConstraints Exp1qScrollConstraints = new QScrConstraints();
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
				Exp1AList.setSelectedIndex(0);
				Exp1QList.setSelectedIndex(0);
				originalAns.setSelectedIndex(0);
				qList.setSelectedIndex(0);
				setCard();
			}
			
		});
		
		originalDeck.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				originalAns.setSelectedIndex(0);
				qList.setSelectedIndex(0);
				setCard();
			}
			
		});
		
		Expansion1.addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent arg0)
			{
				Exp1AList.setSelectedIndex(0);
				Exp1QList.setSelectedIndex(0);
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
		 * @param deck - the deck that is having its cards' data represented in the list.
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
		 * @param deck - the deck that is having its data found.
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
	public class QColumnedList extends JList
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
			
			super.setBackground(Color.BLACK);
			super.setAutoscrolls(false);
			super.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
			setFixedCellWidth(1532);
			
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
		 * @param deck - the deck that {@linkplain #getData(Decks[]) will find.
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
	 * 
	 *
	 */
	@SuppressWarnings({ "serial", "rawtypes" })
	public class QListCellRenderer extends JPanel implements ListCellRenderer
	{
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
	 * A class of object that represents the scroll constraints of a QColumnedList.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	private class QScrConstraints extends GridBagConstraints
	{
		/**
		 * Serial Version UID.
		 */
		private static final long serialVersionUID = 3715430882347157074L;

		/**
		 * Creates qScrConstraints
		 * @author Holt Maki
		 * @since CAH1.0
		 */
		private QScrConstraints()
		{
			gridx = 0;
			gridy = 0;
			
			gridwidth = 1;
			gridheight = 1;
			
			fill = GridBagConstraints.BOTH;
			anchor = GridBagConstraints.CENTER;
			insets = new Insets(1,1,1,1);
			
			weightx = 1.0;
			weighty = 1.0;
			
			originalQscr = new JScrollPane();
			originalQscr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		}
	}

	/**
	 * Sets the card panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public void setCard()
	{
		if(decksTabbed.getSelectedComponent().equals(originalDeck))
		{
			if(originalDeck.getSelectedComponent().equals(originalQscr))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.ORIGINAL}).getDeck().getQuestionCardList()).get(qList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Component) card).setBounds(1043, 210, 188, 270);
				this.add((Component) card);
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{(Component) card}));
			}
			else if(originalDeck.getSelectedComponent().equals(originalAnsScr))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.ORIGINAL}).getDeck().getAnswerCardList()).get(originalAns.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Component) card).setBounds(1043, 210, 188, 270);
				this.remove((Component)card);
				this.add((Component) card);
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{(Component) card}));
			}
		}
		else if(decksTabbed.getSelectedComponent().equals(Expansion1))
		{
			if(Expansion1.getSelectedComponent().equals(Expansion1ScrQ))
			{
				try
				{
					card = new BlackCard((new DeckBuilder(new Decks[] {Decks.EXPANSION1}).getDeck().getQuestionCardList()).get(Exp1QList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Component) card).setBounds(1043, 210, 188, 270);
				this.add((Component) card);
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{(Component) card}));
			}
			else if(Expansion1.getSelectedComponent().equals(Expansion1ScrA))
			{
				try
				{
					card = new WhiteCard((new DeckBuilder(new Decks[] {Decks.EXPANSION1}).getDeck().getAnswerCardList()).get(Exp1AList.getSelectedIndex()));
				} catch (URISyntaxException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				((Component) card).setBounds(1043, 210, 188, 270);
				this.remove((Component)card);
				this.add((Component) card);
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{(Component) card}));
			}
		}
	}
	
}
