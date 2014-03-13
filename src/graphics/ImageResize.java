package graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.ImageIcon;

public class ImageResize
{
	public static ImageIcon resizeImageIcon(BufferedImage buffered, double pct) throws IOException
	{
		BufferedImage resized = new BufferedImage((int) (buffered.getWidth() * pct), (int) (buffered.getHeight() * pct), buffered.getType());
		Graphics2D g = resized.createGraphics();
		g.drawImage(buffered, 0, 0, (int) (buffered.getWidth() * pct), (int) (buffered.getHeight() * pct), null);
		g.dispose();
		return new ImageIcon(buffered);
	}
}
