/*
 * Time Complexity --> Best Case (O(n*log(n)))
 *                 --> Worst Case (O(n*n))
 * Space Complexity --> O(1)                
 * */
package sorting;

public class QuickSort {
	public static int partition(int[] arr, int lb, int ub) {
		int pivot = arr[lb];
		int start = lb;
		int end = ub;
		while(start<end) {
			while(arr[start]<=pivot) {
				start++;
			}
			while(arr[end]>pivot) {
				end--;
			}
			
			if(start<end) {
				int temp = arr[start];
				arr[start] = arr[end];
				arr[end] = temp;
			}
		}
		int temp = arr[lb];
		arr[lb] = arr[end];
		arr[end] = temp;
		
		return end;
	}
	public void quickSort(int[] arr, int lb, int ub) {
		if(lb<ub) {
			int loc = partition(arr, lb, ub);
			quickSort(arr, lb, loc-1);
			quickSort(arr, loc+1, ub);
		}
	}
	public static void main(String[] args) {
		int[] arr = {10, 15, 1, 2, 9, 16, 11};
		System.out.println("Array before sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		QuickSort cs = new QuickSort();
		cs.quickSort(arr, 0, arr.length-1);
		System.out.println("\n\nArray after sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}

	}

}
