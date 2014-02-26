package ui;

/**
 * A group of methods for classes of objects that are can grow.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public interface Growable extends Animated {
	/**
	 * Grows the object to a new size.
	 * @param newX - the new X size.
	 * @param newY - the new Y size.
	 * @param sec - The number of seconds it takes to grow the object.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public void grow(int newX, int newY, int sec);
	
	/**
	 * Grows the object by a certain percent.
	 * @param pct - the percentage by which the object grows. If it is negative, the object shrinks.
	 * @param sec - the number of seconds it takes to grow the object.
	 * @since CAH1.0
	 * @version CAH1.0
	 * @author Holt Maki
	 */
	public void grow(int pct, int sec);
}
