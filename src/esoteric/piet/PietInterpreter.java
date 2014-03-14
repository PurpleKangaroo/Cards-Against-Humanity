package esoteric.piet;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import esoteric.piet.Command.InvalidCommandError;
import esoteric.piet.PietColor.BlackColorException;

public class PietInterpreter
{
	private int codelSize;
	private BufferedImage code;
	private Point location;
	private DirectionPointer direction;
	private CodelChooser chooser;
	private PietColor lastColor;
	private Stack<Byte> pietStack;
	private io inout;
	private String output;
	
	public PietInterpreter(BufferedImage code, int codelSize)
	{
		this.code = code;
		location = new Point(0, 0);
		pietStack = new Stack<Byte>();
		this.codelSize = codelSize;
		chooser = CodelChooser.LEFT;
		direction = DirectionPointer.RIGHT;
		inout = io.JAVA;
		output = "";
	}
	
	public void setIO(io inout)
	{
		this.inout = inout;
	}
	
	public io getIO()
	{
		return inout;
	}
	
	public String interpretToText()
	{
		try
		{
			while(true)
			{
				incrementLocation();
				if(getPietColor().equals(PietColor.BLACK))
				{
					throw new BlackColorException();
				}
				Command command = getCommand();
				int numberOfCodels = getNumberOfCodels();
				switch(command)
				{
				case PUSH:
					push();
					break;
				case POP:
					pop();
					break;
				case ADD:
					add();
					break;
				case SUBTRACT:
					subtract();
					break;
				case MULTIPLY:
					multiply();
					break;
				case DEVIDE:
					devide();
					break;
				case MOD:
					mod();
					break;
				case NOT:
					not();
					break;
				case GREATER:
					greater();
					break;
				case POINTER:
					pointer();
					break;
				case SWITCH:
					switchCC();
					break;
				case DUPLICATE:
					duplicate();
					break;
				case ROLL:
					try
					{
						roll();
					}
					catch(NegativeRollError e)
					{
						
					}
					break;
				case IN_NUMBER:
					numberIn();
					break;
				case IN_CHAR:
					charIn();
					break;
				case OUT_NUMBER:
					numberOut();
					break;
				case OUT_CHAR:
					charOut();
					break;
				default:
					throw new Command.InvalidCommandError();
				}
			}
		}
		catch(BlackColorException e)
		{
			return output;
		}
		catch(InvalidCommandError e)
		{
			interpretToText();
		}
		return output;
	}
	
	public void numberOut()
	{
		output = output + ((int) pietStack.pop());
	}
	
	public void charOut()
	{
		output = output + (char) ((int) pietStack.pop());
	}
	
	public void numberIn()
	{
		
	}
	
	public void charIn()
	{
		
	}

	private void roll()
	{
		byte turns = pietStack.pop();
		byte depth = pietStack.pop();
		byte[] rolls = new byte[depth];
		for(int i = 0; i < depth; i++)
		{
			rolls[i] = pietStack.pop();
		}
		
		for(int i = 0; i < depth; i++)
		{
			pietStack.push(rolls[(i + turns) % depth]);
		}
	}

	private void duplicate()
	{
		pietStack.push(pietStack.peek());		
	}

	private void switchCC()
	{
		byte a = pietStack.pop();
		if(a % 2 == 1)
		{
			chooser = chooser.switchChooser();
		}
	}

	private void pointer()
	{
		byte a = pietStack.pop();
		direction = direction.rotate(a);
	}

	private void greater()
	{
		byte a = pietStack.pop();
		byte b = pietStack.pop();
		int c = b > a ? 1 : 0;
		pietStack.push((byte) c);
	}

	private void not()
	{
		int a = pietStack.pop() == 0 ? 1 : 0;
		pietStack.push((byte) a);
	}

	private void mod()
	{
		byte a = pietStack.pop();
		byte b = pietStack.pop();
		pietStack.push((byte) (b % a));
	}

	private void devide()
	{
		byte a = pietStack.pop();
		byte b = pietStack.pop();
		pietStack.push((byte) (((int) b) / ((int) a)));
	}

	private void multiply()
	{
		byte a = pietStack.pop();
		byte b = pietStack.pop();
		pietStack.push((byte) (b * a));
	}

	private void subtract()
	{
		byte a = pietStack.pop();
		byte b = pietStack.pop();
		pietStack.push((byte) (b - a));
	}

	private void pop()
	{
		pietStack.pop();
	}

	private void push()
	{
		pietStack.push(getNumberOfCodels());
	}
	
	private void add()
	{
		byte a = pietStack.pop();
		byte b = pietStack.pop();
		pietStack.push((byte) (a + b));
	}

	private byte getNumberOfCodels()
	{
		Point searcher;
		ArrayList<Point> pointsContained = new ArrayList<Point>();
		ArrayList<Point> checkCodels = new ArrayList<Point>();
		checkCodels.add(location);
		
		do
		{
			searcher = checkCodels.get(0);
			HashMap<Side, Point> map = getAdjacentCodels(searcher);
			for(int i = 0; i < Side.values().length; i++)
			{
				Point p = map.get(Side.values()[i]);
				if(sameColor(getPietColor(p)))
				{
					if(!pointsContained.contains(p) && !checkCodels.contains(p))
					{
						checkCodels.add(p);
					}
				}
			}
			checkCodels.remove(searcher);
			pointsContained.add(searcher);
		}
		while(checkCodels.size() > 0);
		
		return (byte) pointsContained.size();
	}
	
	private HashMap<Side, Point> getAdjacentCodels(Point p)
	{
		HashMap<Side, Point> map = new HashMap<Side, Point>();
		
		map.put(Side.UP, new Point((int) p.getX(), (int) p.getY() - codelSize));
		map.put(Side.DOWN, new Point((int) p.getX(), (int) p.getY() + codelSize));
		map.put(Side.LEFT, new Point((int) p.getX()  - codelSize, (int) p.getY()));
		map.put(Side.RIGHT, new Point((int) p.getX() + codelSize, (int) p.getY()));
		
		return map;
	}
	
	private boolean sameColor(int xIncr, int yIncr)
	{
		return lastColor.equals(PietColor.getPietColor(code.getRGB((int) location.getX() + xIncr, (int) location.getY() + yIncr))) && (location.getX() + xIncr) < code.getWidth() && (location.getY() + yIncr) < code.getHeight();
	}
	
	private boolean sameColor(PietColor color)
	{
		return color.equals(getPietColor());
	}
	
	private Command getCommand()
	{
		return Command.getCommand(this.lastColor, getPietColor());
	}
	
	private PietColor getPietColor()
	{
		return PietColor.getPietColor(code.getRGB((int) location.getX(), (int) location.getY()));
	}
	
	private PietColor getPietColor(Point p)
	{
		return PietColor.getPietColor(code.getRGB((int) p.getX(), (int) p.getY()));
	}
	
	private void incrementLocation()
	{
		lastColor = getPietColor();
		
		if(direction.equals(DirectionPointer.LEFT))
		{
			do
			{
				while(sameColor(-1 * codelSize, 0))
				{
					location  = new Point((int) location.getX() - codelSize, (int) location.getY());			
				}
				if(chooser.equals(CodelChooser.LEFT))
				{
					while(sameColor(1, codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() + codelSize);
					}
				}
				else
				{
					while(sameColor(1, -1 * codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() - codelSize);
					}
				}
				
			}
			while(sameColor(-1 * codelSize, 0) || (sameColor(1, codelSize) && chooser.equals(CodelChooser.LEFT)) || (sameColor(1, -1 * codelSize) && chooser.equals(CodelChooser.LEFT)));		
		}
		else if(direction.equals(DirectionPointer.RIGHT))
		{
			do
			{
				while(sameColor(codelSize, 0))
				{
					location  = new Point((int) location.getX() + codelSize, (int) location.getY());			
				}
				if(chooser.equals(CodelChooser.RIGHT))
				{
					while(sameColor(-1, codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() + codelSize);
					}
				}
				else
				{
					while(sameColor(-1, -1 * codelSize))
					{
						location  = new Point((int) location.getX(), (int) location.getY() - codelSize);
					}
				}
				
			}
			while(sameColor(codelSize, 0) || (sameColor(-1, -1 * codelSize) && chooser.equals(CodelChooser.LEFT)) || (sameColor(-1, codelSize) && chooser.equals(CodelChooser.LEFT)));		
		}
		else if(direction.equals(DirectionPointer.DOWN))
		{
			do
			{
				while(sameColor(0, codelSize))
				{
					location  = new Point((int) location.getX(), (int) location.getY() + codelSize);			
				}
				if(chooser.equals(CodelChooser.RIGHT))
				{
					while(sameColor(-1 * codelSize, -1))
					{
						location  = new Point((int) location.getX() - codelSize, (int) location.getY());
					}
				}
				else
				{
					while(sameColor(codelSize, -1))
					{
						location  = new Point((int) location.getX() + codelSize, (int) location.getY());
					}
				}
				
			}
			while(sameColor(0, codelSize) || (sameColor(codelSize, -1) && chooser.equals(CodelChooser.LEFT)) || (sameColor(-1 * codelSize, -1) && chooser.equals(CodelChooser.LEFT)));		
		}
		else if(direction.equals(DirectionPointer.UP))
		{
			do
			{
				while(sameColor(0, -1 * codelSize))
				{
					location  = new Point((int) location.getX(), (int) location.getY() - codelSize);			
				}
				if(chooser.equals(CodelChooser.RIGHT))
				{
					while(sameColor(codelSize, 1))
					{
						location  = new Point((int) location.getX() + codelSize, (int) location.getY());
					}
				}

				else
				{
					while(sameColor(-1 * codelSize, 1))
					{
						location  = new Point((int) location.getX() - codelSize, (int) location.getY());
					}
				}
				
			}
			while(sameColor(0, codelSize) || (sameColor(-1 * codelSize, 1) && chooser.equals(CodelChooser.LEFT)) || (sameColor(codelSize, 1) && chooser.equals(CodelChooser.LEFT)));		
		}
	}
	
	protected enum Side
	{
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}
	
	public enum io
	{
		JAVA,
		COMMAND_LINE;
	}
	
	/**
	 * A class of error that is thrown when the program tries to execute a negative number of rolls.
	 * @author Holt Maki
	 * @since CAH 1.0
	 * @version CAH1.0
	 *
	 */
	public class NegativeRollError extends PietError
	{
		
	}
	
}
