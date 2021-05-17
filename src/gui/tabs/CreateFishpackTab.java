package gui.tabs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateFishpackTab extends JPanel {
    private JTextField txtDate;
    private JLabel lblSpecies;
    private JLabel lblNewLabel;
    private JComboBox comboBoxSpecies;
    private JLabel lblAquarium;
    private JComboBox comboBoxAquarium;
    private JLabel lblFeedingPlan;
    private JComboBox comboBoxFeedingPlan;
    private JButton btnNewButton_1;
    private JButton btnCreateAquarium;
    private JButton btnCancel;
    private JButton btnCreate;

    /**
     * Create the panel.
     */
    public CreateFishpackTab() {
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[] { 0, 101, 0, 0, 0, 0 };
	gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
	gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
		Double.MIN_VALUE };
	setLayout(gridBagLayout);

	lblSpecies = new JLabel("Art:");
	GridBagConstraints gbc_lblSpecies = new GridBagConstraints();
	gbc_lblSpecies.insets = new Insets(0, 0, 5, 5);
	gbc_lblSpecies.anchor = GridBagConstraints.EAST;
	gbc_lblSpecies.gridx = 1;
	gbc_lblSpecies.gridy = 2;
	add(lblSpecies, gbc_lblSpecies);

	comboBoxSpecies = new JComboBox();
	GridBagConstraints gbc_comboBoxSpecies = new GridBagConstraints();
	gbc_comboBoxSpecies.insets = new Insets(0, 0, 5, 5);
	gbc_comboBoxSpecies.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBoxSpecies.gridx = 2;
	gbc_comboBoxSpecies.gridy = 2;
	add(comboBoxSpecies, gbc_comboBoxSpecies);

	JButton btnCreateSpecies = new JButton("Opret Art");
	btnCreateSpecies.setEnabled(false);
	btnCreateSpecies.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	GridBagConstraints gbc_btnCreateSpecies = new GridBagConstraints();
	gbc_btnCreateSpecies.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnCreateSpecies.insets = new Insets(0, 0, 5, 5);
	gbc_btnCreateSpecies.gridx = 3;
	gbc_btnCreateSpecies.gridy = 2;
	add(btnCreateSpecies, gbc_btnCreateSpecies);

	lblNewLabel = new JLabel("Dato");
	GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
	gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
	gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
	gbc_lblNewLabel.gridx = 1;
	gbc_lblNewLabel.gridy = 3;
	add(lblNewLabel, gbc_lblNewLabel);

	txtDate = new JTextField();
	GridBagConstraints gbc_txtDate = new GridBagConstraints();
	gbc_txtDate.insets = new Insets(0, 0, 5, 5);
	gbc_txtDate.fill = GridBagConstraints.HORIZONTAL;
	gbc_txtDate.gridx = 2;
	gbc_txtDate.gridy = 3;
	add(txtDate, gbc_txtDate);
	txtDate.setColumns(10);

	lblAquarium = new JLabel("Akvarie:");
	lblAquarium.setHorizontalTextPosition(SwingConstants.RIGHT);
	lblAquarium.setHorizontalAlignment(SwingConstants.RIGHT);
	GridBagConstraints gbc_lblAquarium = new GridBagConstraints();
	gbc_lblAquarium.anchor = GridBagConstraints.EAST;
	gbc_lblAquarium.insets = new Insets(0, 0, 5, 5);
	gbc_lblAquarium.gridx = 1;
	gbc_lblAquarium.gridy = 4;
	add(lblAquarium, gbc_lblAquarium);

	comboBoxAquarium = new JComboBox();
	GridBagConstraints gbc_comboBoxAquarium = new GridBagConstraints();
	gbc_comboBoxAquarium.insets = new Insets(0, 0, 5, 5);
	gbc_comboBoxAquarium.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBoxAquarium.gridx = 2;
	gbc_comboBoxAquarium.gridy = 4;
	add(comboBoxAquarium, gbc_comboBoxAquarium);

	btnCreateAquarium = new JButton("Opret Akvarie");
	btnCreateAquarium.setEnabled(false);
	GridBagConstraints gbc_btnCreateAquarium = new GridBagConstraints();
	gbc_btnCreateAquarium.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnCreateAquarium.insets = new Insets(0, 0, 5, 5);
	gbc_btnCreateAquarium.gridx = 3;
	gbc_btnCreateAquarium.gridy = 4;
	add(btnCreateAquarium, gbc_btnCreateAquarium);

	lblFeedingPlan = new JLabel("Fodderplan:");
	GridBagConstraints gbc_lblFeedingPlan = new GridBagConstraints();
	gbc_lblFeedingPlan.anchor = GridBagConstraints.EAST;
	gbc_lblFeedingPlan.insets = new Insets(0, 0, 5, 5);
	gbc_lblFeedingPlan.gridx = 1;
	gbc_lblFeedingPlan.gridy = 5;
	add(lblFeedingPlan, gbc_lblFeedingPlan);

	comboBoxFeedingPlan = new JComboBox();
	GridBagConstraints gbc_comboBoxFeedingPlan = new GridBagConstraints();
	gbc_comboBoxFeedingPlan.insets = new Insets(0, 0, 5, 5);
	gbc_comboBoxFeedingPlan.fill = GridBagConstraints.HORIZONTAL;
	gbc_comboBoxFeedingPlan.gridx = 2;
	gbc_comboBoxFeedingPlan.gridy = 5;
	add(comboBoxFeedingPlan, gbc_comboBoxFeedingPlan);

	btnNewButton_1 = new JButton("Opret Fodderplan");
	btnNewButton_1.setEnabled(false);
	btnNewButton_1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
	gbc_btnNewButton_1.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
	gbc_btnNewButton_1.gridx = 3;
	gbc_btnNewButton_1.gridy = 5;
	add(btnNewButton_1, gbc_btnNewButton_1);

	btnCancel = new JButton("Annuller");
	GridBagConstraints gbc_btnCancel = new GridBagConstraints();
	gbc_btnCancel.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnCancel.insets = new Insets(0, 0, 0, 5);
	gbc_btnCancel.gridx = 3;
	gbc_btnCancel.gridy = 10;
	add(btnCancel, gbc_btnCancel);

	btnCreate = new JButton("Opret Fiskekuld");
	btnCreate.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
	    }
	});
	GridBagConstraints gbc_btnCreate = new GridBagConstraints();
	gbc_btnCreate.fill = GridBagConstraints.HORIZONTAL;
	gbc_btnCreate.gridx = 4;
	gbc_btnCreate.gridy = 10;
	add(btnCreate, gbc_btnCreate);

    }

}
