package linkedList;

import java.util.Scanner;

public class SinglyLinkedList {

	//represent node of singly linked list
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
	static Scanner sc=null;
	
	//add node will add new node to the linked list
	public void addNode(int data) {
		//create a new node
		Node newNode = new Node(data);
		
		//check if the list is empty
		if(head==null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	
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
			temp.next = null;
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
			}
			else {
				newNode.next = head;
				head = newNode;
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
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static int length() {
		Node temp;
		temp = head;
		int count=0;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		SinglyLinkedList sll = new SinglyLinkedList();
		
		while(true) {
			System.out.println("\n1.Insert Node\t2.Delete Node\t3.Display\t4.Exit");
			System.out.print("Enter your choice ----> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter element ----> ");
				int data = sc.nextInt();
				sll.insertAtSpePos(data);
				break;
			case 2:
				int ele = sll.deleteFromSpePos();
				if(ele==-1) {
					System.out.println("Position not present in the linked list");
				}
				else {
					System.out.println("element deleted "+ele);
				}
				break;
			case 3:
				sll.display();
				break;
			case 4:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid Input");
			}
		}

	}
	


}
