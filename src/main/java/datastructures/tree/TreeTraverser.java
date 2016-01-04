package datastructures.tree;

import datastructures.MyStack;

import java.util.*;

public class TreeTraverser {


    public void depthFirst_recursive_preOrder(Node n) {
        if (n == null) return;
        process(n);
        depthFirst_recursive_preOrder(n.left);
        depthFirst_recursive_preOrder(n.right);
    }

    public void depthFirst_recursive_inOrder(Node n) {
        if (n == null) return;
        depthFirst_recursive_inOrder(n.left);
        process(n);
        depthFirst_recursive_inOrder(n.right);
    }

    public void depthFirst_recursive_postOrder(Node n) {
        if (n == null) return;
        depthFirst_recursive_postOrder(n.left);
        depthFirst_recursive_postOrder(n.right);
        process(n);
    }

    public void depthFirst_iterative_preOrder(Node n) {
        MyStack<Node> stack = new MyStack<Node>();
        while (!stack.isEmpty() || n != null) {
            if (n == null) {
                n = stack.pop();
            } else {
                process(n);
                if (n.right != null) {
                    stack.push(n.right);
                }
                n = n.left;
            }
        }
    }

    public void depthFirst_iterative_inOrder(Node n) {
        MyStack<Node> stack = new MyStack<Node>();
        while (!stack.isEmpty() || n != null) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                n = stack.pop();
                process(n);
                n = n.right;
            }
        }
    }

    public void depthFirst_iterative_postOrder(Node n) {
        MyStack<Node> stack = new MyStack<Node>();
        Node lastVisited = null;

        while (!stack.isEmpty() || n != null) {
            if (n != null) {
                stack.push(n);
                n = n.left;
            } else {
                n = stack.peek();
                if (n.right != null && lastVisited != n.right) {
                    n = n.right;
                } else {
                    process(n);
                    lastVisited = stack.pop();
                }
            }
        }
    }

    public void breadthFirst_iterative(Node root) {
        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            process(n);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }


    private void process(Node n) {
        System.out.println(n);
    }

    private class Node {
        private Node left;
        private Node right;
    }

}