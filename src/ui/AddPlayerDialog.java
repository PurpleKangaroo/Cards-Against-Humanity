package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.ButtonGroup;

public class AddPlayerDialog extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private final ButtonGroup playerTypeGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			AddPlayerDialog dialog = new AddPlayerDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddPlayerDialog()
	{
		setTitle("Add Player");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Player Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(186, Short.MAX_VALUE))
		);
		{
			JRadioButton rdbtnComputerPlayer = new JRadioButton("Computer Player");
			rdbtnComputerPlayer.setSelected(true);
			playerTypeGroup.add(rdbtnComputerPlayer);
			panel.add(rdbtnComputerPlayer);
		}
		{
			JRadioButton rdbtnHumanPlayer = new JRadioButton("Human Player");
			playerTypeGroup.add(rdbtnHumanPlayer);
			panel.add(rdbtnHumanPlayer);
		}
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
