package tree;

import java.util.*;

public class BinarySearchTree {  
	public class Node{
		int data;
		Node left, right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	} 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree bst = new BinarySearchTree();
		
		Node root = null;
		int data;
		do {
			System.out.println("Enter the data :- ");
			data = sc.nextInt();
			if(data==-1) break;
			root = bst.insert(root, data);
		}
		while(data!=-1);
		
		System.out.println("\nInorder Tree Traversal");
		bst.inorderTraversal(root);
		
		System.out.println("\n\nPreorder Tree Traversal");
		bst.preorderTraversal(root);
		
		System.out.println("\n\nPostorder Tree Traversal");
		bst.postorderTraversal(root);
		
		System.out.println("\n\nLevelorder Tree Traversal");
		bst.levelOrderTraversal(root);
		
		
		System.out.print("\n\nEnter the value which is to be search --> ");
		int ele = sc.nextInt();
		boolean res = bst.searchIteratively(root, ele);
		if(res==true) {
			System.out.println("Element present in the tree");
		}
		else {
			System.out.println("Element does not present in the tree");
		}
		
		
		System.out.print("\n\nEnter the value which is to be search --> ");
		int ele2 = sc.nextInt();
		Node res2 = bst.searchRecursively(root, ele2);
		if(res2!=null) {
			System.out.println("Element present in the tree");
		}
		else {
			System.out.println("Element does not present in the tree");
		}
		
		
		bst.minAndMax(root);
		
		sc.close();
	}
	
	public Node insert(Node root, int data) {
		if(root==null) {
			return new Node(data);
		}
		else {
			Node curr;
			if(data<=root.data) {
				curr = insert(root.left, data);
				root.left = curr;
			}
			else {
				curr = insert(root.right, data);
				root.right = curr; 
			}
			return root;
		}
	}
	
	public void inorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		else {
			inorderTraversal(root.left);
			System.out.print(root.data+" ");
			inorderTraversal(root.right);
		}
	}
	
	public void preorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		else {
			System.out.print(root.data+" ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	
	public void postorderTraversal(Node root) {
		if(root==null) {
			return;
		}
		else {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			System.out.print(root.data+" ");
		}
	}
	
	public void levelOrderTraversal(Node root) {
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
	
	public boolean searchIteratively(Node root, int key) {
		if(root==null) {
			return false;
		}
		
		boolean isPresent = false;
		
		while(root!=null) {
			if(key<root.data) {
				root = root.left;
			}
			else if(key>root.data) {
				root = root.right;
			}
			else {
				isPresent = true;
				break;
			}
		}
		
		return isPresent;
			
	}
	
	public Node searchRecursively(Node root, int key) {
		if(root==null || root.data==key) {
			return root;
		}
		
		if(root.data<key) {
			return searchRecursively(root.right, key);
		}
		
		return searchRecursively(root.left, key);
	}
	
	public void minAndMax(Node root) {
		if(root==null) {
			System.out.println("Tree is empty");
		}
		
		Node curr = root;
		
		while(curr.left!=null) {
			curr = curr.left;
		}
		
		System.out.println("\nSmallest element present in the binary search tree is :- "+curr.data);
		
		curr = root;
		while(curr.right!=null) {
			curr = curr.right;
		}
		
		System.out.println("Largest element from the binary search tree is :- "+curr.data);
	
	}
 
}

