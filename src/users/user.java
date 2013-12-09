package users;

import java.io.File;
import java.util.GregorianCalendar;

/**
 * An object that represents a user
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class User {
	private UserProfile profile;
	private UserActionLog log;
	private UserBehavior behaviorStats;
	private UserGameHistory history;
	//TODO Make CAH have a static UserID list that contains all userIDs
	//TODO Make each user have a userID number
	private File userInfoFile;//TODO Do work on this part! make it so that it supports both new users and old users and saves user info.
	//Password protection???
	
	/**
	 * Creates an object that represents a user.
	 * @param first - First Name.
	 * @param last - Last Name.
	 * @param userName - Username
	 * @param gender - Gender (m or f)
	 * @param bDateMonth - the month that the player was born in.
	 * @param bDateDay - the day of the month the player was born in.
	 * @param bDateYear - the year that the player was born in.
	 * @see {@linkplain userProfile}
	 * @since CAH1.0
	 */
	public User(String first, String last, String userName, char gender, int bDateMonth, int bDateDay, int bDateYear)
	{
		GregorianCalendar birthDate = new GregorianCalendar(bDateYear, bDateMonth, bDateDay);
		profile = new UserProfile(first, last, userName, gender, birthDate);
	}
	
	/**
	 * Gets the user's user profile.
	 * @return profile - the user's profile
	 * @since CAH1.0
	 */
	public UserProfile getUserProfile()
	{
		return profile;
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
