package esoteric.brainfuck;

public class TextToBrainfuck {
	
	public static String brainFuck(String txt)
	{
		String brainFuck = "";
		int counter = 0;
		
		int thirtyTwos[] = new int[txt.length()];
		int eights[] = new int[txt.length()];
		int ones[] = new int[txt.length()];
		
		for(int i = 0; i < txt.length(); i++)
		{
			int a = (int) txt.charAt(i);
			
			thirtyTwos[i] = a / 32;
			if(a % 32 > 16)
			{
				thirtyTwos[i]++;
			}
			
			eights[i] = (a - (32 * thirtyTwos[i])) / 8;
			if(Math.abs(a - (32 * thirtyTwos[i])) >= 4)
			{
				if(a - (32 * thirtyTwos[i]) < 0)
				{
					eights[i]++;
				}
				else if(a - (32 * thirtyTwos[i]) > 0)
				{
					eights[i]--;
				}
			}
			
			ones[i] = a - (32 * thirtyTwos[i]) - (8 * eights[i]);
		}
		
		brainFuck = "++++++++[>++++[";
		int cell = 1;
		
		for(int i = 0; i < thirtyTwos.length; i++)
		{
			while(cell != i + 2)
			{
				if(cell < i + 2)
				{
					brainFuck = brainFuck + ">";
					cell++;
				}
				else
				{
					brainFuck = brainFuck + "<";
					cell--;
				}
			}
			
			if(thirtyTwos[i] != 0)
			{
				for(int n = 0; n < thirtyTwos[i]; n++)
				{
					brainFuck = brainFuck + "+";
				}
			}
		}
		
		while(cell != 1)
		{
			if(cell < 1)
			{
				brainFuck = brainFuck + ">";
				cell++;
			}
			else
			{
				brainFuck = brainFuck + "<";
				cell--;
			}
		}
		
		brainFuck = brainFuck + "-]";
		
		for(int i = 0; i < eights.length; i++)
		{
			while(cell != i + 2)
			{
				if(cell < i + 2)
				{
					brainFuck = brainFuck + ">";
					cell++;
				}
				else
				{
					brainFuck = brainFuck + "<";
					cell--;
				}
			}
			
			if(eights[i] != 0)
			{
				for(int n = 0; n < Math.abs(eights[i]); n++)
				{
					if(eights[i] > 0)
					{
						brainFuck = brainFuck + "+";
					}
					else
					{
						brainFuck = brainFuck + "-";
					}
					
				}
			}
		}
		
		while(cell != 0)
		{
			if(cell < 0)
			{
				brainFuck = brainFuck + ">";
				cell++;
			}
			else
			{
				brainFuck = brainFuck + "<";
				cell--;
			}
		}
		
		brainFuck = brainFuck + "-]";
		
		for(int i = 0; i < ones.length; i++)
		{
			while(cell != i + 2)
			{
				if(cell < i + 2)
				{
					brainFuck = brainFuck + ">";
					cell++;
				}
				else
				{
					brainFuck = brainFuck + "<";
					cell--;
				}
			}
			
			if(ones[i] != 0)
			{
				for(int n = 0; n < Math.abs(ones[i]); n++)
				{
					if(ones[i] > 0)
					{
						brainFuck = brainFuck + "+";
					}
					else
					{
						brainFuck = brainFuck + "-";
					}
					
				}
			}
		}
		brainFuck = brainFuck +"[<]";
		
		for(int i = 0; i < txt.length(); i++)
		{
			brainFuck = brainFuck +">.";
		}
		
		return brainFuck;
	}
	
	public static void main(String[] args)
	{
		System.out.println(TextToBrainfuck.brainFuck("Cards Against Humanity."));
		BrainfuckInterpreter a = new BrainfuckInterpreter();
		System.out.println(a.interpret(TextToBrainfuck.brainFuck("Cards Against Humanity.")));
	}

}