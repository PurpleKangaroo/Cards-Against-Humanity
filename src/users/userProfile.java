package users;

/**
 * An object that represents profile of a user.
 * @author Holt Maki
 * @since 1.0
 * @version 1.0
 * @see {@linkplain user}, {@linkplain userSave}
 *
 */

public class UserProfile {
	public String FirstName;
	public String LastName;
	public String userName;
	public Gender gender;
	
	/**
	 * Creates a user profile.
	 * @param first - The user's first name.
	 * @param last - The user's last name.
	 * @param Username - The user's user name.
	 * @param genderChar - The character that represents the character's gender (m or f).
	 * @since 1.0
	 */
	
	public UserProfile(String first, String last, String Username, char genderChar)
	{
		FirstName = first;
		LastName = last;
		userName = Username;
		if (genderChar == 'm')
		{
			gender = Gender.MALE;
		}
		else if (genderChar == 'f')
		{
			gender = Gender.FEMALE;
		}
	}

}
