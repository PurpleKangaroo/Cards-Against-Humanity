package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * A class that loads images.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @deprecated CAH1.0
 */
public class ImageLoad
{
	/**
	 * Loads an image.
	 * @param imageName the name of the image that is being loaded
	 * @return image - the image that was loaded.
	 * @since CAH1.0
	 */
	public static Image loadImage(String imageName)
	{
		ImageIcon a = new ImageIcon(ImageLoad.class.getResource(imageName));
		Image image = a.getImage();
		return image;
	}
}
