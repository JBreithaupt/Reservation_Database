package com;

import java.awt.Frame;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.*;

public class ReservationDatabase {

	public static void main(String[] args) {

		File database = null;

		if (args.length > 0) {

			for (int i = 0; i < args.length; i++) {
				database = new File(args[i].toLowerCase());
			}

		} else {

			JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Reservation Binary file", "dat");
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
		Database.sortAll();
		MainForm.initGUI();
	}

}