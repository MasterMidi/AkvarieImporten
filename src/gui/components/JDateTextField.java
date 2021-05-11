package gui.components;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFormattedTextField;

public class JDateTextField extends JFormattedTextField {

	public JDateTextField(DateTimeFormatter formatter) {
		super(formatter.toFormat(LocalDate::from));
	}

	@Override
	public LocalDate getValue() {
		return (LocalDate) super.getValue();
	}
}
