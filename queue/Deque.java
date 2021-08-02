package queue;

import java.util.Scanner;

public class Deque {
	int[] data;
	int front;
	int rear;
	Deque(int cap){
		data = new int[cap];
		front = -1;
		rear = -1;
	}
	
	void enqueueAtFront(int data) {
		
	}
	
	void enqueueAtRear(int data) {
		
	}
	
	int dequeFromFront() {
		
		return 0;
	}
	
	int dequeFromEnd() {
		
		return 0;
	}
	
	void display() {
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque q = new Deque(5);
		System.out.println("1.Insertion At Front\t2.Insertion At End\t3.Deletion From Front\t4.Deletion From End\t5.Display\t6.Exit");
		while(true) {
			System.out.print("\nEnter your choice:-  ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the data:-  ");
				int data1 = sc.nextInt();
				q.enqueueAtFront(data1);
				break;
			case 2:
				System.out.print("Enter the data:-  ");
				int data2 = sc.nextInt();
				q.enqueueAtRear(data2);
				break;
			case 3:
				int rem1 = q.dequeFromFront();
				System.out.println("Element removed from front "+rem1);
				break;
			case 4:
				int rem2 = q.dequeFromFront();
				System.out.println("Element removed from front "+rem2);
				q.display();
				break;
			case 5:
				q.display();
			case 6:
				System.exit(0);
			default:
				System.out.println("You have entered invalid choice");
			}
		}		

	}

}
