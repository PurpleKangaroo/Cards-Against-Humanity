package netplay;

import com.esotericsoftware.kryonet.Connection;

/**
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class CAH_Connection extends Connection
{
	private String username;
	
	public CAH_Connection(String username)
	{
		super();
		this.username = username;
	}
	
	public String getUsername()
	{
		return username;
	}
}
