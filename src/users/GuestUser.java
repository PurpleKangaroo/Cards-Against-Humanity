package users;

/**
 * A class of object that represents a guest user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class GuestUser extends User
{

	/**
	 * Creates an object that represents a guest user.
	 * @param userName The guest user's username.
	 * @param name The guest user's name.
	 */
	public GuestUser(String userName, String name)
	{
		super.setGuest(true);
		super.setUserProfile(new GuestUserProfile(userName, name));
	}

}
