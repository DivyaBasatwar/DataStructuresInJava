package searching;
import java.util.Scanner;
public class LinearSearch {
	public static void linearSearch(int[] arr, int key) {
		boolean found = false;
		int index = 0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==key) {
				found = true;
				index = i;
				break;
			}
		}
		
		if(found==true) {
			System.out.println("Key Element found in the list at index "+index);
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
		linearSearch(arr, key);
	}

}
