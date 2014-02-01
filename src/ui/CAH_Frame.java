package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.FlowLayout;
import com.jgoodies.forms.factories.FormFactory;

@SuppressWarnings("serial")
public class CAH_Frame extends JFrame {

	private JPanel CAH_Panel;

	/**
	 * Launch the application.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CAH_Frame frame = new CAH_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public CAH_Frame() {
		setMinimumSize(new Dimension(1300, 752));
		setTitle("Cards Against Humanity");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout());
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		CAH_Panel = new JPanel();
		CAH_Panel.setMinimumSize(new Dimension(1400, 700));
		CAH_Panel.setMaximumSize(new Dimension(1450, 700));
		CAH_Panel.setBorder(null);
		setContentPane(CAH_Panel);
		CAH_Panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1500px:grow"),},
			new RowSpec[] {
				RowSpec.decode("722px"),}));
		
		JLayeredPane CAH_Layers = new JLayeredPane();
		CAH_Layers.setBorder(null);
		CAH_Panel.add(CAH_Layers, "1, 1, fill, fill");
		CAH_Layers.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),
				ColumnSpec.decode("1450px"),},
			new RowSpec[] {
				RowSpec.decode("722px"),}));
		
		JLayeredPane StartPane = new JLayeredPane();
		CAH_Layers.add(StartPane, "1, 1, fill, fill");
		StartPane.setLayout(null);
		
		JPanel MainMenuPanel = new JPanel();
		MainMenuPanel.setBounds(5, 185, 189, -179);
		StartPane.add(MainMenuPanel);
		MainMenuPanel.setOpaque(false);
		MainMenuPanel.setLayout(null);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setBounds(281, 10, 303, 69);
		lblNewGame.setIconTextGap(1);
		lblNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewGame.addMouseListener(new LabelGrow(lblNewGame));
		lblNewGame.setFont(new Font("Shruti", Font.BOLD, 62));
		lblNewGame.setForeground(new Color(255, 255, 255));
		MainMenuPanel.add(lblNewGame);
		
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setBounds(449, 160, 135, 69);
		lblStats.setIconTextGap(1);
		lblStats.setForeground(Color.WHITE);
		lblStats.setFont(new Font("Shruti", Font.BOLD, 62));
		lblStats.setAlignmentX(0.5f);
		lblStats.addMouseListener(new LabelGrow(lblStats));
		MainMenuPanel.add(lblStats);
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setBounds(430, 235, 154, 69);
		lblUsers.setIconTextGap(1);
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Shruti", Font.BOLD, 62));
		lblUsers.setAlignmentX(0.5f);
		lblUsers.addMouseListener(new LabelGrow(lblUsers));		
		MainMenuPanel.add(lblUsers);
		
		JLabel lblCards = new JLabel("Cards");
		lblCards.setBounds(426, 310, 158, 62);
		lblCards.setIconTextGap(1);
		lblCards.setForeground(Color.WHITE);
		lblCards.setFont(new Font("Shruti", Font.BOLD, 62));
		lblCards.setAlignmentX(0.5f);
		lblCards.addMouseListener(new LabelGrow(lblCards));
		MainMenuPanel.add(lblCards);
		
		JLabel lblLoadGame = new JLabel("Load Game");
		lblLoadGame.setBounds(268, 85, 316, 69);
		lblLoadGame.setIconTextGap(1);
		lblLoadGame.setForeground(Color.WHITE);
		lblLoadGame.setFont(new Font("Shruti", Font.BOLD, 62));
		lblLoadGame.setAlignmentX(0.5f);
		MainMenuPanel.add(lblLoadGame);
		lblLoadGame.addMouseListener(new LabelGrow(lblLoadGame));
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.setIconTextGap(1);
		lblRules.setForeground(Color.WHITE);
		lblRules.setFont(new Font("Shruti", Font.BOLD, 62));
		lblRules.setAlignmentX(0.5f);
		lblRules.setBounds(426, 383, 158, 62);
		lblRules.addMouseListener(new LabelGrow(lblRules));
		MainMenuPanel.add(lblRules);
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(-52, 738, 115, 14);
		StartPane.add(lblCardsAgainstHumanity);
		
		
		JLabel BackgroundImage = new JLabel("");
		CAH_Layers.add(BackgroundImage, "2, 1, left, top");
		BackgroundImage.setIconTextGap(0);
		BackgroundImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		BackgroundImage.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/signupbackground.jpg")));
		CAH_Layers.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{MainMenuPanel, StartPane, lblNewGame, lblStats, lblUsers, lblCards, lblLoadGame, lblRules, lblCardsAgainstHumanity, BackgroundImage}));
		
	}
	
	private class LabelGrow extends MouseAdapter {
		private JLabel label;
		
		public LabelGrow(JLabel label)
		{
			this.label = label;
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			//TODO- JLabel should grow
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			if(label.getText().equals("New Game"))
			{
				
			}
			else if(label.getText().equals("Load Game"))
			{
				
			}
			else if(label.getText().equals("Stats"))
			{
				
			}
			else if(label.getText().equals("Cards"))
			{
				
			}
			else if(label.getText().equals("Users"))
			{
				
			}
			else if(label.getText().equals("Rules"))
			{
				
			}
		}
	}
}
