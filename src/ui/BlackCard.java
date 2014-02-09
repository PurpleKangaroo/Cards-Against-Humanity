package ui;

import javax.swing.JPanel;

import cards.QuestionCard;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

import java.awt.Color;
import java.awt.Font;

/**
 * A class of object that represents a Black CAH card in the form of a panel.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see WhiteCard
 * @see cards.QuestionCard
 *
 */
public class BlackCard extends JPanel
{

	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param card - the {@linkplain QuestionCard} represented by the panel.
	 */
	public BlackCard(QuestionCard card)
	{
		setFocusTraversalPolicyProvider(true);
		setBackground(new Color(Color.TRANSLUCENT));
		setSize(new Dimension(188, 270));
		setLayout(null);
		
		String str = new String();
		str = card.getCardString();		
		
		JTextArea textArea = new JTextArea(str);
		textArea.setDisabledTextColor(Color.WHITE);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textArea.setAutoscrolls(false);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setOpaque(false);
		textArea.setBounds(10, 11, 168, 192);
		add(textArea);
		
		
		JLabel d2p3 = new JLabel("");
		d2p3.setBounds(new Rectangle(0, 0, 522, 37));
		d2p3.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/draw2pick3.png")));
		d2p3.setBounds(20, 206, 51, 40);
		add(d2p3);
		
		JLabel p2 = new JLabel("");
		p2.setBounds(new Rectangle(0, 0, 51, 21));
		p2.setSize(new Dimension(51, 21));
		p2.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/pick2.png")));
		p2.setBounds(20, 227, 51, 21);
		add(p2);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setSize(new Dimension(87, 15));
		lblLogo.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/icon_b.png")));
		lblLogo.setBounds(91, 233, 87, 15);
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(BlackCard.class.getResource("/graphics/bc.png")));
		add(lblCard);
		
		if(card.getDraw() != 2 || card.getPick() != 3)
		{
			d2p3.setVisible(false);
		}
		
		if(card.getPick() != 2)
		{
			p2.setVisible(false);
		}
		
	}

}
