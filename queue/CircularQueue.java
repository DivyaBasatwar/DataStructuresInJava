package queue;

/*Implementation of circular queue using array*/

import java.util.Scanner;

public class CircularQueue {
	static int n = 5;
	static int[] queue = new int[n];
	static int front = -1;
	static int rear = -1;
	static void enqueue(int x) {
		if(front==-1 && rear==-1) {
			front = rear = 0;
			queue[rear] = x;
		}
		else if((rear+1)%n==front) {
			System.out.println("Queue is full");
		}
		else {
			rear = (rear+1)%n;
			queue[rear] = x;
		}
	}

	static void dequeue() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty\n");
		}
		else if(front==rear) {
			System.out.println("Dequeued element is "+queue[front]);
			front = rear = -1;
		}
		else {
			System.out.println("Dequeued element is "+queue[front]);
			front = (front+1)%n;
		}
	}

	static void display() {
		int i=front;
		if(front==-1  && rear==-1) {
			System.out.println("queue is empty");
		}
		else {
			System.out.println("Circular queue is,");
			while(i!=rear) {
				System.out.print(queue[i]+" ");
				i = (i+1)%n;
			}
			System.out.print(queue[rear]+"\n");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.Enqueue\t2.Dequeue\t3.Display\t4.Exit");
			System.out.print("Enter your choice ---> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the value to insert into the queue --> ");
				int key = sc.nextInt();
				enqueue(key);
				break;
			case 2:
				dequeue();
				break;
			case 3:
				display();
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("You have entered invalid choice");
			}
		}



	}

}


