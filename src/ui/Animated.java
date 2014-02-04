package ui;

/**
 * A group of methods for classes of objects that are animated.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public interface Animated {
	/**
	 * Grows the object to a new size.
	 * @param newX the new X size.
	 * @param newY the new Y size.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public void grow(int newX, int newY);
	
	/**
	 * Grows the object by a certain percent.
	 * @param pct - the percentage by which the object grows. If it is negative, the object shrinks.
	 * @since CAH1.0
	 * @author Holt Maki
	 */
	public void grow(int pct);
}
