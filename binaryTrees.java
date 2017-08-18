package BinaryTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class binaryTrees {

	private class Node {
		int data;
		Node left = null;
		Node right = null;
	}

	private int size;
	private Node root;

	public boolean isempty() {
		return this.size() == 0;
	}

	public int size() {
		return this.size;
	}

	public binaryTrees() {
		this.root = this.TakeInput(new Scanner(System.in), null, false);
	}
	


	public binaryTrees(int[] pre, int[] post) {
		this.root = construct(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	private Node construct(int[] pre, int prelo, int prehi, int[] post, int postlo, int posthi) {
//		if (plo > phi) {
//			return null;
//		}
//
//		Node head = new Node();
//		this.size++;
//		head.data = pre[plo];
//		int sIndex=0;
//		for(int i=ilo ; i<=ihi ; i++) {
//			if(head.data == in[i]) {
//				sIndex = i;
//				break;
//			}
//		}
//		int numberOnLeft = sIndex - ilo;
//		head.left = construct(pre, plo + 1, plo + numberOnLeft, in, ilo, sIndex - 1);
//		head.right = construct(pre, plo + numberOnLeft+1, phi, in, sIndex + 1, ihi);
//
//		return head;
		
//		if (plo > phi) {
//			return null;
//		}
//
//		Node head = new Node();
//		this.size++;
//		head.data = post[phi];
//		int sIndex=0;
//		for(int i=ilo ; i<=ihi ; i++) {
//			if(head.data == in[i]) {
//				sIndex = i;
//				break;
//			}
//		}
//		int numberOnLeft = sIndex - ilo;
////		int numbersOnRight = phi-plo -numberOnLeft;
//		head.left = construct(post, plo ,plo + numberOnLeft-1 , in, ilo, sIndex - 1);
//		head.right = construct(post,plo + numberOnLeft, phi -1, in, sIndex + 1, ihi);
//
//		return head;
		
		if (prelo >= prehi) {
			return null;
		}

		Node head = new Node();
		this.size++;
		head.data = pre[prelo];
		int search=pre[prelo+1];
		int sIndex=0;
		for(int i=postlo ; i<=posthi ; i++) {
			if(search == post[i]) {
				sIndex = i;
				break;
			}
		}
		int numberOnLeft = sIndex + postlo +1 ;
//		int numbersOnRight = phi-plo -numberOnLeft;
		head.left = construct(pre, prelo +1 ,prelo + numberOnLeft ,post ,postlo , postlo + numberOnLeft-1);
		head.right = construct(pre,prelo + numberOnLeft+1,prehi,post, postlo + numberOnLeft,posthi-1 );

		
		return head;
		
		
	}

	private Node TakeInput(Scanner scn, Node parent, boolean ilc) {
		if (parent == null) {
			System.out.println("enter the root member");
		} else {
			if (ilc) {
				System.out.println("enter the left data");
			} else {
				System.out.println("enter the right data");
			}

		}

		Node child = new Node();
		int cdata = scn.nextInt();
		child.data = cdata;
		this.size++;
		System.out.println(" do you have a left child?");
		boolean hlc = scn.nextBoolean();
		if (hlc) {
			child.left = TakeInput(scn, child, true);
		}

		System.out.println(" do you have a right child?");
		boolean hrc = scn.nextBoolean();
		if (hrc) {
			child.right = TakeInput(scn, child, false);
		}
		return child;
	}
	public void display() {
		display(this.root);
	}
	
	
	private void display(Node node) {
		if (node == null) {
			return;
		}
		String str = "";
		// do with string , if lft data is null itt will give error
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += ".";
		}

		str += " => " + node.data + "<=";

		if (node.right != null) {
			str += node.right.data;
		} else {
			str += ".";
		}

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}
		int ls = size2(node.left);
		int rs = size2(node.right);

		return ls + rs + 1;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return 0;
		}
		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));
	}

	public int height() {
		return height(this.root);
	}
//
	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		int lh = height(node.left);
		int rh = height(node.right);
		return 1 + Math.max(lh, rh);
	}

	public boolean find(int data) {
		return find(data, this.root);
	}

	
    private boolean find(int data, Node node) {
		if (node == null) {
			return false;
		}
		boolean lf, rf;
		if (node.data == data) {
			return true;

		} else {
			lf = find(data, node.left);
			rf = find(data, node.right);
		}
		if (lf) {
			return lf;
		} else if (rf) {
			return rf;
		}
		return false;
	}





    private class DiaPair {
		int diameter = 0;
		int height = 0;

	}

    
    
	public int diameter2() {
		DiaPair mr = diameter2(this.root);
		return mr.diameter;
	}

	
	
	
    private DiaPair diameter2(Node node) {
//		if (node == null) {
//			DiaPair BR = new DiaPair();
//			BR.diameter = 0;
//			BR.height = -1;
//			return BR;
//		}
//
//		DiaPair DL = diameter2(node.left);
//		DiaPair RL = diameter2(node.right);
//
//		int factor1 = DL.height + RL.height + 2;
//		DiaPair MR = new DiaPair();
//		MR.height = Math.max(DL.height, RL.height) + 1;
//		MR.diameter = Math.max(factor1, Math.max(DL.diameter, RL.diameter));
//
//		return MR;
//	}
	if(node==null ) {
		DiaPair br = new DiaPair() ;
		br.height = -1;
		br.diameter=0;
		return br;
	}
	 DiaPair ld = diameter2(node.left);
	 DiaPair rd = diameter2(node.right);
	 DiaPair mr = new DiaPair();
	 mr.height = Math.max(ld.height, rd.height) +1;
	 mr.diameter = Math.max(Math.max(ld.diameter, rd.diameter), ld.height+rd.height +2);
	 return mr;
	
	
}

	private class BalancedPair {
		int height;
		boolean Isbalanced;
	}

	public boolean isBalanced() {

		BalancedPair mr = isBalanced(this.root);
		return mr.Isbalanced;
	}
	
	private BalancedPair isBalanced(Node node) {
		if (node == null) {
			BalancedPair BR = new BalancedPair();
			BR.height = -1;
			BR.Isbalanced = true;
			return BR;
		}

		BalancedPair LP = isBalanced(node.left);
		BalancedPair RP = isBalanced(node.right);

		BalancedPair MR = new BalancedPair();
		if (!LP.Isbalanced || !RP.Isbalanced) {

		} else if (Math.abs(LP.height - RP.height) <= 1) {
			MR.Isbalanced = true;
		}
		MR.height = Math.max(LP.height, RP.height) + 1;

		return MR;
	}

	
	private class BSTpair {
		int max;
		int min;
		boolean IsBst;
		int size;
		Node LargestBST_root;
	}

	public boolean isBST() {
		BSTpair mr = isBST(this.root);
		return mr.IsBst;
	}

	private BSTpair isBST(Node node) {
		if (node == null) {
			BSTpair BR = new BSTpair();
			BR.IsBst = true;
			BR.max = Integer.MIN_VALUE;
			BR.min = Integer.MAX_VALUE;
			return BR;
		}

		BSTpair bl = isBST(node.left);
		BSTpair br = isBST(node.right);

		BSTpair mr = new BSTpair();
		if (bl.IsBst && br.IsBst && node.data < br.min && node.data > bl.max) {
			mr.IsBst = true;
		}
		mr.max = Math.max(node.data, Math.max(br.max, bl.max));
		mr.min = Math.min(node.data, Math.min(br.min, bl.min));

		return mr;
	}

		
		
		
		
	public void largestBST() {

		BSTpair mr = largestBST(this.root);
		if(mr.LargestBST_root!=null)
			
		System.out.println(mr.LargestBST_root.data);
		System.out.println(mr.size);
	}

	private BSTpair largestBST(Node node) {
		if(node==null) {
			BSTpair BR = new BSTpair();
			BR.IsBst = true;
			BR.max = Integer.MIN_VALUE;
			BR.min = Integer.MAX_VALUE;
			BR.size = 0;
			return BR;
		}
		BSTpair bl = largestBST(node.left);
		BSTpair br = largestBST(node.right);

		BSTpair mr = new BSTpair();
		if (bl.IsBst && br.IsBst && node.data < br.min && node.data > bl.max) {
			mr.IsBst = true;
			mr.LargestBST_root = node;
			mr.size=1+ bl.size + br.size;
		} else {
			mr.IsBst = false; 
			if(bl.size > br.size)
			mr.LargestBST_root = bl.LargestBST_root;
			else mr.LargestBST_root = br.LargestBST_root;
					mr.size = Math.max(bl.size, br.size);
		}
		mr.max = Math.max(node.data, Math.max(br.max, bl.max));
		mr.min = Math.min(node.data, Math.min(br.min, bl.min));
		
        return mr;
	}

	private class OrderPair {
		Node node;
		boolean selfdone;
		boolean leftdone;
		boolean rightdone;
	}

	public void PreOrder() {
		PreOrder(this.root);
	}

	private void PreOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");
		PreOrder(node.left);
		PreOrder(node.right);
	}

	public void preOrderIterative() {
		preOrderIterative(this.root);
	}

	private void preOrderIterative(Node node) {
//		LinkedList<OrderPair> Stack = new LinkedList<>();
//		OrderPair head = new OrderPair();
//		head.node = node;
//
//		Stack.addFirst(head);
//
//		while (!Stack.isEmpty()) {
//			OrderPair temp = Stack.getFirst();
//			if (!temp.selfdone) {
//				System.out.print(temp.node.data + ",");
//				temp.selfdone = true;
//			}
//			if (!temp.leftdone) {
//				if (temp.node.left != null) {
//					OrderPair left = new OrderPair();
//					left.node = temp.node.left;
//					Stack.addFirst(left);
//				}
//				temp.leftdone = true;
//			} else if (!temp.rightdone) {
//				if (temp.node.right != null) {
//					OrderPair right = new OrderPair();
//					right.node = temp.node.right;
//					Stack.addFirst(right);
//				}
//				temp.rightdone = true;
//			} else {
//				Stack.removeFirst();
//			}
//		}
		
		OrderPair head = new OrderPair();
		head.node = node ;
		LinkedList<OrderPair> stack = new LinkedList<>();
		stack.addFirst(head);
		while(!stack.isEmpty()) {
			OrderPair temp = stack.getFirst();
			if(!temp.selfdone) {
				System.out.print(temp.node.data + ",");
				temp.selfdone=true;
			}
			if(!temp.leftdone) {
				if(temp.node.left!=null) {
				OrderPair left = new OrderPair();
				left.node = temp.node.left;
				stack.addFirst(left);
				}
				temp.leftdone = true;
			} else
			if(!temp.rightdone) {
				if(temp.node.right !=null){
				OrderPair right = new OrderPair();
				right.node = temp.node.right;
				stack.addFirst(right);
				}
				temp.rightdone = true;
			} else {
				stack.removeFirst();
			}
		}

	}

	public void postOrder() {
		postOrder(this.root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ",");
	}

	public void postOrderIterative() {
		postOrderIterative(this.root);
	}

	private void postOrderIterative(Node node) {
		LinkedList<OrderPair> Stack = new LinkedList<>();
		OrderPair head = new OrderPair();
		head.node = node;

		Stack.addFirst(head);

		while (!Stack.isEmpty()) {
			OrderPair temp = Stack.getFirst();

			if (!temp.leftdone) {
				if (temp.node.left != null) {
					OrderPair left = new OrderPair();
					left.node = temp.node.left;
					Stack.addFirst(left);
				}
				temp.leftdone = true;
			} else if (!temp.rightdone) {
				if (temp.node.right != null) {
					OrderPair right = new OrderPair();
					right.node = temp.node.right;
					Stack.addFirst(right);
				}
				temp.rightdone = true;
			} else if (!temp.selfdone) {
				System.out.print(temp.node.data + ",");
				temp.selfdone = true;
			} else {
				Stack.removeFirst();
			}
		}

	}

	public void inorder() {
		inorder(this.root);
	}

	private void inorder(Node node) {
		if (node == null) {
			return;
		}
		inorder(node.left);
		System.out.print(node.data + ",");
		inorder(node.right);
	}

	public void inOrderIterative() {
		inOrderIterative(this.root);
	}

	private void inOrderIterative(Node node) {
		LinkedList<OrderPair> Stack = new LinkedList<>();
		OrderPair head = new OrderPair();
		head.node = node;

		Stack.addFirst(head);

		while (!Stack.isEmpty()) {
			OrderPair temp = Stack.getFirst();

			if (!temp.leftdone) {
				if (temp.node.left != null) {
					OrderPair left = new OrderPair();
					left.node = temp.node.left;
					Stack.addFirst(left);
				}
				temp.leftdone = true;
			} else if (!temp.selfdone) {
				System.out.print(temp.node.data + ",");
				temp.selfdone = true;
			} else if (!temp.rightdone) {
				if (temp.node.right != null) {
					OrderPair right = new OrderPair();
					right.node = temp.node.right;
					Stack.addFirst(right);
				}
				temp.rightdone = true;
			}

			else {
				Stack.removeFirst();
			}
		}

	}

	 n
}