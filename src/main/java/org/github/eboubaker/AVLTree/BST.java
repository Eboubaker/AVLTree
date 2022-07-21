package org.github.eboubaker.AVLTree;

import java.util.Objects;

/**
 * AVLTree binary search tree methods
 */
final class BST {
    static <T extends Comparable<T>> Node<T> min(Node<T> n) {
        if (n == null) return null;
        while (n.left != null)
            n = n.left;
        return n;
    }

    static <T extends Comparable<T>> Node<T> remove(Node<T> node, T key) {
        if (node == null) {
            return null;
        }
        int cmp = compare(node, key);
        if (cmp > 0) {
            node.right = remove(node.right, key);
        } else if (cmp < 0) {
            node.left = remove(node.left, key);
        } else {
            // the key has been found, now delete it

            // case 1: node is a leaf node
            if (node.left == null && node.right == null) {
                node = null;
            }

            // case 2: node has only one child
            else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }

            // case 3: has both children
            else {
                Node<T> temp = min(node.right);
                node.data = temp.data;
                node.right = remove(node.right, temp.data);
            }
        }
        return node == null ? null : rebalance(node);
    }

    static <T extends Comparable<T>> Node<T> find(Node<T> node, T search) {
        if (node == null) {
            return null;
        }
        Node<T> path = compare(node, search) == 0 ? node.right : node.left;
        return find(path, search);
    }

    static <T extends Comparable<T>> Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        } else {
            if (compare(node, data) > 0) {
                node.right = insert(node.right, data);
            } else {
                node.left = insert(node.left, data);
            }
        }
        return rebalance(node);
    }

    private static <T extends Comparable<T>> int compare(Node<T> n, T a) {
        Objects.requireNonNull(n);
        if (a == null) {
            if (n.data == null)
                return 0;
            else
                return -1;
        } else {
            return a.compareTo(n.data);
        }
    }

    static <T extends Comparable<T>> Node<T> uniqueInsert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        } else {
            int cmp = compare(node, data);
            if (cmp > 0) {
                node.right = insert(node.right, data);
            } else if (cmp < 0) {
                node.left = insert(node.left, data);
            } else {
                return node;
            }
        }
        return rebalance(node);
    }

    //    protected static Node removeDuplicates(Node node, boolean deleting)
//    {
//        if(node == null)
//            return null;
//        if(deleting)
//        {
//            // the key has been found, now delete it
//
//            // case 1: node is a leaf node
//            if (node.left == null && node.right == null) {
//                node = null;
//            }
//
//            // case 2: node has only one child
//            else if (node.left == null) {
//                Node temp = node;
//                node = node.right;
//            }
//
//            else if (node.right == null) {
//                Node temp = node;
//                node = node.left;
//            }
//
//            // case 3: has both children
//            else {
//                Node temp = min(node.right);
//                node.data = temp.data;
//                node.right = remove(node.right, temp.data);
//            }
//        }else if(node.left != null && node.data.compareTo(node.left.data) == 0)
//        {
//            node.left = removeDuplicates(node.left, true);
//        }
//        return rebalance(node);
//    }
    static <T extends Comparable<T>> Node<T> rebalance(Node<T> node) {
        reCalculateWeights(node);
        // balance
        if (node.balance > 1) {
            if (node.left != null && node.left.balance <= -1) {
                node.left = rightRotate(node.left);
            }
            return leftRotate(node);
        } else if (node.balance < -1) {
            if (node.left != null && node.left.balance >= 1) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }
        return node;
    }

    static <T extends Comparable<T>> Node<T> leftRotate(Node<T> me) {
        Node<T> theRight = me.right;
        me.right = theRight.left;
        theRight.left = reCalculateWeights(me);
        return reCalculateWeights(theRight);
    }

    static <T extends Comparable<T>> Node<T> rightRotate(Node<T> me) {
        Node<T> theLeft = me.left;
        me.left = theLeft.right;

        theLeft.right = reCalculateWeights(me);
        return reCalculateWeights(theLeft);
    }

    static <T extends Comparable<T>> int height(Node<T> n) {
        if (n == null) return -1;
        return n.height;
    }

    static <T extends Comparable<T>> Node<T> reCalculateWeights(Node<T> n) {
        int lh = height(n.left);
        int rh = height(n.right);
        n.height = Math.max(lh, rh) + 1;
        n.balance = rh - lh;
        return n;
    }

    static <T extends Comparable<T>> int calculateHeight(Node<T> n) {
        if (n == null) {
            return -1;
        }
        return Math.max(height(n.left), height(n.right)) + 1;
    }

    static <T extends Comparable<T>> int size(Node<T> n) {
        if (n == null) {
            return 0;
        }
        return 1 + size(n.left) + size(n.right);
    }

    static <T extends Comparable<T>> Node<T> clone(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> newNode = new Node<>(node.data);
        newNode.left = clone(node.left);
        newNode.right = clone(node.right);
        return newNode;
    }
}
