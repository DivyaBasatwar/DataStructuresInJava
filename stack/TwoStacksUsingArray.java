package stack;

import java.util.Scanner;

public class TwoStacksUsingArray {
    int[] data;
    int tos1;
    int tos2;

    public TwoStacksUsingArray(int cap) {
      // write your code here
      data = new int[cap];
      tos1 = -1;
      tos2 = cap;
    }

    int size1() {
      // write your code here
      return tos1+1;
    }

    int size2() {
      // write your code here
      return data.length-tos2;
    }

    void push1(int val) {
      // write your code here
      if(tos1==tos2-1){
          System.out.println("Stack overflow");
      }
      else{
          tos1++;
          data[tos1] = val;
      }
    }

    void push2(int val) {
      // write your code here
      if(tos2-1==tos1){
          System.out.println("Stack overflow");
      }
      else{
          tos2--;
          data[tos2] = val;
      }
    }

    int pop1() {
      // write your code here
      if(tos1==-1){
          System.out.println("Stack underflow");
          return -1;
      }      
      int elePopped = data[tos1];
      tos1--;
      return elePopped;
    }

    int pop2() {
      // write your code here
      if(tos2==data.length){
          System.out.println("Stack underflow");
          return -1; 
      }      
      int elePopped = data[tos2];
      tos2++;
      return elePopped;
    }

    int top1() {
      // write your code here
      if(tos1==-1){
          System.out.println("Stack underflow");
          return -1;
      }
      return data[tos1];
    }

    int top2() {
      // write your code here
      if(tos2==data.length){
          System.out.println("Stack underflow");
          return -1; 
      }
      return data[tos2];
    }
    
    void display1() {
    	if(tos1==-1) {
    		System.out.println("Stack1 is empty");
    		return;
    	}
    	
    	System.out.println("Elements present in first stack are,");
    	for(int i=0;i<=tos1;i++) {
    		System.out.print(data[i]+" ");
    	}
    }
   
    void display2() {
    	if(tos2==data.length) {
    		System.out.println("Stack2 is empty");
    		return;
    	}
    	
    	System.out.println("Elements present in second stack are,");
    	for(int i=data.length-1;i>=tos2;i--) {
    		System.out.print(data[i]+" ");
    	}
    }    
  
	public static void main(String[] args) {
		TwoStacksUsingArray ts = new TwoStacksUsingArray(5);
		Scanner sc = new Scanner(System.in);
		System.out.println("1.push1\t2.push2\t3.pop1\t4.pop2\t5.top1\t6.top2");
		System.out.println("7.size1\t8.size2\t9.display1\t10.display2\t11.exit");
		while(true) {
			System.out.print("\nEnter your choice:- ");
			int ch = sc.nextInt();
			switch(ch) {
			case 1:
				System.out.print("Enter the data:-  ");
				int val1 = sc.nextInt();
				ts.push1(val1);
				break;
			case 2:
				System.out.print("Enter the data:-  ");
				int val2 = sc.nextInt();
				ts.push2(val2);
				break;
			case 3:
				int p1 = ts.pop1();
				System.out.println("Element popped from first stack is "+p1);
				break;
			case 4:
				int p2 = ts.pop2();
				System.out.println("Element popped from second stack is "+p2);
				break;
			case 5:
				ts.top1();
				break;	
			case 6:
				ts.top2();
				break;
			case 7:
				ts.size1();
				break;
			case 8:
				ts.size2();
				break;
			case 9:
				ts.display1();
				break;
			case 10:
				ts.display2();
				break;
			case 11:
				System.exit(0);
			default:
				System.out.println("You have entered invalid choice");
			}
		}

	}

}
