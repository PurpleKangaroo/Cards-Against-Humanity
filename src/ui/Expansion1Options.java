package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cards.Decks;

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
		setUndecorated(true);
		setAlwaysOnTop(true);
		setTitle("Expansion 1");
		setBounds(100, 100, 214, 163);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		contentPanel.setFocusable(false);
		
		JTextPane txtpnWhichVersionOf = new JTextPane();
		txtpnWhichVersionOf.setBounds(0, 0, 214, 48);
		txtpnWhichVersionOf.setFocusCycleRoot(false);
		txtpnWhichVersionOf.setFocusTraversalKeysEnabled(false);
		txtpnWhichVersionOf.setEditable(false);
		txtpnWhichVersionOf.setDisabledTextColor(Color.BLACK);
		txtpnWhichVersionOf.setEnabled(false);
		txtpnWhichVersionOf.setFocusable(false);
		txtpnWhichVersionOf.setOpaque(false);
		txtpnWhichVersionOf.setText("Which version of the first Cards Against Humanity expansion would you like to use?");
		contentPanel.add(txtpnWhichVersionOf);
		
		final JRadioButton rdbtnExpansion = new JRadioButton("Expansion 1.0");
		rdbtnExpansion.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnExpansion.setBounds(10, 49, 198, 22);
		rdbtnExpansion.setFocusPainted(false);
		rdbtnExpansion.setToolTipText(wrap(Decks.EXPANSION1_0.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		contentPanel.add(rdbtnExpansion);
		rdbtnExpansion.setSelected(true);
		rdbtnExpansion.setFocusable(false);
		
		final JRadioButton rdbtnExpansion_1 = new JRadioButton("Expansion 1.2");
		rdbtnExpansion_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnExpansion_1.setBounds(6, 76, 202, 22);
		rdbtnExpansion_1.setFocusPainted(false);
		rdbtnExpansion.setToolTipText(wrap(Decks.EXPANSION1_2.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		contentPanel.add(rdbtnExpansion_1);
		rdbtnExpansion_1.setFocusable(false);
		
		final JRadioButton rdbtnExpansionAnd = new JRadioButton("Expansions 1.0 and 1.2");
		rdbtnExpansionAnd.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnExpansionAnd.setBounds(6, 103, 202, 22);
		rdbtnExpansionAnd.setFocusPainted(false);
		rdbtnExpansion.setToolTipText(wrap(Decks.EXPANSION1.getDescription()).replaceAll("-", " -").replaceAll("surface -to -air", "surface-to-air"));
		contentPanel.add(rdbtnExpansionAnd);
		rdbtnExpansionAnd.setFocusable(false);
		
		final ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnExpansion);
		buttonGroup.add(rdbtnExpansion_1);
		buttonGroup.add(rdbtnExpansionAnd);
		
		JButton button = new JButton("OK");
		button.setBounds(82, 130, 52, 22);
		button.setFocusPainted(false);
		button.setFocusable(false);
		button.setBorderPainted(false);
		getRootPane().setDefaultButton(button);
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
		setOpacity(0.95f);
		
		addKeyListener(new KeyListener() {

			private int i = 0;
			
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				i++;
				JRadioButton[] buttonarr = new JRadioButton[3];
				buttonarr[0] = rdbtnExpansion;
				buttonarr[1] = rdbtnExpansion_1;
				buttonarr[2] = rdbtnExpansionAnd;
				if((arg0.getKeyCode() == KeyEvent.VK_DOWN || arg0.getKeyCode() == KeyEvent.VK_RIGHT) && isVisible())
				{
					if(i == 0)
					{
						i = i + 2;
					}
					buttonarr[i%3].setSelected(true);
				}
				else if((arg0.getKeyCode() == KeyEvent.VK_UP || arg0.getKeyCode() == KeyEvent.VK_LEFT) && isVisible())
				{
					i++;
					buttonarr[i%3].setSelected(true);
				}
				else
				{
					
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
		});
		setFocusable(true);
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
