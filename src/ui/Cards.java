package ui;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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

/**
 * A class of object that represents the layered pane that contains information about a players statistics.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class Cards extends JLayeredPane
{
	private JScrollPane originalQscr;

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
		
		JTabbedPane decksTabbed = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.setBounds(84, 195, 883, 494);
		add(decksTabbed);
		
		JTabbedPane originalDeck = new JTabbedPane(JTabbedPane.TOP);
		decksTabbed.addTab("Original", null, originalDeck, null);
		
		
		DeckBuilder original = new DeckBuilder(new Decks[]{Decks.ORIGINAL});
		ArrayList<QuestionCard> qCards = original.getDeck().getQuestionCardList();
		String[][] qCardsData = new String[qCards.size()][3];
		for(int i = 0; i < qCards.size(); i++)
		{
			qCardsData[i][0] = qCards.get(i).getCardString();
			qCardsData[i][1] = qCards.get(i).getDraw() + "";
			qCardsData[i][2] = qCards.get(i).getPick() + "";
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
		
		qScrollLayout.setConstraints(originalQscr, qScrollConstraints);
		
		originalDeck.addTab("Black Cards", null, originalQscr, null);
		
		JList qList = new QColumnedList(qCardsData);
		qList.setAutoscrolls(false);
		qList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		originalQscr.setViewportView(qList);
		
		JList originalAns = new JList();
		originalDeck.addTab("White Cards", null, originalAns, null);

	}
	
	/**
	 * A class of object that represents a columned list.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	@SuppressWarnings("serial")
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
	public class QListCellRenderer extends JPanel implements ListCellRenderer
	{
		/**
		 * The {@linkplain cards.QuestionCard}s' {@linkplain cards.Card#cardString}.
		 */
		private JLabel cardStr;
		/**
		 * The number of cards drawn for the {@linkplain cards.QuestionCard}
		 */
		private JLabel draw;
		
		/**
		 * The number of cards picked for the {@linkplain cards.QuestionCard}.
		 */
		private JLabel pick;
		
		/**
		 * Creates the renderer.
		 * @since CAH1.0
		 * @author Holt Maki		
		 */
		private QListCellRenderer()
		{
			setLayout(new GridLayout(1,3));
			
			cardStr = new JLabel();
			draw = new JLabel();
			pick = new JLabel();
			
			cardStr.setOpaque(true);
			draw.setOpaque(true);
			pick.setOpaque(true);
			
			add(cardStr);
			add(draw);
			add(pick);
		}
		
		@Override
		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus)
		{
			String cardStrData = ((String[])value)[0];
			String drawData = ((String[])value)[1];
			String pickData = ((String[])value)[2];
			
			cardStr.setText(cardStrData);
			draw.setText(drawData + "");
			pick.setText(pickData + "");
			
			draw.setBounds(draw.getX(), draw.getY(), 5, draw.getHeight());
			pick.setBounds(pick.getX(), pick.getY(), 5, pick.getHeight());
			
			if(isSelected)
			{
				draw.setBackground(list.getSelectionBackground());
				draw.setForeground(list.getSelectionForeground());
				
				pick.setBackground(list.getSelectionBackground());
				pick.setForeground(list.getSelectionForeground());
				
				cardStr.setBackground(list.getSelectionBackground());
				cardStr.setForeground(list.getSelectionForeground());
			}
			
			else
			{
				draw.setBackground(list.getBackground());
				draw.setForeground(list.getForeground());
				
				pick.setBackground(list.getBackground());
				pick.setForeground(list.getForeground());
				
				cardStr.setBackground(list.getBackground());
				cardStr.setForeground(list.getForeground());
			}
			
			setEnabled(list.isEnabled());
			setFont(list.getFont());
			
			return this;
		}
		
	}
}
