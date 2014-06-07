package GUI;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

/**
 *
 * @author Joe Breithaupt
 */
public class MainForm {

    private static final String TITLE = "Reservation Manager";
    private static final int TEXT_HEIGHT = 10;
    private static final int TEXT_WIDTH = 40;

    public static void main(String[] args) {
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
        menuFile.add(itemFile);
        mb.add(menuFile);
        
        JTextArea searchBox = new JTextArea();
        JButton buttonSearch = new JButton("Search");
        searchPane.add(searchBox);
        searchPane.add(buttonSearch);
        

        ButtonGroup radios = new ButtonGroup();
        JRadioButton radioContains = new JRadioButton("Contains text");
        radioContains.setSelected(true);
        JRadioButton radioStarts = new JRadioButton("Begins with text");
        radios.add(radioContains);
        radios.add(radioStarts);
        radioPane.add(radioContains);
        radioPane.add(radioStarts);

        JTextArea text = new JTextArea();
        text.setColumns(TEXT_WIDTH);
        text.setRows(TEXT_HEIGHT);
        text.setEditable(false);
        textPane.add(text);

        
        JButton buttonClear = new JButton("Clear");
        JButton buttonExit = new JButton("Exit");
        
        buttonPane.add(buttonClear);
        buttonPane.add(buttonExit);

        f.setJMenuBar(mb);
        f.add(searchPane, BorderLayout.NORTH);
        f.add(radioPane, BorderLayout.EAST);
        f.add(textPane, BorderLayout.CENTER);
        f.add(buttonPane, BorderLayout.SOUTH);
        f.pack();
        return f;
    }
}
