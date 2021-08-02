/*
 * 3) Find the minimum and maximum element in an array.
 */
package array;

import java.util.Scanner;

public class MinAndMax {
	public void minAndMax(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		System.out.println("MAX : "+max+"\nMIN : "+min);
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
		
		MinAndMax mm = new MinAndMax();
		mm.minAndMax(arr);
	}

}
