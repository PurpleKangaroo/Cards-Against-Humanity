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
public class WhiteCard extends JPanel implements CardDisplay
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
	 */
	public WhiteCard(AnswerCard card)
	{
		setSize(new Dimension(188, 270));
		setMinimumSize(new Dimension(188, 270));
		setMaximumSize(new Dimension(188, 270));
		setOpaque(false);
		setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(91, 233, 87, 15);
		lblLogo.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/icon_w.png")));
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/wc.png")));
		add(lblCard);
		
		JTextArea cardTextArea = new JTextArea();
		cardTextArea.setText(card.getCardString());
		cardTextArea.setFont(new Font("Arial Black", Font.BOLD, 12));//TODO make font autosize to fit better.
		cardTextArea.setDisabledTextColor(Color.BLACK);
		cardTextArea.setEditable(false);
		cardTextArea.setEnabled(false);
		cardTextArea.setWrapStyleWord(true);
		cardTextArea.setOpaque(false);
		cardTextArea.setAutoscrolls(false);
		cardTextArea.setBounds(10, 11, 168, 216);
		add(cardTextArea);
		answerCard = card;
	}
	
	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 * @param cardStr - the string that will appear on the panel.
	 */
	public WhiteCard(String cardStr)
	{
		setSize(new Dimension(188, 270));
		setMinimumSize(new Dimension(188, 270));
		setMaximumSize(new Dimension(188, 270));
		setOpaque(false);
		setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(91, 233, 87, 15);
		lblLogo.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/icon_w.png")));
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 5, 188, 270);
		lblCard.setIcon(new ImageIcon(WhiteCard.class.getResource("/graphics/wc.png")));
		add(lblCard);
		
		JTextArea cardTextArea = new JTextArea();
		cardTextArea.setText(cardStr);
		cardTextArea.setFont(new Font("Arial Black", Font.BOLD, 12));//TODO make font autosize to fit better.
		cardTextArea.setDisabledTextColor(Color.BLACK);
		cardTextArea.setEditable(false);
		cardTextArea.setEnabled(false);
		cardTextArea.setWrapStyleWord(true);
		cardTextArea.setOpaque(false);
		cardTextArea.setAutoscrolls(false);
		cardTextArea.setBounds(10, 11, 168, 216);
		add(cardTextArea);
		try
		{
			answerCard = new AnswerCard(cardStr);
		} catch (URISyntaxException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
