package queue;

import java.util.Scanner;

public class QueueUsingLinkedList {
	class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	
	static Node front = null;
	static Node rear = null;
	
	public void enqueue(int ele) {
		Node newNode = new Node(ele);
		if(rear==null) {
			rear = newNode;
			front = newNode;
		}
		else {
			rear.next = newNode;
			rear = newNode;
		}
	}
	public int dequeue() {
		Node temp = front;
		int deqEle = Integer.MAX_VALUE;
		if(front==null) {
			System.out.println("Queue is empty");
		}
		else {
			deqEle = front.data;
			front = front.next;
		}
		return deqEle;
	}
	public int peek() {
		Node temp = front;
		int deqEle = Integer.MAX_VALUE;
		if(front==null) {
			System.out.println("Queue is empty");
		}
		else {
			deqEle = front.data;
		}
		return deqEle;
	}
	public void display() {
		if(front==null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Queue elements are...");
		for(Node temp=front;temp!=null;temp = temp.next) {
			System.out.print(temp.data+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueUsingLinkedList que = new QueueUsingLinkedList();

		while(true) {
			System.out.println("\n1.enqueue\t2.dequeue\t3.peek\t4.display\t5.exit\n");
			System.out.print("Enter your choice --> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter the element ---> ");
				int ele = sc.nextInt();
				que.enqueue(ele);
				break;
			case 2:
				int eleDequed = que.dequeue();
				if (eleDequed!=Integer.MAX_VALUE){
					System.out.println("Dequed Element ==> "+eleDequed);
				}
				break;
			case 3:
				int peekEle = que.peek();
				if (peekEle!=Integer.MAX_VALUE){
					System.out.println("Peek Element ==> "+peekEle);
				}
			case 4:
				que.display();
				break;
			case 5:
				System.exit(0);
			}
			
		}		


	}

}
