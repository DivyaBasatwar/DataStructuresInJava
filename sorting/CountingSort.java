package sorting;

public class CountingSort {
	public int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	public void countingSort(int[] arr) {
		int k = this.getMax(arr);
		int[] count = new int[k+1];
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		
		int[] b = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			b[--count[arr[i]]] = arr[i]; 
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = b[i];
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
		System.out.println("Array before sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		CountingSort cs = new CountingSort();
		cs.countingSort(arr);
		System.out.println("\n\nArray after sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		
	}

}
