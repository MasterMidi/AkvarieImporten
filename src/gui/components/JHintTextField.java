package gui.components;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JTextField;

/**
 * @author DaveTheDane, based on a suggestion from Adam Gawne-Cain
 */

@SuppressWarnings("serial")
public class JHintTextField extends JTextField {
	private String hint;

	public JHintTextField() {
		super(null, null, 0);
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	@Override
	public void paintComponent(Graphics graphics) {

		final Graphics2D graphics2d = (Graphics2D) graphics;

		super.paintComponent(graphics2d);

		if (getText().isEmpty()) {
			graphics2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			// gets the insets (border space data) of the component
			final Insets ins = getInsets();
			
			// gets information about the font used in the textfield
			final FontMetrics fm = graphics2d.getFontMetrics();

			// Set the text color to be grey and gentle
			graphics2d.setColor(Color.GRAY);
			
			// draws the hint text onto the textfield
			graphics2d.drawString(hint, ins.left, getHeight() - fm.getDescent() - ins.bottom);
			/*
			 * y Coordinate based on Descent & Bottom-inset seems to align Text spot-on.
			 * DaveTheDane, Apr 10 2020
			 */
		}
	}

}
