package import_export;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * A class of object that finds the paths of files.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public class pathFinder {
	private String CAH_Path;
	
	/**
	 * Creates an object that finds the paths of files.
	 * @since CAH1.0
	 * @throws URISyntaxException
	 */
	public pathFinder() throws URISyntaxException
	{
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource(".");
		File file = new File(url.toString());
		CAH_Path = file.getAbsolutePath();
		int index = CAH_Path.indexOf("%");
		CAH_Path = CAH_Path.substring(0,index);
		CAH_Path = CAH_Path.substring(0, CAH_Path.lastIndexOf("file"));
	}

	/**
	 * Gets the path of the pathfinder.
	 * @return CAH_Path - the path of the pathfinder
	 * @since CAH1.0
	 */
	public String getCAH_Path()
	{
		return CAH_Path;
	}
	
	/**
	 * Gets the path of another cards against humanity file.
	 * @param fileString - the file that is trying to be found's directory on the origninal.
	 * @return - the path of the file trying to be found
	 */
	public String getCAH_Path(String fileString)
	{
		String pathStr = CAH_Path + "";
		fileString = fileString.substring(fileString.indexOf("/Cards Against Humanity/") + "/Cards Against Humanity/".length());
		pathStr = pathStr + fileString;
		return pathStr;
	}
	
}
