package ui;

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

public class CAH_Frame extends JFrame {

	private JPanel StartScreen;

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
		StartScreen = new JPanel();
		StartScreen.setMinimumSize(new Dimension(1400, 700));
		StartScreen.setMaximumSize(new Dimension(1450, 700));
		StartScreen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(StartScreen);
		StartScreen.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1500px:grow"),},
			new RowSpec[] {
				RowSpec.decode("default:grow"),
				RowSpec.decode("722px"),}));
		
		JLayeredPane layeredPane = new JLayeredPane();
		StartScreen.add(layeredPane, "1, 2, fill, fill");
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(347, 227, 594, 441);
		layeredPane.add(panel);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setBounds(281, 10, 303, 69);
		lblNewGame.setIconTextGap(1);
		lblNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewGame.addMouseListener(new LabelGrow());
		panel.setLayout(null);
		lblNewGame.setFont(new Font("Shruti", Font.BOLD, 62));
		lblNewGame.setForeground(new Color(255, 255, 255));
		panel.add(lblNewGame);
		
		JLabel lblStats = new JLabel("Stats");
		lblStats.setBounds(449, 160, 135, 69);
		lblStats.setIconTextGap(1);
		lblStats.setForeground(Color.WHITE);
		lblStats.setFont(new Font("Shruti", Font.BOLD, 62));
		lblStats.setAlignmentX(0.5f);
		lblStats.addMouseListener(new LabelGrow());
		panel.add(lblStats);
		
		JLabel lblUsers = new JLabel("Users");
		lblUsers.setBounds(430, 235, 154, 69);
		lblUsers.setIconTextGap(1);
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Shruti", Font.BOLD, 62));
		lblUsers.setAlignmentX(0.5f);
		lblUsers.addMouseListener(new LabelGrow());		
		panel.add(lblUsers);
		
		JLabel lblCards = new JLabel("Cards");
		lblCards.setBounds(426, 310, 158, 62);
		lblCards.setIconTextGap(1);
		lblCards.setForeground(Color.WHITE);
		lblCards.setFont(new Font("Shruti", Font.BOLD, 62));
		lblCards.setAlignmentX(0.5f);
		lblCards.addMouseListener(new LabelGrow());
		panel.add(lblCards);
		
		JLabel lblLoadGame = new JLabel("Load Game");
		lblLoadGame.setBounds(268, 85, 316, 69);
		lblLoadGame.setIconTextGap(1);
		lblLoadGame.setForeground(Color.WHITE);
		lblLoadGame.setFont(new Font("Shruti", Font.BOLD, 62));
		lblLoadGame.setAlignmentX(0.5f);
		panel.add(lblLoadGame);
		lblLoadGame.addMouseListener(new LabelGrow());
		
		JLabel lblRules = new JLabel("Rules");
		lblRules.setIconTextGap(1);
		lblRules.setForeground(Color.WHITE);
		lblRules.setFont(new Font("Shruti", Font.BOLD, 62));
		lblRules.setAlignmentX(0.5f);
		lblRules.setBounds(426, 368, 158, 62);
		lblRules.addMouseListener(new LabelGrow());
		panel.add(lblRules);
		
		JLabel BackgroundImage = new JLabel("");
		BackgroundImage.setBounds(0, 0, 1500, 722);
		layeredPane.add(BackgroundImage);
		BackgroundImage.setIconTextGap(0);
		BackgroundImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		BackgroundImage.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/signupbackground.jpg")));
		layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{BackgroundImage, panel}));
		
	}
	
	private class LabelGrow extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent arg0) {
			//TODO- JLabel should grow
		}
	}
}
