package esoteric.brainfuck;

import import_export.PathFinder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.Scanner;

import cards.DeckBuilder;

/**
 * The class that does all Brainfuck operations, using other {@linkplain esoteric.brainfuck} classes. Consolidates all Brainfuck operations.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 * @see BrainfuckInterpreter
 * @see TextToBrainfuck
 *
 */
public class Brainfuck
{
	/**
	 * Translates a String of normal text into Brainfuck.
	 * @author Holt Maki
	 * @param text The text that is being put into Brainfuck.
	 * @return {@code TextToBrainfuck.brainFuck(text)} - A String of Brainfuck, translated from text.
	 * @since CAH1.0
	 * @see TextToBrainfuck
	 * @see TextToBrainfuck#TextToBrainfuck()
	 */
	public static String toBrainfuck(String text)
	{
		return TextToBrainfuck.brainFuck(text);
	}
	
	/**
	 * Translates a String of Brainfuck into normal text.
	 * @param brainfuck The String of Brainfuck being translated into normal text.
	 * @author Holt Maki
	 * @return {@code (new BrainfuckInterpreter()).interpret(brainfuck)} - A string of normal text interpreted from Brainfuck.
	 * @since CAH1.0
	 */
	public static String toText(String brainfuck)
	{
		return (new BrainfuckInterpreter()).interpret(brainfuck);
	}
	
	private void createBrainfuckFile(String filename1, String filename2) throws FileNotFoundException, URISyntaxException
	{
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename1))));
		System.out.println((new PathFinder()).getCAH_Path(filename2 + ".bf"));
		PrintWriter out = new PrintWriter((new PathFinder()).getCAH_Path(filename2).replace("\\", "/"));
		while(in.hasNextLine())
		{
			out.println(toBrainfuck(in.nextLine()));
		}
		
		out.close();
		
	}
	
	protected Brainfuck()
	{
		
	}
}
