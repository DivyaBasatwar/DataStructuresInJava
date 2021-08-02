package string;

import java.util.Scanner;

public class StringInJava {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter any string:-");
		String str = sc.nextLine();
		System.out.println("You Entered:-  "+str);
		sc.close();
		
		//two ways to create string
		String str2 = new String("Divya");
		String str3 = "Divya";   //string literal
		System.out.println("str2 :- "+str2);
		System.out.println("str3 :- "+str3);
		
		System.out.println("\nChecking references");
		if(str2==str3) {            // == checks references
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		System.out.println("\nChecking content");
		if(str2.equals(str3)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
		System.out.println(str.charAt(0));
		System.out.println(str.substring(1));
		System.out.println(str.substring(2, 4));
		System.out.println(str.indexOf('D'));
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		
		String str4 = "Divya Shivajirao Basatwar";
		String[] s = str4.split(" ");
		for(String st: s) {
			System.out.println(st);
		}
		
		System.out.println(str4.trim());
		
		System.out.println(str4.length());
		System.out.println(str4.contains("Divya"));
		
		System.out.println(str.replace( 'a', 'Z'));
		
		String str5 = str4.concat(" this is my name");
		System.out.println(str5);

	}

}
