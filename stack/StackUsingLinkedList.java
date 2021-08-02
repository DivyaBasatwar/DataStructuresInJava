package stack;

import java.util.Scanner;

public class StackUsingLinkedList {
	//represent node of singly linked list
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public static Node head = null;
	
	public void push(int ele) {
		Node newNode = new Node(ele);
		if(head==null) {
			head = newNode;
		}
		else {
			Node temp = head;
			head = newNode;
			newNode.next = temp;
		}
		
	}
	
	public int pop() {
		int poppedEle = Integer.MAX_VALUE;
		if(head==null) {
			System.out.println("Stack is Empty");
		}
		else {
			poppedEle = head.data;
			head = head.next;	
		}
		return poppedEle;
	}
	
	public int peek() {
		int peekedEle = Integer.MAX_VALUE;
		if(head==null) {
			System.out.println("Stack is Empty");
		}
		else {
			peekedEle = head.data;
		}
		return peekedEle;
	}
	
	public void display() {
		if(head==null) {
			System.out.println("Stack is Empty");
		}
		else {
			Node temp = head;
			System.out.println("Stack Elements are..");
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StackUsingLinkedList stack = new StackUsingLinkedList();
		while(true) {
			System.out.println("1.Push\t2.Pop\t3.Peek\t4.Display\t5.Exit");
			System.out.print("Enter your choice ===> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the element to be pushed ==> ");
				int ele = sc.nextInt();
				stack.push(ele);
				break;
			case 2:
				int poppedEle = stack.pop();
				if(poppedEle!=Integer.MAX_VALUE)
					System.out.println("Popped Element is ===> "+poppedEle);
				break;
			case 3:
				int peekEle = stack.peek();
				if(peekEle!=Integer.MAX_VALUE)
					System.out.println("Element present at peek is ===> "+peekEle);
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
