/*
 * Time Complexity --> O(n*log(n))   (Best Case As Well As Worst Case)
 * Space Complexity --> O(n)
 * */
package sorting;

public class MergeSort {
	   public static void main(String[] args) {
	    	int[] arr = {48,36,13,52,19,94,21};
	    	int[] temp = new int[arr.length];
	    	System.out.println("Array Before Sorting -->");
	    	for(int no:arr) {
	    		System.out.print(no+"  ");
	    	}
	    	MergeSort ms = new MergeSort();
	    	ms.mergeSort(arr,temp,0,arr.length-1);
	    	System.out.println("\n\nArray After Sorting,");
	    	for(int i=0;i<arr.length;i++) {
	    		System.out.print(arr[i]+"  ");
	    	}
	    }
	    
	    public void mergeSort(int[] arr, int[] temp, int left, int right) {
	    	if(left<right) {
	    		int mid = (left+right)/2;
	    		
	    		mergeSort(arr,temp,left,mid);
	    		mergeSort(arr,temp,mid+1,right);
	    		merge(arr,temp,left,mid+1,right);
	    		
	    	}
	    	
	    }
	    
	    public void merge(int[] arr,int[] temp, int left, int mid, int right) {
	    	int i=left,j=mid,k=left;
	    	while(i<=mid-1 && j<=right) {
	    		if(arr[i]<=arr[j]) {
	    			temp[k++] = arr[i++];
	    		}
	    		else {
	    			temp[k++] = arr[j++];
	    		}
	    	}
	    	while(i<=mid-1) {
	    		temp[k++] = arr[i++];
	    	}
	    	while(j<=right) {
	    		temp[k++] = arr[j++];
	    	}
	    	
	    	for(int m=left;m<=right;m++) {
	    		arr[m] = temp[m];
	    	}
	    }
			
}
