package string;

import java.util.Scanner;

public class ReverseEachWordInGivenString {
	static String reverse(String str) {
		char[] ch = str.toCharArray();
		int n = ch.length;
		for(int i=0;i<n/2;i++) {
			char temp = ch[i];
			ch[i] = ch[n-i-1];
			ch[n-i-1] = temp;
		}
		
		String res= "";
		for(char c:ch) {
			res = res + c;
		}
		return res;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string,,");
		String str = sc.nextLine();
		sc.close();
		
		String[] strArr = str.split(" ");
		for(int i=0;i<strArr.length;i++) {
			System.out.print(reverse(strArr[i])+" ");
		}
	}

}
