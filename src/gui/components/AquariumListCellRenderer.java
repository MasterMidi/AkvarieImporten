package gui.components;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import model.Aquarium;

public class AquariumListCellRenderer extends DefaultListCellRenderer {

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof Aquarium) {
        	Aquarium castedValue = ((Aquarium) value);
            String text = castedValue.getNumber();
            ((JLabel) renderer).setText(text);
        }
        return renderer;
	}

}
