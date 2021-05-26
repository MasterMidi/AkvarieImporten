package gui.renderer;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.FishPack;

public class FishPackTableModel extends AbstractTableModel {

	private static final String[] COL_NAMES = { "Kuld Nr.", "Art", "Akvarie.", "Status", "Lokation", "Foderplan",
			"Dato" };
	private List<FishPack> data;

	public FishPackTableModel() {
		data = new ArrayList<>();
	}

	public void setData(List<FishPack> data) {
		this.data = data;
		super.fireTableDataChanged();
	}

	public FishPack getDataAtIndex(int index) {
		FishPack res = null;
		if (index >= 0 && index < data.size()) {
			res = data.get(index);
		}
		return res;
	}

	@Override
	public int getRowCount() {
		int res = 0;
		if (data != null) {
			res = data.size();
		}
		return res;
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public String getColumnName(int column) {
		return COL_NAMES[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		FishPack fishPack = data.get(row);
		String res = "UNDEFINED";
		switch (column) {
		case 0:
			res = fishPack.getFishPackNumber();
			break;
		case 1:
			res = fishPack.getSpecies().getName();
			break;
		case 2:
			res = fishPack.getCurrentAquarium().getNumber();
			break;
		case 3:
			res = String.valueOf(fishPack.getStatus());
			break;
		case 4:
			res = fishPack.getCurrentAquarium().getLocation();
			break;
		case 5:
			res = fishPack.getFeedingPlan().getName();
			break;
		case 6:
			res = fishPack.getBirthDate().toString();
			break;
		default:
			res = "UNKNOWN COL - CONTACT ADMIN";
			break;
		}
		return res;
	}
}
