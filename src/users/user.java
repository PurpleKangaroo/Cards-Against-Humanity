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
	//Make CAH have a static UserID list that contains all userIDs
	//Make each user have a userID
	private File userInfoFile;//Do work on this part! make it so that it supports both new users and old users and saves user info.
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

}
