package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

public class CAH_Users extends JPanel
{

	/**
	 * Create the panel.
	 */
	public CAH_Users()
	{
		UIManager.put("TitledBorder.border", new LineBorder(new Color(250,250,250), 1, true));
		UIManager.put("ToolTip.background", new ColorUIResource(253, 255, 166));
		
		setBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		setLayout(null);
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		
		final JLabel UsersBackground = new JLabel("");
		UsersBackground.setIcon(new ImageIcon(CAH_NewGame.class.getResource("/graphics/signupbackground.jpg")));
		UsersBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		UsersBackground.setBounds(0, 0, 1450, 722);
		add(UsersBackground);
	}

}
