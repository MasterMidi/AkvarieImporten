package gui.tabs;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.jdi.event.EventQueue;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.components.AquariumListCellRenderer;
import gui.components.AutoCompletion;
import gui.components.FeedingPlanListCellRenderer;
import gui.components.JHintTextField;
import gui.components.SearchMathesChooser;
import gui.components.SpeciesListCellRenderer;
import model.Aquarium;
import model.FeedingPlan;
import model.FishSpecies;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateFishpackTab extends JPanel {
	private JPanel viewport;
	private JLabel lblSpecies;
	private JTextField txtfSpecies;
	private JButton btnCreateSpecies;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblAquarium;
	private JComboBox<Aquarium> txtfAquarium;
	private JButton btnCreateAquarium;
	private JLabel lblFeedingPlan;
	private JComboBox<FeedingPlan> txtfFeedingPlan;
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

		txtfSpecies = new JTextField();
		txtfSpecies.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					speciesSearchPressed(e);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txtfSpecies.setEditable(true);
		GridBagConstraints gbc_txtfSpecies = new GridBagConstraints();
		gbc_txtfSpecies.insets = new Insets(0, 0, 5, 5);
		gbc_txtfSpecies.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfSpecies.gridx = 2;
		gbc_txtfSpecies.gridy = 1;
		viewport.add(txtfSpecies, gbc_txtfSpecies);

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

		txtfAquarium = new JComboBox<>();
		GridBagConstraints gbc_txtfAquarium = new GridBagConstraints();
		gbc_txtfAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_txtfAquarium.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfAquarium.gridx = 2;
		gbc_txtfAquarium.gridy = 3;
		viewport.add(txtfAquarium, gbc_txtfAquarium);

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

		txtfFeedingPlan = new JComboBox<>();
		GridBagConstraints gbc_txtfFeedingPlan = new GridBagConstraints();
		gbc_txtfFeedingPlan.insets = new Insets(0, 0, 5, 5);
		gbc_txtfFeedingPlan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfFeedingPlan.gridx = 2;
		gbc_txtfFeedingPlan.gridy = 4;
		viewport.add(txtfFeedingPlan, gbc_txtfFeedingPlan);

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

	protected void speciesSearchPressed(KeyEvent e) throws Exception {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("123123");
			List<FishSpecies> speciesList = new ArrayList<>(fishPackController.searchFishSpecies(txtfSpecies.getText()).values());
			SearchMathesChooser<FishSpecies> chooser = new SearchMathesChooser<FishSpecies>(new SpeciesListCellRenderer(), speciesList);
			chooser.setVisible(true);
			chooser.callback(() -> {
				FishSpecies res = chooser.getValue();
				txtfSpecies.setText(res.getName());
				fishPackController.setFishSpecies(res.getId());
			});
			
		}
		
	}

	private void init() throws DataAccessException {
		fishPackController = new FishPackController();
		fishPackController.createEmptyFishPack();
//		comboBoxSpecies.setRenderer(new SpeciesListCellRenderer());
		
		
		txtfAquarium.setRenderer(new AquariumListCellRenderer());
		txtfFeedingPlan.setRenderer(new FeedingPlanListCellRenderer());
		
		List<FishSpecies> speciesList = new ArrayList<>(fishPackController.searchFishSpecies("").values());
		
		List<Aquarium> aquariumList = new ArrayList<>(fishPackController.searchAquarium("").values());

		List<FeedingPlan> feedingPlanList = new ArrayList<>(fishPackController.searchFeedingplans("").values());
	}
}
