package stack;

import java.util.Scanner;

public class ReverseAStringUsingStack {
	char[] stack;
	int top;
	ReverseAStringUsingStack(){
		stack = new char[10];
		top = -1;
	}
	void push(char data) {
		if(top==stack.length-1) {
			System.out.println("Stack Overflow");
		}
		else {
			top++;
			stack[top] = data;
		}
	}
	char pop() {
		if(top==-1) {
			System.out.println("Stack Underflow");
			return '0';
		}
		else {
			char elePopped = stack[top];
			top--;
			return elePopped;
		}
	}	
	boolean empty() {
		if(top==-1) {
			return true;
		}
		else {
			return false;
		}
	}	
	String reverse(String str) {
		for(int i=0;i<str.length();i++) {
			this.push(str.charAt(i));
		}
		
		str = "";
		while(!this.empty()) {
			char ch = this.pop();
			str = str + ch;
		}
		return str;
	}
	public static void main(String[] args) {
		ReverseAStringUsingStack re = new ReverseAStringUsingStack();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = sc.next();
		String res = re.reverse(str);
		System.out.println("Reversed string :-  "+res);
	}

}
