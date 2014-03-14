package esoteric.piet;

import java.awt.image.BufferedImage;

public class Piet
{
	public static final int DEFAULT_CODEL_SIZE = 12;
	public static String toText(BufferedImage img, int codelSize)
	{
		PietInterpreter p = new PietInterpreter(img, codelSize);
		return p.interpretToText();
	}
}
