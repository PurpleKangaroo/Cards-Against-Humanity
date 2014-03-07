package netplay;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A class of object that represents a Cards Against Humanity Server.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class CAH_Server implements Runnable {
	private static String channelType = "channelType";
	private static String clientChannel = "clientChannel";
	private static String serverChannel = "serverChannel";
	/**
	 * The port that is used for the connection.
	 */
	private static int port = 2000;
	
	private InetAddress hostAddress = InetAddress.getByAddress(new byte[]{0,0,0,0});
	
	/**
	 * Creates an object that represents a Cards Against Humanity Server
	 * @since CAH1.0
	 * @throws IOException 
	 */
	public CAH_Server() throws IOException
	{
		ServerSocketChannel channel = ServerSocketChannel.open();
		channel.bind(new InetSocketAddress(hostAddress, port));
		channel.configureBlocking(false);
		
		Selector selector = Selector.open();
		
		SelectionKey socketServerSelectionKey = channel.register(selector, SelectionKey.OP_ACCEPT);
		
		Map<String, String> properties = new HashMap<String, String>();
		properties.put(channelType, serverChannel);
		
		socketServerSelectionKey.attach(properties);
		
		for(;;)
		{
			if(selector.select() == 0)
			{
				continue;
			}
			
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectedKeys.iterator();
			
			while(iterator.hasNext())
			{
				SelectionKey key = iterator.next();
				
				if(((Map<Object, Object>) key.attachment()).get(channelType).equals(serverChannel))
				{
					ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
					
					SocketChannel clientSocketChannel = serverSocketChannel.accept();
					
					if(clientSocketChannel != null)
					{
						
					}
				}
			}
		}
		
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
	}
}
