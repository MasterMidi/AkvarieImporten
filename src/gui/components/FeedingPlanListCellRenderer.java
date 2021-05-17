package gui.components;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import model.FeedingPlan;

public class FeedingPlanListCellRenderer extends BasicComboBoxRenderer {

	@Override
	public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
			boolean isSelected, boolean cellHasFocus) {
		Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (renderer instanceof JLabel && value instanceof FeedingPlan) {
        	FeedingPlan castedValue = ((FeedingPlan) value);
            String text = castedValue.getName();
            ((JLabel) renderer).setText(text);
        }
        return renderer;
	}

}
