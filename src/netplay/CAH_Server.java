package netplay;

import game.CAH_Game;
import game.CardNotFoundException;
import game.PlayerNotFoundException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;

import netplay.GameCommandMessage.CardNumberException;
import users.Card_Czar_Exception;
import users.User;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;

/**
 * The server used to run CAH's game logic.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class CAH_Server implements Runnable
{
	/**
	 * A map that contains the usernames and InetSocketAddresses of all of the players of the game.
	 */
	private Map<InetSocketAddress, String> socketMap;
	/**
	 * The {@linkplain Server} used to communicate with a game's clients.
	 */
	private Server gameServer;
	/**
	 * The timer that prompts the server to call {@link Server#update(int)}.
	 */
	private Timer updateTimer;
	
	/**
	 * The type of connection used by {@linkplain #gameServer}. It will either be UDP or TCP.
	 */
	private ConnectionType connectionType;
	
	/**
	 * The socket for the local client that is on the same computer as the client.
	 * This socket will be used for the CAH_Server to communicate to the UI of the computer it is being run on.
	 */
	private Socket localHost;//TODO connect this with a local client that then controls the UI
	private CAH_Game game;
	
	/**
	 * Creates the server that runs game logic and communicates with the clients of a CAH game.
	 * @param connectionType The type of connection being used ({@linkplain ConnectionType#TCP} or {@linkplain ConnectionType#UDP}.
	 * @param game The {@linkplain CAH_Game} that is being played over the CAH_Server.
	 */
	public CAH_Server(ConnectionType connectionType, CAH_Game game)
	{
		gameServer = new Server();
		this.connectionType = connectionType;
		this.socketMap = new HashMap<InetSocketAddress, String>();
		this.game = game;
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
		
		gameServer.getKryo().register(ChatMessage.class);
		gameServer.getKryo().register(Message.class);
		gameServer.getKryo().register(User.class);
		gameServer.getKryo().register(GameCommandMessage.class);
	}

	@Override
	public void run()
	{
		gameServer.addListener(new Listener(){
			public void disconnected(Connection connection)
			{
				super.disconnected(connection);
				if(connectionType.equals(ConnectionType.UDP))
				{
					InetSocketAddress disconnected = connection.getRemoteAddressUDP();
					game.removePlayer(socketMap.get(disconnected));
					socketMap.remove(disconnected);
				}
				else
				{
					InetSocketAddress disconnected = connection.getRemoteAddressTCP();
					game.removePlayer(socketMap.get(disconnected));
					socketMap.remove(disconnected);
				}
				//TODO Send to clients
			}
			public void connected(Connection connection)
			{
				super.connected(connection);
			}
			public void received(Connection connection, Object object)
			{
				super.received(connection, object);
				if(object instanceof GameCommandMessage)
				{
					if(connectionType.equals(ConnectionType.UDP))
					{
						try
						{
							gameServer.sendToAllUDP(game.processCommand((GameCommandMessage) object));
						} catch (Card_Czar_Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (PlayerNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CardNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CardNumberException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else
					{
						try
						{
							gameServer.sendToAllTCP(game.processCommand((GameCommandMessage) object));
						} catch (Card_Czar_Exception e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (PlayerNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CardNotFoundException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CardNumberException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				if(object instanceof ChatMessage)
				{
					if(connectionType.equals(ConnectionType.UDP))
					{
						gameServer.sendToAllUDP(object);
					}
					else
					{
						gameServer.sendToAllTCP(object);
					}
				}
				if(object instanceof User)
				{
					if(connectionType.equals(ConnectionType.UDP))
					socketMap.put(connection.getRemoteAddressUDP(), ((User) object).getUserProfile().getUserName());
					game.addPlayer((User) object);
					//TODO send to clients...
				}
			}
		});
		updateTimer.start();
		boolean running = true;
		while(running)
		{
			
		}
		/*
		 * TODO have timer go off at a certain interval, then when it does call gameServer.update();
		 * TODO then send everything from the server to "localhost" client, as well as all of the clients that aren't connected.
		 * TODO Gamelogic all run on server in netplay...
		 * TODO UI all on client.
		 * TODO Leave as much Gamelogic out of the clients as possible, just have the server send basic info
		 *  	to the clients like the text on the cards...
		 * TODO have the server decide based on UDP/TCP based on onnection type
		 * TODO create a listener
		 */
	}
	
}
