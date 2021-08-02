package string;

import java.util.Scanner;

public class CountNoOfOccOfEachCharacters {
	static int countFreq(char ch, String str) {
		int i = str.indexOf(ch);
		int count = 0;
		while(i!=-1) {
			count++;
			str = str.substring(str.indexOf(ch)+1);
			i = str.indexOf(ch);
		}
		
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string:-  ");
		String str = sc.nextLine();
		sc.close();
		
		str = str.replace(" ", "");
		while(str.length()>0) {
			char ch = str.charAt(0);
			System.out.println("Character "+ch+" is occuring "+countFreq(ch, str)+" no of times");
			str = str.replace(""+ch, "");
		}

	}
	
	//In this same program if countFreq() returns >1 then that character will be duplicate
	//character

}
