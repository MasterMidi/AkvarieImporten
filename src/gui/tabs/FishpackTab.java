package gui.tabs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ctrl.FishPackController;
import exception.DataAccessException;
import gui.Main;
import gui.components.FishPackTableModel;
import gui.components.JRoundedButton;
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
    public FishpackTab() {
	setLayout(new BorderLayout(0, 0));

	JPanel HeaderPane = new JPanel();
	add(HeaderPane, BorderLayout.NORTH);
	HeaderPane.setLayout(new BorderLayout(0, 0));

	JPanel panel = new JPanel();
	HeaderPane.add(panel, BorderLayout.WEST);

	JButton btnCreateFishpack = new JRoundedButton("Opret Kuld");
	btnCreateFishpack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		createFishpackPressed();
	    }
	});
	panel.add(btnCreateFishpack);

	JButton btnUpdateFishpack = new JRoundedButton("Rediger Kuld");
	panel.add(btnUpdateFishpack);

	JPanel panel_1 = new JPanel();
	HeaderPane.add(panel_1, BorderLayout.EAST);

	JButton btnRemoveFishpack = new JRoundedButton("Fjern Kuld");
	panel_1.add(btnRemoveFishpack);

	JPanel InfoPane = new JPanel();
	InfoPane.setBackground(Color.YELLOW);
	add(InfoPane, BorderLayout.EAST);

	txtImALittle = new JTextField();
	txtImALittle.setText("I*M A LITTLE LITTLE FISH IN A BIG BLUE SEA");
	InfoPane.add(txtImALittle);
	txtImALittle.setColumns(10);

	JPanel FooterPane = new JPanel();
	add(FooterPane, BorderLayout.SOUTH);

	JButton btnCancel = new JRoundedButton("Anuller");
	FooterPane.add(btnCancel);

	JButton btnFinish = new JRoundedButton("Færdig");
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

    private void init() {
	try {
	    fishPackController = new FishPackController();
	    fishPackTableModel = new FishPackTableModel();
	    contentTable.setModel(fishPackTableModel);
	    refreshFishPackTable();
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

    private void refreshFishPackTable() throws SQLException, DataAccessException {
	Map<Integer, FishPack> FishPacks = fishPackController.searchFishPack("");
	List<FishPack> lists = new ArrayList<>(FishPacks.values());

	fishPackTableModel.setData(lists);
    }

}
