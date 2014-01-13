package cards;

public enum Decks {	
	ORIGINAL("The original Cards Against Humanity deck.", new String[] {"Answers"}, new String[] {"Questions"}),
	EXPANSION1_0("Just the cards from Expansion1.0", new String[]{"Expansion Only 1.0 Answers", "Expansion 1 Answers"}, new String[]{"Expansion Only 1.0 Questions", "Expansion 1 Questions"}),
	EXPANSION1_2("Just the cards from Expansion1.2", new String[]{"Expansion Only 1.2 Answers", "Expansion 1 Answers"}, new String[]{"Expansion Only 1.2 Questions", "Expansion 1 Questions"}),
	EXPANSION1("The first Cards Against Humanity Expansion- with all the cards from the both versions of it- Expansion1.0 and Expansion1.2", new String[]{"Expansion Only 1.2 Answers", "Expansion Only 1.0 Answers", "Expansion 1 Answers"}, new String[]{"Expansion Only 1.2 Questions", "Expansion Only 1.0 Questions", "Expansion 1 Questions"}),
	EXPANSION2("The second Cards Against Humanity Expanasion", new String[]{"Expansion 2 Answers"}, new String[]{"Expansion 2 Questions"}),
	EXPANSION3("The third Cards Against Humanity Expanasion", new String[]{"Expansion 3 Answers"}, new String[]{"Expansion 3 Questions"}),
	EXPANSION4("The fouth Cards Against Humanity Expanasion", new String[]{"Expansion 4 Answers"}, new String[]{"Expansion 4 Questions"}),
	HOLIDAYEXPANSION("The 2012 Cards Against Humanity Holiday Expansion- Have fun with cards such as \"Elf cum\", \"Whatever Kwanza is supposed to be about\", and \"Taking down Santa with a surface-to-air missile\".", new String[]{"Holiday Expansion Answers"}, new String[]{"Holiday Expansion Questions"});
	
	String description;
	String[] answerPaths;
	String[] questionPaths;
	
	/**
	 * Constructs a new deck's information.
	 * @param description - the description of the deck.
	 * @param answerPaths - the name of the files with the answer cards.
	 * @param questionPaths - the name of the files with the question cards.
	 */
	Decks(String description, String[] answerPaths, String[] questionPaths)
	{
		this.description = description;
		
		for(int i = 0; i < answerPaths.length; i++)
		{
			answerPaths[i] = "/Cards Against Humanity/src/cards/" + answerPaths[i];
		}
		
		this.answerPaths = answerPaths;
		
		for(int i = 0; i < questionPaths.length; i++)
		{
			questionPaths[i] = "/Cards Against Humanity/src/cards/" + questionPaths[i];
		}
		
		this.questionPaths = questionPaths;
	}
	
	public String[] getQuestionPaths()
	{
		return questionPaths;
	}
	
	public String[] getAnswerPaths()
	{
		return answerPaths;
	}
	
	public String getDescription()
	{
		return description;
	}
	
}
