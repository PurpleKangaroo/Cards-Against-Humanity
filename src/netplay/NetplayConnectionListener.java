package netplay;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import jexxus.common.Connection;
import jexxus.common.ConnectionListener;
import jexxus.server.ServerConnection;

public class NetplayConnectionListener implements ConnectionListener
{
	private LinkedList<String> recieved = new LinkedList<String>();
	
	@Override
	public void connectionBroken(Connection broken, boolean forced)
	{
		//TODO notify disconnection
	}

	@Override
	public void receive(byte[] data, Connection from)
	{
		try
		{
			System.in.read(data);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void clientConnected(ServerConnection conn)
	{
		// TODO Notify connection
	}
	
}
