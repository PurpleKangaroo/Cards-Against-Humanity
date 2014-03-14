package esoteric.piet;

public class PietCommand
{
	private int number;
	private Command command;
	
	public PietCommand(Command command, int number)
	{
		this.number = number;
		this.command = command;
	}
	
	public Command getCommand()
	{
		return command;
	}
	
	public int getNumber()
	{
		return number;
	}
}
