package cards;

/**
 * An enum that holds information about each deck.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */

public enum Decks
{
	
	/**
	 * The original CAH deck.
	 * @since CAH1.0
	 */
	
	ORIGINAL("The original Cards Against Humanity deck.", new String[] {"Answers"}, new String[] {"Questions"}),
	
	/**
	 * The first CAH Expansion, not including the second version of it.
	 * @since CAH1.0
	 */
	
	EXPANSION1_0("Just the cards from Expansion1.0.", new String[]{"Expansion Only 1.0 Answers", "Expansion 1 Answers"}, new String[]{"Expansion Only 1.0 Questions", "Expansion 1 Questions"}),
	
	/**
	 * The second version of the first CAH expansion.
	 * @since CAH1.0
	 */
	
	EXPANSION1_2("Just the cards from Expansion1.2.", new String[]{"Expansion Only 1.2 Answers", "Expansion 1 Answers"}, new String[]{"Expansion Only 1.2 Questions", "Expansion 1 Questions"}),
	
	/**
	 * The first expansion - both Expansion1.0 and 1.2.
	 * @since CAH1.0
	 */
	
	EXPANSION1("The first Cards Against Humanity Expansion- with all the cards from the both versions of it- Expansion1.0 and Expansion1.2.", new String[]{"Expansion Only 1.2 Answers", "Expansion Only 1.0 Answers", "Expansion 1 Answers"}, new String[]{"Expansion Only 1.2 Questions", "Expansion Only 1.0 Questions", "Expansion 1 Questions"}),
	
	/**
	 * The second expansion of CAH.
	 * @since CAH1.0
	 */
	
	EXPANSION2("The second Cards Against Humanity Expanasion.", new String[]{"Expansion 2 Answers"}, new String[]{"Expansion 2 Questions"}),
	
	/**
	 * The third CAH expansion.
	 * @since CAH1.0
	 */
	
	EXPANSION3("The third Cards Against Humanity Expanasion.", new String[]{"Expansion 3 Answers"}, new String[]{"Expansion 3 Questions"}),
	
	/**
	 * The fourth CAH expansion.
	 * @since CAH1.0
	 */
	
	EXPANSION4("The fouth Cards Against Humanity Expanasion.", new String[]{"Expansion 4 Answers"}, new String[]{"Expansion 4 Questions"}),
	
	/**
	 * The CAH holiday expansion from 2012.
	 * @since CAH1.0
	 */
	
	HOLIDAYEXPANSION("The 2012 Cards Against Humanity Holiday Expansion- Have fun with cards such as \"Elf cum\", \"Whatever Kwanza is supposed to be about\", and \"Taking down Santa with a surface-to-air missile\".", new String[]{"Holiday Expansion Answers"}, new String[]{"Holiday Expansion Questions"});
	
	String description;
	String[] answerPaths;
	String[] questionPaths;
	
	/**
	 * Constructs a new deck's information.
	 * @param description the description of the deck.
	 * @param answerPaths the name of the files with the answer cards.
	 * @param questionPaths the name of the files with the question cards.
	 */
	
	Decks(String description, String[] answerPaths, String[] questionPaths)
	{
		this.description = description;		
		this.answerPaths = answerPaths;		
		this.questionPaths = questionPaths;
	}
	
	/**
	 * Gets the question file names.
	 * @return questionPaths - the names of the question files.
	 * @since CAH1.0
	 */
	
	public String[] getQuestionPaths()
	{
		return questionPaths;
	}
	
	/**
	 * Gets the answer file names.
	 * @return answerPaths - the names of the answer files.
	 * @since CAH1.0
	 */
	
	public String[] getAnswerPaths()
	{
		return answerPaths;
	}
	
	/**
	 * Gets the description of the deck.
	 * @return description - the description of the deck.
	 * @since CAH1.0
	 */
	
	public String getDescription()
	{
		return description;
	}
	
}
