package tree;

import java.util.*;

public class BinaryTree {
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
	
	static int maxDia = Integer.MIN_VALUE;
	
	static boolean flag = true;
	
	static Scanner sc = null;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
	
		BinaryTree bt = new BinaryTree();
		
		Node root = createTree();
		
		System.out.println("\nInorder Traversal");
		inorderTraversal(root);
		
		System.out.println("\n\nPreorder Traversal");
		preorderTraversal(root);
		
		System.out.println("\n\nPostorder Traversal");
		postorderTraversal(root);
		
		System.out.println("\n\nLevel Order Traversal");
		levelOrderTraversal(root);
		
		System.out.println("\n\nReverse Level Order Traversal");
		reverseLevelOrderTraversal(root);
		
		System.out.println("\n\nTotal number of nodes presert in the binary tree are ---> "+countTotalNumberOfNodes(root));

		System.out.println("\nTotal number of leaf nodes present in the binary tree are ---> "+totalNumberOfLeafNodes(root));
		
		System.out.println("\nHeight of binary tree is ---> "+heightOfBinaryTree(root));
		
		diameterOfATree(root);
		System.out.println("\nDiameter of a tree is ---> "+maxDia);
		
		
		bt.maxEle(root);
		System.out.println("\nMaximum element from the array is ---> "+bt.max);
		
		bt.minEle(root);
		System.out.println("\nMinimum element from the array is ---> "+bt.min);
		
		isBalanced(root);
		System.out.println("\nIs the given binary tree balanced ---> "+flag);
		
		boolean res = isBST(root);
		if(res==true) {
			System.out.println("Given binary tree is Binary Search Tree");
		}
		else {
			System.out.println("Given binary tree is Not A Binary Search Tree");
		}
		
		System.out.print("\nEnter the element which you want to serach ---> ");
		int ele = sc.nextInt();
		boolean res2 = searchAnEle(root, ele);
		if(res2==true) {
			System.out.println("Element present in the binary tree");
		}
		else {
			System.out.println("Element does not present in the binary tree");
		}
		
		
		//finding mirror image of a tree
		mirror(root);
		System.out.println("\nPrinting mirror image of a tree");
		inorderTraversal(root);
		
		
	}
	
	static Node createTree() {
		System.out.println("Enter data(-1 to discontinue)");
		int data = sc.nextInt();
		
		if(data==-1) {
			return null;
		}
		
		Node root = new Node(data);
		
		System.out.println("Enter the left child for "+data);
		root.left = createTree();
		
		System.out.println("Enter the right child for "+data);
		root.right = createTree();
			
		return root;
	}
	
	static void inorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		
		inorderTraversal(root.left);
		System.out.print(root.data+" ");
		inorderTraversal(root.right);
	}
	
	static void preorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		
		System.out.print(root.data+" ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	static void postorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(root.data+" ");
	}
	
	static void levelOrderTraversal(Node root) {
		if(root==null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			System.out.print(curr.data+" ");
			
			if(curr.left!=null) {
				q.add(curr.left);
			}
			
			if(curr.right!=null) {
				q.add(curr.right);
			}
		}
		
	}
	
	static void reverseLevelOrderTraversal(Node root) {
		if(root==null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		Stack<Integer> s = new Stack<>(); 
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			
			s.push(curr.data);
			
			if(curr.right!=null) {
				q.add(curr.right);
			}
			
			if(curr.left!=null) {
				q.add(curr.left);
			}
			
		}
		
		while(!s.isEmpty()) {
			int temp = s.pop();
			System.out.print(temp+" ");
		}
	}
	
	static int countTotalNumberOfNodes(Node root) {
		if(root==null) {
			return 0;
		}
		
		return 1 + countTotalNumberOfNodes(root.left) + countTotalNumberOfNodes(root.right) ;
	}
	
	static int totalNumberOfLeafNodes(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		
		return totalNumberOfLeafNodes(root.left) + totalNumberOfLeafNodes(root.right);
	}
	
	//height in terms of nodes
	static int heightOfBinaryTree(Node root) {
		if(root==null) {
			return 0;
		}
		
		int l = heightOfBinaryTree(root.left);
		int r = heightOfBinaryTree(root.right);
		
		return 1 + Math.max(l, r);
	}
	
	//maximum element from the binary tree
	void maxEle(Node root) {
		if(root==null) {
			return ;
		}
		
		if(root.data>max) {
			max = root.data;
		}
		
		maxEle(root.left);
		maxEle(root.right);
	}
	
	void minEle(Node root) {
		if(root==null) {
			return;
		}
		
		if(root.data<min) {
			min = root.data;
		}
		
		minEle(root.left);
		minEle(root.right);
	}
	
	static int isBalanced(Node root) {
		if(root==null) {
			return 0;
		}
		
		int l = isBalanced(root.left);
		int r = isBalanced(root.right);
		
		if(Math.abs(l-r)>1) {
			flag = false;
		}
		
		return 1+Math.max(l, r);
	}
	
	static boolean searchAnEle(Node root, int key) {
		if(root==null) {
			return false;
		}
		
		if(root.data==key) {
			return true;
		}
		
		return searchAnEle(root.left, key) || searchAnEle(root.right, key);
		
	}
	
	
	static void mirror(Node root) {
		if(root==null) {
			return;
		}
		
		mirror(root.left);
		mirror(root.right);
		
		//swap values
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
		
	}
	
	static int diameterOfATree(Node root) {
		if(root==null) {
			return 0;
		}
	
		int l = diameterOfATree(root.left);
		int r = diameterOfATree(root.right);
		
		maxDia = Math.max(maxDia, l+r+1);
		
		return Math.max(l, r)+1;
	}
	
	static boolean isBST(Node root) {
		
		
		return false;
	}

}

class Node{
	int data;
	Node left, right;
	
	public Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
