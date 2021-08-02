package string;

import java.util.Arrays;
import java.util.Scanner;

public class IsAnagramOrNot {
	static boolean isAnagram(String str1, String str2) {
		if(str1.length()!=str2.length()) {
			System.out.println("NO");
			return false;
		}	
		
		char[] ch = str1.toCharArray();
		char[] ch1 = str2.toCharArray();
		
		Arrays.parallelSort(ch);
		Arrays.parallelSort(ch1);
		
		for(int i=0;i<ch.length;i++) {
			if(ch[i]!=ch1[i]) {
				return false;
			}
		}
		
		return true;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two strings");
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		sc.close();
		
		if(isAnagram(str1, str2)) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}

	}

}
