package esoteric.piet;

import java.awt.Color;

/**
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public enum PietColor {
	LIGHT_RED(new Color(255, 192, 192), Hue.RED, Lightness.LIGHT),
	LIGHT_YELLOW(new Color(255, 255, 192), Hue.YELLOW, Lightness.LIGHT),
	LIGHT_GREEN(new Color(192, 255, 192), Hue.GREEN, Lightness.LIGHT),
	LIGHT_CYAN(new Color(192, 255, 255), Hue.CYAN, Lightness.LIGHT),
	LIGHT_BLUE(new Color(192, 192, 255), Hue.BLUE, Lightness.LIGHT),
	LIGHT_MAGENTA(new Color(255, 192, 255), Hue.MAGENTA, Lightness.LIGHT),
	RED(new Color(255, 0, 0), Hue.RED, Lightness.NORMAL),
	YELLOW(new Color(255, 255, 0), Hue.YELLOW, Lightness.NORMAL),
	GREEN(new Color(0, 255, 255), Hue.GREEN, Lightness.NORMAL),
	CYAN(new Color(0, 255, 255), Hue.CYAN, Lightness.NORMAL),
	BLUE(new Color(0, 0, 255), Hue.BLUE, Lightness.NORMAL),
	MAGENTA(new Color(255, 0, 255), Hue.MAGENTA, Lightness.NORMAL),
	DARK_RED(new Color(192, 0, 0), Hue.RED, Lightness.DARK),
	DARK_YELLOW(new Color(192, 192, 0), Hue.YELLOW, Lightness.DARK),
	DARK_GREEN(new Color(0, 192, 0), Hue.GREEN, Lightness.DARK),
	DARK_CYAN(new Color(0, 192, 192), Hue.CYAN, Lightness.DARK),
	DARK_BLUE(new Color(0, 0, 192), Hue.BLUE, Lightness.DARK),
	DARK_MAGENTA(new Color(192, 0, 192), Hue.MAGENTA, Lightness.DARK),
	BLACK(new Color(0, 0, 0), Hue.NONE, Lightness.NONE),
	WHITE(new Color(255, 255, 255), Hue.NONE, Lightness.NONE);
	
	/**
	 * The color that the {@linkplain PietColor} represents.
	 */
	public final Color color;
	
	/**
	 * The {@linkplain Hue} of the {@linkplain PietColor}.
	 */
	public final Hue hue;
	
	/**
	 * The {@linkplain Lightness} of the {@linkplain PietColor}.
	 */
	public final Lightness lightness;
	
	/**
	 * The order in the hue cycle of the {@linkplain PietColor}.
	 */
	public final int hueOrder;
	
	/**
	 * The order in the lightness cycle of the {@linkplain PietColor}.
	 */
	public final int lightnessOrder;
	
	PietColor(Color color, Hue hue, Lightness lightness)
	{
		this.color = color;
		this.hue = hue;
		this.lightness = lightness;
		hueOrder = hue.order;
		lightnessOrder = lightness.order;
	}
	
	public static PietColor getPietColor(int rgb)
	{
		Color a = new Color(rgb);
		for(int i = 0; i < PietColor.values().length; i++)
		{
			if(PietColor.values()[i].color.equals(a))
			{
				return PietColor.values()[i];
			}
		}
		throw new InvalidColorError();
	}
	
	/**
	 * Gets the change in the hue cycle between two colors.
	 * @param oldColor The old PietColor.
	 * @param newColor The new PietColor.
	 * @return <code>Hue.hueChange(oldColor.hue, newColor.hue);</code> - The difference between the two colors' position on the hue cycle.
	 * @see Hue.hueChange(Hue oldHue, Hue newHue)
	 */
	public static int hueChange(PietColor oldColor, PietColor newColor)
	{
		return Hue.hueChange(oldColor.hue, newColor.hue);
	}
	
	/**
	 * @param oldColor The old PietColor.
	 * @param newColor The new PietColor.
	 * @return <code>Lightness.lightnessChange(oldColor.lightness, newColor.lightness);</code> - The difference between old and new colors' on the lightness cycle.
	 * @see Lightness.lightnessChange(Lightness oldLightness, Lightness newLightness)
	 */
	public static int lightnessChange(PietColor oldColor, PietColor newColor)
	{
		return Lightness.lightnessChange(oldColor.lightness, newColor.lightness);
	}
	
	public static enum Hue
	{
		RED(0),
		YELLOW(1),
		GREEN(2),
		CYAN(3),
		BLUE(4),
		MAGENTA(5),
		NONE(-1);
		
		public final int order;
		
		Hue(int order)
		{
			this.order = order;
		}
		
		public static int hueChange(Hue oldHue, Hue newHue)
		{
			if(oldHue.order >= 0 && newHue.order >= 0)
			{
				return Math.abs(oldHue.order - newHue.order);
			}
			else
			{
				throw new ColorException();
			}
		}
			
	}
	
	public static enum Lightness
	{
		LIGHT(2),
		NORMAL(1),
		DARK(0),
		NONE(-1);
		
		public final int order;
		
		Lightness(int order)
		{
			this.order = order;
		}
		
		public static int lightnessChange(Lightness oldLightness, Lightness newLightness)
		{
			if(oldLightness.order >= 0 && newLightness.order >= 0)
			{
				return ((oldLightness.order -newLightness.order) % 3);
			}
			else
			{
				throw new ColorException();
			}
		}
		
	}
	
	/**
	 * An exception that has to do with {@linkplain PietColor}
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public static class ColorException extends RuntimeException
	{

		/**
		 * Generated Serial Version UID.
		 */
		private static final long serialVersionUID = 8176602531796052728L;
		
	}
	
	/**
	 * An exception that is thrown when white is used as a normal color.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public static class WhiteColorException extends ColorException
	{

		/**
		 * Generated Serial Version UID.
		 */
		private static final long serialVersionUID = -8620431952942228802L;
		
	}
	
	/**
	 * An exception that is thrown when black is used as a normal color. Tells the program to stop running.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public static class BlackColorException extends ColorException
	{

		/**
		 * Generated Serial Version UID.
		 */
		private static final long serialVersionUID = 2898887894302738892L;
		
	}
	
	/**
	 * An error that is thrown when the program runs into an invalid color.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public abstract static class ColorError extends PietError
	{

		/**
		 * Generated Serial Version UID.
		 */
		private static final long serialVersionUID = 4621490445371560848L;
		
	}
	
	/**
	 * An error that is thrown when the program runs into a square of an invalid color.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public static class InvalidColorError extends ColorError
	{

		/**
		 * Generated Serial Version UID.
		 */
		private static final long serialVersionUID = -1649789952231900943L;
		
	}
	
}