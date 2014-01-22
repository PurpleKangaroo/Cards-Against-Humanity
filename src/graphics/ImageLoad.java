package graphics;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageLoad
{
	/**
	 * Loads an image.
	 * @param imageName - the name of the image that is being loaded
	 * @return image - the image that was loaded.
	 */
	public static Image loadImage(String imageName)
	{
		ImageIcon a = new ImageIcon(ImageLoad.class.getResource(imageName));
		Image image = a.getImage();
		return image;
	}
}
