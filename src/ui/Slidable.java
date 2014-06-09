package ui;

/**
 * A group of methods used by classes with components that slide without the whole object moving.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public interface Slidable extends Animated
{
	/**
	 * The integer that represents sliding down.
	 */
	public static final int DOWN = 0;
	
	/**
	 * The integer that represents sliding up. 
	 */
	public static final int UP = 1;
	
	/**
	 * The integer that represents sliding left.
	 */
	public static final int LEFT = 2;
	
	/**
	 * The integer that represents sliding right. 
	 */
	public static final int RIGHT = 3;
	
	/**
	 * Slides part of an object.
	 * @param sec The number of seconds it will take to slide down the object.
	 * @param dir Either {@linkplain #DOWN} (0), {@linkplain #UP} (1), {@linkplain #LEFT} (2), {@linkplain #RIGHT} (3).
	 * @throws InvalidDirectionException When dir is not a valid direction. This can vary in different implementations of the method.
	 * In general it will be any number that is not 0, 1, 2, or 3, but some slide methods may throw an {@linkplain throws InvalidDirectionExceptionInvalidDirectionException} if they
	 * are not designed for all directions.
	 * @since CAH1.0
	 */
	public void slide(double sec, int dir) throws InvalidDirectionException;
	
	/**
	 * An exception that is thrown when an invalid dirrection is entered.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public class InvalidDirectionException extends Exception
	{
		
	}
}
