package array;

import java.util.Scanner;

public class NoOfOccurencesOfN {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,3,3,3,4,1,5};
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();
		
		int count=0;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==N) {
				count++;
			}
		}
		
		System.out.println(N+" occur "+count+" times in the given array");

	}

}
