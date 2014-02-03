package ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.SpringLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.Cursor;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAboutTitle;

	/**
	 * Create the dialog.
	 */
	public AboutDialog() {
		setTitle("About");
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			contentPanel.add(scrollPane);
			{
				txtAboutTitle = new JTextField();
				txtAboutTitle.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				txtAboutTitle.setText("Cards Against Humanity - CAH1.0");
				scrollPane.setColumnHeaderView(txtAboutTitle);
				txtAboutTitle.setColumns(10);
			}
			{
				JTextArea txtAbout = new JTextArea();
				txtAbout.setFont(new Font("Tahoma", Font.PLAIN, 11));
				txtAbout.setText("Software Developed by PurpleKangaroo Development\r\nLead Developer - Holt Maki\r\nLead User Interface Designer - Nick Walker\r\nDevon Grove\r\nThe phrase \"Cards Against Humanity\" belongs to Cards Against Humanity under a creative commons liscence.....\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n[a bunch of other legal or liscence crap]\r\n");
				scrollPane.setViewportView(txtAbout);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
