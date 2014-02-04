package ui;

import game.CAH_Game;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.DropMode;

import users.Player;

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
	private Player player;

	/**
	 * Creates the panel.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @param game - the game of CAH being shown in the pane.
	 * @param player - the player who is playing the game on the computer that is showing the pane.
	 * 
	 */
	public GamePane(CAH_Game game, Player player) 
	{
		this.game = game;
		this.player = player;
		
		setBounds(new Rectangle(0, 0, 1450, 700));
		setLayout(null);
		setMinimumSize(new Dimension(1400, 700));
		setMaximumSize(new Dimension(1450, 700));
		
		JPanel MainGamePanel = new JPanel();
		MainGamePanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		MainGamePanel.setBackground(Color.BLACK);
		MainGamePanel.setBounds(0, 140, 1100, 560);
		add(MainGamePanel);
		
		JPanel HistoryPanel = new JPanel();
		HistoryPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		HistoryPanel.setBackground(Color.BLACK);
		HistoryPanel.setBounds(1100, 140, 270, 560);
		add(HistoryPanel);
		
		JList HistoryList = new JList();//This list will contain all of the previous cards played. or maybe the previous winning cards.
		HistoryList.setSelectionBackground(new Color(255, 255, 255));
		HistoryList.setDropMode(DropMode.ON);
		HistoryPanel.add(HistoryList);
		
		JPanel PlayersPanel = new JPanel();
		PlayersPanel.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new MatteBorder(5, 5, 5, 5, (Color) new Color(255, 255, 255))));
		PlayersPanel.setBackground(Color.BLACK);
		PlayersPanel.setBounds(0, 0, 1370, 140);
		add(PlayersPanel);

	}
}