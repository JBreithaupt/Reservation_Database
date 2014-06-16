package com;

import java.awt.Frame;
import java.io.File;

import javax.swing.JFileChooser;

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
			int returnVal = JFileChooser.CANCEL_OPTION;
			returnVal = fc.showOpenDialog(new Frame());

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				database = fc.getSelectedFile();
			} else {
				System.exit(0);
			}

		}

		Database.load(database);
		MainForm.initGUI();
	}

}