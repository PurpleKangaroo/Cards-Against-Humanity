package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.border.TitledBorder;

/**
 * The panel that allows people to register as a user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Users extends JPanel
{

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -3565226841744890603L;

	/**
	 * Create the panel.
	 * @since CAH1.0
	 */
	public CAH_Users()
	{
		UIManager.put("TitledBorder.border", new LineBorder(new Color(250,250,250), 1, true));
		UIManager.put("ToolTip.background", new ColorUIResource(253, 255, 166));
		
		setBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		mainPanel.setOpaque(false);
		mainPanel.setBounds(599, 230, 336, 255);
		mainPanel.setLayout(null);
		UserPanelEdit edit = new UserPanelEdit();
		mainPanel.add(edit);
		add(mainPanel);
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
	}
	
	/**
	 * Adds the main menu button in front of the background.
	 * @param component The main menu button.
	 */
	protected void addMainMenuButton(JComponent component)
	{
		add(component);
		final JLabel UsersBackground = new JLabel("");
		UsersBackground.setIcon(new ImageIcon(CAH_NewGame.class.getResource("/graphics/signupbackground.jpg")));
		UsersBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		UsersBackground.setBounds(0, 0, 1450, 722);
		add(UsersBackground);
	}
	
}
