package linkedList;

import java.util.Scanner;

public class CircularDoublyLinkedList {
	public class Node{
		int data;
		Node prev;
		Node next;
		public Node(int data){
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	
	public Node head=null;
	public Node tail=null;
	
	public void create(int data) {
		Node newNode = new Node(data);
		if(head==null) {
			head = newNode;
			tail = newNode;
			head.next = head;
		}
		else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			newNode.next = head;
			head.prev = tail;
		}
	}
	
	public int length() {
		Node temp = head;
		int count=0;
		while(temp!=tail) {
			count++;
			temp = temp.next;
		}
		return ++count;
	}
	
	public void insertion(int data) {
		Scanner sc = new Scanner(System.in);
		int len = this.length();
		
		System.out.println("Enter the position ---> ");
		int pos = sc.nextInt();
		//we are assuming indexing starts from 1
		if(pos<=0 || pos>len+1) {
			System.out.println("This position is not present in the linked list");
			return;
		}
		
		Node newNode = new Node(data);
		if(pos==1) {
			if(head==null) {
				head = newNode;
				tail = newNode;
				head.next = head;
				head.prev = head;
			}
			else {
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
				head.prev = tail;
				tail.next = head;
			}
		}
		else if(pos==len) {
			Node temp = tail.prev;
			newNode.next = tail;
			tail.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
		}
		else if(pos==len+1) {	
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;		
			tail.next = head;
			head.prev = tail;
		}
		else {
			Node temp = head;
			int count = 1;
			while(count<pos-1) {
				temp = temp.next;
				count++;
			}
			newNode.next = temp.next;
			temp.next.prev = newNode;
			temp.next = newNode;
			newNode.prev = temp;
		}
	}
	
	public void deletion() {
		Scanner sc = new Scanner(System.in);
		int len = this.length();
	
		System.out.print("Enter the position ---> ");
		int pos = sc.nextInt();
		if(pos<=0 || pos>len) {
			System.out.println("This position is not present in the linked list");
			return;
		}
		else if(pos==1 && len==1) {
			System.out.println("Deleted element --> "+head.data);
			head = null;
			tail = null;
		}
		else if(pos==1){
			int deletedEle = head.data;
			head = head.next;
			head.prev = tail;
			tail.next = head;
			System.out.println("Deleted element --> "+deletedEle);
		}
		else if(pos==len) {
			int deletedEle = tail.data;
			tail = tail.prev;
			tail.next = head;
			head.prev = tail;
			System.out.println("Deleted element --> "+deletedEle);
		}
		else {
			int deletedEle;
			Node temp=head;
			int count=1;
			while(count<pos-1) {
				temp = temp.next;
				count++;
			}
			deletedEle = temp.next.data;
			temp.next.next.prev = temp;
			temp.next = temp.next.next;
			System.out.println("Deleted element --> "+deletedEle);
		}
	}
	
	
	public void display() {
		Node temp = head;
		if(head==null) {
			System.out.println("List is Empty..");
		}
		else {
			System.out.println("Elements present in list are..");
			while(temp!=tail) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
			System.out.println(tail.data+"\n");
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DoublyLinkedList dll = new DoublyLinkedList();
		while(true) {
			System.out.println("\n1.Insert Node\t2.Delete Node\t3.Display\t4.Exit");
			System.out.print("Enter your choice ----> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter element ----> ");
				int data = sc.nextInt();
				dll.insertion(data);
				break;
			case 2:
				dll.deletion();
				break;
			case 3:
				dll.display();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid Input");
			}
		}		
	}

}

