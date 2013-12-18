package cards;
/**
 * An enum that contains all of the AnswerCards' tags.
 * Tags are important for helping the computer impersonate people as well as learn what is funny.
 * @author Holt Maki
 * @since CAH1.0
 * @version CAH1.0
 *
 */
public enum Tag
{
	//I have no idea how we should do this.a
	//IDEAS:
	/*Should we separate it into large categorys like racial, sexual, etc.?
	 * Should we have some way to have subcategorys?
	 * Or should the tags just be like RACIAL_BLACK
	 * I have no idea about any of this these are just ideas
	 * 
	 * Should they include things like EVENT_TRAGIC (this would be applied to famous events like 9/11), 
	 * CELEBRETY_ENTERTAINMENT_MOVIES, CELEBRETY_POLITICAL_CONSERVATIVE, CELEBRITY_HISTORICAL_RUTHLESSDICTATOR,etc.
	 * 
	 * Or should there be a class, subject that contains multiple enums that represent the subject of the card? For example if
	 * the card was about a person it could say if the person was a man or a woman, etc because that might affect the demographic 
	 * that likes the card
	 * 
	 * NOTE: There is no inheritance with enums
	 * NOTE: Enums are written as follows
	 * RACIAL, <-------- All caps, then comma
	 * ...... <--------- These would be more options
	 * ...... <------------------|
	 * ...... <------------------|
	 * ...... <------------------|
	 * ...... <------------------+
	 * SDFDSFDS; <---------END THE ENUM WITH A SEMICOLON
	 * More info at: http://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	 */
	
	//Another idea - consolodate the AnswerTag and QuestionTag into one enum that would contain all of them.
	RACIAL,
	RACIAL_BLACK,
	RACIAL_WHITE,
	RACIAL_LATINO,
	RACIAL_ASIAN,
	RACIAL_INDIAN,
	RACIAL_JEWISH,
	SEXUAL,
	SEXUAL_MALE,
	SEXUAL_FEMALE,
	SEXUAL_CREEPY,
	EVENT,
	EVENT_DISASTER_HOLOCAUST,
	EVENT_DISASTER_911,
	HOLIDAY,
	HOLIDAY_CHRISTMAS,
	HOLIDAY_NEWYEARS,
	HOLIDAY_THANGSKIVING,
	HOLIDAY_FOURTHOFJULY,
	HOLIDAY_HANUKKKAH,
	HOLIDAY_VALENTINESDAY,
	HOLIDAY_STPATRICKSDAY,
	CELEBRITY,
	CELEBRITY_POLITICS_PRESIDENT,
	CELEBRITY_MUSIC,
	CELEBRITY_POLITICS_HISTORICAL,
	CELEBRITY_SPORTS,
	CELEBRITY_MOVIES,
	SPORT,
	SPORT_FOOTBALL,
	SPORT_BASKETBALL,
	SPORT_BASEBALL,
	SOCIAL_DRUGS,
	SOCIAL_GAY,
	SOCIAL_RELIGIOUS_CHRISTIANITY,
	SOCIAL_RELIGIOUS_JUDAISM,
	SOCIAL_RELIGIOUS_ISLAM,
	SOCIAL_RELIGIOUS_SCIENTOLOGY,
	SOCIAL_RELIGIOUS_MORMOMISM,
	SOCIAL_ALCOHOL,
	SOCIAL_DISEASE,
	FOOD,
	
	
}


