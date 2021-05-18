package gui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.Main;
import gui.components.JHintTextField;
import gui.components.JRoundedButton;
import gui.renderer.AquariumListCellRenderer;
import gui.renderer.FeedingPlanListCellRenderer;
import gui.renderer.SpeciesListCellRenderer;
import model.Aquarium;
import model.FeedingPlan;
import model.FishSpecies;

public class CreateFishpackTab extends JPanel {
	private JPanel viewport;
	private JLabel lblSpecies;
	private JTextField txtfSpecies;
	private JButton btnCreateSpecies;
	private JLabel lblNewLabel;
	private JTextField txtfBirthdate;
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
	private JButton btnGenerateDate;

	/**
	 * Create the panel.
	 * 
	 * @throws DataAccessException
	 */
	public CreateFishpackTab() throws DataAccessException {
		setLayout(new BorderLayout(0, 0));

		viewport = new JPanel();
		add(viewport);
		GridBagLayout gbl_viewport = new GridBagLayout();
		gbl_viewport.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_viewport.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_viewport.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_viewport.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
			public void keyReleased(KeyEvent e) {
				speciesSearchPressed(e);
			}
		});
		txtfSpecies.setEditable(true);
		GridBagConstraints gbc_txtfSpecies = new GridBagConstraints();
		gbc_txtfSpecies.insets = new Insets(0, 0, 5, 5);
		gbc_txtfSpecies.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfSpecies.gridx = 2;
		gbc_txtfSpecies.gridy = 1;
		viewport.add(txtfSpecies, gbc_txtfSpecies);

		btnCreateSpecies = new JRoundedButton("Opret Art");
		btnCreateSpecies.setPreferredSize(new Dimension(120, 30));
		btnCreateSpecies.setBorderPainted(false);
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
		gbc_lblNewLabel.gridy = 3;
		viewport.add(lblNewLabel, gbc_lblNewLabel);

		txtfBirthdate = new JHintTextField("yyyy-mm-dd");
		txtfBirthdate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				validateDate();
			}
		});

		txtfBirthdate.setColumns(10);
		GridBagConstraints gbc_txtfBirthdate = new GridBagConstraints();
		gbc_txtfBirthdate.insets = new Insets(0, 0, 5, 5);
		gbc_txtfBirthdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfBirthdate.gridx = 2;
		gbc_txtfBirthdate.gridy = 3;
		viewport.add(txtfBirthdate, gbc_txtfBirthdate);

		btnGenerateDate = new JRoundedButton("I dag");
		btnGenerateDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetCurrentDate(e);
			}
		});
		btnGenerateDate.setPreferredSize(new Dimension(120, 30));
		btnGenerateDate.setBorderPainted(false);
		GridBagConstraints gbc_btnGenerateDate = new GridBagConstraints();
		gbc_btnGenerateDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGenerateDate.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerateDate.gridx = 3;
		gbc_btnGenerateDate.gridy = 3;
		viewport.add(btnGenerateDate, gbc_btnGenerateDate);

		lblAquarium = new JLabel("Akvarie:");
		lblAquarium.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblAquarium.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAquarium = new GridBagConstraints();
		gbc_lblAquarium.anchor = GridBagConstraints.EAST;
		gbc_lblAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_lblAquarium.gridx = 1;
		gbc_lblAquarium.gridy = 5;
		viewport.add(lblAquarium, gbc_lblAquarium);

		txtfAquarium = new JTextField();
		txtfAquarium.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				aquariumSearchPressed(e);
			}
		});
		GridBagConstraints gbc_txtfAquarium = new GridBagConstraints();
		gbc_txtfAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_txtfAquarium.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfAquarium.gridx = 2;
		gbc_txtfAquarium.gridy = 5;
		viewport.add(txtfAquarium, gbc_txtfAquarium);

		btnCreateAquarium = new JRoundedButton("Opret Akvarie");
		btnCreateAquarium.setPreferredSize(new Dimension(120, 30));
		btnCreateAquarium.setBorderPainted(false);
		btnCreateAquarium.setEnabled(false);
		GridBagConstraints gbc_btnCreateAquarium = new GridBagConstraints();
		gbc_btnCreateAquarium.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreateAquarium.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreateAquarium.gridx = 3;
		gbc_btnCreateAquarium.gridy = 5;
		viewport.add(btnCreateAquarium, gbc_btnCreateAquarium);

		lblFeedingPlan = new JLabel("Fodderplan:");
		GridBagConstraints gbc_lblFeedingPlan = new GridBagConstraints();
		gbc_lblFeedingPlan.anchor = GridBagConstraints.EAST;
		gbc_lblFeedingPlan.insets = new Insets(0, 0, 5, 5);
		gbc_lblFeedingPlan.gridx = 1;
		gbc_lblFeedingPlan.gridy = 7;
		viewport.add(lblFeedingPlan, gbc_lblFeedingPlan);

		txtfFeedingPlan = new JTextField();
		txtfFeedingPlan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				FeedingPlanSearchpressed(e);
			}
		});
		GridBagConstraints gbc_txtfFeedingPlan = new GridBagConstraints();
		gbc_txtfFeedingPlan.insets = new Insets(0, 0, 5, 5);
		gbc_txtfFeedingPlan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfFeedingPlan.gridx = 2;
		gbc_txtfFeedingPlan.gridy = 7;
		viewport.add(txtfFeedingPlan, gbc_txtfFeedingPlan);

		btnNewButton = new JRoundedButton("Opret Fodderplan");
		btnNewButton.setPreferredSize(new Dimension(120, 30));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 7;
		viewport.add(btnNewButton, gbc_btnNewButton);

		footer = new JPanel();
		add(footer, BorderLayout.SOUTH);

		btnCancel = new JRoundedButton("Annuller");
		btnCancel.setPreferredSize(new Dimension(120, 30));
		btnCancel.setBorderPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelPressed(e);
			}
		});
		footer.add(btnCancel);

		btnCreate = new JRoundedButton("Opret Fiskekuld");
		btnCreate.setPreferredSize(new Dimension(120, 30));
		btnCreate.setBorderPainted(false);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinishPressed(e);
			}
		});
		footer.add(btnCreate);

		init();
	}

	protected void SetCurrentDate(ActionEvent e) {
//		txtfBirthdate.setText(LocalDate.now().format(new DateTimeFormatterBuilder().));
	}

	protected void FinishPressed(ActionEvent e) {
		Future<Boolean> f = fishPackController.finishFishPack();
		EventQueue.invokeLater(() -> {
			try {
				f.get();
			} catch (InterruptedException | ExecutionException ex) {
				JOptionPane.showMessageDialog(this, "Noget gik galt, kunne ikke gemme kuld i database", "Fejl",
						JOptionPane.ERROR_MESSAGE);
			}
		});
		CancelPressed(e);
	}

	protected void CancelPressed(ActionEvent e) {
		EventQueue.invokeLater(() -> Main.newView(FishpackTab.class));
	}

	private void validateDate() {
		Pattern pattern = Pattern.compile("^(19|20)\\d\\d([- /.])(0[1-9]|1[012])\\2(0[1-9]|[12][0-9]|3[01])$");
		Matcher matcher = pattern.matcher(txtfBirthdate.getText());
		if (matcher.find()) {
			txtfBirthdate.setBorder(new LineBorder(Color.green, 1));
			fishPackController.setFishPackBirthday(LocalDate.parse(txtfBirthdate.getText()));
		} else {
			txtfBirthdate.setBorder(new LineBorder(Color.red, 1));
		}

	}

	protected void aquariumSearchPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			List<Aquarium> aquariumList = new ArrayList<>(
					fishPackController.searchAquarium(txtfAquarium.getText()).values());
			SearchMathesChooser<Aquarium> chooser = new SearchMathesChooser<Aquarium>(new AquariumListCellRenderer(),
					aquariumList);
			chooser.setVisible(true);
			chooser.callback(() -> {
				Aquarium res = chooser.getValue();
				txtfAquarium.setText(res.getNumber());
				fishPackController.setAquarium(res.getId());
			});
		}
	}

	protected void FeedingPlanSearchpressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			List<FeedingPlan> feedingPlanList = new ArrayList<>(
					fishPackController.searchFeedingplans(txtfFeedingPlan.getText()).values());
			SearchMathesChooser<FeedingPlan> chooser = new SearchMathesChooser<>(new FeedingPlanListCellRenderer(),
					feedingPlanList);
			chooser.setVisible(true);
			chooser.callback(() -> {
				FeedingPlan res = chooser.getValue();
				txtfFeedingPlan.setText(res.getName());
				fishPackController.setFeedingPlan(res.getID());
			});
		}
	}

	protected void speciesSearchPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			List<FishSpecies> speciesList = new ArrayList<>(
					fishPackController.searchFishSpecies(txtfSpecies.getText()).values());
			SearchMathesChooser<FishSpecies> chooser = new SearchMathesChooser<>(new SpeciesListCellRenderer(),
					speciesList);
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
	}
}
