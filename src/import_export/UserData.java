package import_export;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import users.User;

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
	 * The RandomAccessFile that the user's profile data is saved to.
	 */
	private RandomAccessFile proFile;
	
	/**
	 * The RandomAccessFile that the user's stats data is saved to.
	 */
	private RandomAccessFile statsFile;
	
	/**
	 * Creates a new UserData.
	 * @throws FileNotFoundException 
	 * @since CAH1.0
	 */
	public UserData() throws FileNotFoundException
	{
		proFile = new RandomAccessFile((UserData.class.getResource("userSave.dat")).getFile(), "rw");
		statsFile = new RandomAccessFile((UserData.class.getResource("statsFile.dat")).getFile(), "rw");
	}
}
