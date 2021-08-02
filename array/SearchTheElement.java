/*
 * Check whether n is present in an array of size m or not.
 * Input - n,m (Input number, size of array)
 * - Take input n elements for the array
 * Output -> true/false
 * [ Hint : - Create a dynamic array]
 * */

package array;

import java.util.Scanner;

public class SearchTheElement {
	public boolean search(int[] arr, int m) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==m) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array and the element which you want to search");
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter the "+n+" elements of an array");
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		SearchTheElement se = new SearchTheElement();
		System.out.println(se.search(arr,m));

	}

}
