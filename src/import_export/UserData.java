package import_export;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.URISyntaxException;
import java.util.GregorianCalendar;
import java.util.Scanner;

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
	
	private Scanner proFileIn;
	
	private PrintWriter proFileOut;
	
	/**
	 * Creates a new UserData.
	 * @throws IOException 
	 * @throws URISyntaxException 
	 * @since CAH1.0
	 */
	public UserData() throws IOException, URISyntaxException
	{
		System.out.println(getClass().getResource("userSave.txt").toURI());
		proFileIn = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("userSave.txt"))));
		proFileOut = new PrintWriter(new FileOutputStream(new File(getClass().getResource("userSave.txt").toURI())));
		proFileOut.write("AAAAA");
		proFileOut.close();
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
		String username = proFileIn.nextLine();
		String first = proFileIn.nextLine();
		String last = proFileIn.nextLine();
		String gender =proFileIn.nextLine();
		String birthDate = proFileIn.nextLine();
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
		proFileOut.println(user.getUserName());
		proFileOut.println(user.getFirstName());
		proFileOut.println(user.getLastName());
		proFileOut.println(user.getGender().equals(Gender.MALE) ? "m" : "f");
		proFileOut.println(user.getBirthDate());
		proFileOut.close();
	}
}
