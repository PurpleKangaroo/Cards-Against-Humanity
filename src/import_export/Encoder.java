package import_export;

/**
 * A class of object that deals with encoding of text characters.
 * @author s-hmaki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public class Encoder {
	private final static String[] chars = {"\u00A2", "\u00A3", "\u00A5", "\u00A9", "\u00AE", "\u2122", "\u2116", "\u00C0",
										"\u00C1", "\u00C7", "\u00C8", "\u00C9", "\u00CA", "\u00CC", "\u00CD", "\u00CE",
										"\u00D2", "\u00D3", "\u00D4", "\u00E0", "\u00E1", "\u00E2", "\u00E3", "\u00BF",
										"\u00C3", "\u00D5", "\u00E4", "\u00E5", "\u00E7", "\u00E8", "\u00E9", "\u00EA",
										"\u00EB", "\u00E4", "\u00C4", "\u00CB", "\u00CF", "\u00DC", "\u00DF", "\u00EC",
										"\u00ED", "\u00EE", "\u00EF", "\u00F1", "\u00F2", "\u00F3", "\u00F4", "\u00F5",
										"\u00F6", "\u00F9", "\u00FA", "\u00FB", "\u00FC"};
	private final static String[] strs = {"\\u00A2", "\\u00A3", "\\u00A5", "\\u00A9", "\\u00AE", "\\u2122", "\\u2116", "\\u00C0",
										"\\u00C1", "\\u00C7", "\\u00C8", "\\u00C9", "\\u00CA", "\\u00CC", "\\u00CD", "\\u00CE",
										"\\u00D2", "\\u00D3", "\\u00D4", "\\u00E0", "\\u00E1", "\\u00E2", "\\u00E3", "\\u00BF",
										"\\u00C3", "\\u00D5", "\\u00E4", "\\u00E5", "\\u00E7", "\\u00E8", "\\u00E9", "\\u00EA",
										"\\u00EB", "\\u00E4", "\\u00C4", "\\u00CB", "\\u00CF", "\\u00DC", "\\u00DF", "\\u00EC",
										"\\u00ED", "\\u00EE", "\\u00EF", "\\u00F1", "\\u00F2", "\\u00F3", "\\u00F4", "\\u00F5",
										"\\u00F6", "\\u00F9", "\\u00FA", "\\u00FB", "\\u00FC"};
	/**
	 * Creates an object that represents an encoder
	 * @since CAH1.0
	 */
	public Encoder() 
	{
		
	}
	
	/**
	 * Gets the text in the right encoding.
	 * @param encodeStr - The string that will have its encoding fixed.
	 * @return encoded - the corectly encoded String.
	 * @since CAH1.0
	 */
	public String encode(String encodeStr)
	{
		String encoded = encodeStr;
		for (int i = 0; i< chars.length; i++)
		{
			while(encoded.contains(strs[i]))
			{
				encoded = encoded.replace(strs[i], chars[i] +"");
			}
			
		}
		return encoded;
	}	
	
}
