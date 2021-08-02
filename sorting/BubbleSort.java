/*
 * Worst Case Time Complexity --> O(n*n)
 * Best Case that is if array is already sorted is--> O(n)  (Here we are using flag variable)
 * Space Complexity ---> O(1)
 * */
package sorting;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter how much elements you want to enter");
		int n = sc.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the array elements");
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		sc.close();
		for(int i=0;i<n-1;i++) {
			int flag=0;
			for(int j=0;j<n-1-i;j++) {
				if(a[j]>a[j+1]) {
					int c =a[j];
					a[j]=a[j+1];
					a[j+1]=c;
					flag=1;
				}
			}
			if(flag==0) {
				break;
			}
		}
		System.out.println("Elements after sorting are:");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+"  ");
		}

	}

}
