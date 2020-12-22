package com.ds.tree;

import java.util.TreeMap;
import java.util.Map.Entry;

import com.ds.tree.BinaryTreeVerticalSumMain.TreeNode;

public class BinaryTreeSum {
	public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
	}
	
	// sum all nodes
	public static int sumAllTreeNode(TreeNode root){
		int result = 0;
		
		if(root != null){
			int sumLeft = sumAllTreeNode(root.left);
			int sumRight = sumAllTreeNode(root.right);
			System.out.println(root.data+",");
			result = root.data + sumLeft + sumRight;
			
		}else{
			return result;
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		
		/**
		  *                       40
		  *                 20          60
		  *             10     30   50       70
		  *                  5         55
		  */
		// Creating a binary tree
		TreeNode rootNode = createBinaryTree();
		int subtotal = sumAllTreeNode(rootNode);
		
		System.out.println("Subtotal is:"+subtotal);
	}
	
	public static TreeNode createBinaryTree()
	{
 
		TreeNode rootNode =new TreeNode(40);
		TreeNode node20=new TreeNode(20);
		TreeNode node10=new TreeNode(10);
		TreeNode node30=new TreeNode(30);
		TreeNode node60=new TreeNode(60);
		TreeNode node50=new TreeNode(50);
		TreeNode node70=new TreeNode(70);
		TreeNode node55=new TreeNode(55);
		TreeNode node5=new TreeNode(5);
 
		rootNode.left=node20;
		rootNode.right=node60;
 
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
		node50.right=node55;
		node30.left=node5;
		return rootNode;
	}
}
