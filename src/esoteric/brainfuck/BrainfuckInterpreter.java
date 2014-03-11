package esoteric.brainfuck;
import java.beans.Encoder;
import java.util.Stack;


public class BrainfuckInterpreter {
	private Command[] commands = Command.values();
	
	private String output;	
	private byte[] data;
	private short dataPointer;
	private int codeCounter;
	private char[] codeChars;
	private Stack<Integer> loops;
	
	public BrainfuckInterpreter()
	{
		data = new byte[Short.MAX_VALUE];
		dataPointer = 0;
		
		output = "";
		codeCounter = 0;
		codeChars = new char[1];
		loops = new Stack<Integer>();
	}
	
	public String interpret(String code)
	{
		codeChars =  code.toCharArray();
		if(code.contains(","))
		{
			class BrainfuckException extends RuntimeException
			{
				
			}
			throw new BrainfuckException();
		}
		for(; codeCounter < codeChars.length; codeCounter++)
		{
			Command c = getCommand(codeChars[codeCounter]);
			interpretCommand(c);
		}
		return output;
	}
	
	private void interpretCommand(Command c)
	{
		switch(c)
		{
		case INCREMENT_DATAPOINTER:
			incrementDatapointer();
			break;
		case DECREMENT_DATAPOINTER:
			decrementDatapointer();
			break;
		case INCREMENT_ELEMENT:
			incrementElement();
			break;
		case DECREMENT_ELEMENT:
			decrementElement();
			break;
		case START_LOOP:
			startLoop();
			break;
		case END_LOOP:
			endLoop();
			break;
		case OUT:
			out();
			break;
		default:
			break;
		}
	}
	
	private void out() 
	{
		int ascii = (int) data[dataPointer];
		output = output + (char) ascii;		
	}
	
	private void startLoop()
	{
		loops.push((Integer) codeCounter);
	}

	private void endLoop() 
	{
		if(data[dataPointer] == 0)
		{
			loops.pop();
		}
		else
		{
			codeCounter = loops.pop() - 1;
		}
	}

	private void decrementElement()
	{
		data[dataPointer]--;
	}

	private void incrementElement() 
	{
		data[dataPointer]++;
	}

	private void decrementDatapointer() 
	{
		if(dataPointer == 0)
		{
			dataPointer = Short.MAX_VALUE;
		}
		else
		{
			dataPointer--;
		}
		
	}

	private void incrementDatapointer() 
	{
		if(dataPointer == Short.MAX_VALUE)
		{
			dataPointer = 0;
		}
		else
		{
			dataPointer++;
		}
		
	}

	private Command getCommand(char a)
	{
		for(int i = 0; i < commands.length; i++)
		{
			if(commands[i].commandChar == a)
			{
				return commands[i];
			}
		}
		return null;
	}
	
	private enum Command
	{
		INCREMENT_DATAPOINTER ('>'),
		DECREMENT_DATAPOINTER ('<'),
		INCREMENT_ELEMENT ('+'),
		DECREMENT_ELEMENT ('-'),
		START_LOOP ('['),
		END_LOOP (']'),
		OUT ('.'),
		IN(',');
		
		public final char commandChar;
		
		private Command(char commandChar)
		{
			this.commandChar = commandChar;
		}
	}

}
