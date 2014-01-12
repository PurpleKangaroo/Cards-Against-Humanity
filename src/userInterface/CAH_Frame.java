package userInterface;

import game.CAH_Game;
import game.RuleConflictException;
import import_export.PathFinder;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * A class of object that makes the frame that a Cards Against Humanity game is run in.
 * @author {@linkplain ([Nick Walker] (https://github.com/oswin5656))}
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Frame extends JFrame{
	private static final long serialVersionUID = -3033860031108235857L;
	private CAH_Game game;

	/**
	 * Creates a new frame in which a cards against of humanity game is shown in.
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws RuleConflictException Thrown if there is a rule conflict. Handle by telling the user that they used an invalid combination of rules.
	 */
	public CAH_Frame() throws IOException, URISyntaxException, RuleConflictException
	{
		super("Cards Against Humanity");
		super.setLayout(new BorderLayout());
		add(new CAH_MenuBar(), BorderLayout.NORTH);
		//PathFinder a = new PathFinder();
		setDefaultLookAndFeelDecorated(true);
		//setIconImage(new ImageIcon(a.getCAH_Path("/Cards Against Humanity/src/CAH_GraphicsFiles/CAHIcon.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setMinimumSize(new Dimension(800,600));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		pack();
		setVisible(true);
		
		CAH_Panel_STARTGAME start = new CAH_Panel_STARTGAME();
		super.add(start);
		super.setVisible(true);
		//Then we start up the game.
		
		game = start.getGame();
		CAH_Panel_GAME panel = new CAH_Panel_GAME(10, game.getPlayers().get(0));//FIXME We have to find a way to identify which player is which
		super.remove(start);
		
		//TODO change to get the number of players
		super.add(panel);
		
	}
	
	/**
	 * Paints the frame.
	 * @param g - the graphics that will be painted onto the frame
	 * @since CAH1.0
	 */
	public void Paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
	}
	
	public static void main(String [] args) throws URISyntaxException, IOException, RuleConflictException
	{
		//PathFinder a = new PathFinder();
		CAH_Frame a = new CAH_Frame();
	}

}
