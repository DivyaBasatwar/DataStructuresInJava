package queue;

import java.util.Scanner;


public class QueueUsingArray {
	int front,rear;
	int queue[];
	QueueUsingArray(){
		front=-1;
		rear=-1;
		queue = new int[100];
	}
	void enqueue(int x) {
		if(rear==queue.length-1) {
			System.out.println("Overflow");
		}
		else if(front==-1 && rear == -1) {
			front=rear=0;
			queue[rear] = x;
		}
		else {
			rear++;
			queue[rear] = x;
		}
	}
	
	int dequeue() {
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
			return -1;
		}
		else if(front==rear) {
			int dequedEle = queue[front];
			front=rear=-1;
			return dequedEle;
		}
		else {
			int dequedEle = queue[front];
			front++;
			return dequedEle;  
		}
	}
	
	void display() {
		int i;
		if(front==-1 && rear==-1) {
			System.out.println("Queue is empty");
		}
		else {
			for(i=front;i<=rear;i++) {
				System.out.print(queue[i]+"   ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QueueUsingArray que = new QueueUsingArray();

		while(true) {
			System.out.println("\n1.enqueue\t2.dequeue\t3.display\t4.exit\n");
			System.out.println("Enter your choice --> ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.println("Enter the element ---> ");
				int ele = sc.nextInt();
				que.enqueue(ele);
				break;
			case 2:
				int eleDequed = que.dequeue();
				if(eleDequed==-1) {
					System.out.println("Queue Is Empty");
				}
				else {
					System.out.println("Dequeued element ---->"+eleDequed);
				}
				break;
			case 3:
				que.display();
				break;
			case 4:
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
			}
			
		}		

	}
	
}
