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
	 * @param dir Either {@linkplain #DOWN} (0), {@linkplain #UP} (1), {@linkplain #LEFT} (2), {@linkplain #RIGHT} (3) .
	 * @since CAH1.0
	 */
	public void slide(double sec, int dir);
}
