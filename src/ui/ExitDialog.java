package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * A JDialog that warns people before they exit the application.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0 
 *
 */
public class ExitDialog extends JDialog
{

	/**
	 * The Generated Serial Version UID.
	 */
	private static final long serialVersionUID = -6917485848768464833L;
	
	/**
	 * The panel that contains the warning.
	 */
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 * @since CAH1.0
	 */
	public ExitDialog()
	{
		//TODO: Are you sure you want to exit. Yes / no.
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
