package gui.tabs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gui.ICallback;
import gui.components.JRoundedButton;

public class SearchMathesChooser<T> extends JDialog implements ICallback<T> {

	private final JPanel contentPanel = new JPanel();
	private JList<T> list;
	private T object;
	private Runnable callback;
	private JButton btnCreateObject;

	/**
	 * Create the dialog.
	 * 
	 * @param speciesList
	 * @param string
	 */
	public SearchMathesChooser(DefaultListCellRenderer cellRenderer, List<T> speciesList, String title) {
		setTitle(title);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				list = new JList<>();
				scrollPane.setViewportView(list);
			}
		}
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		btnCreateObject = new JRoundedButton("Opret");
		btnCreateObject.setPreferredSize(new Dimension(120, 30));
		btnCreateObject.setBorderPainted(false);
		btnCreateObject.setEnabled(false);
		buttonPane.add(btnCreateObject);
		
		JButton btnOK = new JRoundedButton("Vælg");
		btnOK.setPreferredSize(new Dimension(120, 30));
		btnOK.setBorderPainted(false);
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okClicked(e);
			}
		});
		btnOK.setActionCommand("OK");
		buttonPane.add(btnOK);


		JButton btnCancel = new JRoundedButton("Annuller");
		btnCancel.setPreferredSize(new Dimension(120, 30));
		btnCancel.setBorderPainted(false);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelClicked(e);
			}
		});
		btnCancel.setActionCommand("Cancel");
		buttonPane.add(btnCancel);

		init(cellRenderer, speciesList);
	}

	protected void cancelClicked(ActionEvent e) {
		this.setVisible(false);
		this.dispose();

	}

	protected void okClicked(ActionEvent e) {
		this.object = list.getSelectedValue();
		callback.run();
		cancelClicked(e);
	}

	private void init(DefaultListCellRenderer cellRenderer, List<T> speciesList) {
		list.setCellRenderer(cellRenderer);
		DefaultListModel<T> listModel = new DefaultListModel<T>();
		listModel.addAll(speciesList);
		list.setModel(listModel);
	}

	public T getValue() {
		return object;
	}

	@Override
	public void callback(Runnable callback) {
		this.callback = callback;
	}

}
