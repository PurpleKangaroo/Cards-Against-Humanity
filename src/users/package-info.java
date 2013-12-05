
/**
 * The package that contains the classes that have to do with users, user information, and keeping records on users so that they can be impersonated by the computer.
 * This package contains the class {@linkplain userProfile}, which keeps information about the user to allow the computer to predict the behavior of other users with similar information.
 * This package also contains the class {@linkplain userGameHistory}, which keeps track of how well the user has done in past games, 
 * {@linkplain userBehavior}, which keeps track of the users behavior, 
 *  and {@linkplain userActionLog} which keeps track of every action of the user in the game so that the computer may impersonate the user, and so that the computer can predict what the user will find funny.
 *  The class {@linkplain userSave} saves the {@linkplain userProfile}, {@linkplain userGameHistory}, {@linkplain userBehavior}, and {@linkplain userActionLog} into a text file 
 *  in an obviscated or encrypted form so that it cannot be easily tampered with.
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