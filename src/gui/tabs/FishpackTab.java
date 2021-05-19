package gui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.Main;
import gui.components.JRoundedButton;
import gui.renderer.FishPackTableModel;
import model.FishPack;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class FishpackTab extends JPanel {
	private JTable contentTable;
	private FishPackController fishPackController;
	private FishPackTableModel fishPackTableModel;
	private JTextField txtfSearch;

	
	private SwingWorker<Void, Void> updateTableWorker;
	/**
	 * Create the panel.
	 * 
	 * @throws DataAccessException
	 */
	public FishpackTab() {
		setLayout(new BorderLayout(0, 0));

		JPanel HeaderPane = new JPanel();
		add(HeaderPane, BorderLayout.NORTH);
		HeaderPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		HeaderPane.add(panel, BorderLayout.WEST);

		JButton btnCreateFishpack = new JRoundedButton("Opret Kuld");
		btnCreateFishpack.setPreferredSize(new Dimension(120, 30));
		btnCreateFishpack.setBorderPainted(false);
		btnCreateFishpack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createFishpackPressed();
			}
		});
		panel.add(btnCreateFishpack);

		JButton btnUpdateFishpack = new JRoundedButton("Rediger Kuld");
		btnUpdateFishpack.setEnabled(false);
		btnUpdateFishpack.setPreferredSize(new Dimension(120, 30));
		btnUpdateFishpack.setBorderPainted(false);
		panel.add(btnUpdateFishpack);

		JPanel panel_1 = new JPanel();
		HeaderPane.add(panel_1, BorderLayout.EAST);

		JButton btnRemoveFishpack = new JRoundedButton("Fjern Kuld");
		btnRemoveFishpack.setEnabled(false);
		btnRemoveFishpack.setPreferredSize(new Dimension(120, 30));
		btnRemoveFishpack.setBorderPainted(false);
		panel_1.add(btnRemoveFishpack);
		
		JButton btnNewButton = new JButton("Opdater");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					refreshFishPackTable(txtfSearch.getText());
				} catch (SQLException | DataAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		HeaderPane.add(btnNewButton, BorderLayout.CENTER);

		JPanel ContentPane = new JPanel();
		add(ContentPane, BorderLayout.CENTER);
		ContentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		ContentPane.add(scrollPane);
		
		contentTable = new JTable();
		scrollPane.setViewportView(contentTable);
		
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_southPanel = new GridBagLayout();
		gbl_southPanel.columnWidths = new int[]{324, 0, 0};
		gbl_southPanel.rowHeights = new int[]{20, 0};
		gbl_southPanel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_southPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		southPanel.setLayout(gbl_southPanel);
		
		txtfSearch = new JTextField();
		txtfSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchClicked();
			}
		});
		txtfSearch.setMargin(new Insets(2, 2, 2, 0));
		GridBagConstraints gbc_txtfSearch = new GridBagConstraints();
		gbc_txtfSearch.insets = new Insets(0, 0, 0, 5);
		gbc_txtfSearch.anchor = GridBagConstraints.NORTH;
		gbc_txtfSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtfSearch.gridx = 0;
		gbc_txtfSearch.gridy = 0;
		southPanel.add(txtfSearch, gbc_txtfSearch);
		txtfSearch.setColumns(10);
		
		JButton btnSearchFishPack = new JRoundedButton("Søg...");
		btnUpdateFishpack.setPreferredSize(new Dimension(120, 30));
		btnUpdateFishpack.setBorderPainted(false);
		btnSearchFishPack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchClicked();
			}
		});
		GridBagConstraints gbc_btnSearchFishPack = new GridBagConstraints();
		gbc_btnSearchFishPack.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSearchFishPack.gridx = 1;
		gbc_btnSearchFishPack.gridy = 0;
		southPanel.add(btnSearchFishPack, gbc_btnSearchFishPack);

		init();
	}

	private void searchClicked() {
		String searchInput = txtfSearch.getText();
		if(searchInput != "" || searchInput != null) {
			try {
				refreshFishPackTable(searchInput);
			} catch (SQLException | DataAccessException e) {
				JOptionPane.showMessageDialog(contentTable, "Kunne ikke forbinde til databasen, tjek internet forbindelsen", "Fejl", JOptionPane.OK_OPTION);
			}
		}
		
	}

	private void init() {
		try {
			fishPackController = new FishPackController();
			fishPackTableModel = new FishPackTableModel();
			contentTable.setModel(fishPackTableModel);
			refreshFishPackTable("");
		} catch (DataAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void createFishpackPressed() {
		EventQueue.invokeLater(() -> Main.newView(CreateFishpackTab.class));
	}

	private void refreshFishPackTable(String search) throws SQLException, DataAccessException {
		if(updateTableWorker != null && !updateTableWorker.isDone()) {
			updateTableWorker.cancel(true);
		}
		
		updateTableWorker = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				Map<Integer, FishPack> FishPacks = fishPackController.searchFishPack(search);
				List<FishPack> lists = new ArrayList<>(FishPacks.values());

				fishPackTableModel.setData(lists);
				
				return null;
			}
		};
		
		updateTableWorker.execute();
	}

}
