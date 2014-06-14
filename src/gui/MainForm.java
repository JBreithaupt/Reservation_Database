package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 * A GUI for the reservation database.
 * 
 * @author Joe Breithaupt
 * 
 * 
 *         Compiled in JDK 8 Tested on: Windows 8.1 (SP 1) AMD 8350 @ 4.26 GHZ
 *         16 GB 1866 MHz GSkill Ram Using Eclipse Version: Kepler Service
 *         Release 2
 */
public class MainForm implements ActionListener {

	private static final String TITLE = "Reservation Manager";
	private static final int TEXT_HEIGHT = 10;
	private static final int TEXT_WIDTH = 40;

	public static void initGUI() {
		JFrame f = new JFrame(TITLE);
		f = Boxify(f);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	private static JFrame Boxify(JFrame f) {
		JPanel radioPane = new JPanel();
		radioPane.setLayout(new BoxLayout(radioPane, BoxLayout.Y_AXIS));
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.X_AXIS));
		JPanel searchPane = new JPanel();
		searchPane.setLayout(new BoxLayout(searchPane, BoxLayout.X_AXIS));
		JPanel textPane = new JPanel();
		JMenuBar mb = new JMenuBar();

		JMenu menuFile = new JMenu("File");
		JMenuItem itemFile = new JMenuItem("Exit");
		itemFile.addActionListener(new MainForm());
		menuFile.add(itemFile);
		mb.add(menuFile);

		JTextArea searchBox = new JTextArea();
		JButton buttonSearch = new JButton("Search");
		buttonSearch.addActionListener(new MainForm());
		searchPane.add(searchBox);
		searchPane.add(buttonSearch);

		ButtonGroup radios = new ButtonGroup();
		JRadioButton radioContains = new JRadioButton("Contains text");
		radioContains.addActionListener(new MainForm());

		radioContains.setSelected(true);
		JRadioButton radioStarts = new JRadioButton("Begins with text");
		radioStarts.addActionListener(new MainForm());
		JRadioButton radioDate = new JRadioButton("Search by Date");
		radioDate.addActionListener(new MainForm());

		radios.add(radioContains);
		radios.add(radioStarts);
		radios.add(radioDate);
		radioPane.add(radioContains);
		radioPane.add(radioStarts);
		radioPane.add(radioDate);

		JTextArea text = new JTextArea();
		text.setColumns(TEXT_WIDTH);
		text.setRows(TEXT_HEIGHT);
		text.setEditable(false);
		textPane.add(text);

		JButton buttonClear = new JButton("Clear");
		JButton buttonExit = new JButton("Exit");

		buttonPane.add(buttonClear);
		buttonClear.addActionListener(new MainForm());

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
			break;
		default:
			System.out.println("That action is not yet handled");
			break;
		}
	}
}
