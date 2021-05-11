package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import gui.components.JRoundedButton;
import gui.tabs.menues;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Rectangle;

public class Main extends JFrame implements CallbackIF {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();

					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					frame.setTitle("Akvarieimporten");
					frame.setIconImage(ImageIO.read(new File("res/logo.png")));

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public Main() throws IOException, InterruptedException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel menuPane = new JPanel();
		contentPane.add(menuPane, BorderLayout.WEST);
		GridBagLayout gbl_menuPane = new GridBagLayout();
		gbl_menuPane.columnWidths = new int[] { 0 };
		gbl_menuPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_menuPane.columnWeights = new double[] { Double.MIN_VALUE };
		gbl_menuPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		menuPane.setLayout(gbl_menuPane);

		JRoundedButton btnNewButton = new JRoundedButton("Akvarier");
		btnNewButton.setPreferredSize(new Dimension(120, 30));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(ImageIO.read(new File("res/logo.png"))));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		menuPane.add(btnNewButton, gbc_btnNewButton);

		JButton btnNewButton_1 = new JRoundedButton("Fisk");
		btnNewButton_1.setPreferredSize(new Dimension(120, 30));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		menuPane.add(btnNewButton_1, gbc_btnNewButton_1);

		JButton btnNewButton_2 = new JRoundedButton("Kuld");
		btnNewButton_2.setPreferredSize(new Dimension(120, 30));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 2;
		menuPane.add(btnNewButton_2, gbc_btnNewButton_2);

		JButton btnNewButton_3 = new JRoundedButton("Statistik");
		btnNewButton_3.setPreferredSize(new Dimension(120, 30));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 3;
		menuPane.add(btnNewButton_3, gbc_btnNewButton_3);

		JButton btnNewButton_4 = new JRoundedButton("Arter");
		btnNewButton_4.setPreferredSize(new Dimension(120, 30));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_4.gridx = 0;
		gbc_btnNewButton_4.gridy = 4;
		menuPane.add(btnNewButton_4, gbc_btnNewButton_4);

		JButton btnNewButton_5 = new JRoundedButton("Lokation");
		btnNewButton_5.setPreferredSize(new Dimension(120, 30));
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_5.gridx = 0;
		gbc_btnNewButton_5.gridy = 5;
		menuPane.add(btnNewButton_5, gbc_btnNewButton_5);

		JButton btnNewButton_6 = new JRoundedButton("Kalender");
		btnNewButton_6.setPreferredSize(new Dimension(120, 30));
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 6;
		menuPane.add(btnNewButton_6, gbc_btnNewButton_6);

		JButton btnNewButton_7 = new JRoundedButton("Fodreplan");
		btnNewButton_7.setPreferredSize(new Dimension(120, 30));
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_7 = new GridBagConstraints();
		gbc_btnNewButton_7.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_7.gridx = 0;
		gbc_btnNewButton_7.gridy = 7;
		menuPane.add(btnNewButton_7, gbc_btnNewButton_7);
		
		JPanel Viewport = new JPanel();
		contentPane.add(Viewport, BorderLayout.CENTER);
		Viewport.setLayout(new BorderLayout(0, 0));
		
		JPanel buttonsTop = new JPanel();
		Viewport.add(buttonsTop, BorderLayout.NORTH);
		GridBagLayout gbl_buttonsTop = new GridBagLayout();
		gbl_buttonsTop.columnWidths = new int[]{0, 0, 0};
		gbl_buttonsTop.rowHeights = new int[]{0, 0, 0};
		gbl_buttonsTop.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_buttonsTop.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		buttonsTop.setLayout(gbl_buttonsTop);
		
		JPanel leftButtonPane = new JPanel();
		FlowLayout fl_leftButtonPane = (FlowLayout) leftButtonPane.getLayout();
		fl_leftButtonPane.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_leftButtonPane = new GridBagConstraints();
		gbc_leftButtonPane.insets = new Insets(0, 0, 5, 5);
		gbc_leftButtonPane.fill = GridBagConstraints.BOTH;
		gbc_leftButtonPane.gridx = 0;
		gbc_leftButtonPane.gridy = 0;
		buttonsTop.add(leftButtonPane, gbc_leftButtonPane);
		
		JRoundedButton btnNewButton_8 = new JRoundedButton("Akvarier");
		btnNewButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		leftButtonPane.add(btnNewButton_8);
		
		JRoundedButton btnNewButton_9 = new JRoundedButton("Akvarier");
		btnNewButton_9.setHorizontalAlignment(SwingConstants.LEFT);
		leftButtonPane.add(btnNewButton_9);
		
		JPanel rightButtonPane = new JPanel();
		FlowLayout fl_rightButtonPane = (FlowLayout) rightButtonPane.getLayout();
		fl_rightButtonPane.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_rightButtonPane = new GridBagConstraints();
		gbc_rightButtonPane.insets = new Insets(0, 0, 5, 0);
		gbc_rightButtonPane.fill = GridBagConstraints.BOTH;
		gbc_rightButtonPane.gridx = 1;
		gbc_rightButtonPane.gridy = 0;
		buttonsTop.add(rightButtonPane, gbc_rightButtonPane);
		
		JRoundedButton btnNewButton_10 = new JRoundedButton("Akvarier");
		btnNewButton_10.setHorizontalAlignment(SwingConstants.LEFT);
		rightButtonPane.add(btnNewButton_10);
		
		JPanel InfoPane = new JPanel();
		Viewport.add(InfoPane, BorderLayout.EAST);
		InfoPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		InfoPane.add(panel_1);
		
		JPanel mainView = new JPanel();
		Viewport.add(mainView, BorderLayout.CENTER);
		mainView.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		panel.setBackground(Color.RED);
		mainView.add(panel);

		
		init();
	}

	private void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void callback(Runnable callback) {
		// TODO Auto-generated method stub

	}

}
