package esoteric.brainfuck;

public class Brainfuck
{
	public static String toBrainfuck(String text)
	{
		return TextToBrainfuck.brainFuck(text);
	}
	
	public static String toText(String brainfuck)
	{
		BrainfuckInterpreter a = new BrainfuckInterpreter();
		return a.interpret(brainfuck);
	}
}
