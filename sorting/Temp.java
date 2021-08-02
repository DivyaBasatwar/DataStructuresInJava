package sorting;

public class Temp {
	void temp(int[] brr) {
		brr[2] = 144;
	}
	public static void main(String[] args) {
		Temp t = new Temp();
		int[] arr = {1,2,4,5,6};
		for(int i:arr) {
			System.out.println(i+" ");
		}
		
		t.temp(arr);
		
		System.out.println();
		for(int i:arr) {
			System.out.println(i+" ");
		}
	}

}
