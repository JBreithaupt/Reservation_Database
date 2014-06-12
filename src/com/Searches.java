package com;

import Calendar.DateAD;

/**
 * Searches.java /src/com/Searches
 * 
 * @version 1.0
 * @author Bradley A class to contain all searches needed for project 4.
 *         Compiled in JDK 8 Tested on: Windows 8.1 (SP 1) AMD 8350 @ 4.26 GHZ
 *         16 GB 1866 MHz GSkill Ram Using Eclipse Version: Kepler Service
 *         Release 2
 * 
 */
public class Searches {

	/**
	 * 
	 * @param reservationArray
	 *            anArray of Reservations
	 * @param nameToFind
	 *            the Name being searched for.
	 * @return
	 */
	public boolean binarySearch(Reservation[] reservationArray,
			String nameToFind) {
		int midpoint = reservationArray.length / 2;
		while (reservationArray[midpoint].getName() != nameToFind) {

		}

		return false;
	}

	/*
	 * I think this is the wrong way to search for the dates since I can't
	 * override the method with 2 methods only have the DateAD param and
	 * Comparable[] param, I'm thinking I may just use a built in search for
	 * those two.
	 */
	public boolean binarySearch(Comparable[] reservationArray, DateAD dateToFind) {
		return false;
	}
}
