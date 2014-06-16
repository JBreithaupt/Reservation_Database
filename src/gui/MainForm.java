package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Calendar.DateAD;

import com.*;

/**
 * A GUI for the reservation database.
 * <p>
 * 
 * Compiled in JDK 8 Tested on: Windows 8.1 (SP 1) AMD 8350 @ 4.26 GHZ 16 GB
 * 1866 MHz GSkill Ram Using Eclipse Version: Kepler Service Release 2
 * 
 * @author Joe Breithaupt
 * 
 *         Known Bugs: Searching by Dates does not work. The binary search is
 *         there, however there is no parsing method to allow the creation of a
 *         dateAD from string passed in by user.
 */
public class MainForm implements ActionListener {

	private static final int TEXT_HEIGHT = 10;
	private static final int TEXT_WIDTH = 40;
	private static final String TITLE = "Reservation Manager";

	private static JFrame Boxify(JFrame f) {
		JPanel radioPane = new JPanel();
		radioPane.setLayout(new BoxLayout(radioPane, BoxLayout.Y_AXIS));
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		JPanel searchPane = new JPanel();
		searchPane.setLayout(new BoxLayout(searchPane, BoxLayout.X_AXIS));
		JPanel textPane = new JPanel();
		textPane.setLayout(new BoxLayout(textPane, BoxLayout.Y_AXIS));

		mb = new JMenuBar();

		JMenu menuFile = new JMenu("File");
		JMenuItem itemFile = new JMenuItem("Exit");
		itemFile.addActionListener(new MainForm());
		menuFile.add(itemFile);
		mb.add(menuFile);

		searchBox = new JTextArea();
		buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new MainForm());
		searchPane.add(searchBox);
		searchPane.add(Box.createRigidArea(new Dimension(10, 0)));
		searchPane.add(buttonSearch);

		ButtonGroup radios = new ButtonGroup();
		radioContains = new JRadioButton("Contains text");
		radioContains.addActionListener(new MainForm());
		radioContains.setSelected(true);
		radioFullName = new JRadioButton("Search by Full Name");
		radioFullName.addActionListener(new MainForm());
		radioDateEnd = new JRadioButton("Search by Departure Date");
		radioDateEnd.addActionListener(new MainForm());
		radioDate = new JRadioButton("Search by Arrival Date");
		radioDate.addActionListener(new MainForm());
		radios.add(radioContains);
		radios.add(radioFullName);
		radios.add(radioDate);
		radios.add(radioDateEnd);
		radioPane.add(Box.createRigidArea(new Dimension(10, 10)));

		radioPane.add(radioContains);
		radioPane.add(radioFullName);
		radioPane.add(radioDate);
		radioPane.add(radioDateEnd);

		text = new JTextArea();
		labelResults = new JLabel("Results:");
		text.setColumns(TEXT_WIDTH);
		text.setRows(TEXT_HEIGHT);
		text.setEditable(false);
		textPane.add(Box.createRigidArea(new Dimension(0, 10)));
		textPane.add(labelResults);
		textPane.add(text);

		buttonClear = new JButton("Clear");
		buttonExit = new JButton("Exit");
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));

		buttonPane.add(buttonClear);
		buttonClear.addActionListener(new MainForm());
		buttonPane.add(Box.createRigidArea(new Dimension(10, 0)));

		buttonPane.add(buttonExit);
		buttonExit.addActionListener(new MainForm());

		f.setJMenuBar(mb);
		f.add(searchPane, BorderLayout.NORTH);
		f.add(radioPane, BorderLayout.EAST);
		f.add(textPane, BorderLayout.CENTER);
		f.add(buttonPane, BorderLayout.SOUTH);
		f.pack();
		return f;
	}

	public static void initGUI() {
		f = new JFrame(TITLE);
		f = Boxify(f);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String sender = e.getActionCommand().toLowerCase();
		System.out.println(sender);

		switch (sender) {
		case "exit":
			System.exit(0);
			break;
		case "search":
			// TODO Joe, you need to have the radio buttons change the
			// toSearchFor variable in searches. Then call the search method.
			// I'm not sure what you've got going on here to fix it myself, but
			// I'm pretty sure that's all we're missing.

			// seen 6/14/14 -Joe
			// Bradley couldn't wait and fixed. 6/15/2014 -Bradley
			/*
			 * toSearchFor = Name: 0 Arrival Date: 1 Departure Date: 2 Partial
			 * Name: 3
			 */

			//DateAD dateToFind;
			searcher = new Searches();
			if (!searchBox.getText().isEmpty()) {

				if (radioFullName.isSelected()) {
					searcher.setToSearchFor(Reservation.NAME);
					results = searcher.search(searchBox.getText(),
							searcher.getToSearchFor());
				}
				if (radioContains.isSelected()) {
					searcher.setToSearchFor(Reservation.PARTIAL_NAME);
					// searcher.setToSearchFor(Reservation.NAME);
					results = searcher.search(searchBox.getText(),
							searcher.getToSearchFor());
				}
				if (radioDateEnd.isSelected()) {
					// searcher.setToSearchFor(Reservation.DEPART);
					// dateToFind = new DateAD(searchBox.getText());
					// results = searcher.search(dateToFind,
					// searcher.getToSearchFor());
				}
				if (radioDate.isSelected()) {
					// Code for searching dateADs is there, but due to family
					// matters BP was unable to finish the parsing method to
					// allow the building of a DateAD
					// searcher.setToSearchFor(Reservation.ARRIVAL);
					// dateToFind = new DateAD(searchBox.getText());
					// results = searcher.search(dateToFind,
					// searcher.getToSearchFor());
				}
				StringBuilder view = new StringBuilder();
				for (Reservation a : results) {
					if (view.length() != 0) {
						view.append(a.toString());
					} else {
						view.append(a.toString());
					}
				}
				text.setText(view.toString());
			}
			break;
		case "clear":
			text.setText(null);
			searchBox.setText(null);
			radioContains.setSelected(true);
		default:
			// System.out.println("That action is not yet handled");
			break;
		}
	}

	private static Reservation[] results;
	private Searches searcher;
	private static JRadioButton radioDateEnd;
	private static JButton buttonClear;
	private static JButton buttonExit;
	private static JButton buttonSearch;
	private static JFrame f;
	private static JMenuBar mb;
	private static JRadioButton radioContains;
	private static JRadioButton radioDate;
	private static JRadioButton radioFullName;
	private static JTextArea searchBox;
	private static JTextArea text;
	private static JLabel labelResults;
}
