package searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void binarySearch(int[] arr, int key, int beg, int end){
		
		boolean found = false;
		while(beg<=end && found==false) {
			int mid = (beg+end)/2;
			if(arr[mid]==key) {
				found = true;
				break;
			}
			else if(arr[mid]<key){
				beg = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		
		if(found==true) {
			System.out.println("Element found in the list");
		}
		else {
			System.out.println("Element does not found in the list");
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = {10,20,30,25,16,18};
		System.out.print("Enter the element which you want to search ==> ");
		int key = sc.nextInt();
		sc.close();
		Arrays.parallelSort(arr);
		binarySearch(arr, key, 0, arr.length-1);

	}

}
