/*
 * 1) Create an Array of size 10 of integers. Take input from the user for these
 * 10 elements and print the entire array after that.
*/
package array;
import java.util.Scanner;
public class OneDArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of array ==> ");
		int n = sc.nextInt();
		if(n<=0) {
			System.out.println("Array size should be greater than zero");
			sc.close();
			return;
		}
		int[] arr = new int[n];
		System.out.println("Enter the "+n+" elements of an array");
		for(int i=0;i<n;i++) {
			arr[i] =sc.nextInt();
		}
		sc.close();
		System.out.println("\nArray Elements Are..");
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum += arr[i];
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		double avg = (double)sum/n;
		System.out.print("\nAverage of all elements of an array is ==> "+avg);
	}

}
