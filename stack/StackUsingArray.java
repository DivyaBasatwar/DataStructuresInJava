package stack;
import java.util.Scanner;
public class StackUsingArray {
	int[] a;
	int top;
	StackUsingArray(){
		a = new int[10];
		top = -1;
	}
	public void push(int ele) {
		if(top==a.length-1) {
			System.out.println("Stack Overflow");
		}
		else {
			top++;
			a[top] = ele;
		}
	}
	public int pop() {
		if(top==-1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			int ele = a[top];
			top--;
			return ele;
		}
	}
	public int peek() {
		if(top==-1) {
			System.out.println("Stack Underflow");
			return -1;
		}
		else {
			int ele = a[top];
			return ele;
		}
	}
	public void display() {
		if(top==-1) {
			System.out.println("Stack is empty");
			return;
		}
		System.out.println("Elements present in the stack are...");
		for(int i=0;i<=top;i++) {
			System.out.print(a[i]+"  ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackUsingArray stack = new StackUsingArray();

		while(true) {
			System.out.println("1.Push\t2.Pop\t3.Peek\t4.Display\t5.Exit");
			System.out.print("Enter your choice ==> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the element to be pushed ===> ");
				int ele = sc.nextInt();
				stack.push(ele);
				break;
			case 2:
				int popedEle = stack.pop();
				System.out.println("Element Popped ===> "+popedEle);
				break;
			case 3:
				int peekEle = stack.peek();
				System.out.println("Element At Peek ===> "+peekEle);
				break;
			case 4:
				stack.display();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}

	}

}
