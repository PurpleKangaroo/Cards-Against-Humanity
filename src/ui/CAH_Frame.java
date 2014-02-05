package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

/**
 * A class of object that represents the frame that contains Cards against humanity.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class CAH_Frame extends JFrame {

	/**
	 * The panel that contains CAH.
	 */
	private JPanel CAH_Panel;
	
	/**
	 * The layered pane that contains CAH.
	 */
	private JLayeredPane CAH_Layers;
	
	/**
	 * The layered pane that contains the start menu.
	 */
	private JLayeredPane Start;
	
	/**
	 * The layered pane that contains the new game menu.
	 */
	private JLayeredPane newGame;
	
	/**
	 * Launch the application.
	 * @since CAH1.0
	 * @version CAH1.0
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
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public CAH_Frame() {
		
		setMaximizedBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		setMinimumSize(new Dimension(1300, 752));
		setTitle("Cards Against Humanity");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewGame = new JMenuItem("New Game");
		mntmNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO fill
			}
		});
		mnFile.add(mntmNewGame);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO have some kind of warning come up before exiting
				System.exit(1);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnNetplay = new JMenu("Netplay");
		menuBar.add(mnNetplay);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AboutDialog dialog = new AboutDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setLocation(500,225);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmRules = new JMenuItem("Rules");
		mntmRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO fill
			}
		});
		mnHelp.add(mntmRules);
		CAH_Panel = new JPanel();
		CAH_Panel.setMinimumSize(new Dimension(1400, 700));
		CAH_Panel.setMaximumSize(new Dimension(1450, 700));
		CAH_Panel.setBorder(null);
		setContentPane(CAH_Panel);
		CAH_Panel.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1500px:grow"),},
			new RowSpec[] {
				RowSpec.decode("722px"),}));
		
		final JLayeredPane CAH_Layers = new JLayeredPane();
		CAH_Layers.setBorder(null);
		CAH_Panel.add(CAH_Layers, "1, 1, fill, fill");
		CAH_Layers.setLayout(new GridLayout(0, 1, 0, 0));
		
		Start = new JLayeredPane();
		Start.setBorder(null);
		Start.setName("Start");
		CAH_Layers.add(Start);
		Start.setLayout(null);
		
		final JPanel StartPanel = new JPanel();
		StartPanel.setOpaque(false);
		StartPanel.setBounds(632, 227, 331, 427);
		Start.add(StartPanel);
		
		final JButton btnNewGame = new JButton("<html><body align=\"left\">New Game</body></html>");
		btnNewGame.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnNewGame.setContentAreaFilled(false);
		btnNewGame.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewGame.setFocusPainted(false);
		btnNewGame.setBorderPainted(false);
		btnNewGame.setOpaque(false);
		
		btnNewGame.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewGame.setForeground(Color.WHITE);
		btnNewGame.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		final JButton btnLoadGame = new JButton("Load Game");
		btnLoadGame.setFocusPainted(false);
		btnLoadGame.setOpaque(false);
		btnLoadGame.setContentAreaFilled(false);
		btnLoadGame.setBorderPainted(false);
		btnLoadGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO:fill
			}
		});
		btnLoadGame.setHorizontalAlignment(SwingConstants.RIGHT);
		btnLoadGame.setForeground(Color.WHITE);
		btnLoadGame.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		final JButton btnStats = new JButton("Stats");
		btnStats.setOpaque(false);
		btnStats.setContentAreaFilled(false);
		btnStats.setBorderPainted(false);
		btnStats.setFocusPainted(false);
		btnStats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO:fill
			}
		});
		btnStats.setHorizontalAlignment(SwingConstants.RIGHT);
		btnStats.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnStats.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnStats.setForeground(Color.WHITE);
		btnStats.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		final JButton btnUsers = new JButton("Users");
		btnUsers.setOpaque(false);
		btnUsers.setContentAreaFilled(false);
		btnUsers.setBorderPainted(false);
		btnUsers.setFocusPainted(false);
		btnUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO:fill
			}
		});
		btnUsers.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUsers.setForeground(Color.WHITE);
		btnUsers.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		final JButton btnCards = new JButton("Cards");
		btnCards.setOpaque(false);
		btnCards.setContentAreaFilled(false);
		btnCards.setBorderPainted(false);
		btnCards.setFocusPainted(false);
		btnCards.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO:fill
			}
		});
		
		btnCards.setHorizontalAlignment(SwingConstants.RIGHT);
		btnCards.setForeground(Color.WHITE);
		btnCards.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		final JButton btnRules = new JButton("Rules");
		btnRules.setOpaque(false);
		btnRules.setContentAreaFilled(false);
		btnRules.setBorderPainted(false);
		btnRules.setFocusPainted(false);
		btnRules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				//TODO:fill
			}
			@Override
			public void mouseExited(MouseEvent e) {
				//TODO:fill
			}
		});
		
		btnRules.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRules.setForeground(Color.WHITE);
		btnRules.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		GroupLayout gl_StartPanel = new GroupLayout(StartPanel);
		gl_StartPanel.setHorizontalGroup(
			gl_StartPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_StartPanel.createSequentialGroup()
					.addContainerGap(220, Short.MAX_VALUE)
					.addGroup(gl_StartPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_StartPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_StartPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_StartPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_StartPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnStats, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLoadGame, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
									.addComponent(btnUsers, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnCards, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnRules, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnNewGame, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_StartPanel.setVerticalGroup(
			gl_StartPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_StartPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLoadGame, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStats, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUsers, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCards, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRules, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		StartPanel.setLayout(gl_StartPanel);
		
		final JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		Start.add(lblCardsAgainstHumanity);
		
		
		final JLabel StartBackground = new JLabel("");
		StartBackground.setForeground(SystemColor.text);
		StartBackground.setBounds(0, -11, 1474, 745);
		StartBackground.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/signupbackground.jpg")));
		Start.add(StartBackground);
		
		Start.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnNewGame, StartPanel, StartBackground, lblCardsAgainstHumanity, btnStats, btnLoadGame, btnUsers, btnCards, btnRules}));
		
			btnNewGame.addActionListener(new ActionListener()
			{

				@Override
				public void actionPerformed(ActionEvent e)
				{
					newGame = new CAH_NewGame();
					newGame.setName("newGame");
					CAH_Layers.remove(Start);
					CAH_Layers.add(newGame);
					CAH_Layers.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{newGame}));
					CAH_Panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{CAH_Layers}));
				}
				
			});
			
		CAH_Layers.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{Start, StartPanel, btnStats, btnLoadGame, btnUsers, btnCards, btnRules, btnNewGame, lblCardsAgainstHumanity, StartBackground}));
		CAH_Panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{CAH_Layers}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnFile, mntmNewGame, mntmExit, mnNetplay, mnHelp, mntmAbout, mntmRules, CAH_Panel}));
	}
	
	/**
	 * A list of the different screens that there are.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	private enum screens
	{
		START,
		NEWGAME,
		LOADGAME,
		STATS,
		USERS,
		CARDS,
		RULES,
		MAINGAME,
		ENDGAME;
	}
	
}
