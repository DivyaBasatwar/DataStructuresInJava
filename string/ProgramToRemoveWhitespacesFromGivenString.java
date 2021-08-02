package string;

import java.util.Scanner;

public class ProgramToRemoveWhitespacesFromGivenString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter one string");
		String str = sc.nextLine();
		sc.close();
		System.out.println("\nString before removing white spaces:-  "+str);
		
		str = str.replaceAll("\\s", "");
		
		System.out.println("\nString after removing white spaces:-  "+str);
		
	}
}
