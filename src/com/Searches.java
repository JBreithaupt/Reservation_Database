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

	/*
	 * A private byte representing the possible choices of what to search for.
	 * Name: 0 Arrival Date: 1 Departure Date: 2 Partial Name: 3
	 */
	private byte toSearchFor = 0;

	public static final byte NAME = 0;
	public static final byte ARRIVAL = 1;
	public static final byte DEPARTURE = 2;
	public static final byte PARTIAL = 3;


	/**
	 * @return the toSearchFor
	 */
	public byte getToSearchFor() {
		return this.toSearchFor;
	}

	/**
	 * @param toSearchFor
	 *            the toSearchFor to set
	 */
	public void setToSearchFor(byte toSearchFor) {
		this.toSearchFor = toSearchFor;
	}

	/**
	 * Performs binary search on the reservation array
	 * 
	 * @param reservationArray
	 *            the array to search
	 * @param nameToFind
	 *            the string representing either the name or parial name
	 * @param typeOfSearch
	 *            the byte representing the type of search either 0 or 3 for
	 *            this search

	 *            anArray of Reservations
	 * @param nameToFind
	 *            the Name being searched for.
	 * @return
	 */

	private boolean binarySearch(String nameToFind, byte typeOfSearch) {
		boolean out = false;
		
		Reservation[] reservationArray = null;
		// this variable was missing and I did not see it in any classes -Joe
		// TODO: properly initialize the array

		int midpoint = reservationArray.length / 2;

		switch(typeOfSearch) {
		case 0:
			while (reservationArray[midpoint].getName() != nameToFind) {

			}
			break;
		case 1:

		while (reservationArray[midpoint].getName() != nameToFind) {


		}
		}

		return out;
	}


	/**
	 * 
	 * @param reservationArray
	 *            the Array to Search
	 * @param dateToFind
	 *            the Date to find
	 * @param typeOfSearch
	 *            the type of search either 1 or 2 for this search.
	 * @return
	/*
	 * I think this is the wrong way to search for the dates since I can't
	 * override the method with 2 methods only have the DateAD param and
	 * Comparable[] param, I'm thinking I may just use a built in search for
	 * those two.

	 */
	private boolean binarySearch(DateAD dateToFind, byte typeOfSearch) {
		return false;

	}

	public boolean search(Object toFind, byte typeOfSearch) {
		boolean out = false;
		if (typeOfSearch == NAME || typeOfSearch == PARTIAL) {
			out = binarySearch((String) toFind, typeOfSearch);
		} else if (typeOfSearch == ARRIVAL || typeOfSearch == DEPARTURE) {
			out = binarySearch((DateAD) toFind, typeOfSearch);
		}
		return out;
	}
}
