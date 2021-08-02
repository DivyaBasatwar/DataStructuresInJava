/*
 * 4) Write a program to reverse the array.
 * */

package array;

import java.util.Scanner;

public class ReverseTheArray {
	public void reverseTheArray(int[] arr) {
		for(int i=0; i<arr.length/2;i++) {
			int temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		System.out.println("\nReversed Array");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
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
		
		ReverseTheArray ra = new ReverseTheArray();
		ra.reverseTheArray(arr);

	}

}
