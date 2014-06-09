package com;

import java.util.Arrays;

/**
 * Sorting of a comparable array.
 * @author Christopher Dombroski
 * @version 1.0
 *
 *Tested version 1.0 on:
 *AMD A-8 3850
 *8 gig DDR3 RAM
 *Windows 7 Ultimate
 */
@SuppressWarnings("rawtypes")
public class Sorts {

	/**
	 * Perform an optimized quicksort on the given array.
	 * 
	 * @param array
	 *            The array to sort.
	 */
	public static void quickSort(Comparable[] array) {
		quickSort(array, 0, array.length - 1);
	}

	/**
	 * Perform an optimized quicksort on the given array.
	 * 
	 * @param array
	 *            The array to sort.
	 * @param from
	 *            left (inclusive)
	 * @param to
	 *            right (inclusive)
	 */
	public static void quickSort(Comparable[] array, int from, int to) {
		if (array.length < 4 || to + 1 - from < 4) {
			insertionSort(array, from, to);
		} else {
			int part = partition(array, from, to);
			quickSort(array, from, part - 1);
			quickSort(array, part + 1, to);
		}
	}

	/**
	 * Perform an insertion sort on the given array.
	 * 
	 * @param array
	 *            The array to sort.
	 * @param from
	 *            left (inclusive)
	 * @param to
	 *            right (inclusive)
	 */
	public static void insertionSort(Comparable[] array, int from, int to) {
		Arrays.sort(array, from, to + 1);
	}

	/**
	 * Perform a partition for quicksort.
	 * 
	 * @param array
	 *            the array to partition
	 * @param from
	 *            (inclusive)
	 * @param to
	 *            (inclusive)
	 * @return The new pivot
	 */
	@SuppressWarnings("unchecked")
	public static int partition(Comparable[] array, int from, int to) {
		int pivot = (to - from) / 2 + from;
		sortFirstMiddleLast(array, from, pivot, to);
		Comparable pivotValue = array[pivot];
		swap(array, pivot, to - 1);

		int left = from;
		int right = to - 1;
		while (left < right) {
			while (array[left].compareTo(pivotValue) < 1) {
				left++;
				while (array[right].compareTo(pivotValue) > -1) {
					right--;
				}
				if (left > right) {
					break;
				}

			}
			if (left <= right) {
				swap(array, left, right);
			}
		}

		swap(array, left, to - 1);
		return left;
	}

	/**
	 * Swap two values in a given array.
	 * 
	 * @param array
	 *            The array to swap to and from.
	 * @param from
	 *            index to swap
	 * @param to
	 *            index to swap
	 */
	public static void swap(Comparable[] array, int from, int to) {
		Comparable temp = array[to];
		array[to] = array[from];
		array[from] = temp;
	}

	/**
	 * Sort the front, pivot, end of an array.
	 * 
	 * @param array
	 *            The array to sort
	 * @param from
	 * @param mid
	 * @param to
	 */
	public static void sortFirstMiddleLast(Comparable[] array, int from,
			int mid, int to) {
		Comparable[] temp = new Comparable[] { array[from], array[mid],
				array[to] };
		insertionSort(temp, 0, 2);
		array[from] = temp[0];
		array[mid] = temp[1];
		array[to] = temp[2];
	}
}
