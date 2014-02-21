package ui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

	/**
	 * A class of object that represents the scroll constraints of a JList.
	 * @author Holt Maki
	 * @since CAH1.0
	 * @version CAH1.0
	 *
	 */
	public class ListScrConstraints extends GridBagConstraints
	{
		/**
		 * Generated Serial Version UID.
		 */
		private static final long serialVersionUID = 3715430882347157074L;

		/**
		 * Creates ListScrConstraints
		 * @author Holt Maki
		 * @since CAH1.0
		 */
		public ListScrConstraints()
		{
			gridx = 0;
			gridy = 0;
			
			gridwidth = 1;
			gridheight = 1;
			
			fill = GridBagConstraints.BOTH;
			anchor = GridBagConstraints.CENTER;
			insets = new Insets(1,1,1,1);
			
			weightx = 1.0;
			weighty = 1.0;
		}
	}
