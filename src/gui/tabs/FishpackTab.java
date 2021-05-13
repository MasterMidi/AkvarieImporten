package gui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.components.FishPackTableModel;
import model.FishPack;

public class FishpackTab extends JPanel {
    private JTable contentTable;
    private FishPackController fishPackController;
    private FishPackTableModel fishPackTableModel;
    private JTextField txtImALittle;

    /**
     * Create the panel.
     * 
     * @throws DataAccessException
     */
    public FishpackTab() throws DataAccessException {
	setLayout(new BorderLayout(0, 0));

	JPanel HeaderPane = new JPanel();
	add(HeaderPane, BorderLayout.NORTH);

	JButton btnCreateFishpack = new JButton("Opret Kuld");
	HeaderPane.add(btnCreateFishpack);

	JButton btnUpdateFishpack = new JButton("Rediger Kuld");
	HeaderPane.add(btnUpdateFishpack);

	JButton btnRemoveFishpack = new JButton("Fjern Kuld");
	HeaderPane.add(btnRemoveFishpack);

	JPanel InfoPane = new JPanel();
	InfoPane.setBackground(Color.YELLOW);
	add(InfoPane, BorderLayout.EAST);

	txtImALittle = new JTextField();
	txtImALittle.setText("I*M A LITTLE LITTLE FISH IN A BIG BLUE SEA");
	InfoPane.add(txtImALittle);
	txtImALittle.setColumns(10);

	JPanel FooterPane = new JPanel();
	add(FooterPane, BorderLayout.SOUTH);

	JButton btnCancel = new JButton("Anuller");
	FooterPane.add(btnCancel);

	JButton btnFinish = new JButton("Færdig");
	FooterPane.add(btnFinish);

	JPanel ContentPane = new JPanel();
	add(ContentPane, BorderLayout.CENTER);
	ContentPane.setLayout(new BorderLayout(0, 0));

	JScrollPane scrollPane = new JScrollPane();
	ContentPane.add(scrollPane);

	contentTable = new JTable();
	scrollPane.setViewportView(contentTable);

	init();
    }

    private void init() throws DataAccessException {
	fishPackController = new FishPackController();
	fishPackTableModel = new FishPackTableModel();
	contentTable.setModel(fishPackTableModel);
	refreshFishPackTable();
    }

    private void refreshFishPackTable() {
	List<FishPack> lists = fishPackController.searchFishPack("");

	fishPackTableModel.setData(lists);
    }

}
