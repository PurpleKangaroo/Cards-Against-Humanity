package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

/**
 * A class of object that represents the panel that will come up to allow a player to start up netplay.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Netplay extends JPanel
{

	/**
	 * Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -8317819384838582033L;
	private JComponent panel;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CAH_Netplay()
	{
		this.setLayout(null);
		setOpaque(true);
		setBorder(null);
		setBackground(Color.BLACK);
		setMaximumSize(new Dimension(1450, 700));
		setBounds(new Rectangle(0, 0, 1450, 700));
		
		JLabel lblNetplay = new JLabel("Netplay");
		lblNetplay.setForeground(Color.WHITE);
		lblNetplay.setFont(new Font("Arial Black", Font.PLAIN, 25));
		lblNetplay.setBounds(681, 220, 114, 33);
		add(lblNetplay);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new LineBorder(Color.WHITE, 1, true));
		panel.setBounds(557, 264, 369, 189);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(10, 11, 349, 46);
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		JLabel lblYourIpAddress = new JLabel("Your IP Address:");
		lblYourIpAddress.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblYourIpAddress.setForeground(Color.WHITE);
		panel_1.add(lblYourIpAddress);
		
		JLabel label;
		try
		{
			label = new JLabel("\t" + InetAddress.getLocalHost().getHostAddress());
			label.setFont(new Font("Arial Black", Font.PLAIN, 16));
			label.setForeground(Color.GREEN);
			panel_1.add(label);
		}
		catch (UnknownHostException e)
		{
			e.printStackTrace();
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(10, 57, 349, 46);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblHostIpAddress = new JLabel("Host IP Address:");
		lblHostIpAddress.setBounds(0, 11, 146, 23);
		lblHostIpAddress.setForeground(Color.WHITE);
		lblHostIpAddress.setFont(new Font("Arial Black", Font.PLAIN, 16));
		panel_2.add(lblHostIpAddress);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.PLAIN, 16));
		textField.setForeground(Color.GREEN);
		textField.setCaretColor(Color.GREEN);
		textField.setSelectedTextColor(Color.GREEN);
		textField.setSelectionColor(new Color(51, 51, 51));
		textField.setBorder(new LineBorder(new Color(255, 255, 255)));
		textField.setBackground(new Color(51, 51, 51));
		textField.setBounds(151, 10, 153, 28);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setOpaque(false);
		panel_3.setBounds(10, 114, 349, 32);
		panel.add(panel_3);
		
		final JRadioButton rdbtnHost = new JRadioButton("Host");
		rdbtnHost.setFocusPainted(false);
		rdbtnHost.setRequestFocusEnabled(false);
		rdbtnHost.setRolloverEnabled(false);
		rdbtnHost.setForeground(Color.WHITE);
		rdbtnHost.setOpaque(false);
		panel_3.add(rdbtnHost);
		
		JRadioButton rdbtnClient = new JRadioButton("Client");
		rdbtnClient.setFocusPainted(false);
		rdbtnClient.setSelected(true);
		rdbtnClient.setRequestFocusEnabled(false);
		rdbtnClient.setRolloverEnabled(false);
		rdbtnClient.setOpaque(false);
		rdbtnClient.setForeground(Color.WHITE);
		panel_3.add(rdbtnClient);
		
		ButtonGroup clienthost = new ButtonGroup();
		clienthost.add(rdbtnHost);
		clienthost.add(rdbtnClient);
		
		final JButton btnStart = new JButton("Connect");
		btnStart.setRolloverEnabled(false);
		btnStart.setRequestFocusEnabled(false);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO fill...
			}
		});
		btnStart.setOpaque(false);
		btnStart.setBounds(90, 157, 100, 17);
		panel.add(btnStart);
		
		rdbtnHost.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e)
			{
				if(rdbtnHost.isSelected())
				{
					btnStart.setText("Start");
				}
				else
				{
					btnStart.setText("Connect");
				}
				
			}
			
		});
		
		JLabel lblCardsAgainstHumanity = new JLabel("Cards Against Humanity");
		lblCardsAgainstHumanity.setBounds(84, 43, 1024, 139);
		add(lblCardsAgainstHumanity);
		lblCardsAgainstHumanity.setForeground(Color.WHITE);
		lblCardsAgainstHumanity.setFont(new Font("Arial Black", Font.BOLD, 70));
		// How to get IP adress of your computer: InetAddress.getLocalHost().getHostAddress()
		
	}
	
	/**
	 * Adds the main menu button in front of the background.
	 * @param mainMenu The main menu button.
	 * @since CAH1.0
	 */
	protected void addMainMenuButton(JComponent mainMenu)
	{
		mainMenu.setBounds(200, 157, 100, 17);
		panel.add(mainMenu);
		final JLabel StartBackground = new JLabel("");
		StartBackground.setRequestFocusEnabled(false);
		StartBackground.setForeground(SystemColor.text);
		StartBackground.setBounds(0, -11, 1474, 745);
		StartBackground.setIcon(new ImageIcon(CAH_Frame.class.getResource("/graphics/signupbackground.jpg")));
		this.add(StartBackground);
	}
}
