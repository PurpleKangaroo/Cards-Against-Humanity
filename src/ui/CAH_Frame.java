package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JLayeredPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		panel.setBounds(339, 235, 594, 361);
		layeredPane.add(panel);
		
		JLabel lblNewGame = new JLabel("New Game");
		lblNewGame.setIconTextGap(1);
		lblNewGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		lblNewGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//TODO- JLabel should grow
			}
		});
		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewGame, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewGame, -284, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewGame, -10, SpringLayout.EAST, panel);
		panel.setLayout(sl_panel);
		lblNewGame.setFont(new Font("Shruti", Font.BOLD, 62));
		lblNewGame.setForeground(new Color(255, 255, 255));
		panel.add(lblNewGame);
		
		JLabel lblStats = new JLabel("Stats");
		sl_panel.putConstraint(SpringLayout.NORTH, lblStats, 6, SpringLayout.SOUTH, lblNewGame);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblStats, -211, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblStats, -10, SpringLayout.EAST, panel);
		lblStats.setIconTextGap(1);
		lblStats.setForeground(Color.WHITE);
		lblStats.setFont(new Font("Shruti", Font.BOLD, 62));
		lblStats.setAlignmentX(0.5f);
		
		lblStats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//TODO- JLabel should grow
			}
		});
		panel.add(lblStats);
		
		JLabel lblUsers = new JLabel("Users");
		sl_panel.putConstraint(SpringLayout.NORTH, lblUsers, 6, SpringLayout.SOUTH, lblStats);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblUsers, -138, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblUsers, 0, SpringLayout.EAST, lblNewGame);
		lblUsers.setIconTextGap(1);
		lblUsers.setForeground(Color.WHITE);
		lblUsers.setFont(new Font("Shruti", Font.BOLD, 62));
		lblUsers.setAlignmentX(0.5f);
		lblUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//TODO- JLabel should grow
			}
		});
		
		panel.add(lblUsers);
		
		JLabel lblCards = new JLabel("Cards");
		sl_panel.putConstraint(SpringLayout.NORTH, lblCards, 6, SpringLayout.SOUTH, lblUsers);
		sl_panel.putConstraint(SpringLayout.WEST, lblCards, 426, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblCards, -65, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblCards, 0, SpringLayout.EAST, lblNewGame);
		lblCards.setIconTextGap(1);
		lblCards.setForeground(Color.WHITE);
		lblCards.setFont(new Font("Shruti", Font.BOLD, 62));
		lblCards.setAlignmentX(0.5f);
		lblCards.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				//TODO- JLabel should grow
			}
		});
		
		panel.add(lblCards);
		
		JLabel BackgroundImage = new JLabel("");
		BackgroundImage.setBounds(0, 0, 1500, 722);
		layeredPane.add(BackgroundImage);
		BackgroundImage.setIconTextGap(0);
		BackgroundImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		BackgroundImage.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/signupbackground.jpg")));
		layeredPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{BackgroundImage, panel}));
		
	}
}
