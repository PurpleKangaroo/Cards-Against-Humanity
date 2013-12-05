package saving;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * The methods for the interface Saveable are written in this clas.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class Save {//This class declares the methods that go in saveable interface
	
	public void save(String saveString, String fileName) throws FileNotFoundException
	{
		File saveFile = new File(fileName + ".txt");
		PrintWriter out = new PrintWriter(saveFile);
	}

}
