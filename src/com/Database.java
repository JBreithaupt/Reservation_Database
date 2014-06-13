package com;

import java.io.*;

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
	public boolean load(File file) {
		
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
	
	

}
