package ui;

/**
 * A collection of methods used by objects that move.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public interface Movable extends Animated
{
	/**
	 * The 
	 * @since CAH1.0
	 * @param newX the new x coordinate that the object is being moved to.
	 * @param newY the new y coordinate that the object is being moved to.
	 * @param sec the number of seconds it will take to complete the animation.
	 */
	public void move(int newX, int newY, double sec);
}
