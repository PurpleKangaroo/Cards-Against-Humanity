package users;

import java.io.File;

/**
 * An object that represents a user
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class user {
	private userProfile profile;
	private userActionLog log;
	private userBehavior behaviorStats;
	private userGameHistory history;
	//Make CAH have a static UserID list that contains all userIDs
	//Make each user have a userID
	private File userInfoFile;//Do work on this part! make it so that it supports both new users and old users and saves user info.
	//Password protection???
	
	/**
	 * Creates a new user
	 * @param first - First Name.
	 * @param last - Last Name.
	 * @param userName - Username
	 * @param gender - Gender (m or f)
	 * @see {@linkplain userProfile}
	 * @since CAH1.0
	 */
	public user(String first, String last, String userName, char gender)
	{
		profile = new userProfile(first, last, userName, gender);
	}
	
	/**
	 * Gets the user's user profile.
	 * @return profile - the user's profile
	 * @since CAH1.0
	 */
	public userProfile getUserProfile()
	{
		return profile;
	}

}
