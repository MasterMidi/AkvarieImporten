package gui.components;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.Aquarium;
import model.FishSpecies;

public class AquariumListCellRenderer extends BasicComboBoxRenderer {

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
