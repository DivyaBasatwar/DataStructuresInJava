package linkedList;

import java.util.Scanner;

public class CircularLinkedList {

	//represent node of singly circular linked list
	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	//represent head and tail of singly linked list
	public static Node head = null;
	public static Node tail = null;
	static Scanner sc = null;
	
	//below method will add new node to the end of a linked list
	public void addNode(int data) {
		//create a new node
		Node newNode = new Node(data);
		
		//check if the list is empty
		if(head==null) {
			head = newNode;
			tail = newNode;
			head.next = head;
		}
		else {
			tail.next = newNode;
			tail = newNode;
			tail.next = head;
		}
	}
	
	//will delete node present at last
	public int deleteNode() {
		Node temp;
		temp = head;
		if(head==null) {
			return Integer.MAX_VALUE;
		}
		else {
			int ele = tail.data;
			while(temp.next!=tail) {
				temp = temp.next;
			}
			tail = temp;
			temp.next = head;
			return ele;
		}
		
	}
	
	public void insertAtSpePos(int data) {
		Node newNode = new Node(data);
		System.out.println("Enter the position ---> ");
		int pos = sc.nextInt(); 
		int len = length();

		if(pos<=0 || (pos>len+1)) {
			System.out.println(("Given Position does not exists"));
			return;
		}
		else if(pos==1) {
			//insert at beg
			if(head==null) {
				head = newNode;
				tail = newNode;
				head.next = newNode;
			}
			else {
				newNode.next = head;
				head = newNode;
				tail.next = head;
			}
		}
		else if(pos==len+1) {
			this.addNode(data);
		}
		else {
			int count=1;
			Node temp=head;
			while(count<pos-1) {
				temp = temp.next;
				count++;
			}
			newNode.next = temp.next;
			temp.next = newNode;
		}
	}
	
	public int deleteFromSpePos() {
		System.out.println("Enter the position");
		int pos = sc.nextInt();
		int len = length();
		
		int ele;
		if(pos>len || pos<1) {
			return -1;
		}
		else if(pos==1) {
			//delete first node
			Node temp=head;
			ele = head.data;
			head = head.next;
			temp.next=null;
			tail.next = head;
			return ele;
		}
		else if(pos==len) {
			//delete last node
			ele = tail.data;
			Node temp;
			temp=head;
			while(temp.next!=tail) {
				temp = temp.next;
			}
			tail = temp;
			tail.next = head;
			temp.next = null;
			return ele;
		}
		else {
			int count = 1;
			Node temp=head;
			while(count<pos-1) {
				temp = temp.next;
				count++;
			}
			ele = temp.next.data;
			temp.next = temp.next.next;
			return ele;
		}
	}
	public void display() {
		Node temp = head;
		if(head==null) {
			System.out.println("List is empty");
			return;
		}
		System.out.println("Nodes of singly list are:");
		while(temp!=tail) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println(tail.data);
		System.out.println();
	}
	
	public static int length() {
		Node temp;
		temp = head;
		int count=0;
		while(temp!=tail) {
			++count;
			temp = temp.next;
		}
		return ++count;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		CircularLinkedList cll = new CircularLinkedList();
		
		while(true) {
			System.out.println("\n1.Insert Node\t2.Delete Node\t3.Display\t4.Exit\t5.length");
			System.out.print("Enter your choice ----> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter element ----> ");
				int data = sc.nextInt();
				cll.insertAtSpePos(data);
				break;
			case 2:
				int ele = cll.deleteFromSpePos();
				if(ele==-1) {
					System.out.println("Position not present in the linked list");
				}
				else {
					System.out.println("element deleted "+ele);
				}
				break;
			case 3:
				cll.display();
				break;
			case 4:
				sc.close();
				System.exit(0);
			case 5:
				int len = length();
				System.out.println("Length of linked list is:-  "+len);
				break;
			default:
				System.out.println("Invalid Input");
			}
		}

	}
	


}

