package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
		setMaximizedBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		setMinimumSize(new Dimension(1300, 752));
		setTitle("Cards Against Humanity");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new CardLayout());
		
		JMenuBar menuBar = new JMenuBar();
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
		
		JLayeredPane CAH_Layers = new JLayeredPane();
		CAH_Layers.setBorder(null);
		CAH_Panel.add(CAH_Layers, "1, 1, fill, fill");
		CAH_Layers.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),
				ColumnSpec.decode("1450px:grow"),},
			new RowSpec[] {
				RowSpec.decode("722px:grow"),}));
		
		JLayeredPane Start = new JLayeredPane();
		CAH_Layers.add(Start, "2, 1, fill, fill");
		Start.setLayout(null);
		
		JPanel StartPanel = new JPanel();
		StartPanel.setOpaque(false);
		StartPanel.setBounds(607, 229, 331, 427);
		Start.add(StartPanel);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
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
		lblNewGame.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewGame.setForeground(Color.WHITE);
		lblNewGame.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		JLabel lblLoadGame = new JLabel("Load Game");
		lblLoadGame.addMouseListener(new MouseAdapter() {
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
		lblLoadGame.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLoadGame.setForeground(Color.WHITE);
		lblLoadGame.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.addMouseListener(new MouseAdapter() {
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
		lblStats.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStats.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblStats.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblStats.setForeground(Color.WHITE);
		lblStats.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.addMouseListener(new MouseAdapter() {
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
		lblUsers.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		JLabel lblCards = new JLabel("Cards");
		lblCards.addMouseListener(new MouseAdapter() {
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
		
		lblCards.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCards.setForeground(Color.WHITE);
		lblCards.setFont(new Font("Arial Black", Font.BOLD, 35));
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.addMouseListener(new MouseAdapter() {
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
		
		lblRules.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRules.setForeground(Color.WHITE);
		lblRules.setFont(new Font("Arial Black", Font.BOLD, 35));
		
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
										.addComponent(lblStats, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblLoadGame, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblUsers, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCards, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblRules, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewGame, Alignment.TRAILING))
					.addContainerGap())
		);
		gl_StartPanel.setVerticalGroup(
			gl_StartPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_StartPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewGame)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblLoadGame, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblStats, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsers, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCards, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRules, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(86, Short.MAX_VALUE))
		);
		StartPanel.setLayout(gl_StartPanel);
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		Start.add(lblCardsAgainstHumanity);
		
		
		JLabel StartBackground = new JLabel("");
		StartBackground.setForeground(SystemColor.text);
		StartBackground.setBounds(0, 0, 1450, 722);
		StartBackground.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/signupbackground.jpg")));
		Start.add(StartBackground);
		
		Start.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewGame, StartPanel, StartBackground, lblCardsAgainstHumanity, lblStats, lblLoadGame, lblUsers, lblCards, lblRules}));
		CAH_Layers.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblStats, lblLoadGame, lblUsers, lblCards, lblRules, lblNewGame, lblCardsAgainstHumanity, StartPanel, Start, StartBackground}));
		CAH_Panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblLoadGame, lblUsers, lblStats, lblRules, lblCards, lblNewGame, CAH_Layers, Start, StartPanel, lblCardsAgainstHumanity, StartBackground}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{menuBar, mnFile, mntmNewGame, mntmExit, mnNetplay, mnHelp, mntmAbout, mntmRules, lblCardsAgainstHumanity, lblStats, lblLoadGame, lblUsers, lblCards, lblRules, lblNewGame, CAH_Panel, Start, StartPanel, CAH_Layers, StartBackground}));
	}
}
