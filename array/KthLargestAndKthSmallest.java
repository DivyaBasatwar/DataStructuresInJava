package array;

import java.util.Scanner;

public class KthLargestAndKthSmallest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of k:- ");
		int k = sc.nextInt();
		sc.close();
		
		int[] arr = {1,2,3,4,5,9,6,33,12,8};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]<arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
			if(i==k-1) {
				System.out.println(k+"th largest element from the given array is:-  "+arr[i]);
				break;
			}
		}
	
	}

}
