package users;

import java.io.File;
import java.util.GregorianCalendar;

/**
 * A class of object that represents a user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public abstract class User {
	/**
	 * The user's profile.
	 */
	private UserProfile profile;
	
	/**
	 * Whether or not the user is a {@linkplain GuestUser}.
	 */
	private boolean guest;
	
	/**
	 * Sets the user's {@linkplain UserProfile}.
	 * @param profile The user's new user {@linkplain UserProfile}.
	 * @since CAH1.0
	 */
	public void setUserProfile(UserProfile profile)
	{
		this.profile = profile;
	}
	
	/**
	 * Gets the user's {@linkplain UserProfile}.
	 * @return profile - The user's {@linkplain UserProfile}
	 * @since CAH1.0
	 */
	public UserProfile getUserProfile()
	{
		return profile;
	}
	
	/**
	 * Sets the boolean that tells whether or not the player is a guest.
	 * @since CAH1.0
	 * @param guest The boolean that tells whether or not the player is a guest.
	 */
	public void setGuest(boolean guest)
	{
		this.guest = guest;
	}
	
	/**
	 * Tells whether or not the user is a guest user.
	 * @return guest - The boolean that tells whether or not the player is a guest.
	 * @since CAH1.0
	 */
	public boolean isGuest()
	{
		return guest;
	}
}
