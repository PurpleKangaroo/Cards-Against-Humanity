package ui;

import game.CAH_Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import netplay.ChatMessage;
import users.Player;

import java.awt.FlowLayout;

/**
 * The layered pane that contains the game.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class GamePane extends JLayeredPane {
	/**
	 * The game of Cards Against Humanity being shown in the pane.
	 */
	private CAH_Game game;
	
	/**
	 * The player who is playing the game through this pane.
	 */
	private String username;
	
	/**
	 * The text field where people can enter their chat messages.
	 */
	private JTextField chatEntry;

	/**
	 * Creates the panel.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @param game - the game of CAH being shown in the pane.
	 * @param player - the player who is playing the game on the computer that is showing the pane.
	 * 
	 */
	public GamePane(CAH_Game game, String username) 
	{
		this.username = username;
		this.game = game;
		
		setBounds(new Rectangle(0, 0, 1450, 700));
		setLayout(null);
		setMinimumSize(new Dimension(1400, 700));
		setMaximumSize(new Dimension(1450, 700));
		
		JPanel MainGamePanel = new JPanel();
		MainGamePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		MainGamePanel.setBackground(Color.BLACK);
		MainGamePanel.setBounds(0, 140, 1000, 560);
		add(MainGamePanel);
		MainGamePanel.setLayout(null);
		
		BlankBlackCard blankBlackCard = new BlankBlackCard();
		blankBlackCard.setLocation(32, 145);
		MainGamePanel.add(blankBlackCard);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(230, 279, 760, 270);
		panel.setLayout(null);
		MainGamePanel.add(panel);
		
		BlankWhiteCard blankWhiteCard_3 = new BlankWhiteCard();
		blankWhiteCard_3.setBounds(150, 0, 188, 270);
		panel.add(blankWhiteCard_3);
		
		BlankWhiteCard blankWhiteCard_4 = new BlankWhiteCard();
		blankWhiteCard_4.setBounds(100, 0, 188, 270);
		panel.add(blankWhiteCard_4);
		
		BlankWhiteCard blankWhiteCard_2 = new BlankWhiteCard();
		blankWhiteCard_2.setBounds(50, 0, 188, 270);
		panel.add(blankWhiteCard_2);
		
		BlankWhiteCard blankWhiteCard = new BlankWhiteCard();
		blankWhiteCard.setLocation(0,0);
		panel.add(blankWhiteCard);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(230, 11, 760, 270);
		MainGamePanel.add(panel_1);
		
		BlankWhiteCard blankWhiteCard_1 = new BlankWhiteCard();
		blankWhiteCard_1.setBounds(0, 0, 188, 270);
		panel_1.add(blankWhiteCard_1);
		
		JPanel chatPanel = new JPanel();
		chatPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		chatPanel.setBackground(Color.BLACK);
		chatPanel.setBounds(1000, 140, 284, 304);
		add(chatPanel);
		chatPanel.setLayout(null);
		
		JTextPane chatTextPane = new JTextPane();
		chatTextPane.setEditable(false);
		chatTextPane.setForeground(new Color(255, 255, 255));
		chatTextPane.setContentType("text/html");
		chatTextPane.setName("chat");
		chatTextPane.setText("<html></html>");
		chatTextPane.setEnabled(false);
		chatTextPane.setDisabledTextColor(Color.white);
		chatTextPane.setBackground(new Color(16, 16, 16));
		chatTextPane.setBounds(10, 52, 264, 241);
		chatPanel.add(chatTextPane);
		
		chatEntry = new JTextField();
		chatEntry.setFocusTraversalKeysEnabled(false);
		chatEntry.setRequestFocusEnabled(false);
		chatEntry.setBounds(10, 25, 264, 20);
		chatPanel.add(chatEntry);
		chatEntry.setColumns(10);
		
		JLabel lblChat = new JLabel("Chat");
		lblChat.setForeground(new Color(255, 255, 255));
		lblChat.setBounds(10, 9, 46, 14);
		chatPanel.add(lblChat); 
		
		JPanel playersPanel = new JPanel();
		playersPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		playersPanel.setBackground(Color.BLACK);
		playersPanel.setBounds(0, 0, 1284, 140);
		playersPanel.setLayout(null);
		add(playersPanel);
		
		JPanel historyPanel = new JPanel();
		historyPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		historyPanel.setBackground(Color.BLACK);
		historyPanel.setBounds(1000, 444, 284, 256);
		add(historyPanel);
		historyPanel.setLayout(null);
		
		JTextPane historyTextPane = new JTextPane();
		historyTextPane.setContentType("text/html");
		historyTextPane.setDisabledTextColor(new Color(255, 255, 255));
		historyTextPane.setEditable(false);
		historyTextPane.setEnabled(false);
		historyTextPane.setBackground(new Color(16, 16, 16));
		historyTextPane.setBounds(10, 11, 264, 234);
		historyPanel.add(historyTextPane);

	}
	
	public void printChat(ChatMessage message)
	{
		//TODO Fill
	}
	
	/**
	 * Sets the players panel with all the players.
	 */
	private void setPlayers()
	{
		
	}
}