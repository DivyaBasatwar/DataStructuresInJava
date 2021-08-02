package array;
import java.util.Scanner;
public class TwoDArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows ==> ");
		int row = sc.nextInt();
		System.out.print("Enter the number of columns ==> ");
		int col = sc.nextInt();
		int[][] arr = new int[row][col];
		int[][] arr2 = new int[row][col];
		
		System.out.println("Enter the "+row*col+" elements of first matrix");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter the "+row*col+" elements of second matrix");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				arr2[i][j] = sc.nextInt();
			}
		}
		
		sc.close();
		
		System.out.println("------------------\nElements of first matrix are..");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("--------------------\nElements of second matrix are..");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
		
		int[][] arr3 = new int[row][row];
		System.out.println("--------------------\nMultiplication of two matrices is...");
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				for(int k=0;k<col;k++) {
					arr3[i][j] += arr[i][k]*arr2[k][j];
				}
			}
		}
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
	}

}
