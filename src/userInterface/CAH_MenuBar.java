package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * A class of object that represents the menu bar at the top of the CAH_Frame.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * 
 */
public class CAH_MenuBar extends JMenuBar{
	private static final long serialVersionUID = -4687887555666164293L;
	
	public CAH_MenuBar()
	{
		super();
		
		JMenu file = new JMenu("File");
		
		JMenuItem exit = new JMenuItem("Exit", MouseEvent.MOUSE_CLICKED);
		exit.addActionListener(new ExitListener());
		
		file.add(exit);
		
		super.add(file);
	}
	
	private class ExitListener implements ActionListener 
	{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
			
		}
	}
	
}
