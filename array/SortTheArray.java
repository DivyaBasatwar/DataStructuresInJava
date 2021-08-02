/*
 * 5) Write a program to sort the given array.
 * Here I am using bubble sort
 */
package array;

import java.util.Scanner;

public class SortTheArray {
	public void sortTheArray(int[] arr) {
		for(int i=0;i<arr.length-1;i++) {
			//for()
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter "+n+" elements of an array");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		SortTheArray mm = new SortTheArray();
		mm.sortTheArray(arr);

	}

}
