package netplay;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class CAH_Connection {
	
	public static void main(String[] args) throws IOException
	{
		Scanner in = new Scanner(System.in);//Testing
		String servername = in.nextLine();//Testing
		ArrayList<Byte> a = new ArrayList<Byte>();//Testing
		for(int i = 0; i < servername.length(); i = i + servername.indexOf(".", i))//Testing
		{//Testing
			try//Testing
			{//Testing
				a.add(Byte.parseByte(servername.substring(i,servername.indexOf(".", i))));//Testing
			}//Testing
			catch(Exception e)//Testing
			{//Testing
				a.add(Byte.parseByte(servername.substring(i)));//Testing
			}//Testing
			//Testing
		}//Testing
		byte[] b = new byte[a.size()];//Testing
		for(int i = 0; i < a.size(); i++)//Testing
		{//Testing
			b[i] = a.get(i);//Testing
		}//Testing
		
		InetAddress inet = InetAddress.getByAddress(b);//Testing
		int port = 2000;
		SocketChannel channel = SocketChannel.open();
		
		channel.configureBlocking(false);
		channel.connect(new InetSocketAddress(inet, port));
		while(true)
		{
			ByteBuffer bufferA = ByteBuffer.allocate(20);
			int i = 0;
			String message = "";
			while((i = channel.read(bufferA)) > 0)
			{
				bufferA.flip();
				message += Charset.defaultCharset().decode(bufferA);
			}
			System.out.println(message);
		}
	}

}
