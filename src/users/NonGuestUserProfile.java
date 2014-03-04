package users;

import java.util.GregorianCalendar;

/**
 * A class of object that represents a {@linkplain NonGuestPlayer}'s {@linkplain UserProfile}.
 * @author Holt Maki
 * @version CAH1.0
 * @since CAH1.0
 *
 */
public class NonGuestUserProfile extends UserProfile
{
	private String firstName;
	private String lastName;
	private Gender gender;
	private GregorianCalendar bDate;
	//TODO: add IP adress here?
	
	//TODO password?
	
	/**
	 * Creates an object that represents  {@linkplain NonGuestPlayer}'s user profile.
	 * @param first - The user's first name.
	 * @param last - The user's last name.
	 * @param userName - The user's user name.
	 * @param genderChar - The character that represents the character's gender (m or f).
	 * @param birthDay - The user's birthday.
	 * @since CAH1.0
	 */
	public NonGuestUserProfile(String userName, String first, String last, char genderChar, GregorianCalendar birthDate)
	{
		super(userName);
		firstName = first;
		lastName = last;
		if (genderChar == 'm')
		{
			gender = Gender.MALE;
		}
		else if (genderChar == 'f')
		{
			gender = Gender.FEMALE;
		}
		bDate = birthDate;
	}
	
	/**
	 * Gets the user's first name.
	 * @return firstName - the user's first name.
	 * @since CAH1.0
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Gets the user's last name.
	 * @return lastName - the user's last name.
	 * @since CAH1.0
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Calculates the user's age.
	 * @return age - the user's age.
	 * @since CAH1.0
	 */
	@SuppressWarnings("static-access")
	private int calculateAge()
	{
		GregorianCalendar now = new GregorianCalendar();
		now =  new GregorianCalendar(now.YEAR, now.MONTH, now.DATE);//simplifys the date so there is no problem with times
		GregorianCalendar birthDay = new GregorianCalendar(now.YEAR, bDate.MONTH, bDate.DATE);
		int age = 0;
		if(now.before(birthDay) || now.equals(birthDay))
		{
			age = now.YEAR - bDate.YEAR;
		}
		else
		{
			age = now.YEAR - bDate.YEAR;
			age--;
		}
		return age;
	}
	
	/**
	 * Gets the user's age.
	 * @return age - the user's age.
	 * @since CAH1.0
	 */
	public int getAge()
	{
		int age = calculateAge();
		return age;
	}
	
	/**
	 * Tells whether or not it is the user's birthday.
	 * @return isBirthday - the boolean that tells whether or not it is the user's birthday.
	 * @since CAH1.0
	 */
	@SuppressWarnings("static-access")
	public boolean isBirthday()
	{
		GregorianCalendar now = new GregorianCalendar();
		boolean isBirthday = false;
		if (now.MONTH == bDate.MONTH && now.DATE == bDate.DATE)
		{
			isBirthday = true;
		}
		return isBirthday;
	}

	/**
	 * Gets the user's gender.
	 * @return gender - the user's gender.
	 * @since CAH1.0
	 */
	public Gender getGender()
	{
		return gender;
	}
	
	/**
	 * Sets the players birth date.
	 * @param newBirthDate - the player's new birthDate.
	 * @since CAH1.0
	 */
	public void setBirthDate(GregorianCalendar newBirthDate)
	{
		bDate = newBirthDate;
	}
}
