#Javadoc Guidelines
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
		 * @version (CAH#.#(.#)) update version with new version
		 * @since(CAH#.#(.#)) (don't change since after it has been finished)
		 * (only if necessary) @see
		 * @see DO NOT USE {@link} or {@linkplain} in see tags
		 */
		
- Method documentation:
	
		/**
		 * "_______" ... Explanation
		 * @since(CAH#.#(.#))(dont change since after it has been finished)
		 * (only if necessary) @param paramater \[NO DASH\] Explanation 
		 * (only if necessary) @throws Throwable \[NO DASH\] Explanation 
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
		