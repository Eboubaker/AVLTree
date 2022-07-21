package org.github.eboubaker.AVLTree;

/**
 * inserts unique nodes only
 */
public class HashTree<T extends Comparable<T>> extends Tree<T> {
    public HashTree() {

    }
    public HashTree(Tree<T> instance) {
        for (T item : instance.preOrder()) {
            this.root = BST.uniqueInsert(this.root, item);
        }
    }

    @Override
    public void insert(T data) {
        BST.uniqueInsert(this.root, data);
    }
}
