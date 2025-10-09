package org.example; /**
 * LS2BArrays.ArrayUtilities class contains methods to generate random numbers array, print array, sum array, average array, max array, and min array.
 *
 * @Author: Niklas Fabritzius
 */

import java.util.Arrays;

public class ArrayUtilities {
	public static void main(String[] args) {

		int[] array = randomNumbersArray(10, 1, 100000);

		printArray(array);
		sumArray(array);
		averageArray(array);
		maxArray(array);
		minArray(array);
		System.out.println();


		bubbleSort(array);
		selectionSort(array);
		insertionSort(array);
		quickSort(array);
		System.out.println();
	}

	public static int[] randomNumbersArray(int size, int minValue, int maxValue) {
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = minValue + (int) (Math.random() * ((maxValue - minValue) + 1));
		}
		return array;
	}

	public static void printArray(int[] array) {

		System.out.println("Array: " + Arrays.toString(array));
		System.out.println();

	}

	public static int sumArray(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		System.out.println("Sum: " + sum);
		return sum;
	}

	public static double averageArray(int[] array) {
		int sum = sumArray(array);
		double average = (double) sum / array.length;
		System.out.println("Average: " + average);
		return average;
	}

	public static int maxArray(int[] array) {
		int max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("Max: " + max);
		return max;
	}

	public static int minArray(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("Min: " + min);
		return min;
	}

	public static int[] bubbleSort(int[] array) {
		boolean checked = true;

		while (checked) {
			checked = false;

			// Iterate over every Number in Array and compare it with right neighbour
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					int tempValue = array[i];

					array[i] = array[i + 1];
					array[i + 1] = tempValue;

					checked = true;
				}
			}
		}

		System.out.println("Bubblesort Result:");
		printArray(array);
		return array;
	}

	public static int[] selectionSort(int[] array) {
		for (int currentIndex = 0; currentIndex < array.length - 1; currentIndex++) {
			int minIndex = currentIndex;

			for (int j = currentIndex + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			// Swap the found minimum element with the current element
			if (minIndex != currentIndex) {
				int temp = array[currentIndex];
				array[currentIndex] = array[minIndex];
				array[minIndex] = temp;
			}
		}

		System.out.println("Selectionsort Result:");
		printArray(array);
		return array;
	}

	public static int[] insertionSort(int[] array) {

		// Loop through the array starting from index 1
		for (int i = 1; i < array.length; i++) {
			// Store the current value to be compared
			int currentValue = array[i];
			int j = i - 1;

			while (j >= 0 && array[j] > currentValue) {
				array[j + 1] = array[j];
				j--;
			}

			// Insert the current value at its correct position
			array[j + 1] = currentValue;
		}

		System.out.println("Insertionsort Result:");
		printArray(array);
		return array;
	}

	public static void quickSort(int[] array) {
		quickSort(array, 0, array.length - 1);
		System.out.println("Quicksort Result: ");
		printArray(array);
	}

	private static void quickSort(int[] array, int low, int high) {
		if (low < high) {
			int pivot = array[high];
			int i = low - 1;

			for (int j = low; j < high; j++) {
				if (array[j] < pivot) {
					i++;
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}

			int temp = array[i + 1];
			array[i + 1] = array[high];
			array[high] = temp;

			int pivotIndex = i + 1;

			quickSort(array, low, pivotIndex - 1);  // Recursively sort left half
			quickSort(array, pivotIndex + 1, high); // Recursively sort right half
		}
	}
}