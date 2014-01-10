package game;

/**
 * A list of the types of house rules that may be applied to CAH.
 * <br><b>
 * Contents:
 * </b>
 * </br>
 * <li>
 * {@linkplain #HAPPY_ENDING}
 * <li>
 * {@linkplain #REBOOTING_THE_UNIVERSE}
 * <li>
 * {@linkplain #PACKING_HEAT}
 * <li>
 * {@linkplain #RANDO_CARDRISSIAN}
 * <li>
 * {@linkplain #GOD_IS_DEAD}
 * <li>
 * {@linkplain #SURVIVAL_OF_THE_FITTEST}
 * <li>
 * {@linkplain #SERIOUS_BUSINESS}
 * <li>
 * {@linkplain #NEVER_HAVE_I_EVER}
 * <ul>
 * IDEA: some of these rules where the cards are ranked by players
 *  might be good for teaching the computer because it would give it more info.
 * </ul>
 * @since CAH1.0
 * @version CAH1.0
 * @author Holt Maki
 *
 */
public enum HouseRules {

	/**
	 * "When you're ready to stop playing,
	 *  play the "Make a Haiku" Black Card to end the game.
	 *  This is the official ceremonial ending of a good game
	 *  of Cards Against Humanity, and this card should
	 *  be reserved for the end. (NOTE: Haikus don't need
	 *  to follow the 5-7-5 form. They just have to be read
	 *  dramatically)."
	 * @since CAH1.0
	 */
	HAPPY_ENDING("\"At any time players may trade in an Awesome Point to return as many White Cards as they'd like to the deck and draw back up to ten.\""),
	
	/**
	 * "At any time players may
	 *  trade in an Awesome Point to return as many White
	 *  Cards as they'd like to the deck and draw back
	 *  up to ten."
	 * @since CAH1.0
	 */
	REBOOTING_THE_UNIVERSE("\"For Pick 2s (and pick 3, draw 2s), all players draw an extra card before playing the hand to open up more options.\""),
	
	/**
	 * "For Pick 2s (and pick 3, draw 2s), all players draw an extra
	 *  card before playing the hand to open up more options."
	 * @since CAH1.0
	 */
	PACKING_HEAT("\"Every round, pick one random White Card from the pile and place it into play. This card belongs to an Imaginary player named Rando Cardrissian and if he wins the game, all players go home in a state of everlasting shame.\""),
	
	/**
	 * "Every round, pick one random
	 *  White Card from the pile and place it into play. This
	 *  card belongs to an Imaginary player named Rando
	 *  Cardrissian and if he wins the game, all players
	 *  go home in a state of everlasting shame."
	 * @since CAH1.0
	 */
	RANDO_CARDRISSIAN("\"Every round, pick one random White Card from the pile and place it into play. This card belongs to an Imaginary player named Rando Cardrissian and if he wins the game, all players go home in a state of everlasting shame.\""),
	
	/**
	 * "Play without a Card Czar. Each player
	 *  picks his or her favorite card each round. The card
	 *  with the most votes wins the round."
	 * <ul>
	 * NOTE: Make the computer have a very slight bias like 
	 * everyone else will, so that it is not completely at a disadvantage.
	 * </ul>
	 *  <b>
	 *  Compatability Issues:</b> {@linkplain #SURVIVAL_OF_THE_FITTEST}, {@linkplain #SERIOUS_BUSINESS}
	 * @since CAH1.0
	 */
	GOD_IS_DEAD("\"Play without a Card Czar. Each player picks his or her favorite card each round. The card with the most votes wins the round.\""),
	
	/**
	 * "Play without a Card Czar. After everyone has answered
	 *  the question, players take turns eliminating one card
	 *  each. The last remaining card is declared the funniest."
	 * <ul>
	 * NOTE: Make the computer have a very slight bias like 
	 * everyone else will, so that it is not completely at a disadvantage.
	 * </ul>
	 *  <b>
	 *  Compatability Issues:</b> 
	 *  {@linkplain #SERIOUS_BUSINESS}, {@linkplain #GOD_IS_DEAD}
	 * @since CAH1.0
	 */
	SURVIVAL_OF_THE_FITTEST("\"Play without a Card Czar. After everyone has answered the question, players take turns eliminating one card each. The last remaining card is declared the funniest."),
	
	/**
	 * "Instead of picking a favorite card
	 *  each round, the card Czar ranks the top three in order.
	 *  The best card gets 3 Awesome Points, the second-best
	 *  gets 2, and the third gets 1. Keep a running tally
	 *  of the score, and at the end of the game, the winner is
	 *  declared the funniest, mathematically speaking."
	 *  <br>
	 *  <b>
	 *  Compatability Issues:</b> 
	 *  {@linkplain #SURVIVAL_OF_THE_FITTEST}, {@linkplain #GOD_IS_DEAD}
	 * @since CAH1.0
	 * 
	 */
	SERIOUS_BUSINESS("\"Instead of picking a favorite card each round, the card Czar ranks the top three in order. The best card gets 3 Awesome Points, the second-best gets 2, and the third gets 1. Keep a running tally of the score, and at the end of the game, the winner is declared the funniest, mathematically speaking.\""),
	
	/**
	 * "At any time players may discard
	 *  cards that they don't understand, but they must
	 *  confess their ignorance to the group and suffer the
	 *  resulting humilliation."
	 *  <ul>
	 * NOTE: May be good for teaching the computer. If the computer doesn't understand a card,
	 *  it can discard it so that it may learn about it. </ul>
	 * @since CAH1.0
	 */
	NEVER_HAVE_I_EVER("\"At any time players may discard cards that they don't understand, but they must confess their ignorance to the group and suffer the resulting humilliation.\"");
	
	private final String description;
	HouseRules(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}

}
