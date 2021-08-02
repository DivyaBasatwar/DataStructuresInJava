package sorting;

import java.util.Scanner;

public class SelectionSort {

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
			int min = i;              //min is index 
			for(int j=i+1;j<n;j++) {
				if(a[j]<a[min]) {
					min = j;
				}
			}
			if(min!=i) {
				int c=a[i];
				a[i] =a[min];
				a[min]=c;
			}
		}
		
		System.out.println("Elements after sorting are:");
		for(int i=0;i<n;i++) {
			System.out.print(a[i]+"  ");
		}

	}	

}
