package string;

import java.util.Scanner;

public class FindDuplicateCharacters {
	static int getCharCount(char ch, String str) {
		int count = 0;
		int i = str.indexOf(ch);
		while(i!=-1) {
			count++;
			str = str.substring(str.indexOf(ch)+1);
			i = str.indexOf(ch);
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter one string:-");
		String str = sc.nextLine();
		sc.close();
		
		System.out.println("Duplicate characters from given string are");
		str = str.replace(" ", "");
		while(str.length()>0) {
			char ch = str.charAt(0);
			int count = getCharCount(ch, str);
			if(count>1) {
				System.out.print(ch+" ");
			}
			str = str.replace(""+ch, "");
		}
	}

}
