package esoteric.piet;

public enum CodelChooser
{
	RIGHT,
	LEFT;
	
	public static CodelChooser switchChooser(CodelChooser a)
	{
		return a.switchChooser();
	}
	
	public CodelChooser switchChooser()
	{
		if(this.equals(RIGHT))
		{
			return LEFT;
		}
		else
		{
			return RIGHT;
		}
	}
}
