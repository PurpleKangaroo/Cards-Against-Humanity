package users;

/**
 * A class of object that represents the profle of a guest user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class GuestUserProfile extends UserProfile
{
	/**
	 * The name of the guest user to whom this profile belongs.
	 */
	private String name;
	
	/**
	 * Creates an object that represents the profle of a guest user.
	 * @param userName The GuestUser's username.
	 * @param name The GuestUser's name.
	 * @since CAH1.0
	 */
	public GuestUserProfile(String userName, String name)
	{
		super(userName);
		this.name = name;
	}
	
	/**
	 * Gets the name of the guest user whose profile this is.
	 * @return name - The name of the guest user whose profile this is.
	 * @since CAH1.0
	 */
	public String getName()
	{
		return name;
	}
	
}
