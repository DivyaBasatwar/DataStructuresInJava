package sorting;

public class HeapSort {
	public void heapSort(int[] arr) {
		int len = arr.length; 

        // Build heap (rearrange array) 
        for (int i = len / 2 - 1; i >= 0; i--) 
        maxHeapify(arr, len, i); 

        // One by one extract an element from heap 
        for (int i=len-1; i>=0; i--) 
              { 
                // Move current root to end 
                 int temp = arr[0]; 
                 arr[0] = arr[i]; 
                 arr[i] = temp; 

                  // call max heapify on the reduced heap 
                  maxHeapify(arr, i, 0); 
              } 
	}
	void maxHeapify(int[] arr, int len, int i) {
		int largest = i; // Initialize largest as root 
        int l = 2*i + 1; // left = 2*i + 1 
        int r = 2*i + 2; // right = 2*i + 2 

         // If left child is larger than root 
         if (l < len && arr[l] > arr[largest]) 
         largest = l; 

         // If right child is larger than largest so far 
         if (r < len && arr[r] > arr[largest]) 
         largest = r; 

         // If largest is not root 
         if (largest != i) 
               { 
                  int swap = arr[i]; 
                  arr[i] = arr[largest]; 
                  arr[largest] = swap; 

                 // Recursively heapify the affected sub-tree 
                   maxHeapify(arr, len, largest); 
                 } 
	}
	public static void main(String[] args) {
		int[] arr = {10, 15, 1, 2, 9, 16, 11};
		System.out.println("Array before sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		HeapSort hs = new HeapSort();
		hs.heapSort(arr);
		System.out.println("\n\nArray after sorting,,");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
	}

}
