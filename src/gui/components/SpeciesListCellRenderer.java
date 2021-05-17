package gui.components;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.FishSpecies;

public class SpeciesListCellRenderer extends BasicComboBoxRenderer {

	@Override
	public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
			boolean cellHasFocus) {
		Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof FishSpecies) {
        	FishSpecies castedValue = ((FishSpecies) value);
            String text = castedValue.getName();
            ((JLabel) renderer).setText(text);
        }
        return renderer;
	}

}
