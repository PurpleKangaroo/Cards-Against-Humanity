package game;

import java.util.ArrayList;

/**
 * A class of object that represents a set of rules for a CAH game without House Rules.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 */
public final class Rules {
	//TODO add javadoc to fields.
	private final int NUMBER_OF_CARDS = 10;
	private boolean basic = true;
	private boolean cCzarExists = true;
	private boolean GodIsDead = false;
	private boolean HappyEnding = false;
	private boolean NeverHaveIEver = false;
	private boolean PackingHeat = false;
	private boolean RandoCardrissianExists = false;
	private boolean RebootingTheUniverse = false;
	private boolean SeriousBuisness = false;
	private boolean SurviavalOfTheFittest = false;
	private boolean gambling;
	private ArrayList<HouseRules> houseRules;
	
	/**
	 * Constructs an object that represents a  set of rules for a non-basic rules CAH game or a basic rules CAH game.
	 * This constructor also checks for rule conflicts.
	 * @param rules the list of house rules that will be used.
	 * @param gambling The boolean that tells whether or not the gambling rule is being used.
	 * @throws RuleConflictException Thrown if some rules are not compatable.
	 * <ul>
	 * Later make this exception caught in a UI Class that makes a small little box
	 *  (not a full window/frame, just one of those boxes that comes up and says something)
	 * come up that says you may not have both of these two rules, because they disagree.
	 * </ul>
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	public Rules(ArrayList<HouseRules> rules, boolean gambling) throws RuleConflictException
	{
		this.gambling = gambling;
		try
		{
			if (rules != null)
			{
				basic = false;
				houseRules = rules;
				
				/*Checks for rule conflicts - these rules are not compatable with eachother
				 * Basically that means that there cannot be more than one of the following rules at a time:
				 * GOD_IS_DEAD
				 * SURVIVAL_OF_THE_FITTEST
				 * SERIOUS_BUISNESS
				 */
				if (houseRules.contains(HouseRules.SURVIVAL_OF_THE_FITTEST) && houseRules.contains(HouseRules.GOD_IS_DEAD))
				{
					RuleConflictException HouseRuleConfEx = new RuleConflictException();
					throw HouseRuleConfEx;
				}
				if (houseRules.contains(HouseRules.SURVIVAL_OF_THE_FITTEST) && houseRules.contains(HouseRules.SERIOUS_BUSINESS))
				{
					RuleConflictException HouseRuleConfEx = new RuleConflictException();
					throw HouseRuleConfEx;
				}
				if (houseRules.contains(HouseRules.GOD_IS_DEAD) && houseRules.contains(HouseRules.SERIOUS_BUSINESS))
				{
					RuleConflictException HouseRuleConfEx = new RuleConflictException();
					throw HouseRuleConfEx;
				}
				
				/*
				 * Creates the rules. This uses a switch for each index.
				 */
				for (int index = 0; index<houseRules.size(); index++)
				{
					switch(houseRules.get(index))
					{
					case GOD_IS_DEAD:
						cCzarExists = false;
						GodIsDead = true;
						break;
					case HAPPY_ENDING:
						HappyEnding = true;
						//Maybe add a thing later when we get to UI that has a box come up when this is selected that 
						break;
					case NEVER_HAVE_I_EVER:
						NeverHaveIEver = true;
						break;
					case PACKING_HEAT:
						PackingHeat = true;
						break;
					case RANDO_CARDRISSIAN:
						RandoCardrissianExists = true;
						break;
					case REBOOTING_THE_UNIVERSE:
						RebootingTheUniverse = true;
						break;
					case SERIOUS_BUSINESS:
						SeriousBuisness = true;
						break;
					case SURVIVAL_OF_THE_FITTEST:
						SurviavalOfTheFittest = true;
						cCzarExists = false;
						break;
					default:
						break;
						
					}
				}
			}
			else
			{
				
			}
		}
		catch (NullPointerException nullPoint)
		{
			
		}
		
	}
	
	/**
	 * Gets the number of cards a player holds in their hand in a game.
	 * @return NUMBER_OF_CARDS - The number of cards a player holds in their hand in a game.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected int NUMBER_OF_CARDS()
	{
		return NUMBER_OF_CARDS;
	}
	
	/**
	 * Gets the boolean that tells whether or not basic rules are being used.
	 * @return basic - The boolean that tells whether or not basic rules are in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean basic()
	{
		return basic;
	}
	
	/**
	 * Gets the boolean that tells whether or not the Card Czar exists.
	 * @return cCzarExists - The boolean that tells whether or not the Card Czar exists.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean cCzarExists()
	{
		return cCzarExists;
	}

	/**
	 * Gets the boolean that tells whether or not the God Is Dead rule is in effect.
	 * @return GodIsDead - The boolean that tells whether or not the God Is Dead rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean GodIsDead()
	{
		return GodIsDead;
	}
	
	/**
	 * Gets the boolean that tells whether or not the Happy Ending rule is in effect.
	 * @return HappyEnding - The boolean that tells whether or not the Happy Ending rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean HappyEnding()
	{
		return HappyEnding;
	}
	
	/**
	 * Gets the boolean that tells whether or not the Never Have I Ever rule is in effect.
	 * @return NeverHaveIEver - The boolean that tells whether or not the Never Have I Ever rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean NeverHaveIEver()
	{
		return NeverHaveIEver;
	}
	
	/**
	 * Gets the boolean that tells whether or not the Packing Heat rule is in effect.
	 * @return PackingHeat - The boolean that tells whether or not the Packing Heat rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean PackingHeat()
	{
		return PackingHeat;
	}
	
	/**
	 * Gets the boolean that tells whether or not Rando Cardrissian exists. This also tells us if the Rando Cardrissian rule is in effect.
	 * @return RandoCardrissianExists - The boolean that tells if Rando Cardrissian exists and if the {@linkplain HouseRules} Rando Cardrissian is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean RandoCardrissianExists()
	{
		return RandoCardrissianExists;
	}
	
	/**
	 * Gets the boolean that tells whether or not the Rebooting The Universe rule is in effect.
	 * @return RebootingTheUniverse - The boolean that tells whether or not the Rebooting The Universe rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean RebootingTheUniverse()
	{
		return RebootingTheUniverse;
	}
	
	/**
	 * Gets the boolean that tells whether or not the Serious Buisness rule is in effect.
	 * @return SeriousBuisness - The boolean that tells whether or not the Serious Buisness rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean SeriousBuisness()
	{
		return SeriousBuisness;
	}

	/**
	 * Gets the boolean that tells whether or not the Surviaval Of The Fittest rule is in effect.
	 * @return SurviavalOfTheFittest - The boolean that tells whether or not the Surviaval Of The Fittest rule is in effect.
	 * @since CAH1.0
	 * @version CAH1.0
	 */
	protected boolean SurviavalOfTheFittest()
	{
		return SurviavalOfTheFittest;
	}
	
	/**
	 * Gets the arrayList of House Rules used in the game.
	 * @return houseRules - The arrayList of House Rules used in the game.
	 * @since CAH1.0
	 */
	protected ArrayList<HouseRules> houseRules()
	{
		return houseRules;
	}
	
	/**
	 * Gets gambling, the boolean that tells whether or not the gambling rule is in effect.
	 * @return gambling - The boolean that tells whether or not the gambling rule is in effect.
	 * @since CAH1.0
	 */
	protected boolean getGambling()
	{
		return gambling;
	}
	
}
