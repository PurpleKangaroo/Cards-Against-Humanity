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
	 * Slides part of an object.
	 * @since CAH1.0
	 */
	public void slide();
}
