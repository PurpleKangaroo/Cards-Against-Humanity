package import_export;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.GregorianCalendar;

import users.Gender;
import users.NonGuestUserProfile;
import users.UserProfile;

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
	
	/**
	 * Closes both the profile data file and the stats data file.
	 * @throws IOException
	 */
	public void close() throws IOException
	{
		if (proFile != null)
		{
			proFile.close();
			proFile = null;
		}
		
		if (statsFile != null)
		{
			statsFile.close();
			statsFile = null;
		}
	}
	
	/**
	 * Reads a saved user profile from the profile data RandomAccessFile.
	 * @return the user profile interpreted from the data.
	 * @throws IOException 
	 * @since CAH1.0
	 */
	public NonGuestUserProfile readProfile() throws IOException
	{
		String username = proFile.readLine();
		String first = proFile.readLine();
		String last = proFile.readLine();
		String gender = proFile.readLine();
		String birthDate = proFile.readLine();
		int month = Integer.parseInt(birthDate.substring(0, birthDate.indexOf("/")));
		birthDate = birthDate.substring(birthDate.indexOf("/") + 1);
		int day = Integer.parseInt(birthDate.substring(0, birthDate.indexOf("/")));
		birthDate = birthDate.substring(birthDate.indexOf("/") + 1);
		int year = Integer.parseInt(birthDate);
		
		NonGuestUserProfile user = new NonGuestUserProfile(username, first, last, gender.charAt(0), new GregorianCalendar(year, month, day));
		return user;
	}

	/**
	 * Reads a saved user profile from the profile data RandomAccessFile.
	 * @param user the user profile to be written/edited.
	 * @throws IOException 
	 * @since CAH1.0
	 */
	public void writeProfile(NonGuestUserProfile user) throws IOException
	{
		proFile.writeChars(user.getUserName() + "\n");
		proFile.writeChars(user.getFirstName() + "\n");
		proFile.writeChars(user.getLastName() + "\n");
		proFile.writeChars(user.getGender().equals(Gender.MALE) ? "m\n" : "f\n");
		proFile.writeChars(user.getBirthDate() + "\n");
	}
}
