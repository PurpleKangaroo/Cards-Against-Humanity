package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import cards.AnswerCard;


/**
 * A class of object that represents a white CAH card.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see BlackCard
 * @see cards.AnswerCard
 *
 */
public class WhiteCard extends JPanel
{
	
	/**
	 * The card represented by the WhiteCard.
	 */
	private AnswerCard answerCard;

	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param card - The {@linkplain AnswerCard} that the panel represents.
	 * @wbp.parser.constructor
	 */
	public WhiteCard(AnswerCard card)
	{
		setFocusTraversalPolicyProvider(true);
		setBackground(new Color(Color.TRANSLUCENT));
		setSize(new Dimension(188, 270));
		setLayout(null);
		
		String str = new String();
		str = card.getCardString();		
		
		JTextArea textArea = new JTextArea(str);
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textArea.setAutoscrolls(false);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setOpaque(false);
		textArea.setBounds(10, 11, 168, 192);
		add(textArea);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(91, 233, 87, 15);
		lblLogo.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/icon_w.png")));
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/wc.png")));
		add(lblCard);
		
		answerCard = card;
	}
}
