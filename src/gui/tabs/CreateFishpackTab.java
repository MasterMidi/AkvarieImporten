package gui.tabs;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.components.AquariumListCellRenderer;
import gui.components.AutoCompletion;
import gui.components.FeedingPlanListCellRenderer;
import gui.components.JHintTextField;
import model.Aquarium;
import model.FeedingPlan;
import model.FishSpecies;

public class CreateFishpackTab extends JPanel {
	private JPanel viewport;
	private JLabel lblSpecies;
	private JComboBox<FishSpecies> comboBoxSpecies;
	private JButton btnCreateSpecies;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblAquarium;
	private JComboBox<Aquarium> comboBoxAquarium;
	private JButton btnCreateAquarium;
	private JLabel lblFeedingPlan;
	private JComboBox<FeedingPlan> comboBoxFeedingPlan;
	private JButton btnNewButton;
	private JPanel footer;
	private JButton btnCancel;
	private JButton btnCreate;
	
	
	private FishPackController fishPackController;

	/**
	 * Create the panel.
	 * @throws DataAccessException 
	 */
	public CreateFishpackTab() throws DataAccessException {
		setLayout(new BorderLayout(0, 0));

		viewport = new JPanel();
		add(viewport);
		GridBagLayout gbl_viewport = new GridBagLayout();
		gbl_viewport.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_viewport.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_viewport.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_viewport.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		viewport.setLayout(gbl_viewport);

		lblSpecies = new JLabel("Art:");
		GridBagConstraints gbc_lblSpecies = new GridBagConstraints();
		gbc_lblSpecies.anchor = GridBagConstraints.EAST;
		gbc_lblSpecies.insets = new Insets(0, 0, 5, 5);
		gbc_lblSpecies.gridx = 1;
		gbc_lblSpecies.gridy = 1;
		viewport.add(lblSpecies, gbc_lblSpecies);

		comboBoxSpecies = new JComboBox<>();
		comboBoxSpecies.setEditable(true);
		GridBagConstraints gbc_comboBoxSpecies = new GridBagConstraints();
		gbc_comboBoxSpecies.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSpecies.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSpecies.gridx = 2;
		gbc_comboBoxSpecies.gridy = 1;
		viewport.add(comboBoxSpecies, gbc_comboBoxSpecies);

		btnCreateSpecies = new JButton("Opret Art");
		btnCreateSpecies.setEnabled(false);
		GridBagConstraints gbc_btnCreateSpecies = new GridBagConstraints();
		gbc_btnCreateSpecies.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateSpecies.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateSpecies.gridx = 3;
		gbc_btnCreateSpecies.gridy = 1;
		viewport.add(btnCreateSpecies, gbc_btnCreateSpecies);

		lblNewLabel = new JLabel("Dato");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 2;
		viewport.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JHintTextField("yyyy-mm-dd");
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		viewport.add(textField, gbc_textField);

		lblAquarium = new JLabel("Akvarie:");
		lblAquarium.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblAquarium.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAquarium = new GridBagConstraints();
		gbc_lblAquarium.anchor = GridBagConstraints.EAST;
		gbc_lblAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_lblAquarium.gridx = 1;
		gbc_lblAquarium.gridy = 3;
		viewport.add(lblAquarium, gbc_lblAquarium);

		comboBoxAquarium = new JComboBox<>();
		GridBagConstraints gbc_comboBoxAquarium = new GridBagConstraints();
		gbc_comboBoxAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxAquarium.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxAquarium.gridx = 2;
		gbc_comboBoxAquarium.gridy = 3;
		viewport.add(comboBoxAquarium, gbc_comboBoxAquarium);

		btnCreateAquarium = new JButton("Opret Akvarie");
		btnCreateAquarium.setEnabled(false);
		GridBagConstraints gbc_btnCreateAquarium = new GridBagConstraints();
		gbc_btnCreateAquarium.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateAquarium.gridx = 3;
		gbc_btnCreateAquarium.gridy = 3;
		viewport.add(btnCreateAquarium, gbc_btnCreateAquarium);

		lblFeedingPlan = new JLabel("Fodderplan:");
		GridBagConstraints gbc_lblFeedingPlan = new GridBagConstraints();
		gbc_lblFeedingPlan.anchor = GridBagConstraints.EAST;
		gbc_lblFeedingPlan.insets = new Insets(0, 0, 5, 5);
		gbc_lblFeedingPlan.gridx = 1;
		gbc_lblFeedingPlan.gridy = 4;
		viewport.add(lblFeedingPlan, gbc_lblFeedingPlan);

		comboBoxFeedingPlan = new JComboBox<>();
		GridBagConstraints gbc_comboBoxFeedingPlan = new GridBagConstraints();
		gbc_comboBoxFeedingPlan.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxFeedingPlan.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFeedingPlan.gridx = 2;
		gbc_comboBoxFeedingPlan.gridy = 4;
		viewport.add(comboBoxFeedingPlan, gbc_comboBoxFeedingPlan);

		btnNewButton = new JButton("Opret Fodderplan");
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 4;
		viewport.add(btnNewButton, gbc_btnNewButton);

		footer = new JPanel();
		add(footer, BorderLayout.SOUTH);

		btnCancel = new JButton("Annuller");
		footer.add(btnCancel);

		btnCreate = new JButton("Opret Fiskekuld");
		footer.add(btnCreate);

		
		init();
	}

	private void init() throws DataAccessException {
		fishPackController = new FishPackController();
//		comboBoxSpecies.setRenderer(new SpeciesListCellRenderer());
		AutoCompletion ac = new AutoCompletion(comboBoxSpecies);
		
		comboBoxAquarium.setRenderer(new AquariumListCellRenderer());
		comboBoxFeedingPlan.setRenderer(new FeedingPlanListCellRenderer());
		
		List<FishSpecies> speciesList = new ArrayList<>(fishPackController.searchFishSpecies("").values());
		speciesList.parallelStream().forEach(fs -> comboBoxSpecies.addItem(fs));
		
		List<Aquarium> aquariumList = new ArrayList<>(fishPackController.searchAquarium("").values());
		aquariumList.parallelStream().forEach(aq -> comboBoxAquarium.addItem(aq));

		List<FeedingPlan> feedingPlanList = new ArrayList<>(fishPackController.searchFeedingplans("").values());
		feedingPlanList.parallelStream().forEach(fp -> comboBoxFeedingPlan.addItem(fp));
	}
}
