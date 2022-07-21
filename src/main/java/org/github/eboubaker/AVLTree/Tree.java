package org.github.eboubaker.AVLTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Tree<T extends Comparable<T>> extends IBinaryTree<T> {

    public Tree() {

    }

    public Tree(List<T> items) {
        for (T item : items) {
            this.insert(item);
        }
    }

    public Tree(HashSet<T> items) {
        for (T item : items) {
            this.insert(item);
        }
    }

    public void insert(T data) {
        root = BST.insert(root, data);
    }

    public T max() {
        Node<T> current = root;
        while (current.getRight() != null)
            current = current.getRight();
        return current.getData();
    }

    public T min() {
        Node<T> current = root;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current.getData();
    }

    public int size() {
        return BST.size(root);
    }

    /**
     * @return list of items in the tree in ascending order
     */
    public List<T> inOrder() {
        Node<T> node = root;
        Stack<Node<T>> stack = new Stack<>();
        List<T> values = new ArrayList<>();
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else {
                node = stack.pop();
                values.add(node.getData());
                node = node.getRight();
            }
        }
        return values;
    }

    /**
     * @return list of items in the tree in descending order
     */
    @Override
    public List<T> preOrder() {
        Node<T> node = this.root;
        Stack<Node<T>> stack = new Stack<>();
        List<T> values = new ArrayList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            values.add(node.getData());
            //right child is pushed first so that left is processed first
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return values;
    }

    public void remove(T data) {
        root = BST.remove(root, data);
    }

    @Override
    public int getHeight() {
        return root.height;
    }

    public boolean contains(T search) {
        return BST.find(root, search) != null;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
