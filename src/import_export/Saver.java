package import_export;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;
//TODO: Maybe make it work for random accessfiles. Or maybe redo to make this abstract, and make different children of this for different types of files.
/**
 * The methods for the interface Saveable are written in this clas.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class Saver {
	private PrintWriter out;
	private Scanner in;
	private File saveFile;
	
	/**
	 * Creates an object that saves and loads text from files.
	 * @param fileName the name of the file that will be accessed.
	 * @since CAH1.0
	 * @throws URISyntaxException
	 * @throws IOException 
	 */
	public Saver(String fileName, String folder) throws URISyntaxException, IOException //Constructor #1
	{
		PathFinder a = new PathFinder();
		saveFile = new File(a.getCAH_Path("/Cards Against Humanity/src/" + folder + "/" + fileName));
		if (!saveFile.exists())
		{
			saveFile = new File(a.getCAH_Path("/Cards Against Humanity/src/" + folder + "/" + fileName + ".txt"));
			saveFile.createNewFile();
			System.out.println("A");
		}
		out = new PrintWriter(saveFile);
		in = new Scanner(saveFile);
	}

	/**
	 * Saves a line of text to a file
	 * @param printString the String that will be printed to the line
	 * 
	 */
	public void saveln(String printString)
	{
		out.println(printString);
	}
	
	/**
	 * Closes the print stream for the saver.
	 * @since CAH1.0
	 */
	public void close()
	{
		out.close();
	}
	
	/**
	 * Gets the next line from a text document.
	 * @return a the string that the next line contains.
	 */
	public String loadln()
	{
		String a = in.nextLine();
		return a;
	}
	/**
	 * Saves a String to a text document
	 * @param printString the line String that will be saved to the text document.
	 */
	public void save(String printString)
	{
		out.print(printString);
	}
	
	
}
