package com;

import java.io.*;

/**
 * A class to load in Reservation objects from a binary file to an array.
 * 
 * @author Christopher Dombroski
 * @version 1.0
 * 
 *          Tested version 1.0 on: AMD A-8 3850 8 gig DDR3 RAM Windows 7
 *          Ultimate
 */
public class Database {

	static Reservation[] reservations;
	static int[] nameSort;
	static int[] dateArriveSort;
	static int[] dateDepartSort;

	/**
	 * 
	 * 
	 * @param file
	 * @return whether or not the file is loaded
	 */
	public static boolean load(File file) {

		boolean loaded = false;

		try {
			FileInputStream fileIn = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			reservations = (Reservation[]) in.readObject();
			in.close();
			fileIn.close();

			loaded = true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Read binary file " + file);

		return loaded;
	}
	
	public static void sortAll() {
		
		
		
	}

}
