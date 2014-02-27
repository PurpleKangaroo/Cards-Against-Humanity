package users;

import java.io.File;
import java.util.GregorianCalendar;

/**
 * A class of object that represents a user that is not a guest user.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class NonGuestUser extends User
{
	private UserActionLog log;
	private UserBehavior behaviorStats;
	private UserGameHistory history;
	private File userInfoFile;//TODO Do work on this part! make it so that it supports both new users and old users and saves user info.
	//Password protection???
	
	/**
	 * Creates an object that represents a user that is not a guest user.
	 * @param first - First Name.
	 * @param last - Last Name.
	 * @param userName - Username
	 * @param gender - Gender (m or f)
	 * @param bDateMonth - the month that the player was born in.
	 * @param bDateDay - the day of the month the player was born in.
	 * @param bDateYear - the year that the player was born in.
	 * @see User
	 * @since CAH1.0
	 */
	public NonGuestUser(String userName, String first, String last, char gender, int bDateMonth, int bDateDay, int bDateYear)
	{
		GregorianCalendar birthDate = new GregorianCalendar(bDateYear, bDateMonth, bDateDay);
		UserProfile profile = new NonGuestUserProfile(first, last, userName, gender, birthDate);
		super.setUserProfile(profile);
		super.setGuest(false);
	}

	/**
	 * Gets the user's behavior stats.
	 * @return behaviorStats - the User's UserBehavior.
	 * @since CAH1.0
	 */
	public UserBehavior getBehaviorStats() {
		return behaviorStats;
	}
	
	/**
	 * Gets the users game history stats.
	 * @return history - the use's game history stats.
	 * @since CAH1.0
	 */
	public UserGameHistory getUserGameHistory()
	{
		return history;
	}
	
	/**
	 * Gets the user's action log.
	 * @return log - the user's action log.
	 * @since CAH1.0
	 */
	public UserActionLog getLog()
	{
		return log;
	}

}
