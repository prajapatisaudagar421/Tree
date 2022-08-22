package com.tree;

public class Main {
public static void main(String[] args) {
	Tree tree = new Tree();
	tree.insert(7);
	tree.insert(4);
	tree.insert(9);
	tree.insert(1);
	tree.insert(8);
	tree.insert(10);
	tree.insert(6);
	tree.preOrderTraverse();
	System.out.println();
	tree.inOrderTraverse();
	System.out.println();
	tree.postOrderTraverse();
//	System.out.println(tree.find(6));
//	System.out.println(tree.height());
//	System.out.println(tree.min());
//	System.out.println(tree.max());
//	System.out.println(tree.equals(tree));
//	//tree.swap();
//	System.out.println(tree.isBinarySeachTree());
//	System.out.println(tree.isLeaf());
//	System.out.println(tree.getNodesAtDistance(1));
//	tree.levelOrder();
	
	
}
}
