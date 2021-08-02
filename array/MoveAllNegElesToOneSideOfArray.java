package array;

public class MoveAllNegElesToOneSideOfArray {

	public static void main(String[] args) {
		
		int[] arr = {-1,3,-2,1,7,22,8,2,3-9,-4};
		
		int neg = 0, pos = arr.length-1;
		
		while(neg<pos) {
			if(arr[neg]<0) {
				neg++;
			}
			if(arr[pos]>0) {
				pos--;
			}
			if(arr[neg]>0 && arr[pos]<0) {
				int temp = arr[neg];
				arr[neg]  = arr[pos];
				arr[pos] = temp;
				
				neg++;
				pos--;
			}
			
		}
		
		System.out.println("Array after sagragation");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
