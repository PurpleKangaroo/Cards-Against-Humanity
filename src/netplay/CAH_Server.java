package netplay;

import java.util.Timer;

import com.esotericsoftware.kryonet.Server;

public class CAH_Server implements Runnable
{
	private Server gameServer;
	private Timer updateTimer;
	private ConnectionType connectionType;
	
	public CAH_Server(ConnectionType connectionType)
	{
		gameServer = new Server();
		this.connectionType = connectionType;
		
	}

	@Override
	public void run()
	{
		/*TODO have timer go off at a certain interval, then when it does call gameServer.update();
		TODO then send everything from the server to "localhost" client, as well as all of the clients that aren't connected.
		TODO Gamelogic all run on server in netplay...
		TODO UI all on client.
		TODO Leave as much Gamelogic off of the clients as possible
		TODO have the server decide based on UDP/TCP based on onnection type
		*/
	}
	
	enum ConnectionType
	{
		UDP,
		TCP;
	}
}
