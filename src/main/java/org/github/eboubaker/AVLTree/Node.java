package org.github.eboubaker.AVLTree;

/**
 * AVLTree node, it's data must implement Comparable Contract
 */
public class Node<T extends Comparable<T>> {
    protected T data;
    protected int height;
    protected int balance;
    protected Node<T> left;
    protected Node<T> right;

    public Node(T data) {
        this.data = data;
        this.height = 0;
        this.balance = 0;
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "data=" + data +
//                ", height=" + height +
//                ", balance=" + balance +
//                ", left=" + left +
//                ", right=" + right +
//                '}';
//    }


}
