package com;

import java.util.ArrayList;
import java.util.List;

import Calendar.DateAD;

/**
 * Searches.java /src/com/Searches
 * <p>
 * A class to contain all searches needed for project 4. Compiled in JDK 8
 * Tested on: Windows 8.1 (SP 1) AMD 8350 @ 4.26 GHZ 16 GB 1866 MHz GSkill Ram
 * Using Eclipse Version: Kepler Service Release 2
 * 
 * @version 1.0
 * @author Bradley
 */
public class Searches {

	/*
	 * A private byte representing the possible choices of what to search for.
	 * Name: 0 Arrival Date: 1 Departure Date: 2 Partial Name: 3
	 */
	private byte toSearchFor = 0;

	private List<Reservation> reservationList = new ArrayList<Reservation>();;
	private List<Reservation> matchingList = new ArrayList<Reservation>();

	/**
	 * converts a Reservation array to a List.
	 * 
	 * @param reservationArray
	 *            a Reservation array
	 */
	private void toList(Reservation[] reservationArray, int sortBy) {
		switch (sortBy) {
		case Reservation.NAME:
		case Reservation.PARTIAL_NAME:
			for (int i = 0; i < reservationArray.length; i++) {
				reservationList.add(Database.nameSort[i]);
			}
			break;
		case Reservation.ARRIVAL:
			for (int i = 0; i < reservationArray.length; i++) {
				reservationList
						.add(Database.dateArriveSort[i]);
			}
			break;
		case Reservation.DEPART:
			for (int i = 0; i < reservationArray.length; i++) {
				reservationList
						.add(Database.dateDepartSort[i]);
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
		case Reservation.NAME:
			while (reservationList.size() > 2) {
				int midpoint = reservationList.size() / 2;
				if (reservationList.get(midpoint).getName().toLowerCase() != nameToFind
						.toLowerCase()) {
					if (reservationList.get(midpoint).getName()
							.compareToIgnoreCase(nameToFind) < 0) {
						reservationList = reservationList.subList(0, midpoint);
					} else {
						reservationList = reservationList.subList(midpoint,
								reservationList.size());
					}
				} else {
					matchingList.add(reservationList.get(midpoint));
				}
			}
			if (reservationList.get(1).getName()
					.compareToIgnoreCase(nameToFind) == 0) {
				newList.add(reservationList.get(1));
			}
//			if (reservationList.get(2).getName()
//					.compareToIgnoreCase(nameToFind) == 0) {
//				newList.add(reservationList.get(2));
//			}

		case Reservation.PARTIAL_NAME:

			while (reservationList.size() > 2) {
				int midpoint = reservationList.size() / 2;

				if (!reservationList.get(midpoint).getName().toLowerCase()
						.contains(nameToFind.toLowerCase())) {
					if (reservationList.get(midpoint).getName()
							.compareToIgnoreCase(nameToFind) < 0) {
						reservationList = reservationList.subList(0, midpoint);
					} else {
						reservationList = reservationList.subList(midpoint,
								reservationList.size());
					}
				} else {
					matchingList.add(reservationList.get(midpoint));
				}
			}
			if (reservationList.get(1).getName().contains(
					nameToFind.toLowerCase())) {
				newList.add(reservationList.get(1));
			}
//			if (reservationList.get(2).getName().contains(
//					nameToFind.toLowerCase())) {
//				newList.add(reservationList.get(2));
//			}
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
	 */
	@SuppressWarnings("null")
	private void binarySearch(DateAD dateToFind, byte typeOfSearch) {
		List<Reservation> newList = null;
		switch (typeOfSearch) {
		case Reservation.ARRIVAL:
			while (reservationList.size() > 2) {
				int midpoint = reservationList.size() / 2;
				if (reservationList.get(midpoint).getDateArrival() != dateToFind) {
					if (reservationList.get(midpoint).getDateArrival()
							.compareTo(dateToFind) < 0) {
						reservationList = reservationList.subList(0, midpoint);
					} else {
						reservationList = reservationList.subList(midpoint,
								reservationList.size());
					}
				} else {
					matchingList.add(reservationList.get(midpoint));
				}
			}
			if (reservationList.get(1).getDateArrival().equals(dateToFind)) {
				newList.add(reservationList.get(1));
			}
			if (reservationList.get(2).getDateArrival().equals(dateToFind)) {
				newList.add(reservationList.get(2));
			}
			break;
		case Reservation.DEPART:
			while (reservationList.size() > 2) {
				int midpoint = reservationList.size() / 2;
				if (reservationList.get(midpoint).getDateDepart() != dateToFind) {
					if (reservationList.get(midpoint).getDateDepart()
							.compareTo(dateToFind) < 0) {
						reservationList = reservationList.subList(0, midpoint);
					} else {
						reservationList = reservationList.subList(midpoint,
								reservationList.size());
					}
				} else {
					matchingList.add(reservationList.get(midpoint));
				}
			}
			if (reservationList.get(1).getDateArrival().equals(dateToFind)) {
				newList.add(reservationList.get(1));
			}
			if (reservationList.get(2).getDateArrival().equals(dateToFind)) {
				newList.add(reservationList.get(2));
			}
			break;
		}

	}

	/**
	 * 
	 * @param toFind
	 *            the "object" we are looking for, either a String or DateAD
	 * @param typeOfSearch
	 *            the type of search as specified above.
	 * @return the reservation array that contains all Reservations matching the
	 *         search
	 */
	public Reservation[] search(Object toFind, byte typeOfSearch) {
		toList(Database.reservations, typeOfSearch);

		if (typeOfSearch == Reservation.NAME || typeOfSearch == Reservation.PARTIAL_NAME) {
			binarySearch((String) toFind, typeOfSearch);
		} else if (typeOfSearch == Reservation.ARRIVAL || typeOfSearch == Reservation.DEPART) {
			binarySearch((DateAD) toFind, typeOfSearch);
		}
		Reservation[] out = new Reservation[matchingList.size()];
		for (int i = 0; i < matchingList.size(); i++) {
			out[i] = matchingList.get(i);
		}
		return out;
	}
}
