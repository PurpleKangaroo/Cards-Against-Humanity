package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import cards.Decks;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * The options for expansion 1.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
@SuppressWarnings("serial")
public class Expansion1Options extends JDialog
{
	/**
	 * The JPanel that contains the dialog's content.
	 */
	private JPanel contentPanel;
	
	/**
	 * Create the dialog.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public Expansion1Options()
	{
		setTitle("Expansion 1");
		setBounds(100, 100, 214, 164);
		contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		JRadioButton rdbtnExpansion = new JRadioButton("Expansion 1.0");
		rdbtnExpansion.setToolTipText(wrap(Decks.EXPANSION1_0.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		contentPanel.add(rdbtnExpansion);
		JRadioButton rdbtnExpansion_1 = new JRadioButton("Expansion 1.2");
		rdbtnExpansion.setToolTipText(wrap(Decks.EXPANSION1_2.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		contentPanel.add(rdbtnExpansion_1);
		JRadioButton rdbtnExpansionAnd = new JRadioButton("Expansions 1.0 and 1.2");
		rdbtnExpansion.setToolTipText(wrap(Decks.EXPANSION1.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		contentPanel.add(rdbtnExpansionAnd);
		
		final ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnExpansion);
		buttonGroup.add(rdbtnExpansion_1);
		buttonGroup.add(rdbtnExpansionAnd);
		
		JButton button = new JButton("OK");
		button.setOpaque(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(buttonGroup.getSelection() != null)
				{
					setVisible(false);
				}
				else
				{
					
				}
				
			}
		});
		button.setActionCommand("OK");
		contentPanel.add(button);
		this.setContentPane(contentPanel);
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
