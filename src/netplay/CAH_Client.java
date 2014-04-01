package netplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.PriorityQueue;

import javax.swing.Timer;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

public class CAH_Client
{
	private Client client;
	
	/**
	 * The timer that prompts the server to call {@link Server#update(int)}.
	 */
	private Timer updateTimer;
	
	/**
	 * The type of connection used by {@linkplain #gameServer}. It will either be UDP or TCP.
	 */
	private ConnectionType connectionType;
	
	private PriorityQueue<Message> messageQueue;
	
	private String username;
	
	public CAH_Client(String username)
	{
		messageQueue = new PriorityQueue<Message>();
		
		client = new Client();
		
		updateTimer = new Timer(100, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					client.update(10);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public Message pollQueue()
	{
		return messageQueue.poll();
	}
	
	
}
