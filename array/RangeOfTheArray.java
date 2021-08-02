package array;

public class RangeOfTheArray {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,-1,22,5,6,-2};
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min = arr[i];
			}
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		System.out.println("Range Of The Array Is:-  "+Math.abs(min-max));

	}

}
