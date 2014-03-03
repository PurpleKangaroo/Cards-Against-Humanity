package import_export;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * A class of object that represents data about the main user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class UserData
{
	/**
	 * The RandomAccessFile that the user's data is saved to.
	 */
	private RandomAccessFile file;
	
	/**
	 * Creates a new UserData.
	 * @throws FileNotFoundException 
	 * @since CAH1.0
	 */
	public UserData() throws FileNotFoundException
	{
		file = new RandomAccessFile((UserData.class.getResource("userSave.dat")).getFile(), "rw");
	}
}
