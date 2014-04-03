package netplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.PriorityQueue;

import javax.swing.Timer;

import users.HumanPlayer;
import users.Player;
import users.User;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

/**
 * A class of object that represents the client side of a connection in Cards Against Humanity.
 * CAH_Client will communicate with the UI through a priority queue of the messages that it recieves, which the UI will poll from and then act based on the messages.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Client implements Runnable
{
	/**
	 * The {@linkplain Client} that is being used by the CAH_Client.
	 */
	private Client client;
	
	/**
	 * The boolean that tells weather or not the CAH_Client is being used by the host.
	 */
	private boolean host;
	
	/**
	 * The timer that prompts the server to call {@link Server#update(int)}.
	 */
	private Timer updateTimer;
	
	/**
	 * The type of connection used by {@linkplain #gameServer}. It will either be UDP or TCP.
	 */
	private ConnectionType connectionType;
	
	/**
	 * The PriorityQueue used by the CAH_Client.
	 */
	private PriorityQueue<Message> messageQueue;
	
	/**
	 * The username of the person who is using the CAH_Client.
	 */
	private String username;
	
	/**
	 * The {@linkplain User} of the CAH_Client.
	 */
	private User user;
	
	/**
	 * Creates a new object that represents the client side of a connection in a Netplay game of Cards Against Humanity.
	 * CAH_Client will communicate with the UI through a priority queue of the messages that it recieves, which the UI will poll from and then act based on the messages.
	 * @param username The username of person using the CAH_Client.
	 * @param host The boolean that tells weather or not the CAH_Client is being used by the host of a game of Cards Against Humanity.
	 * @since CAH1.0
	 */
	public CAH_Client(User user, boolean host, ConnectionType type)
	{
		this.connectionType = type;
		this.user = user;
		messageQueue = new PriorityQueue<Message>();
		
		client = new Client();
		
		updateTimer = new Timer(100, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					client.update(100);
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Tells weather or not {@linkplain #messageQueue} is empty.
	 * @return {@code messageQueue.isEmpty()} - Tells weather or not the messageQueue is empty.
	 * @since CAH1.0
	 */
	public boolean queueIsEmpty()
	{
		return messageQueue.isEmpty();
	}
	
	/**
	 * Gets the message of highest priority in {@linkplain #messageQueue}.
	 * @return {@code messageQueue.poll()} - The message that is at the top of the the PriorityQueue {@linkplain #messageQueue}.
	 * @since CAH1.0
	 */
	public Message pollQueue()
	{
		return messageQueue.poll();
	}

	@Override
	public void run()
	{
		client.addListener(new Listener(){
			public void disconnected(Connection connection)
			{
				super.disconnected(connection);
			}
			public void connected(Connection connection)
			{
				super.connected(connection);
				if(connectionType.equals(ConnectionType.UDP))
				{
					client.sendUDP(user);
				}
				else
				{
					client.sendTCP(user);
				}
			}
			public void received(Connection connection, Object object)
			{
				super.received(connection, object);
				if(object instanceof GameCommandMessage)
				{
					// UI processing it (TODO)
				}
				if(object instanceof ChatMessage)
				{
					// UI processing it (TODO)
				}
			}
		});
		updateTimer.start();
		boolean running = true;
		while(running)
		{
			
		}
		
	}
}
