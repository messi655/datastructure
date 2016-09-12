package com.datastructure;

import java.util.Stack;

/**
 * Created by tinhv on 09/09/2016.
 */
public class TreeFunction {

    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
        }
    }

    public void preOrder(TreeNode root){
        if(root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root){
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

    }

    public void treeWithStackPreOrder(TreeNode root){

        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return;
        }

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            System.out.print(node.data + " ");

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }

        }

    }

    public void treeWithStackPostOrder(TreeNode root){
        if (root == null) return;

        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;

        while (true) {

            if (current != null) {
                if (current.right != null) {
                    s.push(current.right);
                }
                s.push(current);
                current = current.left;
                continue;
            }

            if (s.isEmpty()) {
                return;
            }
            current = s.pop();

            if (current.right != null && !s.isEmpty() && current.right == s.peek()) {
                s.pop();
                s.push(current);
                current = current.right;
            } else {
                System.out.print(current.data + " ");
                current = null;
            }
        }

    }

    public void innerOrder(TreeNode root){
        if(root != null){
            innerOrder(root.left);
            System.out.print(root.data + " ");
            innerOrder(root.right);
        }
    }

    public int height(TreeNode root){

       if(root == null){
           return -1;
       }
        else{
           int lDepth = height(root.left);
           int rDepth = height(root.right);

           if(lDepth > rDepth){
               return lDepth + 1;
           }
           else{
               return rDepth + 1;
           }
       }
    }

    public static void main(String[] args) {

        TreeFunction treefunc = new TreeFunction();

        TreeNode root = new TreeNode(3);

        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node6 = new TreeNode(6);

        root.left = node5;
        node5.left = node1;
        node5.right = node4;

        root.right = node2;
        node2.left = node6;

        System.out.print("PreOrder: ");
        treefunc.preOrder(root);

        System.out.println();

        System.out.print("PostOrder: ");
        treefunc.postOrder(root);

        System.out.println();

        System.out.print("Stack pre order: ");
        treefunc.treeWithStackPreOrder(root);

        System.out.println();

        System.out.print("Stack post order: ");
        treefunc.treeWithStackPostOrder(root);

        System.out.println();

        System.out.print("Iner Order: ");
        treefunc.innerOrder(root);


        System.out.println();

        System.out.print("Max Depth: " + treefunc.height(root));

    }
}

