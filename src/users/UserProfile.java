package users;

/**
 * A class of object that represents profile of a user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see User
 *
 */

public class UserProfile {
	/**
	 * The username of user whose profile this is.
	 */
	private String userName;
	
	/**
	 * Creates a  new object that represents the profile of a user.
	 * @param userName The username of the user whose profile this is.
	 * @since CAH1.0
	 */
	public UserProfile(String userName)
	{
		this.userName = userName;
	}
	
	/**
	 * Gets the user's username.
	 * @return userName - the user's username.
	 * @since CAH1.0
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Sets the username of the user who this profile belongs to.
	 * @param userName the new username of the user who this profile belongs to.
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
