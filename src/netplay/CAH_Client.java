package netplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.PriorityQueue;

import javax.swing.Timer;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Server;

/**
 * A class of object that represents the client side of a connection in Cards Against Humanity.
 * CAH_Client will communicate with the UI through a priority queue of the messages that it recieves, which the UI will poll from and then act based on the messages.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
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
