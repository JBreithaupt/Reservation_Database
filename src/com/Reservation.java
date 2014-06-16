package com;

import java.io.Serializable;

import Calendar.DateAD;

/**
 * Reservation object to hold a name, date arrava, and date depart.
 * 
 * @author Christopher Dombroski
 * @version 1.0
 * 
 *          Tested version 1.0 on: AMD A-8 3850 8 gig DDR3 RAM Windows 7
 *          Ultimate
 */
public class Reservation implements Serializable, Comparable<Reservation> {

	private static final long serialVersionUID = 1L;
	private String name;
	private DateAD dateArrival;
	private DateAD dateDepart;

	final static byte COMPARE_BY_NAME = 0;
	final static byte COMPARE_BY_DEPART = 1;
	final static byte COMPARE_BY_ARRIVAL = 2;

	byte compareBy = COMPARE_BY_NAME;

	private final static String newline = System.lineSeparator();

	/**
	 * Constructor for making a new Reservation.
	 * 
	 * @param name
	 *            The name of the reservation.
	 * @param dateArrival
	 *            The date of arrival as a DateAD.
	 * @param dateDepart
	 *            The date of departure as a DateAD.
	 */
	Reservation(String name, DateAD dateArrival, DateAD dateDepart) {
		this.name = name;
		this.dateArrival = dateArrival.clone();
		this.dateDepart = dateDepart.clone();
	}

	/**
	 * Acessor for name.
	 * 
	 * @return The reservation name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Acessor for date of arrival.
	 * 
	 * @return The reservation date of arrival.
	 */
	public DateAD getDateArrival() {
		return dateArrival.clone();
	}

	/**
	 * Acessor for date of depart.
	 * 
	 * @return The reservation date of depart.
	 */
	public DateAD getDateDepart() {
		return dateDepart.clone();
	}

	/**
	 * Returns a four line string: name, arrive, depart, blank. example: foobar
	 * Sunday, 1 June, 2014 Wednesday, 4 June, 2014
	 * 
	 */
	@Override
	public String toString() {

		return name + newline + getDateArrival().toString() + newline
				+ getDateDepart().toString() + newline;
	}

	/**
	 * Returns true if the reservations contain the same information.
	 */
	@Override
	public boolean equals(Object reservation) {
		Reservation res = (Reservation) reservation;
		boolean equals = false;

		if (this.name == res.name && this.dateArrival.equals(res.dateArrival)
				&& this.dateDepart.equals(dateDepart))
			equals = true;

		return equals;
	}

	/**
	 * compares first by name, then by arrival, then by departure. returns -1 if
	 * the current object comes before, 0 if equal, 1 if it comes after.
	 * Utilizes the compareTo method of the component properties. throws a
	 * java.lang.ClassCastException if the two objects are not both
	 * Reservations.
	 */
	@Override
	public int compareTo(Reservation reservation) {
		int compare = 0;

		switch (compareBy) {
		case COMPARE_BY_NAME:
			compare = this.getName().compareToIgnoreCase(reservation.getName());
			if (compare == 0) {
				compare = this.getDateArrival().compareTo(
						reservation.getDateArrival());
			}
			if (compare == 0) {
				compare = this.getDateDepart().compareTo(
						reservation.getDateDepart());
			}
			break;
		case COMPARE_BY_DEPART:
			compare = this.getDateDepart().compareTo(
					reservation.getDateDepart());
			if (compare == 0) {
				compare = this.getDateArrival().compareTo(
						reservation.getDateArrival());
			}
			if (compare == 0) {
				compare = this.getName().compareToIgnoreCase(
						reservation.getName());
			}
			break;
		case COMPARE_BY_ARRIVAL:
			compare = this.getDateArrival().compareTo(
					reservation.getDateArrival());
			if (compare == 0) {
				compare = this.getDateDepart().compareTo(
						reservation.getDateDepart());
			}
			if (compare == 0) {
				compare = this.getName().compareToIgnoreCase(
						reservation.getName());
			}
			break;
		}

		return compare;
	}
	
	public static void setCompare(Reservation[] reservations, byte compare) {
		
		for (Reservation res : reservations) {
			
			res.compareBy = compare;
		}
	}
}
