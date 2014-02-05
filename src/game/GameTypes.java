package game;

/**
 * A list of different types of games.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */

public enum GameTypes
{
	/**
	 * A single player game.
	 */
	SINGLEPLAYER("Single Player"),
	
	/**
	 * A multiplayer game with everybody using the same computer.
	 */
	PASSANDPLAY("Pass-and-play multiplayer"),
	
	/**
	 * A multiplayer game over a local internet connection.
	 */
	LOCAL("Local internet multiplayer");
	
	/**
	 * The description of the game type.
	 */
	String discription;
	
	/**
	 * Creates a game type
	 * @param discription - the description of the game type.
	 * @since CAH.10
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	GameTypes(String discription)
	{
		this.discription = discription;
	}
	
	/**
	 * Gets the description of the game type.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @return discription - a discription of the game type.
	 * @author Holt Maki
	 */
	public String getDiscription()
	{
		return discription;
	}
	
}
