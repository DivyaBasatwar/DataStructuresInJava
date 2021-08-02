package queue;

import java.util.Scanner;

public class Queue {
	int[] data;
	int front, rear;
	Queue(int cap){
		data = new int[cap];
		rear = -1;
		front = -1;
	}
	void enqueue(int d) {
		if(front==-1 && rear==-1) {
			front = 0;
			rear = 0;
			data[rear] = d;
		}
		else if(rear==data.length-1) {
			System.out.println("Queue is full");
		}
		else {
			rear++;
			data[rear] = d;
		}
	}
	int dequeue() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
			return -1;
		}
		else if(front==rear) {
			int eleRemoved = data[front];
			front = rear = -1;
			return eleRemoved;
		}
		else {
			int eleRemoved = data[front];
			front++;
			return eleRemoved;
		}
	}
	int front() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
			return -1;
		}
		else {
			return data[front];
		}
	}
	void display() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
			return;
		}
		
		System.out.println("Elements present in the list are,");
		for(int i=front;i<=rear;i++) {
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue q = new Queue(5);
		System.out.println("1.Enqueue\t2.Dequeue\t3.front\t4.Display\t5.Exit");
		while(true) {
			System.out.print("\nEnter your choice:-  ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the data:-  ");
				int data = sc.nextInt();
				q.enqueue(data);
				break;
			case 2:
				int eleDequed = q.dequeue();
				System.out.println("Element dequeued is "+eleDequed);
				break;
			case 3:
				System.out.println("Element present at the front of queue is "+q.front());
				break;
			case 4:
				q.display();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("You have entered invalid choice");
			}
		}
	}

}
