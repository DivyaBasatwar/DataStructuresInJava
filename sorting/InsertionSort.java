package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {48,36,13,52,19,94,21};
		System.out.println("Array Before Sorting -->");
    	for(int no:arr) {
    		System.out.print(no+"  ");
    	}
    	
    	for(int i=1;i<arr.length;i++) {
    		int temp = arr[i];
    		int j = i-1;
    		while(j>=0 && arr[j]>temp) {
    			arr[j+1] = arr[j];
    			j--;
    		}
    		arr[j+1] = temp;
    	}
    	
    	System.out.println("\n\nArray After Sorting -->");
    	for(int no:arr) {
    		System.out.print(no+"  ");
    	}

	}

}
