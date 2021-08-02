package array;

public class SortArraysOf0s1sAnd2s {

	public static void main(String[] args) {
		int[] arr = {0,0,1,2,0,1,2,1};
		
		int low=0, mid=0, high=arr.length-1;

		while(mid<high) {
			if(arr[mid]==0) {
				int temp = arr[mid];
				arr[mid] = arr[low];
				arr[low] = temp;
				low++;
				mid++;
			}
			if(arr[mid]==1) {
				mid++;
			}
			if(arr[mid]==2) {
				int temp = arr[mid];
				arr[mid] = arr[high];
				arr[high] = temp;
				high--;
			}
		}
		
		System.out.println("Array after sorting");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
	}

}
