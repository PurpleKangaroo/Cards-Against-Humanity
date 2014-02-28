package ui;

/**
 * An superinterface for interfaces that contain methods for animating objects.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public interface Animated
{
	/**
	 * The time in between each timer event.
	 */
	public static final int DELAY = 2;
	
	/**
	 * An enumeration of different animation speeds.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public enum AnimationSpeed {
		/**
		 * A fast animation speed.
		 */
		FAST,
		/**
		 * A medium animation speed.
		 */
		MEDIUM,
		/**
		 * A slow animation speed.
		 */
		SLOW;
	}
}
