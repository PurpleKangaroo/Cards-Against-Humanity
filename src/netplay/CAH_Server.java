package netplay;

import java.io.*;
import java.net.*;

/**
 * A class of object that represents a Cards Against Humanity Server.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class CAH_Server extends Thread {
	/**
	 * The port that is used for the connection.
	 */
	private static int port = 2000;
	
	/**
	 * The socket that is used for the server.
	 */
	private ServerSocket serverSocket;
	
	/**
	 * Creates an object that represents a Cards Against Humanity Server
	 * @since CAH1.0
	 * @version CAH1.0
	 * @throws IOException 
	 */
	public CAH_Server() throws IOException
	{
		serverSocket = new ServerSocket(port);
		serverSocket.setSoTimeout(10000);
	}
	
	public void run()
	{
		while(true)
		{
			try
			{
				Socket server = serverSocket.accept();
				
				DataInputStream in = new DataInputStream(server.getInputStream());
				DataOutputStream out = new DataOutputStream(server.getOutputStream());
				
				ObjectInputStream objIn = new ObjectInputStream(server.getInputStream());
				ObjectOutputStream objOut = new ObjectOutputStream(server.getOutputStream());
				
				//FIXME The input and output stream need to actually do stuff.
			}
			
			catch(SocketTimeoutException t)
			{
				
			}
			
			catch(IOException e)
			{
				
			}
		}
	}
}
