package netplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.Timer;

import com.esotericsoftware.kryonet.Server;

public class CAH_Server implements Runnable
{
	private Server gameServer;
	private Timer updateTimer;
	private ConnectionType connectionType;
	private Socket localHost;//TODO connect this with a local client that then controls the UI
	
	public CAH_Server(ConnectionType connectionType)
	{
		gameServer = new Server();
		this.connectionType = connectionType;
		updateTimer = new Timer(100, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					gameServer.update(10);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
	}

	@Override
	public void run()
	{
		boolean running = true;
		while(running)
		{
			
		}
		/*
		 * TODO have timer go off at a certain interval, then when it does call gameServer.update();
		 * TODO then send everything from the server to "localhost" client, as well as all of the clients that aren't connected.
		 * TODO Gamelogic all run on server in netplay...
		 * TODO UI all on client.
		 * TODO Leave as much Gamelogic off of the clients as possible
		 * TODO have the server decide based on UDP/TCP based on onnection type
		 */
	}
	
	enum ConnectionType
	{
		UDP,
		TCP;
	}
}
