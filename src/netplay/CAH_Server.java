package netplay;

import java.io.*;
import java.net.*;

/**
 * A class of object that represents a Cards Against Humanity Server.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * <dt></dt>
 * <b>Extends:</b> <dl> {@linkplain Thread} </dl>
 */
public class CAH_Server extends Thread {
	private static int port = 2000;
	private ServerSocket serverSocket;
	
	/**
	 * Creates an object that represents a Cards Against Humanity Server
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public CAH_Server()
	{		
		boolean socketCreated = false;
		
		while(!socketCreated)
		{
			
			port++;
			
			try
			{
				serverSocket = new ServerSocket(port);
			}
			
			catch(IOException e)
			{
				
			}
			
		}
	}
	
	public void run()
	{
		
	}
}
