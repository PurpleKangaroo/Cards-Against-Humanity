
/**
 * The package that contains the classes that have to do with users, user information, and keeping records on users so that they can be impersonated by the computer.
 * This package contains the class {@linkplain users.UserProfile}, which keeps information about the user to allow the computer to predict the behavior of other users with similar information.
 * This package also contains the class {@linkplain users.UserGameHistory}, which keeps track of how well the user has done in past games, 
 * {@linkplain users.UserBehavior}, which keeps track of the users behavior, 
 *  and {@linkplain userActionLog} which keeps track of every action of the user in the game so that the computer may impersonate the user, and so that the computer can predict what the user will find funny.
 *  We should look into different options for storing user data - XML or text seem the best right now
 * <ul>
 * Todo:
 * <li>
 * {@linkplain userBehavior}
 * <li>
 * {@linkplain userGameHistory}
 * <li>
 * {@linkplain userActionLog}
 * </li>
 * </ul>
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */
package users;