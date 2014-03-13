package ui;

import graphics.ImageResize;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import cards.AnswerCard;

public class SmallWhiteCard extends WhiteCard
{

	public SmallWhiteCard(AnswerCard card)
	{
		super(card);
		setFocusTraversalPolicyProvider(true);
		setBackground(new Color(Color.TRANSLUCENT));
		setSize(new Dimension(141, 202));
		setLayout(null);
		setOpaque(false);
		
		String str = new String();
		str = card.getCardString();		
		
		JTextPane textArea = new JTextPane();
		textArea.setContentType("text/html");
		if(str.length() < 85)
		{
			textArea.setText("<html><body style=\"font-family: Arial Black; font-size:11; font-color: BLACK\">" + str + "</body></html>");
			textArea.setDisabledTextColor(Color.BLACK);
			textArea.setFont(new Font("Arial Black", Font.PLAIN, 15));
		}
		else
		{
			textArea.setText("<html><body style=\"font-family: Arial Black; font-size:10; font-color: BLACK\">" + str + "</body></html>");
			textArea.setDisabledTextColor(Color.BLACK);
			textArea.setFont(new Font("Arial Black", Font.PLAIN, 14));
		}
		
		textArea.setAutoscrolls(false);
		textArea.setEnabled(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.BLACK);
		textArea.setOpaque(false);
		textArea.setBounds(12, 9, 117, 135);
		add(textArea);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(20, 224, 87, 15);
		try
		{
			lblLogo.setIcon(ImageResize.resizeImageIcon(ImageIO.read(WhiteCard.class.getResource("/graphics/icon_w.png")), .75));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(lblLogo);
		
		JLabel lblCard = new JLabel("");
		lblCard.setBounds(0, 3, 141, 202);
		try
		{
			lblCard.setIcon(ImageResize.resizeImageIcon(ImageIO.read(WhiteCard.class.getResource("/graphics/wc.png")), .75));
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		add(lblCard);
		
		setTrueLocation();
	}

}
