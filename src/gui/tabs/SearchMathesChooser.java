package gui.tabs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.ICallback;
import gui.components.JRoundedButton;
import model.FishSpecies;

import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.awt.event.ActionEvent;

public class SearchMathesChooser<T> extends JDialog implements ICallback<T> {

	private final JPanel contentPanel = new JPanel();
	private JList<T> list;
	private T object;
	private DefaultListCellRenderer cellRenderer;
	private Runnable callback;

	/**
	 * Create the dialog.
	 * @param speciesList 
	 */
	public SearchMathesChooser(DefaultListCellRenderer cellRenderer, List<T> speciesList) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				list = new JList();
				scrollPane.setViewportView(list);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JRoundedButton("Vælg");
				okButton.setPreferredSize(new Dimension(120, 30));
				okButton.setBorderPainted(false);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okClicked(e);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JRoundedButton("Annuller");
				cancelButton.setPreferredSize(new Dimension(120, 30));
				cancelButton.setBorderPainted(false);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked(e);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
		}
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
		this.cellRenderer= cellRenderer; 
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
