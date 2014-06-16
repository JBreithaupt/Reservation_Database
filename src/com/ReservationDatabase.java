package com;

import java.awt.Frame;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.*;

/**
 * Loads in a database file, if the file does not exist it requests a file from
 * user.
 * 
 * @author Christopher
 * 
 */
public class ReservationDatabase {

	public static void main(String[] args) {

		File database = null;

		if (new File("Bookings_db.dat").exists()) {

			database = new File("Bookings_db.dat");

		} else {

			JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter(
					"Reservation Binary file", "dat");
			fc.setFileFilter(filter);
			int returnVal = JFileChooser.CANCEL_OPTION;
			returnVal = fc.showOpenDialog(new Frame());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				database = fc.getSelectedFile();
			} else {
				System.exit(0);
			}

		}

		Database.load(database);
		Database.print();
		Database.sortAll();
		MainForm.initGUI();
	}

}