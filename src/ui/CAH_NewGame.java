package ui;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class CAH_NewGame extends JLayeredPane {

	/**
	 * Create the panel.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public CAH_NewGame() {
		setBounds(new Rectangle(0, 0, 1450, 700));
		setMaximumSize(new Dimension(1450, 700));
		
		JPanel StartGameMenus = new JPanel();
		StartGameMenus.setOpaque(false);
		StartGameMenus.setBounds(299, 230, 636, 459);
		add(StartGameMenus);
		StartGameMenus.setLayout(new BoxLayout(StartGameMenus, BoxLayout.X_AXIS));
		
		JPanel Rules = new JPanel();
		Rules.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Rules", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		Rules.setOpaque(false);
		StartGameMenus.add(Rules);
		Rules.setLayout(new BoxLayout(Rules, BoxLayout.X_AXIS));
		
		JPanel HouseRules = new JPanel();
		HouseRules.setBorder(new TitledBorder(null, "House Rules", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		HouseRules.setOpaque(false);
		Rules.add(HouseRules);
		
		JCheckBox chckbxhappyEnding = new JCheckBox("<html><body style=\"color:WHITE\">Happy Ending</body></html>");
		chckbxhappyEnding.setOpaque(false);
		HouseRules.add(chckbxhappyEnding);
		
		JCheckBox chckbxrebootingTheUniverse = new JCheckBox("<html><body style=\"color:WHITE\">Rebooting the Universe</body></html>");
		chckbxrebootingTheUniverse.setOpaque(false);
		HouseRules.add(chckbxrebootingTheUniverse);
		
		JCheckBox chckbxpackingHeat = new JCheckBox("<html><body style=\"color:WHITE\">Packing Heat</body></html>");
		chckbxpackingHeat.setOpaque(false);
		HouseRules.add(chckbxpackingHeat);
		
		JCheckBox chckbxrandoCardrissian = new JCheckBox("<html><body style=\"color:WHITE\">Rando Cardrissian</body></html>");
		chckbxrandoCardrissian.setOpaque(false);
		HouseRules.add(chckbxrandoCardrissian);
		
		JCheckBox chckbxgodIsDead = new JCheckBox("<html><body style=\"color:WHITE\">God Is Dead</body></html>");
		chckbxgodIsDead.setOpaque(false);
		HouseRules.add(chckbxgodIsDead);
		
		JLabel NewGameBackground = new JLabel("");
		NewGameBackground.setIcon(new ImageIcon(CAH_NewGame.class.getResource("/graphics/signupbackground.jpg")));
		NewGameBackground.setAlignmentX(Component.CENTER_ALIGNMENT);
		NewGameBackground.setBounds(0, 0, 1450, 722);
		add(NewGameBackground);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{HouseRules, Rules, StartGameMenus, NewGameBackground}));
	}
	
	/**
	 * Wraps the string for the tool tips.
	 * The wrapping is done with HTML
	 * @param str - the string that will be wrapped with HTML.
	 * @return str + "<</html>/html>" - the String wrapped in HTML plus the closing "<</html>/html>".
	 * <html>
	 * @since CAH1.0
	 * @author Holt Maki
	 * 
	 */
	private String wrap(String str)
	{
		str = "<html>" + str;
		for(int i = 50; i<str.length(); i+=50)
		{
		
			try
			{
				while(str.charAt(i) != ' ' && i <str.length())
				{
					i++;
				}
				
				if (i<str.length())
				{
					str = str.substring(0,i) +"<br>" + str.substring(i);
				}
			}
			
			catch(Exception e)
			{
				
			}
						
		}
		
		return str + "</html>";
	}
}
