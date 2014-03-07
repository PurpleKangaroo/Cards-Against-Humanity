package netplay;

import java.io.*;
import java.net.*;

/**
 * A class of object that represents a Cards Against Humanity Server.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class CAH_Server {
	/**
	 * The port that is used for the connection.
	 */
	private static int port = 2000;
	
	/**
	 * The socket that is used for the server.
	 */
	private MulticastSocket socket;
	
	private Socket server;
	
	/**
	 * Creates an object that represents a Cards Against Humanity Server
	 * @since CAH1.0
	 * @version CAH1.0
	 * @throws IOException 
	 */
	public CAH_Server() throws IOException
	{
		socket = new MulticastSocket(port);
		socket.setSoTimeout(10000);
		
		BufferedInputStream in = new BufferedInputStream(server.getInputStream());
		BufferedOutputStream out = new BufferedOutputStream(server.getOutputStream());
	}
	
	
	
}
