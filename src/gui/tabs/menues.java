package gui.tabs;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.components.JRoundedButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class menues extends JPanel {

	/**
	 * Create the panel.
	 */
	public menues() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JRoundedButton("New button");
		btnNewButton.setPreferredSize(new Dimension(90, 30));
		btnNewButton.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JRoundedButton("New button");
		btnNewButton_1.setPreferredSize(new Dimension(90, 30));
		btnNewButton_1.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JRoundedButton("New button");
		btnNewButton_2.setPreferredSize(new Dimension(90, 30));
		btnNewButton_2.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JRoundedButton("New button");
		btnNewButton_3.setPreferredSize(new Dimension(90, 30));
		btnNewButton_3.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JRoundedButton("New button");
		btnNewButton_4.setPreferredSize(new Dimension(90, 30));
		btnNewButton_4.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JRoundedButton("New button");
		btnNewButton_5.setPreferredSize(new Dimension(90, 30));
		btnNewButton_5.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 5;
		add(btnNewButton_5, gbc_btnNewButton_5);
		
		JButton btnNewButton_6 = new JRoundedButton("New button");
		btnNewButton_6.setPreferredSize(new Dimension(90, 30));
		btnNewButton_6.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 6;
		add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_7 = new JRoundedButton("New button");
		btnNewButton_7.setPreferredSize(new Dimension(90, 30));
		btnNewButton_7.setBorderPainted(false);
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 7;
		add(btnNewButton_7, gbc_btnNewButton_7);

	}

}
