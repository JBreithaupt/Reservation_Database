package com;

import java.util.List;

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
	 * Name: 0 
	 * Arrival Date: 1 
	 * Departure Date: 2 
	 * Partial Name: 3
	 */
	private byte toSearchFor = 0;

	public static final byte NAME = 0;
	public static final byte ARRIVAL = 1;
	public static final byte DEPARTURE = 2;
	public static final byte PARTIAL = 3;

	private List<Reservation> reservationList;
	private List<Reservation> matchingList;

	/**
	 * converts a Reservation array to a List.
	 * 
	 * @param reservationArray
	 *            a Reservation array
	 */
	private void toList(Reservation[] reservationArray, int sortBy) {
		switch (sortBy) {
		case 0:
		case 3:
			for (int i = 0; i < reservationArray.length; i++) {
				reservationList.add(reservationArray[Database.nameSort[i]]);
			}
			break;
		case 1:
			for (int i = 0; i < reservationArray.length; i++) {
				reservationList
						.add(reservationArray[Database.dateArriveSort[i]]);
			}
			break;
		case 2:
			for (int i = 0; i < reservationArray.length; i++) {
				reservationList
						.add(reservationArray[Database.dateDepartSort[i]]);
			}
			break;
		}
	}

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
	 * 
	 *            anArray of Reservations
	 * @param nameToFind
	 *            the Name being searched for.
	 * @return
	 */

	private void binarySearch(String nameToFind, byte typeOfSearch) {
		List<Reservation> newList = null;
		switch (typeOfSearch) {
		case 0:
			while (reservationList.size() > 2) {
				int midpoint = reservationList.size() / 2;
				if (reservationList.get(midpoint).getName().toLowerCase() != nameToFind
						.toLowerCase()) {
					if (reservationList.get(midpoint).getName()
							.compareToIgnoreCase(nameToFind) < 0) {
						newList = reservationList.subList(0, midpoint);
						reservationList.clear();
						reservationList = newList;
					} else {
						newList = reservationList.subList(midpoint,
								reservationList.size());
						reservationList.clear();
						reservationList = newList;
					}
				} else {
					matchingList.add(reservationList.get(midpoint));
				}
			}
			if (reservationList.get(1).getName()
					.compareToIgnoreCase(nameToFind) == 0) {
				newList.add(reservationList.get(1));
			}
			if (reservationList.get(2).getName()
					.compareToIgnoreCase(nameToFind) == 0) {
				newList.add(reservationList.get(2));
			}

		case 1:

			while (reservationList.size() > 2) {
				int midpoint = reservationList.size() / 2;

				if (!reservationList.get(midpoint).getName().toLowerCase()
						.contains(nameToFind.toLowerCase())) {
					if (reservationList.get(midpoint).getName()
							.compareToIgnoreCase(nameToFind) < 0) {
						newList = reservationList.subList(0, midpoint);
						reservationList.clear();
						reservationList = newList;
					} else {
						newList = reservationList.subList(midpoint,
								reservationList.size());
						reservationList.clear();
						reservationList = newList;
					}
				} else {
					matchingList.add(reservationList.get(midpoint));
				}
			}
			if (reservationList.get(1).getName()
					.contains(nameToFind.toLowerCase())) {
				newList.add(reservationList.get(1));
			}
			if (reservationList.get(2).getName()
					.contains(nameToFind.toLowerCase())) {
				newList.add(reservationList.get(2));
			}
		}
	}

	/**
	 * 
	 * @param reservationArray
	 *            the Array to Search
	 * @param dateToFind
	 *            the Date to find
	 * @param typeOfSearch
	 *            the type of search either 1 or 2 for this search.
	 * @return /* I think this is the wrong way to search for the dates since I
	 *         can't override the method with 2 methods only have the DateAD
	 *         param and Comparable[] param, I'm thinking I may just use a built
	 *         in search for those two.
	 */
	private void binarySearch(DateAD dateToFind, byte typeOfSearch) {
		return false;

	}

	public Reservation[] search(Object toFind, byte typeOfSearch) {
		toList(Database.reservations, typeOfSearch);
		
		if (typeOfSearch == NAME || typeOfSearch == PARTIAL) {
			binarySearch((String) toFind, typeOfSearch);
		} else if (typeOfSearch == ARRIVAL || typeOfSearch == DEPARTURE) {
			binarySearch((DateAD) toFind, typeOfSearch);
		}
		Reservation[] out = new Reservation[matchingList.size()];
		for (int i = 0; i < matchingList.size(); i++) {
			out[i] = matchingList.get(i);
		}
		return out;
	}
}
