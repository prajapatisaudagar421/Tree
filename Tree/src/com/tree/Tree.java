package com.tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
private class Node{
	private int data;
	private Node leftchild;
	private Node rightchild;
	public Node(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node ="+ data;
	}
}
private Node root;
//public void insert(int data) {
//	Node node = new Node(data);
//	if(root == null) {
//		root = node;
//		return;
//	}
//	Node current = root;
//	while (true) {
//		if(current.data<data) {
//			if(current.rightchild == null) {
//				current.rightchild = node;
//				break;
//			}
//			current = current.rightchild;
//		}else {
//			if(current.leftchild == null) {
//				current.leftchild = node;
//				break;
//			}
//			current = current.leftchild;
//		}
//	}
//}
public void insert(int value) {
	if (root == null) {
		root = new Node(value);
		return;
	}
	Node current = root;

	while (true) {
		if (current.data > value) {
			if (current.leftchild == null) {
				current.leftchild = new Node(value);
				break;
			}
			current = current.leftchild;
		} else {
			if (current.rightchild == null) {
				current.rightchild = new Node(value);
				break;
			}
			current = current.rightchild;
		}
	}
}
public void preOrderTraverse() {
	preOrder(root);
}
private void preOrder(Node root) {
	if(root == null) {
		return;
	}
	System.out.print(root.data+" ");
	preOrder(root.leftchild);
	preOrder(root.rightchild);
	
}
public void inOrderTraverse() {
	inOrder(root);
}
private void inOrder(Node root) {
	if(root == null) {
		return;
	}
	inOrder(root.leftchild);
	System.out.print(root.data+" ");
	inOrder(root.rightchild);
	
}
public void postOrderTraverse() {
	postOrder(root);
}
private void postOrder(Node root) {
	if(root == null) {
		return;
	}
	postOrder(root.leftchild);
	postOrder(root.rightchild);
	System.out.print(root.data+" ");
	
}
public boolean find(int data) {
	Node current = root;
	while (current != null) {
		if(data<current.data) {
			current = current.leftchild;
		}else if(data>current.data) {
			current = current.rightchild;
		}else {
			return true;
		}
	}
	return false;
	
}
public int height() {
	return heightOfTree(root);
}
private int heightOfTree(Node root) {
	if(root == null) {
		return -1;
	}
	if(root.leftchild == null && root.rightchild == null) {
		return 0;
	}
	return 1+Math.max(heightOfTree(root.leftchild), heightOfTree(root.rightchild));
}
//public int min() {
//	return minValue(root);
//}
//private int minValue(Node root) {
//	Node current = root;
//	Node last = current;
//	while (current != null) {
//		last = current;
//		current = current.leftchild;
//	}
//	return last.data;
//	
//
//}
public int min() {
	return minValue(root);
}
private int minValue(Node root) {
	if(root.leftchild == null && root.rightchild == null) {
		return root.data;
	}
	int left = minValue(root.leftchild);
	int right = minValue(root.rightchild);
	return Math.min(Math.min(left, right), root.data);
}
//public int max() {
//	return maxValue(root);
//}
//private int maxValue(Node root) {
//	Node current = root;
//	Node last = current;
//	while (current != null) {
//		last = current;
//		current = current.rightchild;
//	}
//	return last.data;
//}
public int max() {
	return maxValue(root);
}
private int maxValue(Node root) {
	if(root.leftchild == null && root.rightchild== null) {
		return root.data;
	}
	int left = maxValue(root.leftchild);
	int right = maxValue(root.rightchild);
	return Math.max(Math.max(left, right), root.data);
}
public boolean equals(Tree other) {
	if(other == null) {
		return false;
	}
	return equal(root, other.root);
}
private boolean equal(Node first, Node second) {
	if(first == null && second == null) {
		return true;
	}
	else if(first != null && second != null ) {
		return first.data == second.data && equal(first.leftchild, second.leftchild)&& equal(first.rightchild, second.rightchild);
	}else {
		return false;
	}
}
public boolean isBinarySeachTree() {
	return isBinary(root, Integer.MIN_VALUE,Integer.MAX_VALUE);
}
private boolean isBinary(Node root, int minValue, int maxValue) {
	if(root == null) {
		return true;
	}
	if(root.data<minValue && root.data>maxValue) {
		return false;
	}
	return isBinary(root.leftchild, minValue, root.data-1)&& isBinary(root.rightchild, root.data+1, maxValue);
}
public void swap() {
	Node temp = root.leftchild;
	root.leftchild = root.rightchild;
	root.rightchild = temp;
}
public boolean isLeaf() {
	return isLeaf(root);
}
private boolean isLeaf(Node root) {
	return root.leftchild == null && root.rightchild == null;
}
public ArrayList<Integer> getNodesAtDistance(int distance){
	ArrayList list = new ArrayList<Integer>();
	getNodesAtDistance(root,distance,list);
	return list;
}
private void getNodesAtDistance(Node root, int distance, ArrayList list) {
	if(root == null) {
		return;
	}
	if(distance == 0) {
		list.add(root.data);
		return;
	}
	getNodesAtDistance(root.leftchild, distance-1, list);
	getNodesAtDistance(root.rightchild, distance-1, list);
}

public void levelOrder() {
	for (int i = 0; i <= height(); i++) {
		for (int value : getNodesAtDistance(i)) {
			System.out.print(value+" ");
		}
	}
	
}

}
