package ui;

/**
 * A class of object that represents a timer listener designed for dealing with movement animations.
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */
public abstract class MTimerListener extends TimerListener
{
	/**
	 * The interval at which X changes.
	 */
	private double xInterval;
	
	/**
	 * The interval at which Y changes.
	 */
	private double yInterval;
	
	/**
	 * Creates a new object that represents a timer listener designed for dealing with movement animations.
	 * @param xInterval the interval at which X changes.
	 * @param yInterval the interval at which Y changes.
	 * @since CAH1.0
	 */
	public MTimerListener(double xInterval, double yInterval)
	{
		this.xInterval = xInterval;
		this.yInterval = yInterval;
	}
}
