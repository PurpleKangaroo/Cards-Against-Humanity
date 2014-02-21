#[Cards Against Humanity](http://cardsagainsthumanity.com/)
###"A Party Game for Horrible People" in Java
![Picture][CAHbox]
[CAHbox]: https://github.com/PurpleKangaroo/Cards-Against-Humanity/blob/master/src/graphics/CAHbox.png?raw=true
### Coming Out By May 2014
We may be able to release this game earlier, but we hope to have the game out by May so that High School Seniors with Senioritis may play it after they have taken their AP tests.

###[PurpleKangaroo](https://github.com/PurpleKangaroo)
[@PurpleKangaroo](https://github.com/PurpleKangaroo) is a small organization of [Lake Washington High School](http://www.lwsd.org/school/lwhs/Pages/default.aspx) students who are interested in programing, many of whom are in the school's AP Computer Science class.

###How to Play Cards Against Humanity
[Cards Against Humanity Rules](http://s3.amazonaws.com/cah/CAH_Rules.pdf)

###Documentation and Help
[Javadoc](http://htmlpreview.github.io/?https://raw.github.com/PurpleKangaroo/Cards-Against-Humanity/master/doc/index.html?overview-summary.html)

[Project Guidelines](https://github.com/HoltMaki/CardsAgainstHumanity/blob/master/README.md#project-guidelines)

### Authors and Contributors
Holt Maki ([@HoltMaki](https://github.com/HoltMaki)) - Lead Developer

Devon Grove ([@devongrove](https://github.com/devongrove)) - Associate Developer, Public Relations

Nick Walker ([@oswin5656](https://github.com/oswin5656)) - Associate Developer, Head Graphic Design

### Support or Contact
purplekangs@gmail.com
####Follow us on Twitter [@PurpleKangs_Dev](https://twitter.com/PurpleKangs_Dev)

#Project Guidelines
##General Guidelines:
Use interfaces to stay organized.

Use whitespace where appropriate.

Use inner classes where appropriate.

Use good documentation. (<em>See also: </em>
[Javadoc Guidelines](https://github.com/HoltMaki/CardsAgainstHumanity/blob/master/Guidelines/Javadoc%20Guidelines.md))

[Creating a Jar File](https://github.com/HoltMaki/CardsAgainstHumanity#creating-a-jar-file-in-eclipse)

##Creating a JAR File in Eclipse
1. File > Export
2. Java > Runnable JAR File
3. Next<p>![Picture][picture]
[picture]: https://github.com/PurpleKangaroo/Cards-Against-Humanity/blob/master/Guidelines/jarImage.png?raw=true
</p>
4. Under "Library Handling:" select "Package required libraries into generated JAR.

##Javadoc Guidelines
- Add @depricated to (CAH#.#(.#)) to deprecated things. 
This makes it easy to go back later to find how the program used to work if we run into problems.
- Documentation for variables (only for instance variables): 

		/**Brief Explanation*/ (preferably one line).
	
- Interface Documentation: 
		
		/** Start with: "A collection of methods that ..."
		 * Explanation....
		 * @author(replace s-______ w/ your name; there can be multiple authors, just do @author on a new line.)
		 * @version (CAH#.#(.#)) update version with new version
		 * @since(CAH#.#(.#)) (don't change since after it has been finished)
		 * (only if necessary) @see
		 * @see DO NOT USE {@link} or {@linkplain} in see tags
		 */
		 
- Constructor Documentation:
	
		/**
		 * "A class of object that represents ..."
		 * Explanation....
		 * @author(replace s-______ w/ your name; there can be multiple authors, just do @author on a new line.)
		 * @since(CAH#.#(.#)) (don't change since after it has been finished)
		 * (only if necessary) @param paramater [NO DASH] Explanation 
		 * (only if necessary) @throws Throwable [NO DASH] Explanation 
		 * (only if necessary) @see
		 * @see DO NOT USE {@link} or {@linkplain} in see tags
		 */
		
- Method documentation:
	
		/**
		 * "_______" ... Explanation
		 * @since(CAH#.#(.#))(dont change since after it has been finished)
		 * (only if necessary) @param paramater [NO DASH] Explanation 
		 * (only if necessary) @throws Throwable [NO DASH] Explanation 
		 * (only if necessary) @see
		 * @see DO NOT USE {@link} or {@linkplain} in see tags
		 */
		
- Enum documentation:
		
		/**
		 * Explanation: "A list of ..."
		 * @since (CAH#.#(.#))(dont change since after it has been finished)
		 * @version (CAH#.#(.#)) update version with new version
		 * (only if necessary) @see
		 * @see DO NOT USE {@link} or {@linkplain} in see tags
		 */
- Enumcontents documentation:
		
		/**
		 * Explanation
		 * @since (CAH#.#(.#))(dont change since after it has been finished)
		 * (only if necessary) @see
		 * @see DO NOT USE {@link} or {@linkplain} in see tags
		 */
		
