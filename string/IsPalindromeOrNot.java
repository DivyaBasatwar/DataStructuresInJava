package string;

import java.util.Scanner;

public class IsPalindromeOrNot {
	static boolean isPalindrome(String str) {
		char[] ch = str.toCharArray();
		int n = ch.length;
		for(int i=0;i<n/2;i++) {
			if(str.charAt(i)!=str.charAt(n-i-1)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string");
		String str = sc.next();
		sc.close();
		
		boolean res = isPalindrome(str);
		
		if(res) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}

}
