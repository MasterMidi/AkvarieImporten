package gui.tabs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.Main;
import gui.components.AquariumListCellRenderer;
import gui.components.AutoCompletion;
import gui.components.FeedingPlanListCellRenderer;
import gui.components.JHintTextField;
<<<<<<< Updated upstream
import gui.components.SpeciesListCellRenderer;
=======
import gui.components.SearchMathesChooser;
>>>>>>> Stashed changes
import model.Aquarium;
import model.FeedingPlan;
import model.FishSpecies;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreateFishpackTab extends JPanel {
	private JPanel viewport;
	private JLabel lblSpecies;
	private JTextField txtfSpecies;
	private JButton btnCreateSpecies;
	private JLabel lblNewLabel;
	private JTextField txtfBirthDate;
	private JLabel lblAquarium;
	private JTextField txtfAquarium;
	private JButton btnCreateAquarium;
	private JLabel lblFeedingPlan;
	private JTextField txtfFeedingPlan;
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
				speciesSearch(e);
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

		txtfBirthDate = new JHintTextField("yyyy-mm-dd");
		txtfBirthDate.setColumns(10);
		GridBagConstraints gbc_txtfBirthDate = new GridBagConstraints();
		gbc_txtfBirthDate.insets = new Insets(0, 0, 5, 5);
		gbc_txtfBirthDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfBirthDate.gridx = 2;
		gbc_txtfBirthDate.gridy = 2;
		viewport.add(txtfBirthDate, gbc_txtfBirthDate);

		lblAquarium = new JLabel("Akvarie:");
		lblAquarium.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblAquarium.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAquarium = new GridBagConstraints();
		gbc_lblAquarium.anchor = GridBagConstraints.EAST;
		gbc_lblAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_lblAquarium.gridx = 1;
		gbc_lblAquarium.gridy = 3;
		viewport.add(lblAquarium, gbc_lblAquarium);

		txtfAquarium = new JTextField();
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

		txtfFeedingPlan = new JTextField();
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

	protected void speciesSearch(KeyEvent e) {
		JDialog chooser = new SearchMathesChooser();
		chooser.setVisible(true);
		
		
	}

	private void init() throws DataAccessException {
		fishPackController = new FishPackController();
//		comboBoxSpecies.setRenderer(new SpeciesListCellRenderer());
		
		List<FishSpecies> speciesList = new ArrayList<>(fishPackController.searchFishSpecies("").values());
		
		List<Aquarium> aquariumList = new ArrayList<>(fishPackController.searchAquarium("").values());

		List<FeedingPlan> feedingPlanList = new ArrayList<>(fishPackController.searchFeedingplans("").values());
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
