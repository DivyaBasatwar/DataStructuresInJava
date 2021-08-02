package stack;

import java.util.Scanner;

public class BalancedParethesis {
	char[] stack;
	int top;
	BalancedParethesis(){
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
	char peek() {
		if(top==-1) {
			System.out.println("Stack Is Empty");
			return '0';
		}
		return stack[top];
	}	
	boolean empty() {
		if(top==-1) {
			return true;
		}
		else {
			return false;
		}
	}		
	char match(char ch) {
		if(ch==')') {
			return '(';
		}
		else if(ch==']') {
			return '[';
		}
		else if(ch=='}') {
			return '{';
		}
		
		return '0';
	}
	boolean isBalanced(String str){
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='(' || ch=='[' || ch=='{') {
				this.push(ch);
			}
			else if(ch==')' || ch==']' || ch=='}') {
				if(this.empty() || this.peek()!=this.match(ch)) {
					return false;
				}
				else {
					this.pop();
				}
			}
		}
		return this.empty()?true:false;
	}
	public static void main(String[] args) {
		BalancedParethesis bp = new BalancedParethesis();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression");
		String str = sc.next();
		boolean b = bp.isBalanced(str);
		if(b) {
			System.out.println("Parenthesis Are Balanced");
		}
		else {
			System.out.println("Parenthesis Are Not Balanced");
		}
	}

}
