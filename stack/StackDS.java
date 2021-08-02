package stack;

import java.util.Scanner;

public class StackDS {
	int[] stack;
	int top;
	StackDS(){
		stack = new int[10];
		top = -1;
	}
	void push(int data) {
		if(top==stack.length-1) {
			System.out.println("Stack Overflow");
		}
		else {
			top++;
			stack[top] = data;
		}
	}
	int pop() {
		if(top==-1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			int elePopped = stack[top];
			top--;
			return elePopped;
		}
	}
	int peek() {
		if(top==-1) {
			System.out.println("Stack Is Empty");
			return -1;
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
	void display() {
		if(top==-1) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.println("ELement present in the stack are,");
		for(int i=0;i<=top;i++) {
			System.out.print(stack[i]+" ");
		}
	}
	boolean search(int data) {
		for(int i=0;i<=top;i++) {
			if(stack[i]==data) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackDS st = new StackDS();
		System.out.println("1.Push\t2.Pop\t3.Peek\t4.Empty\t5.Search\t6.Display\t7.Exit");
		while(true) {
			System.out.print("\nEnter your choice :- ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the data:- ");
				int data = sc.nextInt();
				st.push(data);
				break;
			case 2:
				int elePopped = st.pop();
				if(elePopped!=-1) {
					System.out.println("Element popped is "+elePopped);
				}
				break;
			case 3:
				int peekEle = st.peek();
				if(peekEle!=-1) {
					System.out.println("Element present at peek is "+peekEle);
				}
				break;
			case 4:
				boolean isEmpty = st.empty();  //will return true if stack is empty
				if(isEmpty) {
					System.out.println("Stack is emtpy");
				}
				else {
					System.out.println("Stack is not empty");
				}
				break;
			case 5:
				System.out.print("Enter the element which is to be search:-  ");
				int ele = sc.nextInt();
				boolean res = st.search(ele);
				if(res) {
					System.out.println("Element present in the stack");
				}
				else {
					System.out.println("Element does present in the stack");
				}
				break;
			case 6:
				st.display();
				break;
			case 7:
				sc.close();
				System.exit(0);
			default:
				System.out.println("You have entered invalid choice");
			}
		}

	}

}
