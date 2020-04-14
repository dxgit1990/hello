package com.els.compute;

import java.awt.print.Printable;

import javax.swing.text.ChangedCharSetException;

/**
 * 排序算法
 * 
 * @author dengxu
 *
 */
public class Test1 {
	public static void main(String[] args) {
		int[] arr = { 7, 5, 9, 1, 21, 44, 8, 10, 23, 15 };

//		testSelect(arr);
//		testMaoPao(arr);
		testInsert(arr);

		print(arr);
	}

	private static void testInsert(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					change(arr, j - 1, j);
				}
			}
		}
	}

	private static void testMaoPao(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					change(arr, j, j + 1);
				}
			}
		}
	}

	private static void testSelect(int[] arr) {
		for (int j = 0; j < arr.length - 1; j++) {
			int minPosition = j;
			for (int i = j + 1; i < arr.length; i++) {
//				if (arr[i] < arr[minPosition]) {
//					minPosition = i;
//				}
				minPosition = arr[i] < arr[minPosition] ? i : minPosition;
			}
			change(arr, j, minPosition);
		}
	}

	private static void change(int[] arr, int j, int minPosition) {
		int temp = arr[j];
		arr[j] = arr[minPosition];
		arr[minPosition] = temp;
	}

	private static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.err.print(arr[i] + " ");
		}
	}
}
