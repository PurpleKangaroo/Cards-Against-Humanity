package esoteric.piet;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class PietCreator
{
	private String imgPath;
	private String text;
	private ArrayList<PietCommand> commands;
	private Stack<Byte> pietStack;
	
	public PietCreator(String imgPath, String text)
	{
		this.imgPath = imgPath;
		this.text = text;
		commands = new ArrayList<PietCommand>();
		pietStack = new Stack<Byte>();
	}
	
	protected void createPiet()
	{
		Random a = new Random();
		for(int i = 0; i < text.length(); i++)
		{
			if(i > 0 && text.charAt(i-1) == text.charAt(i) && a.nextBoolean())
			{
				commands.add(new PietCommand(Command.DUPLICATE, -1));
			}
			else
			{
				pietStack.push((byte) 1);
				commands.add(new PietCommand(Command.PUSH, 1));
				int method = a.nextInt(2);
				if(method == 0)
				{
					pietStack.push((byte) 1);
					commands.add(new PietCommand(Command.PUSH, 1));
				}
				else
				{
					pietStack.push((byte) 1);
					commands.add(new PietCommand(Command.DUPLICATE, -1));
				}
				
				int character = (int) text.charAt(i);
				if(pietStack.peek() != character)
				{
					method = a.nextInt(5);
					if(method == 0)
					{
						boolean r = a.nextBoolean();
						if(pietStack.size() < 2)
						{
							if(r)
							{
								pietStack.push((byte) 1);
								commands.add(new PietCommand(Command.PUSH, 1));
							}
							else
							{
								pietStack.push((byte) 1);
								commands.add(new PietCommand(Command.DUPLICATE, -1));
							}
						}
						
					}
				}
			}
			
			
		}
	}
}