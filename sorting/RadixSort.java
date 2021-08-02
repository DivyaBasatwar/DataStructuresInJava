package sorting;

public class RadixSort {
	public int getMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	public void countingSort(int[] arr, int pass) {
		int[] count = new int[10];
		for(int i=0;i<arr.length;i++) {
			count[(arr[i]/pass)%10]++;
		}
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		
		int[] b = new int[arr.length];
		for(int i=arr.length-1;i>=0;i--) {
			b[--count[(arr[i]/pass)%10]] = arr[i]; 
		}
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = b[i];
		}
	}
	public void radixSort(int[] arr) {
		int max = this.getMax(arr);
		for(int pass=1; max/pass>0; pass*=10) {
			this.countingSort(arr, pass);
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,1,1,0,2,5,4,223,54,0,2,8,7,7,9,2,0,1,9};
		System.out.println("Array before sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		RadixSort rs = new RadixSort();
		rs.radixSort(arr);
		System.out.println("\n\nArray after sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}

	}

}
