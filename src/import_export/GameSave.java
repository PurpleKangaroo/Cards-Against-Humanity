package import_export;

import game.CAH_Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class of object that can access all game saves.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class GameSave implements Serializable
{
	/**
	 * The list of saved games that GameSaveBank contains.
	 */
	private ArrayList<CAH_Game> saves;
	
	/**
	 * The file that the games are saved to.
	 */
	private File gameSaves = new File("gameSaves.dat");
	
	/**
	 * Creates an object that saves and loads {@linkplain CAH_Game}s.
	 * @since CAH1.0
	 * Saves is set equal to <code> {@linkplain #saves} = ((GameSave) in.readObject()).getSaves();</code>
	 * If saves is null, then a {@linkplain NoSavesException} will be thrown.
	 * Also an exception will probably be thrown if gameSaves.dat does not contain any GameSave objects.
	 * If an exception is thrown, it will be caught and saves will be initialized as a <code> new ArrayList<CAH_Game>();</code>.
	 */
	public GameSave()
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(gameSaves));
			saves = ((GameSave) in.readObject()).getSaves();
			if(saves == null)
			{
				NoSavesException e = new NoSavesException();
				throw e;
			}
		}
		catch(Exception e)
		{
			saves = new ArrayList<CAH_Game>();
		}
		
	}
	
	/**
	 * Saves a game.
	 * @param game The game being saved.
	 * @since CAH1.0
	 */
	public void saveGame(CAH_Game game)
	{
		saves.add(game);
	}
	
	/**
	 * Gets an array list of CAH_Games that were saved to gameSaves.dat inside T
	 * @return saves - The array list of saves t
	 */
	public ArrayList<CAH_Game> getSaves()
	{
		return saves;
	}
	
	/**
	 * Thrown if there are no saves in gameSaves.dat.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	private class NoSavesException extends Exception
	{

		/**
		 * Default Serial Version UID.
		 */
		private static final long serialVersionUID = 3272133817810280103L;
		
	}
}
