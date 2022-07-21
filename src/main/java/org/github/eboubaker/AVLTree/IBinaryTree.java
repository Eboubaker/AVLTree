package org.github.eboubaker.AVLTree;

import java.util.List;

public abstract class IBinaryTree<T extends Comparable<T>> {
    protected Node<T> root;

    abstract void insert(T data);
    abstract void remove(T key);
    abstract int getHeight();
    abstract int size();

    abstract List<T> inOrder();
    abstract List<T> preOrder();

    abstract T max();
    abstract T min();

    abstract boolean contains(T search);
}
