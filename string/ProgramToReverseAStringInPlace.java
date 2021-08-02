package string;

import java.util.Scanner;

public class ProgramToReverseAStringInPlace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter one string:-");
		String str = sc.nextLine();
		sc.close();
		
		char[] ch = str.toCharArray();
		int n = ch.length;
		
		for(int i=0;i<n/2;i++) {
			char temp = ch[i];
			ch[i] = ch[n-i-1];
			ch[n-1-i] = temp;
		}
		
		System.out.println("String after reversing:- ");
		for(char c:ch) {
			System.out.print(c);
		}
	}

}
