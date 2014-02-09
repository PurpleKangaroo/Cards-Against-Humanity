package ui;

import graphics.ImageLoad;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Color;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ListCellRenderer;

import cards.DeckBuilder;
import cards.Decks;
import cards.QuestionCard;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

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
	 * The list with all of the questions for CAH's original deck.
	 */
	private JList qList;
	
	/**
	 * The array list of the different question cards from the original CAH deck.
	 */
	private ArrayList<QuestionCard> qCards;
	
	/**
	 * The boolean that tells whether or not the JPanel is running.
	 */
	private boolean running;
	
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
		running = true;
		
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
		
		
		DeckBuilder original = new DeckBuilder(new Decks[]{Decks.ORIGINAL});
		qCards = original.getDeck().getQuestionCardList();
		String[][] qCardsData = new String[qCards.size()][2];
		for(int i = 0; i < qCards.size(); i++)
		{
			qCardsData[i][0] = "<html><body style=\"color:WHITE\">" + qCards.get(i).getCardString() + "</body></html>";
			qCardsData[i][1] = "    "+ qCards.get(i).getDraw() + "               " + qCards.get(i).getPick() + "";
		}
		
		GridBagLayout qScrollLayout = new GridBagLayout();
		GridBagConstraints qScrollConstraints = new GridBagConstraints();
		
		qScrollConstraints.gridx = 0;
		qScrollConstraints.gridy = 0;
		
		qScrollConstraints.gridwidth = 1;
		qScrollConstraints.gridheight = 1;
		
		qScrollConstraints.fill = GridBagConstraints.BOTH;
		qScrollConstraints.anchor = GridBagConstraints.CENTER;
		qScrollConstraints.insets = new Insets(1,1,1,1);
		
		qScrollConstraints.weightx = 1.0;
		qScrollConstraints.weighty = 1.0;
		
		originalQscr = new JScrollPane();
		originalQscr.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		qScrollLayout.setConstraints(originalQscr, qScrollConstraints);
		
		originalDeck.addTab("Black Cards", null, originalQscr, null);
		
		qList = new QColumnedList(qCardsData);
		qList.setForeground(Color.WHITE);
		qList.setSelectionBackground(new Color(0, 153, 255));
		qList.setSelectionForeground(Color.WHITE);
		
		qList.setBackground(Color.BLACK);
		qList.setAutoscrolls(false);
		qList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		originalQscr.setViewportView(qList);
		
		JLabel lblCardText = new JLabel("Card Text" +
										"                                                                                                                         " + 
										"                                                                                                                   " +
										"Draw" + "          " + "Pick");
		lblCardText.setHorizontalTextPosition(SwingConstants.LEFT);
		originalQscr.setColumnHeaderView(lblCardText);
		
		JList originalAns = new JList();
		originalAns.setSelectionBackground(new Color(0, 153, 255));
		originalDeck.addTab("White Cards", null, originalAns, null);
		
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
		
		qList.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0)
			{
				setCard();
			}
			
		});
	}
	
	/**
	 * A class of object that represents a columned list.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	@SuppressWarnings({ "serial", "rawtypes" })
	public class QColumnedList extends JList
	{
		/**
		 * The data that the list contains.
		 */
		private String[][] data;
		
		/**
		 * Creates a new QColumnedList.
		 * @since CAH1.0
		 * @author Holt Maki
		 * @param data the data that will be represented in the columns
		 */
		@SuppressWarnings("unchecked")
		public QColumnedList(String[][] data)
		{
			this.data = data;
			super.setListData(this.data);
			super.setCellRenderer(new QListCellRenderer());
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
			
			return this;
		}
		
	}

	public void setCard()
	{
		if(decksTabbed.getSelectedComponent().equals(originalDeck))
		{
			if(originalDeck.getSelectedComponent().equals(originalQscr))
			{
				card = new BlackCard(qCards.get(qList.getSelectedIndex()));
				((Component) card).setBounds(1043, 210, 188, 270);
				this.add((Component) card);
				this.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{(Component) card}));
			}
		}
	}
	
}
